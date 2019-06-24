package drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

inline class Sp(val value: Float)

fun Sp.toSpInt() = SpInt(value.toInt())

//region toPx
fun Sp.toPx(context: Context) = toPx(context.resources)

fun Sp.toPx(resources: Resources) = toPx(resources.displayMetrics)

fun Sp.toPx(displayMetrics: DisplayMetrics) = toPx(displayMetrics.scaledDensity)

internal fun Sp.toPx(scaledDensity: Float) = Px(value * scaledDensity)
//endregion

//region toDp
fun Sp.toDp(context: Context) = toDp(context.resources)

fun Sp.toDp(resources: Resources) = toDp(resources.displayMetrics)

fun Sp.toDp(displayMetrics: DisplayMetrics) = toDp(
    density = displayMetrics.density,
    scaledDensity = displayMetrics.scaledDensity
)

internal fun Sp.toDp(density: Float, scaledDensity: Float) = Dp(value * scaledDensity / density)
//endregion
