package dev.drewhamilton.inlinedimens

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class PxIntTest {

    private val testInput = 83487
    private val testPxInt = testInput.px

    @Test fun `toPxFloat converts via Int-toFloat`() {
        assertThat(testPxInt.toPxFloat().value)
            .isEqualTo(testInput.toFloat())
    }

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
