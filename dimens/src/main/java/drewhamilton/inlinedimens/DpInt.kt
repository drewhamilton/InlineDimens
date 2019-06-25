package drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

/**
 * The integer representation of dp dimens.
 */
inline class DpInt(val value: Int)

/**
 * Convert [this] to a floating-point dp dimen.
 */
fun DpInt.toDpFloat() = Dp(value.toFloat())

//region toPx
/**
 * Convert [this] dp value to px based on [context]'s display metrics.
 */
fun DpInt.toPx(context: Context) = toPx(context.resources)

/**
 * Convert [this] dp value to px based on [resources]' display metrics.
 */
fun DpInt.toPx(resources: Resources) = toPx(resources.displayMetrics)

/**
 * Convert [this] dp value to px based on [displayMetrics].
 */
fun DpInt.toPx(displayMetrics: DisplayMetrics) = toDpFloat().toPx(displayMetrics.density)
//endregion

//region toSp
/**
 * Convert [this] dp value to sp based on [context]'s display metrics.
 */
fun DpInt.toSp(context: Context) = toSp(context.resources)

/**
 * Convert [this] dp value to sp based on [resources]' display metrics.
 */
fun DpInt.toSp(resources: Resources) = toSp(resources.displayMetrics)

/**
 * Convert [this] dp value to sp based on [displayMetrics].
 */
fun DpInt.toSp(displayMetrics: DisplayMetrics) = toDpFloat().toSp(
    density = displayMetrics.density,
    scaledDensity = displayMetrics.scaledDensity
)
//endregion
