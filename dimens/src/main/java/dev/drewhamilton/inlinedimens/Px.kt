package dev.drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

/**
 * The floating-point representation of px dimens.
 */
inline class Px(val value: Float)

/**
 * Convert [this] to an integer px dimen.
 */
fun Px.toPxInt() = PxInt(value.toInt())

//region toDp
/**
 * Convert [this] px value to dp based on the system [Resources]' display metrics.
 */
fun Px.toDp() = toDp(Resources.getSystem())

/**
 * Convert [this] px value to dp based on [context]'s display metrics.
 */
fun Px.toDp(context: Context) = toDp(context.resources)

/**
 * Convert [this] px value to dp based on [resources]' display metrics.
 */
fun Px.toDp(resources: Resources) = toDp(resources.displayMetrics)

/**
 * Convert [this] px value to dp based on [displayMetrics].
 */
fun Px.toDp(displayMetrics: DisplayMetrics) = toDp(displayMetrics.density)

/**
 * Convert [this] px value to dp based on the given [density].
 */
internal fun Px.toDp(density: Float) = Dp(value / density)
//endregion

//region toSp
/**
 * Convert [this] px value to sp based on the system [Resources]' display metrics.
 */
fun Px.toSp() = toSp(Resources.getSystem())

/**
 * Convert [this] px value to sp based on [context]'s display metrics.
 */
fun Px.toSp(context: Context) = toSp(context.resources)

/**
 * Convert [this] px value to sp based on [resources]' display metrics.
 */
fun Px.toSp(resources: Resources) = toSp(resources.displayMetrics)

/**
 * Convert [this] px value to sp based on [displayMetrics].
 */
fun Px.toSp(displayMetrics: DisplayMetrics) = toSp(displayMetrics.scaledDensity)

/**
 * Convert [this] px value to sp based on the given [scaledDensity].
 */
internal fun Px.toSp(scaledDensity: Float) = Sp(value / scaledDensity)
//endregion
