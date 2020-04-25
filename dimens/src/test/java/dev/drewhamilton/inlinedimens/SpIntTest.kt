package dev.drewhamilton.inlinedimens

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SpIntTest {

    private val testInput = 932
    private val testSpInt = testInput.sp

    //region Operators
    @Test fun `plus adds SpInt`() =
        assertThat(testSpInt + testSpInt).isEqualTo(SpInt(testInput + testInput))

    @Test fun `minus subtracts SpInt`() =
        assertThat(testSpInt - 10.sp).isEqualTo(SpInt(testInput - 10))

    @Test fun `unaryMinus negates SpInt`() =
        assertThat(-testSpInt).isEqualTo(SpInt(-testInput))

    @Test fun `div with float divides SpInt by scalar`() =
        assertThat(testSpInt / 2.1f).isEqualTo(Sp(testInput / 2.1f))

    @Test fun `div with integer divides SpInt by scalar`() =
        assertThat(testSpInt / 2).isEqualTo(Sp(testInput / 2f))

    @Test fun `div with SpInt divides into scalar`() =
        assertThat(testSpInt / 3.sp).isEqualTo(testInput.toFloat() / 3)

    @Test fun `times with float multiplies SpInt by scalar`() =
        assertThat(testSpInt * 2.1f).isEqualTo(Sp(testInput * 2.1f))

    @Test fun `times with integer multiplies SpInt by scalar`() =
        assertThat(testSpInt * 2).isEqualTo(SpInt(testInput * 2))

    @Test fun `times with float receiver multiplies scalar by SpInt`() =
        assertThat(2.1f * testSpInt).isEqualTo(Sp(2.1f * testInput))

    @Test fun `times with integer receiver multiplies scalar by SpInt`() =
        assertThat(2 * testSpInt).isEqualTo(SpInt(2 * testInput))
    //endregion

    //region Comparisons
    @Test fun `compareTo compares correctly`() {
        assertThat(testSpInt).isGreaterThan(-testSpInt)
        assertThat(-testSpInt).isLessThan(testSpInt)
        assertThat(testSpInt).isEquivalentAccordingToCompareTo(testSpInt)
    }

    @Test fun `min chooses the lower value`() {
        assertThat(min(2.sp, 3.sp)).isEqualTo(2.sp)
        assertThat(min(2.sp, (-3).sp)).isEqualTo((-3).sp)
    }

    @Test fun `max chooses the higher value`() {
        assertThat(max(2.sp, 3.sp)).isEqualTo(3.sp)
        assertThat(max(2.sp, (-3).sp)).isEqualTo(2.sp)
    }

    @Test fun `coerceIn between values chooses original value`() =
        assertThat(3.sp.coerceIn(0.sp, 9.sp)).isEqualTo(3.sp)

    @Test fun `coerceIn over maximum value chooses maximum value`() =
        assertThat(19.sp.coerceIn(0.sp, 9.sp)).isEqualTo(9.sp)

    @Test fun `coerceIn under minimum value chooses minimum value`() =
        assertThat((-5).sp.coerceIn(0.sp, 9.sp)).isEqualTo(0.sp)

    @Test fun `coerceAtLeast under minimum value chooses minimum value`() =
        assertThat((-5).sp.coerceAtLeast(0.sp)).isEqualTo(0.sp)

    @Test fun `coerceAtLeast over minimum value chooses original value`() =
        assertThat(5.sp.coerceAtLeast(0.sp)).isEqualTo(5.sp)

    @Test fun `coerceAtMost under maximum value chooses original value`() =
        assertThat(5.sp.coerceAtMost(9.sp)).isEqualTo(5.sp)

    @Test fun `coerceAtMost over maximum value chooses maximum value`() =
        assertThat(34.sp.coerceAtMost(9.sp)).isEqualTo(9.sp)
    //endregion

    @Test fun `toString returns well-formatted unit`() =
        assertThat(testSpInt.toString()).isEqualTo("932sp")

    @Test fun `exact converts via Int-toFloat`() =
        assertThat(testSpInt.exact().value).isEqualTo(testInput.toFloat())

    @Suppress("DEPRECATION")
    @Deprecated("Testing deprecated function")
    @Test fun `toDpFloat converts via Int-toFloat`() {
        assertThat(testSpInt.toSpFloat().value)
            .isEqualTo(testInput.toFloat())
    }

    //region toPx
    @Test fun `toPx(Context) multiplies value by scaledDensity from DisplayMetrics`() {
        assertThat(testSpInt.toPx(TestValues.mockContext).value)
            .isEqualTo(testInput.toFloat() * TestValues.SCALED_DENSITY)
    }

    @Test fun `toPx(Resources) multiplies value by scaledDensity from DisplayMetrics`() {
        assertThat(testSpInt.toPx(TestValues.mockResources).value)
            .isEqualTo(testInput.toFloat() * TestValues.SCALED_DENSITY)
    }

    @Test fun `toPx(DisplayMetrics) multiplies value by scaledDensity from DisplayMetrics`() {
        assertThat(testSpInt.toPx(TestValues.displayMetrics).value)
            .isEqualTo(testInput.toFloat() * TestValues.SCALED_DENSITY)
    }
    //endregion

    //region toDp
    @Test fun `toDp(Context) multiplies value by scaledDensity and divides by density from DisplayMetrics`() {
        assertThat(testSpInt.toDp(TestValues.mockContext).value)
            .isEqualTo(testInput.toFloat() * TestValues.SCALED_DENSITY / TestValues.DENSITY)
    }

    @Test fun `toDp(Resources) multiplies value by scaledDensity and divides by density from DisplayMetrics`() {
        assertThat(testSpInt.toDp(TestValues.mockResources).value)
            .isEqualTo(testInput.toFloat() * TestValues.SCALED_DENSITY / TestValues.DENSITY)
    }

    @Test fun `toDp(DisplayMetrics) multiplies value by scaledDensity and divides by density from DisplayMetrics`() {
        assertThat(testSpInt.toDp(TestValues.displayMetrics).value)
            .isEqualTo(testInput.toFloat() * TestValues.SCALED_DENSITY / TestValues.DENSITY)
    }
    //endregion
}
