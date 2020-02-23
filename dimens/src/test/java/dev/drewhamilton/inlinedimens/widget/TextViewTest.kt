package dev.drewhamilton.inlinedimens.widget

import android.graphics.Paint
import android.text.TextPaint
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import dev.drewhamilton.inlinedimens.Dp
import dev.drewhamilton.inlinedimens.Sp
import dev.drewhamilton.inlinedimens.TestValues
import dev.drewhamilton.inlinedimens.arrays.toDpIntArray
import dev.drewhamilton.inlinedimens.arrays.toPxIntArray
import dev.drewhamilton.inlinedimens.arrays.toSpIntArray
import dev.drewhamilton.inlinedimens.dp
import dev.drewhamilton.inlinedimens.px
import dev.drewhamilton.inlinedimens.sp
import dev.drewhamilton.inlinedimens.spoofSdkInt
import org.junit.Assert.assertEquals
import org.junit.Test

class TextViewTest {

    private val mockTextView = mock<TextView>()
    private val mockResources = TestValues.mockResources

    //region Auto-size
    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Px on API 27 sets px text sizes`() {
        spoofSdkInt(27)

        val pxArray = arrayOf(1.px, 2.px).toPxIntArray()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(pxArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(pxArray.values, TypedValue.COMPLEX_UNIT_PX)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Px on API 26 AutoSizeableTextView sets px text sizes`() {
        spoofSdkInt(26)

        val pxArray = arrayOf(1.px, 2.px).toPxIntArray()
        val mockTextView: TextView = mock<AppCompatTextView>()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(pxArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(pxArray.values, TypedValue.COMPLEX_UNIT_PX)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Px on API 26 TextView is no-op`() {
        spoofSdkInt(26)

        val pxArray = arrayOf(1.px, 2.px).toPxIntArray()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(pxArray)

        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Dp on API 27 sets dp text sizes`() {
        spoofSdkInt(27)

        val dpArray = arrayOf(1.dp, 2.dp).toDpIntArray()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(dpArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(dpArray.values, TypedValue.COMPLEX_UNIT_DIP)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Dp on API 26 AutoSizeableTextView sets dp text sizes`() {
        spoofSdkInt(26)

        val dpArray = arrayOf(1.dp, 2.dp).toDpIntArray()
        val mockTextView: TextView = mock<AppCompatTextView>()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(dpArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(dpArray.values, TypedValue.COMPLEX_UNIT_DIP)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Dp on API 26 TextView is no-op`() {
        spoofSdkInt(26)

        val dpArray = arrayOf(1.dp, 2.dp).toDpIntArray()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(dpArray)

        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Sp on API 27 sets sp text sizes`() {
        spoofSdkInt(27)

        val spArray = arrayOf(1.sp, 2.sp).toSpIntArray()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(spArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(spArray.values, TypedValue.COMPLEX_UNIT_SP)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Sp on API 26 AutoSizeableTextView sets sp text sizes`() {
        spoofSdkInt(26)

        val spArray = arrayOf(1.sp, 2.sp).toSpIntArray()
        val mockTextView: TextView = mock<AppCompatTextView>()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(spArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(spArray.values, TypedValue.COMPLEX_UNIT_SP)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Sp on API 26 TextView is no-op`() {
        spoofSdkInt(26)

        val spArray = arrayOf(1.sp, 2.sp).toSpIntArray()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(spArray)

        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithConfiguration with Px on API 27 sets px text size range`() {
        spoofSdkInt(27)

        val pxMin = 24.px
        val pxMax = 48.px
        val pxGranularity = 4.px
        mockTextView.setAutoSizeTextTypeUniformWithConfiguration(pxMin, pxMax, pxGranularity)

        verify(mockTextView).setAutoSizeTextTypeUniformWithConfiguration(
            pxMin.value,
            pxMax.value,
            pxGranularity.value,
            TypedValue.COMPLEX_UNIT_PX
        )
        verifyNoMoreInteractions(mockTextView)
    }

    @Test
    fun `setAutoSizeTextTypeUniformWithConfiguration with Px on API 26 AutoSizeableTextView sets px text size range`() {
        spoofSdkInt(26)

        val pxMin = 24.px
        val pxMax = 48.px
        val pxGranularity = 4.px
        val mockTextView: TextView = mock<AppCompatTextView>()
        mockTextView.setAutoSizeTextTypeUniformWithConfiguration(pxMin, pxMax, pxGranularity)

        verify(mockTextView).setAutoSizeTextTypeUniformWithConfiguration(
            pxMin.value,
            pxMax.value,
            pxGranularity.value,
            TypedValue.COMPLEX_UNIT_PX
        )
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithConfiguration with Px on API 26 TextView is no-op`() {
        spoofSdkInt(26)

        val pxMin = 24.px
        val pxMax = 48.px
        val pxGranularity = 4.px
        mockTextView.setAutoSizeTextTypeUniformWithConfiguration(pxMin, pxMax, pxGranularity)

        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithConfiguration with Dp on API 27 sets dp text size range`() {
        spoofSdkInt(27)

        val dpMin = 24.dp
        val dpMax = 48.dp
        val dpGranularity = 4.dp
        mockTextView.setAutoSizeTextTypeUniformWithConfiguration(dpMin, dpMax, dpGranularity)

        verify(mockTextView).setAutoSizeTextTypeUniformWithConfiguration(
            dpMin.value,
            dpMax.value,
            dpGranularity.value,
            TypedValue.COMPLEX_UNIT_DIP
        )
        verifyNoMoreInteractions(mockTextView)
    }

    @Test
    fun `setAutoSizeTextTypeUniformWithConfiguration with Dp on API 26 AutoSizeableTextView sets dp text size range`() {
        spoofSdkInt(26)

        val dpMin = 24.dp
        val dpMax = 48.dp
        val dpGranularity = 4.dp
        val mockTextView: TextView = mock<AppCompatTextView>()
        mockTextView.setAutoSizeTextTypeUniformWithConfiguration(dpMin, dpMax, dpGranularity)

        verify(mockTextView).setAutoSizeTextTypeUniformWithConfiguration(
            dpMin.value,
            dpMax.value,
            dpGranularity.value,
            TypedValue.COMPLEX_UNIT_DIP
        )
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithConfiguration with Dp on API 26 TextView is no-op`() {
        spoofSdkInt(26)

        val dpMin = 24.dp
        val dpMax = 48.dp
        val dpGranularity = 4.dp
        mockTextView.setAutoSizeTextTypeUniformWithConfiguration(dpMin, dpMax, dpGranularity)

        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithConfiguration with Sp on API 27 sets sp text size range`() {
        spoofSdkInt(27)

        val spMin = 24.sp
        val spMax = 48.sp
        val spGranularity = 4.sp
        mockTextView.setAutoSizeTextTypeUniformWithConfiguration(spMin, spMax, spGranularity)

        verify(mockTextView).setAutoSizeTextTypeUniformWithConfiguration(
            spMin.value,
            spMax.value,
            spGranularity.value,
            TypedValue.COMPLEX_UNIT_SP
        )
        verifyNoMoreInteractions(mockTextView)
    }

    @Test
    fun `setAutoSizeTextTypeUniformWithConfiguration with Sp on API 26 AutoSizeableTextView sets sp text size range`() {
        spoofSdkInt(26)

        val spMin = 24.sp
        val spMax = 48.sp
        val spGranularity = 4.sp
        val mockTextView: TextView = mock<AppCompatTextView>()
        mockTextView.setAutoSizeTextTypeUniformWithConfiguration(spMin, spMax, spGranularity)

        verify(mockTextView).setAutoSizeTextTypeUniformWithConfiguration(
            spMin.value,
            spMax.value,
            spGranularity.value,
            TypedValue.COMPLEX_UNIT_SP
        )
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithConfiguration with Sp on API 26 TextView is no-op`() {
        spoofSdkInt(26)

        val spMin = 24.sp
        val spMax = 48.sp
        val spGranularity = 4.sp
        mockTextView.setAutoSizeTextTypeUniformWithConfiguration(spMin, spMax, spGranularity)

        verifyNoMoreInteractions(mockTextView)
    }
    //endregion

    //region Line and baseline heights
    @Test fun `lineHeightPx matches lineHeight as PxInt`() {
        whenever(mockTextView.lineHeight).thenReturn(34)
        assertThat(mockTextView.lineHeightPx).isEqualTo(34.px)
    }

    @Test fun `set lineHeightPx forwards to set lineHeight`() {
        val mockPaint = mock<TextPaint>()
        whenever(mockPaint.getFontMetricsInt(null)).thenReturn(30)
        whenever(mockTextView.paint).thenReturn(mockPaint)

        mockTextView.lineHeightPx = 35.px
        verify(mockTextView).paint
        verify(mockTextView).setLineSpacing(5f, 1f)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `firstBaselineToTopHeightPx matches firstBaselineToTopHeight as PxInt`() {
        val mockFontMetricInt = mock<Paint.FontMetricsInt>()
        mockFontMetricInt.top = 31
        val mockPaint = mock<TextPaint>()
        whenever(mockPaint.fontMetricsInt).thenReturn(mockFontMetricInt)
        whenever(mockTextView.paint).thenReturn(mockPaint)
        whenever(mockTextView.paddingTop).thenReturn(42)

        assertThat(mockTextView.firstBaselineToTopHeightPx).isEqualTo(11.px)
    }

    @Test fun `set firstBaselineToTopHeightPx forwards to set firstBaselineToTopHeight`() {
        spoofSdkInt(28)

        mockTextView.firstBaselineToTopHeightPx = 65.px
        verify(mockTextView).firstBaselineToTopHeight = 65
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `lastBaselineToBottomHeightPx matches lastBaselineToBottomHeight as PxInt`() {
        val mockFontMetricInt = mock<Paint.FontMetricsInt>()
        mockFontMetricInt.bottom = 53
        val mockPaint = mock<TextPaint>()
        whenever(mockPaint.fontMetricsInt).thenReturn(mockFontMetricInt)
        whenever(mockTextView.paint).thenReturn(mockPaint)
        whenever(mockTextView.paddingBottom).thenReturn(62)

        assertThat(mockTextView.lastBaselineToBottomHeightPx).isEqualTo(115.px)
    }

    @Test fun `set lastBaselineToBottomHeightPx forwards to set lastBaselineToBottomHeight`() {
        spoofSdkInt(16)

        val mockFontMetricInt = mock<Paint.FontMetricsInt>()
        mockFontMetricInt.bottom = 35
        val mockPaint = mock<TextPaint>()
        whenever(mockPaint.fontMetricsInt).thenReturn(mockFontMetricInt)
        whenever(mockTextView.paint).thenReturn(mockPaint)
        whenever(mockTextView.includeFontPadding).thenReturn(true)

        mockTextView.lastBaselineToBottomHeightPx = 71.px
        verify(mockTextView).paint
        verify(mockTextView).includeFontPadding
        verify(mockTextView).paddingLeft
        verify(mockTextView).paddingTop
        verify(mockTextView).paddingRight
        verify(mockTextView).setPadding(0, 0, 0, 36)
        verifyNoMoreInteractions(mockTextView)
    }
    //endregion

    //region Text size
    @Test fun `textSizePx gets text size as Px`() {
        whenever(mockTextView.textSize).thenReturn(22f)
        assertEquals(22f.px, mockTextView.textSizePx)
    }

    @Test fun `set textSizePx sets px text size`() {
        val px = 234.5f.px
        mockTextView.textSizePx = px
        verify(mockTextView).setTextSize(TypedValue.COMPLEX_UNIT_PX, px.value)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `textSizeDp gets text size as Dp`() {
        whenever(mockTextView.resources).thenReturn(mockResources)
        whenever(mockTextView.textSize).thenReturn(23f)
        assertEquals(Dp(23f / TestValues.DENSITY), mockTextView.textSizeDp)
    }

    @Test fun `set textSizeDp sets dp text size`() {
        val dp = 234.5f.dp
        mockTextView.textSizeDp = dp
        verify(mockTextView).setTextSize(TypedValue.COMPLEX_UNIT_DIP, dp.value)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `textSizeSp gets text size as Sp`() {
        whenever(mockTextView.resources).thenReturn(mockResources)
        whenever(mockTextView.textSize).thenReturn(24f)
        assertEquals(Sp(24f / TestValues.SCALED_DENSITY), mockTextView.textSizeSp)
    }

    @Test fun `set textSizeSp sets sp text size`() {
        val sp = 234.5f.sp
        mockTextView.textSizeSp = sp
        verify(mockTextView).setTextSize(TypedValue.COMPLEX_UNIT_SP, sp.value)
        verifyNoMoreInteractions(mockTextView)
    }
    //endregion

    //region View size
    @Test fun `minHeightPx gets from View minHeight`() {
        whenever(mockTextView.minHeight).thenReturn(85)
        assertThat(mockTextView.minHeightPx).isEqualTo(85.px)
    }

    @Test fun `set minHeightPx sets View minHeight`() {
        mockTextView.minHeightPx = 58.px
        verify(mockTextView).minHeight = 58
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `maxHeightPx gets from View maxHeight`() {
        whenever(mockTextView.maxHeight).thenReturn(95)
        assertThat(mockTextView.maxHeightPx).isEqualTo(95.px)
    }

    @Test fun `set maxHeightPx sets View maxHeight`() {
        mockTextView.maxHeightPx = 59.px
        verify(mockTextView).maxHeight = 59
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `heightPx gets from View height`() {
        whenever(mockTextView.height).thenReturn(105)
        assertThat(mockTextView.heightPx).isEqualTo(105.px)
    }

    @Test fun `set heightPx sets View height`() {
        mockTextView.heightPx = 501.px
        verify(mockTextView).height = 501
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `minWidthPx gets from View minWidth`() {
        whenever(mockTextView.minWidth).thenReturn(115)
        assertThat(mockTextView.minWidthPx).isEqualTo(115.px)
    }

    @Test fun `set minWidthPx sets View minWidth`() {
        mockTextView.minWidthPx = 511.px
        verify(mockTextView).minWidth = 511
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `maxWidthPx gets from View maxWidth`() {
        whenever(mockTextView.maxWidth).thenReturn(125)
        assertThat(mockTextView.maxWidthPx).isEqualTo(125.px)
    }

    @Test fun `set maxWidthPx sets View maxWidth`() {
        mockTextView.maxWidthPx = 521.px
        verify(mockTextView).maxWidth = 521
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `widthPx gets from View width`() {
        whenever(mockTextView.width).thenReturn(135)
        assertThat(mockTextView.widthPx).isEqualTo(135.px)
    }

    @Test fun `set widthPx sets View width`() {
        mockTextView.widthPx = 531.px
        verify(mockTextView).width = 531
        verifyNoMoreInteractions(mockTextView)
    }
    //endregion

    //region Line spacing
    @Test fun `setLineSpacing forwards to View function`() {
        mockTextView.setLineSpacing(83.2f.px, 2.3f)
        verify(mockTextView).setLineSpacing(83.2f, 2.3f)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `lineSpacingExtraPx wraps View lineSpacingExtra`() {
        whenever(mockTextView.lineSpacingExtra).thenReturn(808f)
        assertThat(mockTextView.lineSpacingExtraPx).isEqualTo(808f.px)
    }
    //endregion
}
