package deomin.dmitriy.find_color.`fun`

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator

fun vibrator(context: Context,milliseconds: Long = 10L){
    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    val canVibrate: Boolean = vibrator.hasVibrator()

    if (canVibrate) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // API 26
            vibrator.vibrate(
                VibrationEffect.createOneShot(
                    milliseconds,
                    VibrationEffect.DEFAULT_AMPLITUDE
                )
            )
        } else {
            // This method was deprecated in API level 26
            vibrator.vibrate(milliseconds)
        }
    }
}