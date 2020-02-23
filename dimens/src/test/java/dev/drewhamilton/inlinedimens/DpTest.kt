package dev.drewhamilton.inlinedimens

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class DpTest {

    private val testInput = 23.7f
    private val testDp = testInput.dp

    @Test fun `toDpInt converts via Float-toInt`() {
        assertThat(testDp.toDpInt().value)
            .isEqualTo(testInput.toInt())
    }

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
