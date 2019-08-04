@file:JvmName("SpIntConversions")
package drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

/**
 * The integer representation of sp dimens.
 */
inline class SpInt(override val value: Int) : DimenInt

/**
 * Convert [this] to a floating-point sp dimen.
 */
fun SpInt.toSpFloat() = Sp(value.toFloat())

//region toPx
/**
 * Convert [this] sp value to px based on [context]'s display metrics.
 */
fun SpInt.toPx(context: Context) = toPx(context.resources)

/**
 * Convert [this] sp value to px based on [resources]' display metrics.
 */
fun SpInt.toPx(resources: Resources) = toPx(resources.displayMetrics)

/**
 * Convert [this] sp value to px based on [displayMetrics].
 */
fun SpInt.toPx(displayMetrics: DisplayMetrics) = toSpFloat().toPx(displayMetrics.scaledDensity)
//endregion

//region toDp
/**
 * Convert [this] sp value to dp based on [context]'s display metrics.
 */
fun SpInt.toDp(context: Context) = toDp(context.resources)

/**
 * Convert [this] sp value to dp based on [resources]' display metrics.
 */
fun SpInt.toDp(resources: Resources) = toDp(resources.displayMetrics)

/**
 * Convert [this] sp value to dp based on [displayMetrics].
 */
fun SpInt.toDp(displayMetrics: DisplayMetrics) = toSpFloat().toDp(
    density = displayMetrics.density,
    scaledDensity = displayMetrics.scaledDensity
)
//endregion
