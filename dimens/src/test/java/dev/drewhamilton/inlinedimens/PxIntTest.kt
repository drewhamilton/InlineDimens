package dev.drewhamilton.inlinedimens

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class PxIntTest {

    private val testInput = 83487
    private val testPxInt = testInput.px

    //region Operators
    @Test fun `plus adds PxInt`() =
        assertThat(testPxInt + testPxInt).isEqualTo(PxInt(testInput + testInput))

    @Test fun `minus subtracts PxInt`() =
        assertThat(testPxInt - 10.px).isEqualTo(PxInt(testInput - 10))

    @Test fun `unaryMinus negates PxInt`() =
        assertThat(-testPxInt).isEqualTo(PxInt(-testInput))

    @Test fun `div with float divides PxInt by scalar`() =
        assertThat(testPxInt / 2.1f).isEqualTo(Px(testInput / 2.1f))

    @Test fun `div with integer divides PxInt by scalar`() =
        assertThat(testPxInt / 2).isEqualTo(Px(testInput / 2f))

    @Test fun `div with PxInt divides into scalar`() =
        assertThat(testPxInt / 3.px).isEqualTo(testInput.toFloat() / 3)

    @Test fun `times with float multiplies PxInt by scalar`() =
        assertThat(testPxInt * 2.1f).isEqualTo(Px(testInput * 2.1f))

    @Test fun `times with integer multiplies PxInt by scalar`() =
        assertThat(testPxInt * 2).isEqualTo(PxInt(testInput * 2))

    @Test fun `times with float receiver multiplies scalar by PxInt`() =
        assertThat(2.1f * testPxInt).isEqualTo(Px(2.1f * testInput))

    @Test fun `times with integer receiver multiplies scalar by PxInt`() =
        assertThat(2 * testPxInt).isEqualTo(PxInt(2 * testInput))
    //endregion

    //region Comparisons
    @Test fun `compareTo compares correctly`() {
        assertThat(testPxInt).isGreaterThan(-testPxInt)
        assertThat(-testPxInt).isLessThan(testPxInt)
        assertThat(testPxInt).isEquivalentAccordingToCompareTo(testPxInt)
    }

    @Test fun `min chooses the lower value`() {
        assertThat(min(2.px, 3.px)).isEqualTo(2.px)
        assertThat(min(2.px, (-3).px)).isEqualTo((-3).px)
    }

    @Test fun `max chooses the higher value`() {
        assertThat(max(2.px, 3.px)).isEqualTo(3.px)
        assertThat(max(2.px, (-3).px)).isEqualTo(2.px)
    }

    @Test fun `coerceIn between values chooses original value`() =
        assertThat(3.px.coerceIn(0.px, 9.px)).isEqualTo(3.px)

    @Test fun `coerceIn over maximum value chooses maximum value`() =
        assertThat(19.px.coerceIn(0.px, 9.px)).isEqualTo(9.px)

    @Test fun `coerceIn under minimum value chooses minimum value`() =
        assertThat((-5).px.coerceIn(0.px, 9.px)).isEqualTo(0.px)

    @Test fun `coerceAtLeast under minimum value chooses minimum value`() =
        assertThat((-5).px.coerceAtLeast(0.px)).isEqualTo(0.px)

    @Test fun `coerceAtLeast over minimum value chooses original value`() =
        assertThat(5.px.coerceAtLeast(0.px)).isEqualTo(5.px)

    @Test fun `coerceAtMost under maximum value chooses original value`() =
        assertThat(5.px.coerceAtMost(9.px)).isEqualTo(5.px)

    @Test fun `coerceAtMost over maximum value chooses maximum value`() =
        assertThat(34.px.coerceAtMost(9.px)).isEqualTo(9.px)
    //endregion

    @Test fun `toString returns well-formatted unit`() =
        assertThat(testPxInt.toString()).isEqualTo("83487px")

    @Test fun `exact converts via Int-toFloat`() =
        assertThat(testPxInt.exact().value).isEqualTo(testInput.toFloat())

    //region toDp
    @Test fun `toDp(Context) divides value by density from DisplayMetrics`() {
        assertThat(testPxInt.toDp(TestValues.mockContext).value)
            .isEqualTo(testInput / TestValues.DENSITY)
    }

    @Test fun `toDp(Resources) divides value by density from DisplayMetrics`() {
        assertThat(testPxInt.toDp(TestValues.mockResources).value)
            .isEqualTo(testInput / TestValues.DENSITY)
    }

    @Test fun `toDp(DisplayMetrics) divides value by density from DisplayMetrics`() {
        assertThat(testPxInt.toDp(TestValues.displayMetrics).value)
            .isEqualTo(testInput / TestValues.DENSITY)
    }
    //endregion

    //region toSp
    @Test fun `toSp(Context) divides value by scaledDensity from DisplayMetrics`() {
        assertThat(testPxInt.toSp(TestValues.mockContext).value)
            .isEqualTo(testInput / TestValues.SCALED_DENSITY)
    }

    @Test fun `toSp(Resources) divides value by scaledDensity from DisplayMetrics`() {
        assertThat(testPxInt.toSp(TestValues.mockResources).value)
            .isEqualTo(testInput / TestValues.SCALED_DENSITY)
    }

    @Test fun `toSp(DisplayMetrics) divides value by scaledDensity from DisplayMetrics`() {
        assertThat(testPxInt.toSp(TestValues.displayMetrics).value)
            .isEqualTo(testInput / TestValues.SCALED_DENSITY)
    }
    //endregion
}
