package drewhamilton.inlinedimens

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class PxTest {

    private val testInput = 98325.3f
    private val testPx = Px(testInput)

    @Test fun `toPxInt converts via Float-toInt`() {
        assertThat(testPx.toPxInt().value)
            .isEqualTo(testInput.toInt())
    }

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
