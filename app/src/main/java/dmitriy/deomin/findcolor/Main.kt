package dmitriy.deomin.findcolor

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.TableRow
import dmitriy.deomin.findcolor.`fun`.getNavigationBarHeight
import dmitriy.deomin.findcolor.`fun`.rnd_color
import kotlinx.android.synthetic.main.main.*


class Main : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

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


        //размеры сетки
        val HEIGH = 7
        val WIDCH = 3
        //количество ячеек с цветом
        val SIZE_POLE = HEIGH * WIDCH

        // узнаем размеры экрана из класса Display
        val display = windowManager.defaultDisplay
        val metricsB = DisplayMetrics()
        display.getMetrics(metricsB)

        //размер панели навигации для расчета коректного размера
        val h_nav = getNavigationBarHeight(this, display.rotation)

        //расчитам размеры кнопок под экран
        val w_button = metricsB.widthPixels / WIDCH
        val h_button = (metricsB.heightPixels + h_nav) / HEIGH


        //создадим масив цветов
        val mas_color = IntArray(SIZE_POLE + 1)
        for (i in 0 until SIZE_POLE + 1) {
            mas_color[i] = rnd_color()
        }

        var number = 0

        for (h in 0 until HEIGH) {

            val stroka = TableRow(this)

            for (w in 0 until WIDCH) {
                val button = Btn(this)
                button.id = number
                button.setBackgroundColor(mas_color[number])
                button.setOnClickListener(View.OnClickListener { clik(button.id) })
                button.height = h_button
                button.width = w_button
                stroka.addView(button, w)

                button.text = number.toString()

                number ++
            }
            fon.addView(stroka, h)
        }

    }

    fun clik(i: Int) {
        Log.e("TTT", i.toString())

        val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        val canVibrate: Boolean = vibrator.hasVibrator()
        val milliseconds = 10L

        if (canVibrate) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // API 26
                vibrator.vibrate(
                    VibrationEffect.createOneShot(
                        milliseconds,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            } else {
                // This method was deprecated in API level 26
                vibrator.vibrate(milliseconds)
            }
        }

        when(i){

            1-> {
               val menu = Window(this,R.layout.menu)
            }

        }





    }
}

