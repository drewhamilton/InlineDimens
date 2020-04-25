package dev.drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

/**
 * The integer representation of sp dimens.
 */
inline class SpInt(val value: Int) : Comparable<SpInt> {
    /**
     * Add two [SpInt]s together.
     */
    operator fun plus(other: SpInt) = SpInt(this.value + other.value)

    /**
     * Subtract an [SpInt] from another one.
     */
    operator fun minus(other: SpInt) = SpInt(this.value - other.value)

    /**
     * This is the same as multiplying the [SpInt] by -1.0.
     */
    operator fun unaryMinus() = SpInt(-value)

    /**
     * Divide an [SpInt] by a scalar.
     */
    operator fun div(other: Float): Sp = Sp(value / other)

    /**
     * Divide an [SpInt] by a scalar.
     */
    operator fun div(other: Int): Sp = Sp(value.toFloat() / other)

    /**
     * Divide by another [SpInt] to get a scalar.
     */
    operator fun div(other: SpInt): Float = value.toFloat() / other.value

    /**
     * Multiply an [SpInt] by a scalar.
     */
    operator fun times(other: Float): Sp = Sp(value * other)

    /**
     * Multiply an [SpInt] by a scalar.
     */
    operator fun times(other: Int): SpInt = SpInt(value * other)

    /**
     * Support comparing [SpInt] with comparison operators.
     */
    override operator fun compareTo(other: SpInt) = value.compareTo(other.value)

    override fun toString() = "${value}sp"
}

/**
 * Create an [SpInt], e.g. `16.sp`.
 */
inline val Int.sp get() = SpInt(this)

/**
 * Convert [this] to a floating-point sp dimen.
 */
fun SpInt.toSpFloat() = Sp(value.toFloat())

/**
 * Multiply a scalar by an [SpInt].
 */
operator fun Float.times(other: SpInt) = Sp(this * other.value)

/**
 * Multiply a scalar by an [SpInt].
 */
operator fun Int.times(other: SpInt) = SpInt(this * other.value)

//region Min/max
/**
 * Determine the smaller [SpInt].
 */
fun min(a: SpInt, b: SpInt): SpInt = SpInt(kotlin.math.min(a.value, b.value))

/**
 * Determine the larger [SpInt].
 */
fun max(a: SpInt, b: SpInt): SpInt = SpInt(kotlin.math.max(a.value, b.value))

/**
 * Ensure that this value lies in the specified range [minimumValue]..[maximumValue].
 *
 * @return this value if it's in the range, or [minimumValue] if this value is less than [minimumValue], or
 * [maximumValue] if this value is greater than [maximumValue].
 */
fun SpInt.coerceIn(minimumValue: SpInt, maximumValue: SpInt) =
    SpInt(value.coerceIn(minimumValue.value, maximumValue.value))

/**
 * Ensures that this value is not less than the specified [minimumValue].
 *
 * @return this value if it's greater than or equal to the [minimumValue] or the [minimumValue] otherwise.
 */
fun SpInt.coerceAtLeast(minimumValue: SpInt) = SpInt(value.coerceAtLeast(minimumValue.value))

/**
 * Ensure that this value is not greater than the specified [maximumValue].
 *
 * @return this value if it's less than or equal to the [maximumValue] or the [maximumValue] otherwise.
 */
fun SpInt.coerceAtMost(maximumValue: SpInt) = SpInt(value.coerceAtMost(maximumValue.value))
//endregion

//region toPx
/**
 * Convert [this] sp value to px based on the system [Resources]' display metrics.
 */
fun SpInt.toPx() = toPx(Resources.getSystem())

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
 * Convert [this] sp value to dp based on the system [Resources]' display metrics.
 */
fun SpInt.toDp() = toDp(Resources.getSystem())

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
