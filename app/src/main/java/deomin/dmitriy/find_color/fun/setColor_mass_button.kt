package deomin.dmitriy.find_color.`fun`

import deomin.dmitriy.find_color.Main.Companion.mas_button

fun setColor_mass_button(){

    //всего кнопок
    val SIZE_TABLE = WIDCH * HEIGH

    //устанавливаем у всех кнопок рандомный цвет
    for(btn in mas_button){
        btn.setBackcolor(rnd_color())
    }

    //кнопка меню(и который цвет надо искать)
    find_button = (0 until SIZE_TABLE).random()

    //если нашли сами себя то поищем еще разок
    if(find_button==1)
        setColor_mass_button()
    else
        mas_button[1].setBackcolor(mas_button[find_button].background_color)
}