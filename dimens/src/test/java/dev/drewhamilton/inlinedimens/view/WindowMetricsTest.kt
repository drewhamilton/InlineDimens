package dev.drewhamilton.inlinedimens.view

import android.graphics.Rect
import android.view.WindowMetrics
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import dev.drewhamilton.inlinedimens.px
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class WindowMetricsTest {

    private val mockWindowMetrics = mock<WindowMetrics>()

    @Test fun `boundsPx forwards to bounds`() {
        val rect = Rect(1, 2, 3, 4)
        whenever(mockWindowMetrics.bounds).thenReturn(rect)

        val pxRect = mockWindowMetrics.boundsPx
        assertThat(pxRect.left).isEqualTo(rect.left.px)
        assertThat(pxRect.top).isEqualTo(rect.top.px)
        assertThat(pxRect.right).isEqualTo(rect.right.px)
        assertThat(pxRect.bottom).isEqualTo(rect.bottom.px)
    }
}
