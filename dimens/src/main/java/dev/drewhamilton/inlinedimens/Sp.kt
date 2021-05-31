package dev.drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import kotlin.math.roundToInt

/**
 * The floating-point representation of sp dimens.
 */
inline class Sp(val value: Float) : Comparable<Sp> {
    /**
     * Add two [Sp]s together.
     */
    operator fun plus(other: Sp) = Sp(this.value + other.value)

    /**
     * Subtract an [Sp] from another one.
     */
    operator fun minus(other: Sp) = Sp(this.value - other.value)

    /**
     * This is the same as multiplying the [Sp] by -1.0.
     */
    operator fun unaryMinus() = Sp(-value)

    /**
     * Divide an [Sp] by a scalar.
     */
    operator fun div(other: Float): Sp = Sp(value / other)

    /**
     * Divide an [Sp] by a scalar.
     */
    operator fun div(other: Int): Sp = Sp(value / other)

    /**
     * Divide by another [Sp] to get a scalar.
     */
    operator fun div(other: Sp): Float = value / other.value

    /**
     * Multiply an [Sp] by a scalar.
     */
    operator fun times(other: Float): Sp = Sp(value * other)

    /**
     * Multiply an [Sp] by a scalar.
     */
    operator fun times(other: Int): Sp = Sp(value * other)

    /**
     * Support comparing [Sp] with comparison operators.
     */
    override operator fun compareTo(other: Sp) = value.compareTo(other.value)

    override fun toString() = "${value}sp"
}

/**
 * Create an [Sp], e.g. `16f.sp`.
 */
inline val Float.sp: Sp get() = Sp(this)

/**
 * Create an [Sp], e.g. `16.0.sp`
 */
inline val Double.sp get() = Sp(this.toFloat())

/**
 * Convert a floating-point sp dimen to an integer sp dimen by converting the value to a size.
 *
 * A size conversion involves rounding the base value and ensuring that a non-zero base value is at least one sp.
 */
fun Sp.toSize(): SpInt {
    val rounded = value.roundToInt()
    val size = when {
        rounded != 0 -> rounded
        value == 0f -> 0
        value > 0f -> 1
        else -> -1
    }
    return SpInt(size)
}

/**
 * Convert a floating-point sp dimen to an integer sp dimen by simply truncating the base value.
 */
fun Sp.toOffset() = SpInt(value.toInt())

/**
 * Multiply a scalar by an [Sp].
 */
operator fun Float.times(other: Sp) = Sp(this * other.value)

/**
 * Multiply a scalar by an [Sp].
 */
operator fun Int.times(other: Sp) = Sp(this * other.value)

//region Min/max
/**
 * Determine the smaller [Sp].
 */
fun min(a: Sp, b: Sp): Sp = Sp(kotlin.math.min(a.value, b.value))

/**
 * Determine the larger [Sp].
 */
fun max(a: Sp, b: Sp): Sp = Sp(kotlin.math.max(a.value, b.value))

/**
 * Ensure that this value lies in the specified range [minimumValue]..[maximumValue].
 *
 * @return this value if it's in the range, or [minimumValue] if this value is less than [minimumValue], or
 * [maximumValue] if this value is greater than [maximumValue].
 */
fun Sp.coerceIn(minimumValue: Sp, maximumValue: Sp) = Sp(value.coerceIn(minimumValue.value, maximumValue.value))

/**
 * Ensures that this value is not less than the specified [minimumValue].
 *
 * @return this value if it's greater than or equal to the [minimumValue] or the [minimumValue] otherwise.
 */
fun Sp.coerceAtLeast(minimumValue: Sp) = Sp(value.coerceAtLeast(minimumValue.value))

/**
 * Ensure that this value is not greater than the specified [maximumValue].
 *
 * @return this value if it's less than or equal to the [maximumValue] or the [maximumValue] otherwise.
 */
fun Sp.coerceAtMost(maximumValue: Sp) = Sp(value.coerceAtMost(maximumValue.value))
//endregion

//region toPx
/**
 * Convert an sp value to px based on the system [Resources]' display metrics.
 */
fun Sp.toPx() = toPx(Resources.getSystem())

/**
 * Convert an sp value to px based on [context]'s display metrics.
 */
fun Sp.toPx(context: Context) = toPx(context.resources)

/**
 * Convert an sp value to px based on [resources]' display metrics.
 */
fun Sp.toPx(resources: Resources) = toPx(resources.displayMetrics)

/**
 * Convert an sp value to px based on [displayMetrics].
 */
fun Sp.toPx(displayMetrics: DisplayMetrics) = toPx(displayMetrics.scaledDensity)

/**
 * Convert an sp value to px based on the given [scaledDensity].
 */
internal fun Sp.toPx(scaledDensity: Float) = Px(value * scaledDensity)
//endregion

//region toDp
/**
 * Convert an sp value to dp based on the system [Resources]' display metrics.
 */
fun Sp.toDp() = toDp(Resources.getSystem())

/**
 * Convert an sp value to dp based on [context]'s display metrics.
 */
fun Sp.toDp(context: Context) = toDp(context.resources)

/**
 * Convert an sp value to dp based on [resources]' display metrics.
 */
fun Sp.toDp(resources: Resources) = toDp(resources.displayMetrics)

/**
 * Convert an sp value to dp based on [displayMetrics].
 */
fun Sp.toDp(displayMetrics: DisplayMetrics) = toDp(
    density = displayMetrics.density,
    scaledDensity = displayMetrics.scaledDensity
)

/**
 * Convert an sp value to dp based on the given [density] and [scaledDensity].
 */
internal fun Sp.toDp(density: Float, scaledDensity: Float) = Dp(value * scaledDensity / density)
//endregion
