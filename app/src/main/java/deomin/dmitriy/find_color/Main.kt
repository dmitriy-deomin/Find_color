package deomin.dmitriy.find_color

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.widget.TableLayout
import deomin.dmitriy.find_color.`fun`.*
import deomin.dmitriy.find_color.game.main_game
import kotlinx.android.synthetic.main.main.*
import kotlinx.coroutines.*
import android.media.MediaPlayer


class Main : Activity() {

    companion object {
        lateinit var context: Context
        lateinit var mas_button: ArrayList<Btn>
        lateinit var mSettings: SharedPreferences
        lateinit var tableLayout: TableLayout
        lateinit var mPlayer: MediaPlayer


        //размеры экрана(не меняется , устанавливается один раз при запуске)
        var navigationBarHeight = 0
        var heightPixels_display = 0
        var widthPixels_display = 0

        //размеры сетки
        // 6x15 - max , 3x7 - min
        var HEIGH = 7
        var WIDCH = 3

        //время обновления цикла игры
        const val TIME_LOOP = 1000

        //Кнопка которую надо найти
        var find_button = 0

        //Пауза
        var PAUSE = false

        //время простоя игрока: 1 = 1/2 секунды
        var TIME_CLIK = 8
        var time_tik = 0

        //предел количества правельных угаданных для перехода к следующему уровню
        const val SIZE_FIND_COLOR = 10

        //текущий счет (загружается при запуске и постоянно сохраняется)
        var size_find_clik = 0

        //
        var ERROR_SMOLL = 1

        //Флаги первоночальных настроек уровней
        var setup_lavel = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        context = this

        mSettings = getSharedPreferences("mysettings", Context.MODE_PRIVATE)

        //настройка экрана
        //------------------------------------------------------------------------------
        //во весь экран
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        //скрывем кнопки навигации
        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        decorView.systemUiVisibility = uiOptions
        //будем слушать  если покажется опять - закроем
        window.decorView.setOnSystemUiVisibilityChangeListener { visibility ->
            if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) decorView.systemUiVisibility =
                uiOptions
        }
        //-----------------------------------------------------------------------------

        // узнаем размеры экрана из класса Display
        val display = windowManager.defaultDisplay
        val metricsB = DisplayMetrics()
        display.getMetrics(metricsB)

        //размер панели и экрана навигации для расчета коректного размера
        navigationBarHeight = getNavigationBarHeight(this, display.rotation)
        widthPixels_display = metricsB.widthPixels
        heightPixels_display = metricsB.heightPixels


        mPlayer = MediaPlayer.create(context, R.raw.start)
        mPlayer.start()


        //делаем глобальным корневой лояут
        tableLayout = fon

        //загрузим количество угаданых цветов
        size_find_clik = save_read_int("size_find_clik")

        //цикл игры delay(500) -  обновление пол секунды
        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                while (true) {
                    //скорость работы цикла
                    delay(TIME_LOOP.toLong())

                    //отчет,показ подсказок и тд выполняется постоянно(кроме паузы)
                    if (!PAUSE)
                        main_game()
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        //Остановим игру
        PAUSE = true
        if (mPlayer.isPlaying) {
            mPlayer.stop()
        }
    }
}

