package deomin.dmitriy.find_color.`fun`

import deomin.dmitriy.find_color.Main

fun save_value(Key: String, Value: String) { //сохранение строки
    val editor = Main.mSettings.edit()
    editor.putString(Key, Value)
    editor.apply()
}

fun save_read(key_save: String): String {  // чтение настройки
    return if (Main.mSettings.contains(key_save)) {
        Main.mSettings.getString(key_save, "").toString()
    } else ""
}

fun save_value_int(Key: String, Value: Int) { //сохранение строки
    val editor = Main.mSettings.edit()
    editor.putInt(Key, Value)
    editor.apply()
}

fun save_read_int(key_save: String): Int {  // чтение настройки
    return if (Main.mSettings.contains(key_save)) {
        Main.mSettings.getInt(key_save, 0)
    } else 0
}

fun save_value_float(Key: String, Value: Float) { //сохранение строки
    val editor = Main.mSettings.edit()
    editor.putFloat(Key, Value)
    editor.apply()
}

fun save_read_float(key_save: String): Float {  // чтение настройки
    return if (Main.mSettings.contains(key_save)) {
        Main.mSettings.getFloat(key_save, 0F)
    } else 0F
}