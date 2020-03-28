@file:Suppress("NOTHING_TO_INLINE")

package dev.drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import kotlin.math.max
import kotlin.math.min

/**
 * The floating-point representation of dp dimens.
 */
inline class Dp(val value: Float) : Comparable<Dp> {
    /**
     * Add two [Dp]s together.
     */
    inline operator fun plus(other: Dp) = Dp(this.value + other.value)

    /**
     * Subtract a [Dp] from another one.
     */
    inline operator fun minus(other: Dp) = Dp(this.value - other.value)

    /**
     * This is the same as multiplying the [Dp] by -1.0.
     */
    inline operator fun unaryMinus() = Dp(-value)

    /**
     * Divide a [Dp] by a scalar.
     */
    inline operator fun div(other: Float): Dp = Dp(value / other)

    /**
     * Divide a [Dp] by a scalar.
     */
    inline operator fun div(other: Int): Dp = Dp(value / other)

    /**
     * Divide by another [Dp] to get a scalar.
     */
    inline operator fun div(other: Dp): Float = value / other.value

    /**
     * Multiply a [Dp] by a scalar.
     */
    inline operator fun times(other: Float): Dp = Dp(value * other)

    /**
     * Multiply a [Dp] by a scalar.
     */
    inline operator fun times(other: Int): Dp = Dp(value * other)

    /**
     * Support comparing [Dp] with comparison operators.
     */
    @Suppress("OVERRIDE_BY_INLINE")
    override inline operator fun compareTo(other: Dp) = value.compareTo(other.value)

    override fun toString() = "${value}dp"
}

/**
 * Create a [Dp], e.g. `16f.dp`.
 */
inline val Float.dp get() = Dp(this)

/**
 * Create a [Dp], e.g. `16.0.dp`
 */
inline val Double.dp get() = Dp(this.toFloat())

/**
 * Convert a floating-point dp dimen to an integer dp dimen.
 */
fun Dp.toDpInt() = DpInt(value.toInt())

/**
 * Multiply a scalar by a [Dp].
 */
inline operator fun Float.times(other: Dp) = Dp(this * other.value)

/**
 * Multiply a scalar by a [Dp].
 */
inline operator fun Int.times(other: Dp) = Dp(this * other.value)

//region Min/max
/**
 * Determine the smaller [Dp].
 */
inline fun min(a: Dp, b: Dp): Dp = Dp(min(a.value, b.value))

/**
 * Determine the larger [Dp].
 */
inline fun max(a: Dp, b: Dp): Dp = Dp(max(a.value, b.value))

/**
 * Ensure that this value lies in the specified range [minimumValue]..[maximumValue].
 *
 * @return this value if it's in the range, or [minimumValue] if this value is less than [minimumValue], or
 * [maximumValue] if this value is greater than [maximumValue].
 */
inline fun Dp.coerceIn(minimumValue: Dp, maximumValue: Dp) = Dp(value.coerceIn(minimumValue.value, maximumValue.value))

/**
 * Ensures that this value is not less than the specified [minimumValue].
 *
 * @return this value if it's greater than or equal to the [minimumValue] or the [minimumValue] otherwise.
 */
inline fun Dp.coerceAtLeast(minimumValue: Dp) = Dp(value.coerceAtLeast(minimumValue.value))

/**
 * Ensure that this value is not greater than the specified [maximumValue].
 *
 * @return this value if it's less than or equal to the [maximumValue] or the [maximumValue] otherwise.
 */
inline fun Dp.coerceAtMost(maximumValue: Dp) = Dp(value.coerceAtMost(maximumValue.value))
//endregion

//region toPx
/**
 * Convert [this] dp value to px based on the system [Resources]' display metrics.
 */
fun Dp.toPx() = toPx(Resources.getSystem())

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
 * Convert [this] dp value to sp based on the system [Resources]' display metrics.
 */
fun Dp.toSp() = toSp(Resources.getSystem())

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
