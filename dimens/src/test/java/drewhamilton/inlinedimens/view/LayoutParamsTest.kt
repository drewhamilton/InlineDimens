package drewhamilton.inlinedimens.view

import android.view.ViewGroup
import com.google.common.truth.Truth.assertThat
import drewhamilton.inlinedimens.PxInt
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
// TODO WORKAROUND: Update when Robolectric supports SDK 29
@Config(sdk = [28])
class LayoutParamsTest {

    //region LayoutParams
    @Test fun `widthPx wraps LayoutParams width`() {
        val testParams = ViewGroup.LayoutParams(1, 0)
        assertThat(testParams.widthPx).isEqualTo(PxInt(1))
    }

    @Test fun `set widthPx forwards to LayoutParams width`() {
        val testParams = ViewGroup.LayoutParams(0, 0)
        testParams.widthPx = PxInt(2)
        assertThat(testParams.width).isEqualTo(2)
    }

    @Test fun `heightPx wraps LayoutParams height`() {
        val testParams = ViewGroup.LayoutParams(0, 11)
        assertThat(testParams.heightPx).isEqualTo(PxInt(11))
    }

    @Test fun `set heightPx forwards to LayoutParams height`() {
        val testParams = ViewGroup.LayoutParams(0, 0)
        testParams.heightPx = PxInt(12)
        assertThat(testParams.height).isEqualTo(12)
    }
    //endregion

    //region MarginLayoutParams
    @Test fun `leftMarginPx wraps LayoutParams leftMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.leftMargin = 21
        assertThat(testParams.leftMarginPx).isEqualTo(PxInt(21))
    }

    @Test fun `set leftMarginPx forwards to LayoutParams leftMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.leftMarginPx = PxInt(22)
        assertThat(testParams.leftMargin).isEqualTo(22)
    }

    @Test fun `topMarginPx wraps LayoutParams topMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.topMargin = 31
        assertThat(testParams.topMarginPx).isEqualTo(PxInt(31))
    }

    @Test fun `set topMarginPx forwards to LayoutParams topMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.topMarginPx = PxInt(32)
        assertThat(testParams.topMargin).isEqualTo(32)
    }

    @Test fun `rightMarginPx wraps LayoutParams rightMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.rightMargin = 41
        assertThat(testParams.rightMarginPx).isEqualTo(PxInt(41))
    }

    @Test fun `set rightMarginPx forwards to LayoutParams rightMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.rightMarginPx = PxInt(42)
        assertThat(testParams.rightMargin).isEqualTo(42)
    }

    @Test fun `bottomMarginPx wraps LayoutParams bottomMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.bottomMargin = 51
        assertThat(testParams.bottomMarginPx).isEqualTo(PxInt(51))
    }

    @Test fun `set bottomMarginPx forwards to LayoutParams bottomMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.bottomMarginPx = PxInt(52)
        assertThat(testParams.bottomMargin).isEqualTo(52)
    }

    @Test fun `startMarginPx wraps LayoutParams startMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.marginStart = 61
        assertThat(testParams.startMarginPx).isEqualTo(PxInt(61))
    }

    @Test fun `set startMarginPx forwards to LayoutParams startMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.startMarginPx = PxInt(62)
        assertThat(testParams.marginStart).isEqualTo(62)
    }

    @Test fun `endMarginPx wraps LayoutParams endMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.marginEnd = 71
        assertThat(testParams.endMarginPx).isEqualTo(PxInt(71))
    }

    @Test fun `set endMarginPx forwards to LayoutParams endMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.endMarginPx = PxInt(72)
        assertThat(testParams.marginEnd).isEqualTo(72)
    }

    @Test fun `setMargins forwards to LayoutParams setMargins`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.setMargins(PxInt(81), PxInt(82), PxInt(83), PxInt(84))
        assertThat(testParams.leftMargin).isEqualTo(81)
        assertThat(testParams.topMargin).isEqualTo(82)
        assertThat(testParams.rightMargin).isEqualTo(83)
        assertThat(testParams.bottomMargin).isEqualTo(84)
    }
    //endregion
}
