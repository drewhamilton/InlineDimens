package drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

inline class PxInt(val value: Int)

fun PxInt.toPxFloat() = Px(value.toFloat())

//region toDp
fun PxInt.toDp(context: Context) = toDp(context.resources)

fun PxInt.toDp(resources: Resources) = toDp(resources.displayMetrics)

fun PxInt.toDp(displayMetrics: DisplayMetrics) = toPxFloat().toDp(displayMetrics.density)
//endregion

//region toSp
fun PxInt.toSp(context: Context) = toSp(context.resources)

fun PxInt.toSp(resources: Resources) = toSp(resources.displayMetrics)

fun PxInt.toSp(displayMetrics: DisplayMetrics) = toPxFloat().toSp(displayMetrics.scaledDensity)
//endregion
