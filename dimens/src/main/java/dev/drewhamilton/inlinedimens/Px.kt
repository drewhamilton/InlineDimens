package dev.drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

/**
 * The floating-point representation of px dimens.
 */
inline class Px(val value: Float) : Comparable<Px> {
    /**
     * Add two [Px]s together.
     */
    operator fun plus(other: Px) = Px(this.value + other.value)

    /**
     * Subtract a [Px] from another one.
     */
    operator fun minus(other: Px) = Px(this.value - other.value)

    /**
     * This is the same as multiplying the [Px] by -1.0.
     */
    operator fun unaryMinus() = Px(-value)

    /**
     * Divide a [Px] by a scalar.
     */
    operator fun div(other: Float): Px = Px(value / other)

    /**
     * Divide a [Px] by a scalar.
     */
    operator fun div(other: Int): Px = Px(value / other)

    /**
     * Divide by another [Px] to get a scalar.
     */
    operator fun div(other: Px): Float = value / other.value

    /**
     * Multiply a [Px] by a scalar.
     */
    operator fun times(other: Float): Px = Px(value * other)

    /**
     * Multiply a [Px] by a scalar.
     */
    operator fun times(other: Int): Px = Px(value * other)

    /**
     * Support comparing [Px] with comparison operators.
     */
    override operator fun compareTo(other: Px) = value.compareTo(other.value)

    override fun toString() = "${value}px"
}

/**
 * Create a [Px], e.g. `16f.px`.
 */
inline val Float.px get() = Px(this)

/**
 * Create a [Px], e.g. `16.0.px`
 */
inline val Double.px get() = Px(this.toFloat())

/**
 * Convert [this] to an integer px dimen.
 */
fun Px.toPxInt() = PxInt(value.toInt())

/**
 * Multiply a scalar by a [Px].
 */
operator fun Float.times(other: Px) = Px(this * other.value)

/**
 * Multiply a scalar by a [Px].
 */
operator fun Int.times(other: Px) = Px(this * other.value)

//region Min/max
/**
 * Determine the smaller [Px].
 */
fun min(a: Px, b: Px): Px = Px(kotlin.math.min(a.value, b.value))

/**
 * Determine the larger [Px].
 */
fun max(a: Px, b: Px): Px = Px(kotlin.math.max(a.value, b.value))

/**
 * Ensure that this value lies in the specified range [minimumValue]..[maximumValue].
 *
 * @return this value if it's in the range, or [minimumValue] if this value is less than [minimumValue], or
 * [maximumValue] if this value is greater than [maximumValue].
 */
fun Px.coerceIn(minimumValue: Px, maximumValue: Px) = Px(value.coerceIn(minimumValue.value, maximumValue.value))

/**
 * Ensures that this value is not less than the specified [minimumValue].
 *
 * @return this value if it's greater than or equal to the [minimumValue] or the [minimumValue] otherwise.
 */
fun Px.coerceAtLeast(minimumValue: Px) = Px(value.coerceAtLeast(minimumValue.value))

/**
 * Ensure that this value is not greater than the specified [maximumValue].
 *
 * @return this value if it's less than or equal to the [maximumValue] or the [maximumValue] otherwise.
 */
fun Px.coerceAtMost(maximumValue: Px) = Px(value.coerceAtMost(maximumValue.value))
//endregion

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
