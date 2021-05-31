package dev.drewhamilton.inlinedimens.view

import android.view.ViewGroup
import com.google.common.truth.Truth.assertThat
import dev.drewhamilton.inlinedimens.px
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class LayoutParamsTest {

    //region LayoutParams
    @Test fun `widthPx wraps LayoutParams width`() {
        val testParams = ViewGroup.LayoutParams(1, 0)
        assertThat(testParams.widthPx).isEqualTo(1.px)
    }

    @Test fun `set widthPx forwards to LayoutParams width`() {
        val testParams = ViewGroup.LayoutParams(0, 0)
        testParams.widthPx = 2.px
        assertThat(testParams.width).isEqualTo(2)
    }

    @Test fun `heightPx wraps LayoutParams height`() {
        val testParams = ViewGroup.LayoutParams(0, 11)
        assertThat(testParams.heightPx).isEqualTo(11.px)
    }

    @Test fun `set heightPx forwards to LayoutParams height`() {
        val testParams = ViewGroup.LayoutParams(0, 0)
        testParams.heightPx = 12.px
        assertThat(testParams.height).isEqualTo(12)
    }
    //endregion

    //region MarginLayoutParams
    @Test fun `leftMarginPx wraps LayoutParams leftMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.leftMargin = 21
        assertThat(testParams.leftMarginPx).isEqualTo(21.px)
    }

    @Test fun `set leftMarginPx forwards to LayoutParams leftMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.leftMarginPx = 22.px
        assertThat(testParams.leftMargin).isEqualTo(22)
    }

    @Test fun `topMarginPx wraps LayoutParams topMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.topMargin = 31
        assertThat(testParams.topMarginPx).isEqualTo(31.px)
    }

    @Test fun `set topMarginPx forwards to LayoutParams topMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.topMarginPx = 32.px
        assertThat(testParams.topMargin).isEqualTo(32)
    }

    @Test fun `rightMarginPx wraps LayoutParams rightMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.rightMargin = 41
        assertThat(testParams.rightMarginPx).isEqualTo(41.px)
    }

    @Test fun `set rightMarginPx forwards to LayoutParams rightMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.rightMarginPx = 42.px
        assertThat(testParams.rightMargin).isEqualTo(42)
    }

    @Test fun `bottomMarginPx wraps LayoutParams bottomMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.bottomMargin = 51
        assertThat(testParams.bottomMarginPx).isEqualTo(51.px)
    }

    @Test fun `set bottomMarginPx forwards to LayoutParams bottomMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.bottomMarginPx = 52.px
        assertThat(testParams.bottomMargin).isEqualTo(52)
    }

    @Test fun `startMarginPx wraps LayoutParams startMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.marginStart = 61
        assertThat(testParams.startMarginPx).isEqualTo(61.px)
    }

    @Test fun `set startMarginPx forwards to LayoutParams startMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.startMarginPx = 62.px
        assertThat(testParams.marginStart).isEqualTo(62)
    }

    @Test fun `endMarginPx wraps LayoutParams endMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.marginEnd = 71
        assertThat(testParams.endMarginPx).isEqualTo(71.px)
    }

    @Test fun `set endMarginPx forwards to LayoutParams endMargin`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.endMarginPx = 72.px
        assertThat(testParams.marginEnd).isEqualTo(72)
    }

    @Test fun `setMargins forwards to LayoutParams setMargins`() {
        val testParams = ViewGroup.MarginLayoutParams(0, 0)
        testParams.setMargins(81.px, 82.px, 83.px, 84.px)
        assertThat(testParams.leftMargin).isEqualTo(81)
        assertThat(testParams.topMargin).isEqualTo(82)
        assertThat(testParams.rightMargin).isEqualTo(83)
        assertThat(testParams.bottomMargin).isEqualTo(84)
    }
    //endregion
}
