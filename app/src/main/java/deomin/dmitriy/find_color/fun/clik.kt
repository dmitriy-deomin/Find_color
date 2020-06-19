package deomin.dmitriy.find_color.`fun`

import deomin.dmitriy.find_color.Btn
import deomin.dmitriy.find_color.Main.Companion.ERROR_SMOLL
import deomin.dmitriy.find_color.Main.Companion.context
import deomin.dmitriy.find_color.Main.Companion.mas_button
import deomin.dmitriy.find_color.Main.Companion.size_find_clik
import deomin.dmitriy.find_color.Main.Companion.time_tik
import deomin.dmitriy.find_color.menu.main_menu

fun clik(btn: Btn) {

    if(btn.id==1) {
        main_menu(context)
    } else{
        if(mas_button[1].background_color==btn.background_color){
            //правельно
            //-------------------------------------------------
            //сбросим время для подсказки
            time_tik=0
            //покажем анимацию(тамже повибрирует немного)
            btn.clik_anim()
            //установим заново все цвета рандомно
            setColor_mass_button()
            //сохраним количество правельных ответов
            size_find_clik++
            save_value_int("size_find_clik", size_find_clik)
            //--------------------------------------------------
        }else{
            //неправельно
            vibrator(context,100L)
            btn.start_anim_error()
            //уменьшим счёт
            if(size_find_clik>=0){
                size_find_clik -= ERROR_SMOLL
                save_value_int("size_find_clik", size_find_clik)
            }

        }
    }
}