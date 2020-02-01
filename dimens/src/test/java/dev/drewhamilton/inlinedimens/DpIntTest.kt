package dev.drewhamilton.inlinedimens

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class DpIntTest {

    private val testInput = 24
    private val testDpInt = DpInt(testInput)

    @Test fun `toDpFloat converts via Int-toFloat`() {
        assertThat(testDpInt.toDpFloat().value)
            .isEqualTo(testInput.toFloat())
    }

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
