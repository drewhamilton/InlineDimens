package drewhamilton.inlinedimens

import android.os.Build
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.reflect.Field
import java.lang.reflect.Modifier

class TextViewTest {

    private val mockTextView = mock<TextView>()

    //region getTextSizePx
    @Test fun `getTextSizePx gets text size as Px`() {
        whenever(mockTextView.textSize).thenReturn(22f)
        assertEquals(Px(22f), mockTextView.getTextSizePx())
    }
    //endregion

    //region setTextSize
    @Test fun `setTextSize with Px sets px text size`() {
        val px = Px(234.5f)
        mockTextView.setTextSize(px)
        verify(mockTextView).setTextSize(TypedValue.COMPLEX_UNIT_PX, px.value)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setTextSize with Dp sets dp text size`() {
        val dp = Dp(234.5f)
        mockTextView.setTextSize(dp)
        verify(mockTextView).setTextSize(TypedValue.COMPLEX_UNIT_DIP, dp.value)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setTextSize with Sp sets sp text size`() {
        val sp = Sp(234.5f)
        mockTextView.setTextSize(sp)
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

        val pxArray = arrayOf(PxInt(1), PxInt(2))
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(pxArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(pxArray.values(), TypedValue.COMPLEX_UNIT_PX)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Px on API 26 AutoSizeableTextView sets px text sizes`() {
        spoofSdkInt(26)

        val pxArray = arrayOf(PxInt(1), PxInt(2))
        val mockTextView: TextView = mock<AppCompatTextView>()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(pxArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(pxArray.values(), TypedValue.COMPLEX_UNIT_PX)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Px on API 26 TextView is no-op`() {
        spoofSdkInt(26)

        val pxArray = arrayOf(PxInt(1), PxInt(2))
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(pxArray)

        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Dp on API 27 sets dp text sizes`() {
        spoofSdkInt(27)

        val dpArray = arrayOf(DpInt(1), DpInt(2))
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(dpArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(dpArray.values(), TypedValue.COMPLEX_UNIT_DIP)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Dp on API 26 AutoSizeableTextView sets dp text sizes`() {
        spoofSdkInt(26)

        val dpArray = arrayOf(DpInt(1), DpInt(2))
        val mockTextView: TextView = mock<AppCompatTextView>()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(dpArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(dpArray.values(), TypedValue.COMPLEX_UNIT_DIP)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Dp on API 26 TextView is no-op`() {
        spoofSdkInt(26)

        val dpArray = arrayOf(DpInt(1), DpInt(2))
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(dpArray)

        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Sp on API 27 sets sp text sizes`() {
        spoofSdkInt(27)

        val spArray = arrayOf(SpInt(1), SpInt(2))
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(spArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(spArray.values(), TypedValue.COMPLEX_UNIT_SP)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Sp on API 26 AutoSizeableTextView sets sp text sizes`() {
        spoofSdkInt(26)

        val spArray = arrayOf(SpInt(1), SpInt(2))
        val mockTextView: TextView = mock<AppCompatTextView>()
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(spArray)

        verify(mockTextView).setAutoSizeTextTypeUniformWithPresetSizes(spArray.values(), TypedValue.COMPLEX_UNIT_SP)
        verifyNoMoreInteractions(mockTextView)
    }

    @Test fun `setAutoSizeTextTypeUniformWithPresetSizes with Sp on API 26 TextView is no-op`() {
        spoofSdkInt(26)

        val spArray = arrayOf(SpInt(1), SpInt(2))
        mockTextView.setAutoSizeTextTypeUniformWithPresetSizes(spArray)

        verifyNoMoreInteractions(mockTextView)
    }
    //endregion

    private fun spoofSdkInt(sdkInt: Int) {
        val sdkIntField = Build.VERSION::class.java.getField("SDK_INT")
        sdkIntField.isAccessible = true

        val sdkIntModifiersField = Field::class.java.getDeclaredField("modifiers")
        sdkIntModifiersField.isAccessible = true
        sdkIntModifiersField.setInt(sdkIntField, sdkIntField.modifiers and Modifier.FINAL.inv())

        sdkIntField.setInt(null, sdkInt)
    }

    private fun Array<out DimenInt>.values() = IntArray(size) { index -> this[index].value }
}
