package dev.drewhamilton.inlinedimens

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SpTest {

    private val testInput = 234.7f
    private val testSp = testInput.sp

    //region Operators
    @Test fun `plus adds Sp`() =
        assertThat(testSp + testSp).isEqualTo(Sp(testInput + testInput))

    @Test fun `minus subtracts Sp`() =
        assertThat(testSp - 10f.sp).isEqualTo(Sp(testInput - 10f))

    @Test fun `unaryMinus negates Sp`() =
        assertThat(-testSp).isEqualTo(Sp(-testInput))

    @Test fun `div with float divides Sp by scalar`() =
        assertThat(testSp / 2.1f).isEqualTo(Sp(testInput / 2.1f))

    @Test fun `div with integer divides Sp by scalar`() =
        assertThat(testSp / 2).isEqualTo(Sp(testInput / 2))

    @Test fun `div with Sp divides into scalar`() =
        assertThat(testSp / 2.9.sp).isEqualTo(testInput / 2.9f)

    @Test fun `times with float multiplies Sp by scalar`() =
        assertThat(testSp * 2.1f).isEqualTo(Sp(testInput * 2.1f))

    @Test fun `times with integer multiplies Sp by scalar`() =
        assertThat(testSp * 2).isEqualTo(Sp(testInput * 2))

    @Test fun `times with float receiver multiplies scalar by Sp`() =
        assertThat(2.1f * testSp).isEqualTo(Sp(2.1f * testInput))

    @Test fun `times with integer receiver multiplies scalar by Sp`() =
        assertThat(2 * testSp).isEqualTo(Sp(2 * testInput))
    //endregion

    //region Comparisons
    @Test fun `compareTo compares correctly`() {
        assertThat(testSp).isGreaterThan(-testSp)
        assertThat(-testSp).isLessThan(testSp)
        assertThat(testSp).isEquivalentAccordingToCompareTo(testSp)
    }

    @Test fun `min chooses the lower value`() {
        assertThat(min(2f.sp, 3f.sp)).isEqualTo(2f.sp)
        assertThat(min(2f.sp, (-3f).sp)).isEqualTo((-3f).sp)
    }

    @Test fun `max chooses the higher value`() {
        assertThat(max(2f.sp, 3f.sp)).isEqualTo(3f.sp)
        assertThat(max(2f.sp, (-3f).sp)).isEqualTo(2f.sp)
    }

    @Test fun `coerceIn between values chooses original value`() =
        assertThat(3f.sp.coerceIn(0f.sp, 9f.sp)).isEqualTo(3f.sp)

    @Test fun `coerceIn over maximum value chooses maximum value`() =
        assertThat(19f.sp.coerceIn(0f.sp, 9f.sp)).isEqualTo(9f.sp)

    @Test fun `coerceIn under minimum value chooses minimum value`() =
        assertThat((-5f).sp.coerceIn(0f.sp, 9f.sp)).isEqualTo(0f.sp)

    @Test fun `coerceAtLeast under minimum value chooses minimum value`() =
        assertThat((-5f).sp.coerceAtLeast(0f.sp)).isEqualTo(0f.sp)

    @Test fun `coerceAtLeast over minimum value chooses original value`() =
        assertThat(5f.sp.coerceAtLeast(0f.sp)).isEqualTo(5f.sp)

    @Test fun `coerceAtMost under maximum value chooses original value`() =
        assertThat(5f.sp.coerceAtMost(9f.sp)).isEqualTo(5f.sp)

    @Test fun `coerceAtMost over maximum value chooses maximum value`() =
        assertThat(34f.sp.coerceAtMost(9f.sp)).isEqualTo(9f.sp)
    //endregion

    @Test fun `toString returns well-formatted unit`() =
        assertThat(testSp.toString()).isEqualTo("234.7sp")

    @Test fun `toSize with normal value rounds value`() =
        assertThat(testSp.toSize().value).isEqualTo(235)

    @Test fun `toSize with low value resolves to one`() =
        assertThat(0.3.sp.toSize().value).isEqualTo(1)

    @Test fun `toSize with value zero resolves to zero`() =
        assertThat(0f.sp.toSize().value).isEqualTo(0)

    @Test fun `toSize with low negative value resolves to negative one`() =
        assertThat(-0.1.sp.toSize().value).isEqualTo(-1)

    @Test fun `toOffset converts via Float-toInt`() =
        assertThat(testSp.toOffset().value).isEqualTo(testInput.toInt())

    //region toPx
    @Test fun `toPx(Context) multiplies value by scaledDensity from DisplayMetrics`() {
        assertThat(testSp.toPx(TestValues.mockContext).value)
            .isEqualTo(testInput * TestValues.SCALED_DENSITY)
    }

    @Test fun `toPx(Resources) multiplies value by scaledDensity from DisplayMetrics`() {
        assertThat(testSp.toPx(TestValues.mockResources).value)
            .isEqualTo(testInput * TestValues.SCALED_DENSITY)
    }

    @Test fun `toPx(DisplayMetrics) multiplies value by scaledDensity from DisplayMetrics`() {
        assertThat(testSp.toPx(TestValues.displayMetrics).value)
            .isEqualTo(testInput * TestValues.SCALED_DENSITY)
    }
    //endregion

    //region toDp
    @Test fun `toDp(Context) multiplies value by scaledDensity and divides by density from DisplayMetrics`() {
        assertThat(testSp.toDp(TestValues.mockContext).value)
            .isEqualTo(testInput * TestValues.SCALED_DENSITY / TestValues.DENSITY)
    }

    @Test fun `toDp(Resources) multiplies value by scaledDensity and divides by density from DisplayMetrics`() {
        assertThat(testSp.toDp(TestValues.mockResources).value)
            .isEqualTo(testInput * TestValues.SCALED_DENSITY / TestValues.DENSITY)
    }

    @Test fun `toDp(DisplayMetrics) multiplies value by scaledDensity and divides by density from DisplayMetrics`() {
        assertThat(testSp.toDp(TestValues.displayMetrics).value)
            .isEqualTo(testInput * TestValues.SCALED_DENSITY / TestValues.DENSITY)
    }
    //endregion
}
