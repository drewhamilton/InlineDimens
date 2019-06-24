package drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

inline class Dp(val value: Float)

fun Dp.toDpInt() = DpInt(value.toInt())

//region toPx
fun Dp.toPx(context: Context) = toPx(context.resources)

fun Dp.toPx(resources: Resources) = toPx(resources.displayMetrics)

fun Dp.toPx(displayMetrics: DisplayMetrics) = toPx(displayMetrics.density)

internal fun Dp.toPx(density: Float) = Px(value * density)
//endregion

//region toSp
fun Dp.toSp(context: Context) = toSp(context.resources)

fun Dp.toSp(resources: Resources) = toSp(resources.displayMetrics)

fun Dp.toSp(displayMetrics: DisplayMetrics) = toSp(
    density = displayMetrics.density,
    scaledDensity = displayMetrics.scaledDensity
)

internal fun Dp.toSp(density: Float, scaledDensity: Float) = Sp(value * density / scaledDensity)
//endregion
