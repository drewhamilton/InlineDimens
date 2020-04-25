package dev.drewhamilton.inlinedimens

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class PxTest {

    private val testInput = 98325.3f
    private val testPx = testInput.px

    //region Operators
    @Test fun `plus adds Px`() =
        assertThat(testPx + testPx).isEqualTo(Px(testInput + testInput))

    @Test fun `minus subtracts Px`() =
        assertThat(testPx - 10f.px).isEqualTo(Px(testInput - 10f))

    @Test fun `unaryMinus negates Px`() =
        assertThat(-testPx).isEqualTo(Px(-testInput))

    @Test fun `div with float divides Px by scalar`() =
        assertThat(testPx / 2.1f).isEqualTo(Px(testInput / 2.1f))

    @Test fun `div with integer divides Px by scalar`() =
        assertThat(testPx / 2).isEqualTo(Px(testInput / 2))

    @Test fun `div with Px divides into scalar`() =
        assertThat(testPx / 2.9.px).isEqualTo(testInput / 2.9f)

    @Test fun `times with float multiplies Px by scalar`() =
        assertThat(testPx * 2.1f).isEqualTo(Px(testInput * 2.1f))

    @Test fun `times with integer multiplies Px by scalar`() =
        assertThat(testPx * 2).isEqualTo(Px(testInput * 2))

    @Test fun `times with float receiver multiplies scalar by Px`() =
        assertThat(2.1f * testPx).isEqualTo(Px(2.1f * testInput))

    @Test fun `times with integer receiver multiplies scalar by Px`() =
        assertThat(2 * testPx).isEqualTo(Px(2 * testInput))
    //endregion

    //region Comparisons
    @Test fun `compareTo compares correctly`() {
        assertThat(testPx).isGreaterThan(-testPx)
        assertThat(-testPx).isLessThan(testPx)
        assertThat(testPx).isEquivalentAccordingToCompareTo(testPx)
    }

    @Test fun `min chooses the lower value`() {
        assertThat(min(2f.px, 3f.px)).isEqualTo(2f.px)
        assertThat(min(2f.px, (-3f).px)).isEqualTo((-3f).px)
    }

    @Test fun `max chooses the higher value`() {
        assertThat(max(2f.px, 3f.px)).isEqualTo(3f.px)
        assertThat(max(2f.px, (-3f).px)).isEqualTo(2f.px)
    }

    @Test fun `coerceIn between values chooses original value`() =
        assertThat(3f.px.coerceIn(0f.px, 9f.px)).isEqualTo(3f.px)

    @Test fun `coerceIn over maximum value chooses maximum value`() =
        assertThat(19f.px.coerceIn(0f.px, 9f.px)).isEqualTo(9f.px)

    @Test fun `coerceIn under minimum value chooses minimum value`() =
        assertThat((-5f).px.coerceIn(0f.px, 9f.px)).isEqualTo(0f.px)

    @Test fun `coerceAtLeast under minimum value chooses minimum value`() =
        assertThat((-5f).px.coerceAtLeast(0f.px)).isEqualTo(0f.px)

    @Test fun `coerceAtLeast over minimum value chooses original value`() =
        assertThat(5f.px.coerceAtLeast(0f.px)).isEqualTo(5f.px)

    @Test fun `coerceAtMost under maximum value chooses original value`() =
        assertThat(5f.px.coerceAtMost(9f.px)).isEqualTo(5f.px)

    @Test fun `coerceAtMost over maximum value chooses maximum value`() =
        assertThat(34f.px.coerceAtMost(9f.px)).isEqualTo(9f.px)
    //endregion

    @Test fun `toString returns well-formatted unit`() =
        assertThat(testPx.toString()).isEqualTo("98325.3px")

    @Test fun `toPxInt converts via Float-toInt`() =
        assertThat(testPx.toPxInt().value).isEqualTo(testInput.toInt())

    //region toDp
    @Test fun `toDp(Context) divides value by density from DisplayMetrics`() {
        assertThat(testPx.toDp(TestValues.mockContext).value)
            .isEqualTo(testInput / TestValues.DENSITY)
    }

    @Test fun `toDp(Resources) divides value by density from DisplayMetrics`() {
        assertThat(testPx.toDp(TestValues.mockResources).value)
            .isEqualTo(testInput / TestValues.DENSITY)
    }

    @Test fun `toDp(DisplayMetrics) divides value by density from DisplayMetrics`() {
        assertThat(testPx.toDp(TestValues.displayMetrics).value)
            .isEqualTo(testInput / TestValues.DENSITY)
    }
    //endregion

    //region toSp
    @Test fun `toSp(Context) divides value by scaledDensity from DisplayMetrics`() {
        assertThat(testPx.toSp(TestValues.mockContext).value)
            .isEqualTo(testInput / TestValues.SCALED_DENSITY)
    }

    @Test fun `toSp(Resources) divides value by scaledDensity from DisplayMetrics`() {
        assertThat(testPx.toSp(TestValues.mockResources).value)
            .isEqualTo(testInput / TestValues.SCALED_DENSITY)
    }

    @Test fun `toSp(DisplayMetrics) divides value by scaledDensity from DisplayMetrics`() {
        assertThat(testPx.toSp(TestValues.displayMetrics).value)
            .isEqualTo(testInput / TestValues.SCALED_DENSITY)
    }
    //endregion
}
