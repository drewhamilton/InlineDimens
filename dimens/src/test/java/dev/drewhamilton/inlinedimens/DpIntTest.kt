package dev.drewhamilton.inlinedimens

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class DpIntTest {

    private val testInput = 24
    private val testDpInt = testInput.dp

    //region Operators
    @Test fun `plus adds DpInt`() =
        assertThat(testDpInt + testDpInt).isEqualTo(DpInt(testInput + testInput))

    @Test fun `minus subtracts DpInt`() =
        assertThat(testDpInt - 10.dp).isEqualTo(DpInt(testInput - 10))

    @Test fun `unaryMinus negates DpInt`() =
        assertThat(-testDpInt).isEqualTo(DpInt(-testInput))

    @Test fun `div with float divides DpInt by scalar`() =
        assertThat(testDpInt / 2.1f).isEqualTo(Dp(testInput / 2.1f))

    @Test fun `div with integer divides DpInt by scalar`() =
        assertThat(testDpInt / 2).isEqualTo(Dp(testInput / 2f))

    @Test fun `div with DpInt divides into scalar`() =
        assertThat(testDpInt / 3.dp).isEqualTo(testInput / 3)

    @Test fun `times with float multiplies DpInt by scalar`() =
        assertThat(testDpInt * 2.1f).isEqualTo(Dp(testInput * 2.1f))

    @Test fun `times with integer multiplies DpInt by scalar`() =
        assertThat(testDpInt * 2).isEqualTo(DpInt(testInput * 2))

    @Test fun `times with float receiver multiplies scalar by DpInt`() =
        assertThat(2.1f * testDpInt).isEqualTo(Dp(2.1f * testInput))

    @Test fun `times with integer receiver multiplies scalar by DpInt`() =
        assertThat(2 * testDpInt).isEqualTo(DpInt(2 * testInput))
    //endregion

    //region Comparisons
    @Test fun `compareTo compares correctly`() {
        assertThat(testDpInt).isGreaterThan(-testDpInt)
        assertThat(-testDpInt).isLessThan(testDpInt)
        assertThat(testDpInt).isEquivalentAccordingToCompareTo(testDpInt)
    }

    @Test fun `min chooses the lower value`() {
        assertThat(min(2.dp, 3.dp)).isEqualTo(2.dp)
        assertThat(min(2.dp, (-3).dp)).isEqualTo((-3).dp)
    }

    @Test fun `max chooses the higher value`() {
        assertThat(max(2.dp, 3.dp)).isEqualTo(3.dp)
        assertThat(max(2.dp, (-3).dp)).isEqualTo(2.dp)
    }

    @Test fun `coerceIn between values chooses original value`() =
        assertThat(3.dp.coerceIn(0.dp, 9.dp)).isEqualTo(3.dp)

    @Test fun `coerceIn over maximum value chooses maximum value`() =
        assertThat(19.dp.coerceIn(0.dp, 9.dp)).isEqualTo(9.dp)

    @Test fun `coerceIn under minimum value chooses minimum value`() =
        assertThat((-5).dp.coerceIn(0.dp, 9.dp)).isEqualTo(0.dp)

    @Test fun `coerceAtLeast under minimum value chooses minimum value`() =
        assertThat((-5).dp.coerceAtLeast(0.dp)).isEqualTo(0.dp)

    @Test fun `coerceAtLeast over minimum value chooses original value`() =
        assertThat(5.dp.coerceAtLeast(0.dp)).isEqualTo(5.dp)

    @Test fun `coerceAtMost under maximum value chooses original value`() =
        assertThat(5.dp.coerceAtMost(9.dp)).isEqualTo(5.dp)

    @Test fun `coerceAtMost over maximum value chooses maximum value`() =
        assertThat(34.dp.coerceAtMost(9.dp)).isEqualTo(9.dp)
    //endregion

    @Test fun `toDpFloat converts via Int-toFloat`() =
        assertThat(testDpInt.toDpFloat().value).isEqualTo(testInput.toFloat())

    //region toPx
    @Test fun `toPx(Context) multiplies value by density from DisplayMetrics`() {
        assertThat(testDpInt.toPx(TestValues.mockContext).value)
            .isEqualTo(testInput.toFloat() * TestValues.DENSITY)
    }

    @Test fun `toPx(Resources) multiplies value by density from DisplayMetrics`() {
        assertThat(testDpInt.toPx(TestValues.mockResources).value)
            .isEqualTo(testInput.toFloat() * TestValues.DENSITY)
    }

    @Test fun `toPx(DisplayMetrics) multiplies value by density from DisplayMetrics`() {
        assertThat(testDpInt.toPx(TestValues.displayMetrics).value)
            .isEqualTo(testInput.toFloat() * TestValues.DENSITY)
    }
    //endregion

    //region toSp
    @Test fun `toSp(Context) multiplies value by density and divides by scaledDensity from DisplayMetrics`() {
        assertThat(testDpInt.toSp(TestValues.mockContext).value)
            .isEqualTo(testInput.toFloat() * TestValues.DENSITY / TestValues.SCALED_DENSITY)
    }

    @Test fun `toSp(Resources) multiplies value by density and divides by scaledDensity from DisplayMetrics`() {
        assertThat(testDpInt.toSp(TestValues.mockResources).value)
            .isEqualTo(testInput.toFloat() * TestValues.DENSITY / TestValues.SCALED_DENSITY)
    }

    @Test fun `toSp(DisplayMetrics) multiplies value by density and divides by scaledDensity from DisplayMetrics`() {
        assertThat(testDpInt.toSp(TestValues.displayMetrics).value)
            .isEqualTo(testInput.toFloat() * TestValues.DENSITY / TestValues.SCALED_DENSITY)
    }
    //endregion
}
