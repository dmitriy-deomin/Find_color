package deomin.dmitriy.find_color.menu

import android.content.Context
import android.util.Log
import android.view.View
import deomin.dmitriy.find_color.*
import deomin.dmitriy.find_color.Main.Companion.PAUSE

fun main_menu(context: Context) {

    //приостанавливаем цикл игры
    PAUSE = true

    val menu =DialogWindow(context, R.layout.menu,true)
    //Если окно закроется каклибо по другому
    menu.onClose {  PAUSE = false }

    val akkaunt = menu.view().findViewById<Btn>(R.id.button_akkaunt)
    akkaunt.setOnClickListener(View.OnClickListener {
        akkaunt.clik_anim()
        menu.close()
        PAUSE = false
        Log.e(
            "TTT", "akkaunt"
        )
    })

    menu.view().findViewById<Btn>(R.id.button_settings)
        .setOnClickListener(View.OnClickListener {
            menu.close()
            PAUSE = false
            Log.e(
                "TTT",
                "settings"
            )
        })

    menu.view().findViewById<Btn>(R.id.button_abaut)
        .setOnClickListener(View.OnClickListener {
            menu.close()
            PAUSE = false
            Log.e("TTT", "abaut")
        })
}