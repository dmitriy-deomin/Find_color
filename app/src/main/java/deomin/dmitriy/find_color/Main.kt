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


class Main : Activity() {

    companion object {
        lateinit var context: Context
        lateinit var mas_button: ArrayList<Btn>
        lateinit var mSettings: SharedPreferences
        lateinit var tableLayout: TableLayout

        //размеры экрана(не меняется , устанавливается один раз при запуске)
        var navigationBarHeight = 0
        var heightPixels_display = 0
        var widthPixels_display = 0
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
}

