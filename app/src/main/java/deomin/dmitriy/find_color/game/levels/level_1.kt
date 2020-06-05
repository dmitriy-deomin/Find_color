package deomin.dmitriy.find_color.game.levels

import deomin.dmitriy.find_color.Main.Companion.mas_button
import deomin.dmitriy.find_color.`fun`.*

fun level_1() {

    val lavel = "Level 1"

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
        TIME_CLIK = 8
        //На сколько уменьшать очки при ошибке или по истечении времени
        ERROR_SMOLL = 1

        //Создание,отрисовка кнопок нужного размера и количества
        load_Table_Row()

        setup_lavel = lavel
    }


    mas_button[0].text = lavel
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