package drewhamilton.inlinedimens

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SpTest {

    private val testInput = 234.7f
    private val testSp = Sp(testInput)

    @Test fun `toSpInt converts via Float-toInt`() {
        assertThat(testSp.toSpInt().value)
            .isEqualTo(testInput.toInt())
    }

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
