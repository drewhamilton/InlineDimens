package drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

inline class SpInt(val value: Int)

fun SpInt.toSpFloat() = Sp(value.toFloat())

//region toPx
fun SpInt.toPx(context: Context) = toPx(context.resources)

fun SpInt.toPx(resources: Resources) = toPx(resources.displayMetrics)

fun SpInt.toPx(displayMetrics: DisplayMetrics) = toSpFloat().toPx(displayMetrics.scaledDensity)
//endregion

//region toDp
fun SpInt.toDp(context: Context) = toDp(context.resources)

fun SpInt.toDp(resources: Resources) = toDp(resources.displayMetrics)

fun SpInt.toDp(displayMetrics: DisplayMetrics) = toSpFloat().toDp(
    density = displayMetrics.density,
    scaledDensity = displayMetrics.scaledDensity
)
//endregion
