package deomin.dmitriy.find_color.`fun`

//размеры сетки
// 6x15 - max , 3x7 - min
var HEIGH = 7
var WIDCH = 3

//время обновления цикла игры
const val TIME_LOOP= 1000

//Кнопка которую надо найти
var find_button =0

//Пауза
var PAUSE = false

//время простоя игрока: 1 = 1/2 секунды
var TIME_CLIK = 8
var time_tik = 0

//предел количества правельных угаданных для перехода к следующему уровню
const val SIZE_FIND_COLOR = 10
//текущий счет (загружается при запуске и постоянно сохраняется)
var size_find_clik=0

//
var ERROR_SMOLL = 1


//Флаги первоночальных настроек уровней
var setup_lavel = ""

