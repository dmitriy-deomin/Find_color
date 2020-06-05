package deomin.dmitriy.find_color.`fun`

import android.widget.TableRow
import deomin.dmitriy.find_color.Main

fun load_Table_Row(){

    //создадим массив кнопок и повесим на них обработку, кнопки видны всем
    Main.mas_button = create_mass_button()

    //заполняем таблицу кнопками
    var index = 0
    for (h in 0 until HEIGH) {
        val stroka = TableRow(Main.context)
        for (w in 0 until WIDCH) {
            stroka.addView(Main.mas_button[index], w)
            index++
        }
        Main.tableLayout.addView(stroka, h)
    }

    //установим цвета
    setColor_mass_button()
}