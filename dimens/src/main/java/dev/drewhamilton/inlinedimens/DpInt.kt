package dev.drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import kotlin.math.max
import kotlin.math.min

/**
 * The integer representation of dp dimens.
 */
inline class DpInt(val value: Int) : Comparable<DpInt> {
    /**
     * Add two [DpInt]s together.
     */
    operator fun plus(other: DpInt) = DpInt(this.value + other.value)

    /**
     * Subtract a [DpInt] from another one.
     */
    operator fun minus(other: DpInt) = DpInt(this.value - other.value)

    /**
     * This is the same as multiplying the [DpInt] by -1.0.
     */
    operator fun unaryMinus() = DpInt(-value)

    /**
     * Divide a [DpInt] by a scalar.
     */
    operator fun div(other: Float): Dp = Dp(value / other)

    /**
     * Divide a [DpInt] by a scalar.
     */
    operator fun div(other: Int): Dp = Dp(value.toFloat() / other)

    /**
     * Divide by another [DpInt] to get a scalar.
     */
    operator fun div(other: DpInt): Float = value.toFloat() / other.value

    /**
     * Multiply a [DpInt] by a scalar.
     */
    operator fun times(other: Float): Dp = Dp(value * other)

    /**
     * Multiply a [DpInt] by a scalar.
     */
    operator fun times(other: Int): DpInt = DpInt(value * other)

    /**
     * Support comparing [DpInt] with comparison operators.
     */
    override operator fun compareTo(other: DpInt) = value.compareTo(other.value)

    override fun toString() = "${value}dp"
}

/**
 * Create a [DpInt], e.g. `16.dp`.
 */
inline val Int.dp get() = DpInt(this)

/**
 * Convert an integer dp dimen to a floating-point dp dimen.
 */
fun DpInt.exact() = Dp(value.toFloat())

/**
 * Multiply a scalar by a [DpInt].
 */
operator fun Float.times(other: DpInt) = Dp(this * other.value)

/**
 * Multiply a scalar by a [DpInt].
 */
operator fun Int.times(other: DpInt) = DpInt(this * other.value)

//region Min/max
/**
 * Determine the smaller [DpInt].
 */
fun min(a: DpInt, b: DpInt): DpInt = DpInt(min(a.value, b.value))

/**
 * Determine the larger [DpInt].
 */
fun max(a: DpInt, b: DpInt): DpInt = DpInt(max(a.value, b.value))

/**
 * Ensure that this value lies in the specified range [minimumValue]..[maximumValue].
 *
 * @return this value if it's in the range, or [minimumValue] if this value is less than [minimumValue], or
 * [maximumValue] if this value is greater than [maximumValue].
 */
fun DpInt.coerceIn(minimumValue: DpInt, maximumValue: DpInt) =
    DpInt(value.coerceIn(minimumValue.value, maximumValue.value))

/**
 * Ensures that this value is not less than the specified [minimumValue].
 *
 * @return this value if it's greater than or equal to the [minimumValue] or the [minimumValue] otherwise.
 */
fun DpInt.coerceAtLeast(minimumValue: DpInt) = DpInt(value.coerceAtLeast(minimumValue.value))

/**
 * Ensure that this value is not greater than the specified [maximumValue].
 *
 * @return this value if it's less than or equal to the [maximumValue] or the [maximumValue] otherwise.
 */
fun DpInt.coerceAtMost(maximumValue: DpInt) = DpInt(value.coerceAtMost(maximumValue.value))
//endregion

//region toPx
/**
 * Convert a dp value to px based on the system [Resources]' display metrics.
 */
fun DpInt.toPx() = toPx(Resources.getSystem())

/**
 * Convert a dp value to px based on [context]'s display metrics.
 */
fun DpInt.toPx(context: Context) = toPx(context.resources)

/**
 * Convert a dp value to px based on [resources]' display metrics.
 */
fun DpInt.toPx(resources: Resources) = toPx(resources.displayMetrics)

/**
 * Convert a dp value to px based on [displayMetrics].
 */
fun DpInt.toPx(displayMetrics: DisplayMetrics) = exact().toPx(displayMetrics.density)
//endregion

//region toSp
/**
 * Convert a dp value to sp based on the system [Resources]' display metrics.
 */
fun DpInt.toSp() = toSp(Resources.getSystem())

/**
 * Convert a dp value to sp based on [context]'s display metrics.
 */
fun DpInt.toSp(context: Context) = toSp(context.resources)

/**
 * Convert a dp value to sp based on [resources]' display metrics.
 */
fun DpInt.toSp(resources: Resources) = toSp(resources.displayMetrics)

/**
 * Convert a dp value to sp based on [displayMetrics].
 */
fun DpInt.toSp(displayMetrics: DisplayMetrics) = exact().toSp(
    density = displayMetrics.density,
    scaledDensity = displayMetrics.scaledDensity
)
//endregion
