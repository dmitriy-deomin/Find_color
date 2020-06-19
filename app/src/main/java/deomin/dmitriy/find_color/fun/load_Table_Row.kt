package deomin.dmitriy.find_color.`fun`

import android.view.ViewGroup
import android.widget.TableRow
import deomin.dmitriy.find_color.Main
import deomin.dmitriy.find_color.Main.Companion.HEIGH
import deomin.dmitriy.find_color.Main.Companion.WIDCH


fun load_Table_Row() {

    //reset
    for (i in 0 until Main.tableLayout.childCount) {
        val child = Main.tableLayout.getChildAt(i)
        if (child is TableRow) (child as ViewGroup).removeAllViews()
    }


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