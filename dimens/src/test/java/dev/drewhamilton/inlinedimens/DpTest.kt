package dev.drewhamilton.inlinedimens

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class DpTest {

    private val testInput = 23.7f
    private val testDp = testInput.dp

    //region Operators
    @Test fun `plus adds Dp`() =
        assertThat(testDp + testDp).isEqualTo(Dp(testInput + testInput))

    @Test fun `minus subtracts Dp`() =
        assertThat(testDp - 10f.dp).isEqualTo(Dp(testInput - 10f))

    @Test fun `unaryMinus negates Dp`() =
        assertThat(-testDp).isEqualTo(Dp(-testInput))

    @Test fun `div with float divides Dp by scalar`() =
        assertThat(testDp / 2.1f).isEqualTo(Dp(testInput / 2.1f))

    @Test fun `div with integer divides Dp by scalar`() =
        assertThat(testDp / 2).isEqualTo(Dp(testInput / 2))

    @Test fun `div with Dp divides into scalar`() =
        assertThat(testDp / 2.9.dp).isEqualTo(testInput / 2.9f)

    @Test fun `times with float multiplies Dp by scalar`() =
        assertThat(testDp * 2.1f).isEqualTo(Dp(testInput * 2.1f))

    @Test fun `times with integer multiplies Dp by scalar`() =
        assertThat(testDp * 2).isEqualTo(Dp(testInput * 2))

    @Test fun `times with float receiver multiplies scalar by Dp`() =
        assertThat(2.1f * testDp).isEqualTo(Dp(2.1f * testInput))

    @Test fun `times with integer receiver multiplies scalar by Dp`() =
        assertThat(2 * testDp).isEqualTo(Dp(2 * testInput))
    //endregion

    //region Comparisons
    @Test fun `compareTo compares correctly`() {
        assertThat(testDp).isGreaterThan(-testDp)
        assertThat(-testDp).isLessThan(testDp)
        assertThat(testDp).isEquivalentAccordingToCompareTo(testDp)
    }

    @Test fun `min chooses the lower value`() {
        assertThat(min(2f.dp, 3f.dp)).isEqualTo(2f.dp)
        assertThat(min(2f.dp, (-3f).dp)).isEqualTo((-3f).dp)
    }

    @Test fun `max chooses the higher value`() {
        assertThat(max(2f.dp, 3f.dp)).isEqualTo(3f.dp)
        assertThat(max(2f.dp, (-3f).dp)).isEqualTo(2f.dp)
    }

    @Test fun `coerceIn between values chooses original value`() =
        assertThat(3f.dp.coerceIn(0f.dp, 9f.dp)).isEqualTo(3f.dp)

    @Test fun `coerceIn over maximum value chooses maximum value`() =
        assertThat(19f.dp.coerceIn(0f.dp, 9f.dp)).isEqualTo(9f.dp)

    @Test fun `coerceIn under minimum value chooses minimum value`() =
        assertThat((-5f).dp.coerceIn(0f.dp, 9f.dp)).isEqualTo(0f.dp)

    @Test fun `coerceAtLeast under minimum value chooses minimum value`() =
        assertThat((-5f).dp.coerceAtLeast(0f.dp)).isEqualTo(0f.dp)

    @Test fun `coerceAtLeast over minimum value chooses original value`() =
        assertThat(5f.dp.coerceAtLeast(0f.dp)).isEqualTo(5f.dp)

    @Test fun `coerceAtMost under maximum value chooses original value`() =
        assertThat(5f.dp.coerceAtMost(9f.dp)).isEqualTo(5f.dp)

    @Test fun `coerceAtMost over maximum value chooses maximum value`() =
        assertThat(34f.dp.coerceAtMost(9f.dp)).isEqualTo(9f.dp)
    //endregion

    @Test fun `toString returns well-formatted unit`() =
        assertThat(testDp.toString()).isEqualTo("23.7dp")

    @Test fun `toSize with normal value rounds value`() =
        assertThat(testDp.toSize().value).isEqualTo(24)

    @Test fun `toSize with low value resolves to one`() =
        assertThat(0.3.dp.toSize().value).isEqualTo(1)

    @Test fun `toSize with value zero resolves to zero`() =
        assertThat(0f.dp.toSize().value).isEqualTo(0)

    @Test fun `toSize with low negative value resolves to negative one`() =
        assertThat(-0.1.dp.toSize().value).isEqualTo(-1)

    @Test fun `toOffset converts via Float-toInt`() =
        assertThat(testDp.toOffset().value).isEqualTo(testInput.toInt())

    @Suppress("DEPRECATION")
    @Deprecated("Testing deprecated function")
    @Test fun `toDpInt converts via Float-toInt`() =
        assertThat(testDp.toDpInt().value).isEqualTo(testInput.toInt())

    //region toPx
    @Test fun `toPx(Context) multiplies value by density from DisplayMetrics`() {
        assertThat(testDp.toPx(TestValues.mockContext).value)
            .isEqualTo(testInput * TestValues.DENSITY)
    }

    @Test fun `toPx(Resources) multiplies value by density from DisplayMetrics`() {
        assertThat(testDp.toPx(TestValues.mockResources).value)
            .isEqualTo(testInput * TestValues.DENSITY)
    }

    @Test fun `toPx(DisplayMetrics) multiplies value by density from DisplayMetrics`() {
        assertThat(testDp.toPx(TestValues.displayMetrics).value)
            .isEqualTo(testInput * TestValues.DENSITY)
    }
    //endregion

    //region toSp
    @Test fun `toSp(Context) multiplies value by density and divides by scaledDensity from DisplayMetrics`() {
        assertThat(testDp.toSp(TestValues.mockContext).value)
            .isEqualTo(testInput * TestValues.DENSITY / TestValues.SCALED_DENSITY)
    }

    @Test fun `toSp(Resources) multiplies value by density and divides by scaledDensity from DisplayMetrics`() {
        assertThat(testDp.toSp(TestValues.mockResources).value)
            .isEqualTo(testInput * TestValues.DENSITY / TestValues.SCALED_DENSITY)
    }

    @Test fun `toSp(DisplayMetrics) multiplies value by density and divides by scaledDensity from DisplayMetrics`() {
        assertThat(testDp.toSp(TestValues.displayMetrics).value)
            .isEqualTo(testInput * TestValues.DENSITY / TestValues.SCALED_DENSITY)
    }
    //endregion
}
