package drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

inline class DpInt(val value: Int)

fun DpInt.toDpFloat() = Dp(value.toFloat())

//region toPx
fun DpInt.toPx(context: Context) = toPx(context.resources)

fun DpInt.toPx(resources: Resources) = toPx(resources.displayMetrics)

fun DpInt.toPx(displayMetrics: DisplayMetrics) = toDpFloat().toPx(displayMetrics.density)
//endregion

//region toSp
fun DpInt.toSp(context: Context) = toSp(context.resources)

fun DpInt.toSp(resources: Resources) = toSp(resources.displayMetrics)

fun DpInt.toSp(displayMetrics: DisplayMetrics) = toDpFloat().toSp(
    density = displayMetrics.density,
    scaledDensity = displayMetrics.scaledDensity
)
//endregion
