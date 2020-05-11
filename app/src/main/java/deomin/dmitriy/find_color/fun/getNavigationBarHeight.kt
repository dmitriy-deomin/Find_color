package deomin.dmitriy.find_color.`fun`

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources

fun getNavigationBarHeight(
    context: Context,
    orientation: Int): Int {
    val resources: Resources = context.resources
    val id: Int = resources.getIdentifier(
        if (orientation == Configuration.ORIENTATION_PORTRAIT) "navigation_bar_height" else "navigation_bar_height_landscape",
        "dimen",
        "android"
    )
    return if (id > 0) {
        resources.getDimensionPixelSize(id)
    } else 0
}