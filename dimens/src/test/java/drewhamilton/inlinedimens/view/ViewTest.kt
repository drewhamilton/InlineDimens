package drewhamilton.inlinedimens.view

import android.graphics.Rect
import android.view.View
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import drewhamilton.inlinedimens.Px
import drewhamilton.inlinedimens.PxInt
import drewhamilton.inlinedimens.graphics.PxRect
import org.junit.Test

class ViewTest {

    private val mockView = mock<View>()

    //region Fading edge length
    @Test fun `verticalFadingEdgeLengthPx returns from View verticalFadingEdgeLength`() {
        whenever(mockView.verticalFadingEdgeLength).thenReturn(1)
        assertThat(mockView.verticalFadingEdgeLengthPx).isEqualTo(PxInt(1))
    }

    @Test fun `horizontalFadingEdgeLengthPx returns from View horizontalFadingEdgeLength`() {
        whenever(mockView.horizontalFadingEdgeLength).thenReturn(2)
        assertThat(mockView.horizontalFadingEdgeLengthPx).isEqualTo(PxInt(2))
    }

    @Test fun `setFadingEdgeLength with PxInt forwards to setFadingEdgeLength with Int`() {
        mockView.setFadingEdgeLength(PxInt(3))
        verify(mockView).setFadingEdgeLength(3)
        verifyNoMoreInteractions(mockView)
    }
    //endregion

    @Test fun `verticalScrollbarWidthPx returns from View verticalScrollbarWidth`() {
        whenever(mockView.verticalScrollbarWidth).thenReturn(4)
        assertThat(mockView.verticalScrollbarWidthPx).isEqualTo(PxInt(4))
    }

    @Test fun `showContextMenu with PxInt forwards to showContextMenu with Int`() {
        mockView.showContextMenu(Px(5f), Px(6f))
        verify(mockView).showContextMenu(5f, 6f)
        verifyNoMoreInteractions(mockView)
    }

    //region Scroll position
    @Test fun `scrollXPx returns from View scrollX`() {
        whenever(mockView.scrollX).thenReturn(7)
        assertThat(mockView.scrollXPx).isEqualTo(PxInt(7))
    }

    @Test fun `scrollXPx writes to View scrollX`() {
        mockView.scrollXPx = PxInt(8)
        verify(mockView).scrollX = 8
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `scrollYPx returns from View scrollY`() {
        whenever(mockView.scrollY).thenReturn(9)
        assertThat(mockView.scrollYPx).isEqualTo(PxInt(9))
    }

    @Test fun `scrollYPx writes to View scrollY`() {
        mockView.scrollYPx = PxInt(10)
        verify(mockView).scrollY = 10
        verifyNoMoreInteractions(mockView)
    }
    //endregion

    //region Size
    @Test fun `widthPx returns from View width`() {
        whenever(mockView.width).thenReturn(11)
        assertThat(mockView.widthPx).isEqualTo(PxInt(11))
    }

    @Test fun `heightPx returns from View height`() {
        whenever(mockView.height).thenReturn(12)
        assertThat(mockView.heightPx).isEqualTo(PxInt(12))
    }
    //endregion

    @Test fun `getDrawingRect with PxRect forwards to getDrawingRect with Rect`() {
        val rect = Rect(13, 14, 15, 16)
        val pxRect = PxRect(rect)

        mockView.getDrawingRect(pxRect)
        verify(mockView).getDrawingRect(rect)
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `cameraDistancePx returns from View cameraDistance`() {
        whenever(mockView.cameraDistance).thenReturn(17f)
        assertThat(mockView.cameraDistancePx).isEqualTo(Px(17f))
    }

    @Test fun `cameraDistancePx writes to View cameraDistance`() {
        mockView.cameraDistancePx = Px(18f)
        verify(mockView).cameraDistance = 18f
        verifyNoMoreInteractions(mockView)
    }

    //region Position
    @Test fun `topPx returns from View top`() {
        whenever(mockView.top).thenReturn(19)
        assertThat(mockView.topPx).isEqualTo(PxInt(19))
    }

    @Test fun `bottomPx returns from View bottom`() {
        whenever(mockView.bottom).thenReturn(20)
        assertThat(mockView.bottomPx).isEqualTo(PxInt(20))
    }

    @Test fun `leftPx returns from View left`() {
        whenever(mockView.left).thenReturn(21)
        assertThat(mockView.leftPx).isEqualTo(PxInt(21))
    }

    @Test fun `rightPx returns from View right`() {
        whenever(mockView.right).thenReturn(22)
        assertThat(mockView.rightPx).isEqualTo(PxInt(22))
    }

    @Test fun `xPx returns from View x`() {
        whenever(mockView.x).thenReturn(23f)
        assertThat(mockView.xPx).isEqualTo(Px(23f))
    }

    @Test fun `xPx writes to View x`() {
        mockView.xPx = Px(24f)
        verify(mockView).x = 24f
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `yPx returns from View y`() {
        whenever(mockView.y).thenReturn(25f)
        assertThat(mockView.yPx).isEqualTo(Px(25f))
    }

    @Test fun `yPx writes to View y`() {
        mockView.yPx = Px(26f)
        verify(mockView).y = 26f
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `zPx returns from View z`() {
        whenever(mockView.z).thenReturn(27f)
        assertThat(mockView.zPx).isEqualTo(Px(27f))
    }

    @Test fun `zPx writes to View z`() {
        mockView.zPx = Px(28f)
        verify(mockView).z = 28f
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `elevationPx returns from View elevation`() {
        whenever(mockView.elevation).thenReturn(29f)
        assertThat(mockView.elevationPx).isEqualTo(Px(29f))
    }

    @Test fun `elevationPx writes to View elevation`() {
        mockView.elevationPx = Px(30f)
        verify(mockView).elevation = 30f
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `translationXPx returns from View translationX`() {
        whenever(mockView.translationX).thenReturn(31f)
        assertThat(mockView.translationXPx).isEqualTo(Px(31f))
    }

    @Test fun `translationXPx writes to View translationX`() {
        mockView.translationXPx = Px(32f)
        verify(mockView).translationX = 32f
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `translationYPx returns from View translationY`() {
        whenever(mockView.translationY).thenReturn(33f)
        assertThat(mockView.translationYPx).isEqualTo(Px(33f))
    }

    @Test fun `translationYPx writes to View translationY`() {
        mockView.translationYPx = Px(34f)
        verify(mockView).translationY = 34f
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `translationZPx returns from View translationZ`() {
        whenever(mockView.translationZ).thenReturn(35f)
        assertThat(mockView.translationZPx).isEqualTo(Px(35f))
    }

    @Test fun `translationZPx writes to View translationZ`() {
        mockView.translationZPx = Px(36f)
        verify(mockView).translationZ = 36f
        verifyNoMoreInteractions(mockView)
    }
    //endregion
}
