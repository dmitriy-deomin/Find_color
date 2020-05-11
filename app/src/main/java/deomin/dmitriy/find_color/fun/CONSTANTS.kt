package deomin.dmitriy.find_color.`fun`

//размеры сетки
// 6x15 - max , 3x7 - min
val HEIGH = 7
val WIDCH = 3
//всего кнопок
val SIZE_TABLE = WIDCH * HEIGH

//Кнопка которую надо найти
var find_button =0

//время простоя игрока: 1 = 1/2 секунды
const val TIME_CLIK = 8
var time_tik = 0

//предел количества правельных угаданных для перехода к следующему уровню
const val SIZE_FIND_COLOR = 25
var size_find_clik=0

