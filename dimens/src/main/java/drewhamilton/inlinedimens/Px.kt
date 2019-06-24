package drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

inline class Px(val value: Float)

fun Px.toPxInt() = PxInt(value.toInt())

//region toDp
fun Px.toDp(context: Context) = toDp(context.resources)

fun Px.toDp(resources: Resources) = toDp(resources.displayMetrics)

fun Px.toDp(displayMetrics: DisplayMetrics) = toDp(displayMetrics.density)

internal fun Px.toDp(density: Float) = Dp(value / density)
//endregion

//region toSp
fun Px.toSp(context: Context) = toSp(context.resources)

fun Px.toSp(resources: Resources) = toSp(resources.displayMetrics)

fun Px.toSp(displayMetrics: DisplayMetrics) = toSp(displayMetrics.scaledDensity)

internal fun Px.toSp(scaledDensity: Float) = Dp(value / scaledDensity)
//endregion
