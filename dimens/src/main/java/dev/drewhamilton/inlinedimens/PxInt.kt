package dev.drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

/**
 * The integer representation of px dimens.
 */
inline class PxInt(val value: Int) : Comparable<PxInt> {
    /**
     * Add two [PxInt]s together.
     */
    operator fun plus(other: PxInt) = PxInt(this.value + other.value)

    /**
     * Subtract a [PxInt] from another one.
     */
    operator fun minus(other: PxInt) = PxInt(this.value - other.value)

    /**
     * This is the same as multiplying the [PxInt] by -1.0.
     */
    operator fun unaryMinus() = PxInt(-value)

    /**
     * Divide a [PxInt] by a scalar.
     */
    operator fun div(other: Float): Px = Px(value / other)

    /**
     * Divide a [PxInt] by a scalar.
     */
    operator fun div(other: Int): Px = Px(value.toFloat() / other)

    /**
     * Divide by another [PxInt] to get a scalar.
     */
    operator fun div(other: PxInt): Float = value.toFloat() / other.value

    /**
     * Multiply a [PxInt] by a scalar.
     */
    operator fun times(other: Float): Px = Px(value * other)

    /**
     * Multiply a [PxInt] by a scalar.
     */
    operator fun times(other: Int): PxInt = PxInt(value * other)

    /**
     * Support comparing [PxInt] with comparison operators.
     */
    override operator fun compareTo(other: PxInt) = value.compareTo(other.value)

    override fun toString() = "${value}px"
}

/**
 * Create a [PxInt], e.g. `16.px`.
 */
inline val Int.px get() = PxInt(this)

/**
 * Convert an integer px dimen to a floating-point px dimen.
 */
fun PxInt.exact() = Px(value.toFloat())

/**
 * Multiply a scalar by a [PxInt].
 */
operator fun Float.times(other: PxInt) = Px(this * other.value)

/**
 * Multiply a scalar by a [PxInt].
 */
operator fun Int.times(other: PxInt) = PxInt(this * other.value)

//region Min/max
/**
 * Determine the smaller [PxInt].
 */
fun min(a: PxInt, b: PxInt): PxInt = PxInt(kotlin.math.min(a.value, b.value))

/**
 * Determine the larger [PxInt].
 */
fun max(a: PxInt, b: PxInt): PxInt = PxInt(kotlin.math.max(a.value, b.value))

/**
 * Ensure that this value lies in the specified range [minimumValue]..[maximumValue].
 *
 * @return this value if it's in the range, or [minimumValue] if this value is less than [minimumValue], or
 * [maximumValue] if this value is greater than [maximumValue].
 */
fun PxInt.coerceIn(minimumValue: PxInt, maximumValue: PxInt) =
    PxInt(value.coerceIn(minimumValue.value, maximumValue.value))

/**
 * Ensures that this value is not less than the specified [minimumValue].
 *
 * @return this value if it's greater than or equal to the [minimumValue] or the [minimumValue] otherwise.
 */
fun PxInt.coerceAtLeast(minimumValue: PxInt) = PxInt(value.coerceAtLeast(minimumValue.value))

/**
 * Ensure that this value is not greater than the specified [maximumValue].
 *
 * @return this value if it's less than or equal to the [maximumValue] or the [maximumValue] otherwise.
 */
fun PxInt.coerceAtMost(maximumValue: PxInt) = PxInt(value.coerceAtMost(maximumValue.value))
//endregion

//region toDp
/**
 * Convert a px value to dp based on the system [Resources]' display metrics.
 */
fun PxInt.toDp() = toDp(Resources.getSystem())

/**
 * Convert a px value to dp based on [context]'s display metrics.
 */
fun PxInt.toDp(context: Context) = toDp(context.resources)

/**
 * Convert a px value to dp based on [resources]' display metrics.
 */
fun PxInt.toDp(resources: Resources) = toDp(resources.displayMetrics)

/**
 * Convert a px value to dp based on [displayMetrics].
 */
fun PxInt.toDp(displayMetrics: DisplayMetrics) = exact().toDp(displayMetrics.density)
//endregion

//region toSp
/**
 * Convert a px value to sp based on the system [Resources]' display metrics.
 */
fun PxInt.toSp() = toSp(Resources.getSystem())

/**
 * Convert a px value to sp based on [context]'s display metrics.
 */
fun PxInt.toSp(context: Context) = toSp(context.resources)

/**
 * Convert a px value to sp based on [resources]' display metrics.
 */
fun PxInt.toSp(resources: Resources) = toSp(resources.displayMetrics)

/**
 * Convert a px value to sp based on [displayMetrics].
 */
fun PxInt.toSp(displayMetrics: DisplayMetrics) = exact().toSp(displayMetrics.scaledDensity)
//endregion
