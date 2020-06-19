package deomin.dmitriy.find_color.game.levels

import deomin.dmitriy.find_color.Main.Companion.ERROR_SMOLL
import deomin.dmitriy.find_color.Main.Companion.HEIGH
import deomin.dmitriy.find_color.Main.Companion.SIZE_FIND_COLOR
import deomin.dmitriy.find_color.Main.Companion.TIME_CLIK
import deomin.dmitriy.find_color.Main.Companion.WIDCH
import deomin.dmitriy.find_color.Main.Companion.find_button
import deomin.dmitriy.find_color.Main.Companion.mas_button
import deomin.dmitriy.find_color.Main.Companion.setup_lavel
import deomin.dmitriy.find_color.Main.Companion.size_find_clik
import deomin.dmitriy.find_color.Main.Companion.time_tik
import deomin.dmitriy.find_color.`fun`.*

fun level_3() {

    val lavel = "Level 3"

    /* При первом запуске уровня устанавливаем его параметры
    первый уровень как учебный, поэтому установим:
     -минимальный размер сетки ,
     -большое время поиска,
     -при ошибке из счета очков уберается одно значение

     -потом если придумаю еще чегонибуть
    */
    if (setup_lavel!=lavel) {

        //Настройки поля (ширина,высота, количество автоматом подсчитается)
        HEIGH = 7
        WIDCH = 3
        //Время для поиска
        TIME_CLIK = 6
        //На сколько уменьшать очки при ошибке или по истечении времени
        ERROR_SMOLL = 2

        //Создание,отрисовка кнопок нужного размера и количества
        load_Table_Row()

        setup_lavel =lavel
    }


    mas_button[0].text =lavel
    mas_button[1].text = "Find color " + (TIME_CLIK - time_tik).toString()
    mas_button[2].text = "$size_find_clik/$SIZE_FIND_COLOR"

    //по истечении времени поиска уменьшим счет и покажем анимацию помощи
    if (time_tik >= TIME_CLIK) {

        //уменьшим счёт
        if(size_find_clik>=0){
            size_find_clik -= ERROR_SMOLL
            save_value_int("size_find_clik", size_find_clik)
        }

        mas_button[find_button].start_anim_help()
        time_tik = 0
    }
    time_tik++
}