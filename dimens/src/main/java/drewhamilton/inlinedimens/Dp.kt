package drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

/**
 * The floating-point representation of dp dimens.
 */
inline class Dp(val value: Float)

/**
 * Convert [this] to an integer dp dimen.
 */
fun Dp.toDpInt() = DpInt(value.toInt())

//region toPx
/**
 * Convert [this] dp value to px based on [context]'s display metrics.
 */
fun Dp.toPx(context: Context) = toPx(context.resources)

/**
 * Convert [this] dp value to px based on [resources]' display metrics.
 */
fun Dp.toPx(resources: Resources) = toPx(resources.displayMetrics)

/**
 * Convert [this] dp value to px based on [displayMetrics].
 */
fun Dp.toPx(displayMetrics: DisplayMetrics) = toPx(displayMetrics.density)

/**
 * Convert [this] dp value to px based on the given [density].
 */
internal fun Dp.toPx(density: Float) = Px(value * density)
//endregion

//region toSp
/**
 * Convert [this] dp value to sp based on [context]'s display metrics.
 */
fun Dp.toSp(context: Context) = toSp(context.resources)

/**
 * Convert [this] dp value to sp based on [resources]' display metrics.
 */
fun Dp.toSp(resources: Resources) = toSp(resources.displayMetrics)

/**
 * Convert [this] dp value to sp based on [displayMetrics].
 */
fun Dp.toSp(displayMetrics: DisplayMetrics) = toSp(
    density = displayMetrics.density,
    scaledDensity = displayMetrics.scaledDensity
)

/**
 * Convert [this] dp value to sp based on the given [density] and [scaledDensity].
 */
internal fun Dp.toSp(density: Float, scaledDensity: Float) = Sp(value * density / scaledDensity)
//endregion
