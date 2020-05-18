package deomin.dmitriy.find_color.`fun`

import android.content.Context
import android.widget.TableLayout
import android.widget.TableRow
import deomin.dmitriy.find_color.Main

fun load_Table_Row(context: Context,tableLayout: TableLayout){
    var index = 0
    for (h in 0 until HEIGH) {
        val stroka = TableRow(context)
        for (w in 0 until WIDCH) {
            stroka.addView(Main.mas_button[index], w)
            index++
        }
        tableLayout.addView(stroka, h)
    }
}