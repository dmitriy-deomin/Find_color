package deomin.dmitriy.find_color.menu

import deomin.dmitriy.find_color.*
import deomin.dmitriy.find_color.Main.Companion.PAUSE
import deomin.dmitriy.find_color.Main.Companion.size_find_clik
import deomin.dmitriy.find_color.`fun`.save_value_int

fun game_win(){
    //Остановим игру
    PAUSE = true

    //Покажем окошко с выбором что делать
    //-Начать новую игру
    val game_win = DialogWindow(Main.context, R.layout.game_win,true)
    //Если окно закроется каклибо по другому
    game_win.onClose {  PAUSE = false }

    val btn_start = game_win.view().findViewById<Btn>(R.id.button_win)
    btn_start.setOnClickListener {
        //сбросим очки счета ,для запуска новой игры
        size_find_clik=0
        save_value_int("size_find_clik", size_find_clik)
        game_win.close()
        PAUSE = false
    }

    val text = game_win.view().findViewById<Text>(R.id.text_win)
    text.setBackgroundColor(btn_start.background_color)
}