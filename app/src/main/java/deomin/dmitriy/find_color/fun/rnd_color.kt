package deomin.dmitriy.find_color.`fun`

import android.graphics.Color

fun rnd_color(): Int {
    val r = (0..255).random()
    val g = (0..255).random()
    val b = (0..255).random()
    return Color.rgb(r, g, b)
}