package drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

/**
 * The floating-point representation of sp dimens.
 */
inline class Sp(val value: Float)

/**
 * Convert [this] to an integer sp dimen.
 */
fun Sp.toSpInt() = SpInt(value.toInt())

//region toPx
/**
 * Convert [this] sp value to px based on the system [Resources]' display metrics.
 */
fun Sp.toPx() = toPx(Resources.getSystem())

/**
 * Convert [this] sp value to px based on [context]'s display metrics.
 */
fun Sp.toPx(context: Context) = toPx(context.resources)

/**
 * Convert [this] sp value to px based on [resources]' display metrics.
 */
fun Sp.toPx(resources: Resources) = toPx(resources.displayMetrics)

/**
 * Convert [this] sp value to px based on [displayMetrics].
 */
fun Sp.toPx(displayMetrics: DisplayMetrics) = toPx(displayMetrics.scaledDensity)

/**
 * Convert [this] sp value to px based on the given [scaledDensity].
 */
internal fun Sp.toPx(scaledDensity: Float) = Px(value * scaledDensity)
//endregion

//region toDp
/**
 * Convert [this] sp value to dp based on the system [Resources]' display metrics.
 */
fun Sp.toDp() = toDp(Resources.getSystem())

/**
 * Convert [this] sp value to dp based on [context]'s display metrics.
 */
fun Sp.toDp(context: Context) = toDp(context.resources)

/**
 * Convert [this] sp value to dp based on [resources]' display metrics.
 */
fun Sp.toDp(resources: Resources) = toDp(resources.displayMetrics)

/**
 * Convert [this] sp value to dp based on [displayMetrics].
 */
fun Sp.toDp(displayMetrics: DisplayMetrics) = toDp(
    density = displayMetrics.density,
    scaledDensity = displayMetrics.scaledDensity
)

/**
 * Convert [this] sp value to dp based on the given [density] and [scaledDensity].
 */
internal fun Sp.toDp(density: Float, scaledDensity: Float) = Dp(value * scaledDensity / density)
//endregion
