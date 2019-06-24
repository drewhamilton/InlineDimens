package drewhamilton.inlinedimens

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SpIntTest {

    private val testInput = 932
    private val testSpInt = SpInt(testInput)

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
