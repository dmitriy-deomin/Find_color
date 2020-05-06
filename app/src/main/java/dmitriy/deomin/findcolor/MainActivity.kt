package dmitriy.deomin.findcolor

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.TableRow
import dmitriy.deomin.findcolor.`fun`.rnd_color
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //во весь экран
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


        //размеры сетки
        val HEIGH = 10
        val WIDCH = 5
        //количество ячеек с цветом
        var SIZE_POLE = HEIGH*WIDCH



        //создадим масив цветов
        val mas_color = IntArray(SIZE_POLE+1)
        for (i in 0 until SIZE_POLE+1) {
            mas_color[i] = rnd_color()
        }

        for (h in 0 until HEIGH) {

            val stroka = TableRow(this)

            for (w in 0 until WIDCH) {
                val button = Btn(this)
                button.id = SIZE_POLE
                button.setBackgroundColor(mas_color[SIZE_POLE])
                button.setOnClickListener(View.OnClickListener { clik_color(mas_color[SIZE_POLE]) })
                button.minHeight=300
                button.minWidth=300
                stroka.addView(button, w)
                SIZE_POLE -= 1
            }

            fon.addView(stroka, h)
        }
    }

    fun clik_color( i: Int) {
        Log.e("TTT",i.toString())
    }
}

