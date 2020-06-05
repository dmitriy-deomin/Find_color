package deomin.dmitriy.find_color.menu

import deomin.dmitriy.find_color.*
import deomin.dmitriy.find_color.`fun`.PAUSE
import deomin.dmitriy.find_color.`fun`.save_value_int
import deomin.dmitriy.find_color.`fun`.size_find_clik

fun game_menu(){
    //Остановим игру
    PAUSE = true

    //Покажем окошко с выбором что делать
    //-Начать новую игру
    val game_menu = DialogWindow(Main.context, R.layout.game_menu,true)
    //Если окно закроется каклибо по другому
    game_menu.onClose {  PAUSE = false }

    val btn_start = game_menu.view().findViewById<Btn>(R.id.button_start_new)
    btn_start.setOnClickListener {
        size_find_clik = 0
        save_value_int("size_find_clik", size_find_clik)
        game_menu.close()
        PAUSE = false
    }

    val text = game_menu.view().findViewById<Text>(R.id.text_new_game)
    text.setBackgroundColor(btn_start.background_color)
}