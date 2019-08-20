package drewhamilton.inlinedimens.widget

import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import drewhamilton.inlinedimens.Dp
import drewhamilton.inlinedimens.DpInt
import drewhamilton.inlinedimens.Px
import drewhamilton.inlinedimens.PxInt
import drewhamilton.inlinedimens.Sp
import drewhamilton.inlinedimens.SpInt
import drewhamilton.inlinedimens.TestValues
import drewhamilton.inlinedimens.arrays.toDpIntArray
import drewhamilton.inlinedimens.arrays.toPxIntArray
import drewhamilton.inlinedimens.arrays.toSpIntArray
import drewhamilton.inlinedimens.spoofSdkInt
import org.junit.Assert.assertEquals
import org.junit.Test

class TextViewTest {

    private val mockTextView = mock<TextView>()
    private val mockResources = TestValues.mockResources

    //region textSize
    @Test fun `textSizePx gets text size as Px`() {
        whenever(mockTextView.textSize).thenReturn(22f)
        assertEquals(Px(22f), mockTextView.textSizePx)
    }

    @Test fun `set textSizePx sets px text size`() {
        val px = Px(234.5f)
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
        val dp = Dp(234.5f)
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
        val sp = Sp(234.5f)
        mockTextView.textSizeSp = sp
        verify(mockTextView).setTextSize(TypedValue.COMPLEX_UNIT_SP, sp.value)
        verifyNoMoreInteractions(mockTextView)
    }
    //endregion

    //region setAutoSizeTextTypeUniformWithConfiguration
    @Test fun `setAutoSizeTextTypeUniformWithConfiguration with Px on API 27 sets px text size range`() {
        spoofSdkInt(27)

        val pxMin = PxInt(24)
        val pxMax = PxInt(48)
        val pxGranularity = PxInt(4)
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

        val pxMin = PxInt(24)
        val pxMax = PxInt(48)
        val pxGranularity = PxInt(4)
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

        val pxMin = PxInt(24)
        val pxMax = PxInt(48)
        val pxGranularity = PxInt(4)
        mockTextView.setAutoSizeTextTypeUniformWithConfiguration(pxMin, pxMax, pxGranularity)

        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithConfiguration with Dp on API 27 sets dp text size range`() {
        spoofSdkInt(27)

        val dpMin = DpInt(24)
        val dpMax = DpInt(48)
        val dpGranularity = DpInt(4)
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

        val dpMin = DpInt(24)
        val dpMax = DpInt(48)
        val dpGranularity = DpInt(4)
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

        val dpMin = DpInt(24)
        val dpMax = DpInt(48)
        val dpGranularity = DpInt(4)
        mockTextView.setAutoSizeTextTypeUniformWithConfiguration(dpMin, dpMax, dpGranularity)

        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithConfiguration with Sp on API 27 sets sp text size range`() {
        spoofSdkInt(27)

        val spMin = SpInt(24)
        val spMax = SpInt(48)
        val spGranularity = SpInt(4)
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

        val spMin = SpInt(24)
        val spMax = SpInt(48)
        val spGranularity = SpInt(4)
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

        val spMin = SpInt(24)
        val spMax = SpInt(48)
        val spGranularity = SpInt(4)
        mockTextView.setAutoSizeTextTypeUniformWithConfiguration(spMin, spMax, spGranularity)

        verifyNoMoreInteractions(mockTextView)
    }
    //endregion

    //region setAutoSizeTextTypeUniformWithPresetSizes
    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Px on API 27 sets px text sizes`() {
        spoofSdkInt(27)

        val pxArray = arrayOf(PxInt(1), PxInt(2)).toPxIntArray()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(pxArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(pxArray.values, TypedValue.COMPLEX_UNIT_PX)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Px on API 26 AutoSizeableTextView sets px text sizes`() {
        spoofSdkInt(26)

        val pxArray = arrayOf(PxInt(1), PxInt(2)).toPxIntArray()
        val mockTextView: TextView = mock<AppCompatTextView>()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(pxArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(pxArray.values, TypedValue.COMPLEX_UNIT_PX)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Px on API 26 TextView is no-op`() {
        spoofSdkInt(26)

        val pxArray = arrayOf(PxInt(1), PxInt(2)).toPxIntArray()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(pxArray)

        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Dp on API 27 sets dp text sizes`() {
        spoofSdkInt(27)

        val dpArray = arrayOf(DpInt(1), DpInt(2)).toDpIntArray()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(dpArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(dpArray.values, TypedValue.COMPLEX_UNIT_DIP)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Dp on API 26 AutoSizeableTextView sets dp text sizes`() {
        spoofSdkInt(26)

        val dpArray = arrayOf(DpInt(1), DpInt(2)).toDpIntArray()
        val mockTextView: TextView = mock<AppCompatTextView>()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(dpArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(dpArray.values, TypedValue.COMPLEX_UNIT_DIP)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Dp on API 26 TextView is no-op`() {
        spoofSdkInt(26)

        val dpArray = arrayOf(DpInt(1), DpInt(2)).toDpIntArray()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(dpArray)

        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Sp on API 27 sets sp text sizes`() {
        spoofSdkInt(27)

        val spArray = arrayOf(SpInt(1), SpInt(2)).toSpIntArray()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(spArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(spArray.values, TypedValue.COMPLEX_UNIT_SP)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Sp on API 26 AutoSizeableTextView sets sp text sizes`() {
        spoofSdkInt(26)

        val spArray = arrayOf(SpInt(1), SpInt(2)).toSpIntArray()
        val mockTextView: TextView = mock<AppCompatTextView>()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(spArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(spArray.values, TypedValue.COMPLEX_UNIT_SP)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Sp on API 26 TextView is no-op`() {
        spoofSdkInt(26)

        val spArray = arrayOf(SpInt(1), SpInt(2)).toSpIntArray()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(spArray)

        verifyNoMoreInteractions(mockTextView)
    }
    //endregion
}
