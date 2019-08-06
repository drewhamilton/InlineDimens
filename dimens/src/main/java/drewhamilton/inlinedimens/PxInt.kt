@file:JvmName("PxIntConversions")
package drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

/**
 * The integer representation of px dimens.
 */
inline class PxInt(override val value: Int) : DimenInt

/**
 * Convert [this] to a floating-point px dimen.
 */
fun PxInt.toPxFloat() = Px(value.toFloat())

//region toDp
/**
 * Convert [this] px value to dp based on the system [Resources]' display metrics.
 */
fun PxInt.toDp() = toDp(Resources.getSystem())

/**
 * Convert [this] px value to dp based on [context]'s display metrics.
 */
fun PxInt.toDp(context: Context) = toDp(context.resources)

/**
 * Convert [this] px value to dp based on [resources]' display metrics.
 */
fun PxInt.toDp(resources: Resources) = toDp(resources.displayMetrics)

/**
 * Convert [this] px value to dp based on [displayMetrics].
 */
fun PxInt.toDp(displayMetrics: DisplayMetrics) = toPxFloat().toDp(displayMetrics.density)
//endregion

//region toSp
/**
 * Convert [this] px value to sp based on the system [Resources]' display metrics.
 */
fun PxInt.toSp() = toSp(Resources.getSystem())

/**
 * Convert [this] px value to sp based on [context]'s display metrics.
 */
fun PxInt.toSp(context: Context) = toSp(context.resources)

/**
 * Convert [this] px value to sp based on [resources]' display metrics.
 */
fun PxInt.toSp(resources: Resources) = toSp(resources.displayMetrics)

/**
 * Convert [this] px value to sp based on [displayMetrics].
 */
fun PxInt.toSp(displayMetrics: DisplayMetrics) = toPxFloat().toSp(displayMetrics.scaledDensity)
//endregion
