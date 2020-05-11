package deomin.dmitriy.find_color

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.widget.TableRow
import deomin.dmitriy.find_color.`fun`.*
import deomin.dmitriy.find_color.game.main_game
import kotlinx.android.synthetic.main.main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Main : Activity() {

    companion object {
        lateinit var context: Context
        lateinit var mas_button: ArrayList<Btn>
        lateinit var mSettings: SharedPreferences
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

        //размер панели навигации для расчета коректного размера
        val h_nav = getNavigationBarHeight(this, display.rotation)

        //расчитам размеры кнопок под экран
        val size_button =
            Pair((metricsB.heightPixels + h_nav) / HEIGH, metricsB.widthPixels / WIDCH)
        //создадим массив кнопок и повесим на них обработку, кнопки видны всем
        mas_button = create_mass_button(this, SIZE_TABLE, size_button)

        //заполняем таблицу кнопками
        //------------------------------------------------------
        var index = 0
        for (h in 0 until HEIGH) {
            val stroka = TableRow(this)
            for (w in 0 until WIDCH) {
                stroka.addView(mas_button[index], w)
                index++
            }
            fon.addView(stroka, h)
        }
        //--------------------------------------------------------

        //установим цвета первый раз
        setColor_mass_button()

        //загрузим количество угаданых цветов
        size_find_clik = save_read_int("size_find_clik")

        //цикл игры
        GlobalScope.launch  {
            while (true) {
                delay(500)
                main_game()
            }
        }
    }
}

