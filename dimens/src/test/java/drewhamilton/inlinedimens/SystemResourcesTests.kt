package drewhamilton.inlinedimens

import android.content.res.Resources
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Tests of functions that use [Resources.getSystem], provided by Robolectric.
 */
@RunWith(RobolectricTestRunner::class)
@Config(qualifiers = "xxhdpi")
class SystemResourcesTests {

    private val testInputFloat = 23.7f
    private val testInputInt = 24

    private val testPx = Px(testInputFloat)
    private val testPxInt = PxInt(testInputInt)
    private val testDp = Dp(testInputFloat)
    private val testDpInt = DpInt(testInputInt)
    private val testSp = Sp(testInputFloat)
    private val testSpInt = SpInt(testInputInt)

    //region Px
    @Test fun `Px toDp() divides value by density from system DisplayMetrics`() {
        Truth.assertThat(testPx.toDp().value)
            .isEqualTo(testInputFloat / XXHDPI_DENSITY)
    }

    @Test fun `Px toSp() divides value by scaledDensity from system DisplayMetrics`() {
        Truth.assertThat(testPx.toSp().value)
            .isEqualTo(testInputFloat / XXHDPI_SCALED_DENSITY)
    }

    @Test fun `PxInt toDp() divides value by density from system DisplayMetrics`() {
        Truth.assertThat(testPxInt.toDp().value)
            .isEqualTo(testInputInt.toFloat() / XXHDPI_DENSITY)
    }

    @Test fun `PxInt toSp() divides value by scaledDensity from system DisplayMetrics`() {
        Truth.assertThat(testPxInt.toSp().value)
            .isEqualTo(testInputInt.toFloat() / XXHDPI_SCALED_DENSITY)
    }
    //endregion

    //region Dp
    @Test fun `Dp toPx() multiplies value by density from system DisplayMetrics`() {
        Truth.assertThat(testDp.toPx().value)
            .isEqualTo(testInputFloat * XXHDPI_DENSITY)
    }

    @Test fun `Dp toSp() multiplies value by density and divides by scaledDensity from system DisplayMetrics`() {
        Truth.assertThat(testDp.toSp().value)
            .isEqualTo(testInputFloat * XXHDPI_DENSITY / XXHDPI_SCALED_DENSITY)
    }

    @Test fun `DpInt toPx() multiplies value by density from system DisplayMetrics`() {
        Truth.assertThat(testDpInt.toPx().value)
            .isEqualTo(testInputInt.toFloat() * XXHDPI_DENSITY)
    }

    @Test fun `DpInt toSp() multiplies value by density and divides by scaledDensity from system DisplayMetrics`() {
        Truth.assertThat(testDpInt.toSp().value)
            .isEqualTo(testInputInt.toFloat() * XXHDPI_DENSITY / XXHDPI_SCALED_DENSITY)
    }
    //endregion

    //region Sp
    @Test fun `Sp toPx() multiplies value by scaledDensity from system DisplayMetrics`() {
        Truth.assertThat(testSp.toPx().value)
            .isEqualTo(testInputFloat * XXHDPI_SCALED_DENSITY)
    }

    @Test fun `Sp toDp() multiplies value by scaledDensity and divides by density from system DisplayMetrics`() {
        Truth.assertThat(testSp.toDp().value)
            .isEqualTo(testInputFloat * XXHDPI_SCALED_DENSITY / XXHDPI_DENSITY)
    }

    @Test fun `SpInt toPx() multiplies value by scaledDensity from system DisplayMetrics`() {
        Truth.assertThat(testSpInt.toPx().value)
            .isEqualTo(testInputInt.toFloat() * XXHDPI_SCALED_DENSITY)
    }

    @Test fun `SpInt toDp() multiplies value by scaledDensity and divides by density from system DisplayMetrics`() {
        Truth.assertThat(testSpInt.toDp().value)
            .isEqualTo(testInputInt.toFloat() * XXHDPI_SCALED_DENSITY / XXHDPI_DENSITY)
    }
    //endregion

    private companion object {
        private const val XXHDPI_DENSITY = 3f
        private const val XXHDPI_SCALED_DENSITY = 3f
    }
}
