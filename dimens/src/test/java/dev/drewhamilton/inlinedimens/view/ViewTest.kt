package dev.drewhamilton.inlinedimens.view

import android.graphics.Rect
import android.view.View
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import dev.drewhamilton.inlinedimens.arrays.PxIntArray
import dev.drewhamilton.inlinedimens.graphics.PxRect
import dev.drewhamilton.inlinedimens.px
import dev.drewhamilton.inlinedimens.spoofSdkInt
import org.junit.Before
import org.junit.Test

class ViewTest {

    private val mockView = mock<View>()

    @Before fun setUp() = spoofSdkInt(28)

    //region Fading edge length
    @Test fun `verticalFadingEdgeLengthPx returns from View verticalFadingEdgeLength`() {
        whenever(mockView.verticalFadingEdgeLength).thenReturn(1)
        assertThat(mockView.verticalFadingEdgeLengthPx).isEqualTo(1.px)
    }

    @Test fun `horizontalFadingEdgeLengthPx returns from View horizontalFadingEdgeLength`() {
        whenever(mockView.horizontalFadingEdgeLength).thenReturn(2)
        assertThat(mockView.horizontalFadingEdgeLengthPx).isEqualTo(2.px)
    }

    @Test fun `setFadingEdgeLength with PxInt forwards to setFadingEdgeLength with Int`() {
        mockView.setFadingEdgeLength(3.px)
        verify(mockView).setFadingEdgeLength(3)
        verifyNoMoreInteractions(mockView)
    }
    //endregion

    @Test fun `verticalScrollbarWidthPx returns from View verticalScrollbarWidth`() {
        whenever(mockView.verticalScrollbarWidth).thenReturn(4)
        assertThat(mockView.verticalScrollbarWidthPx).isEqualTo(4.px)
    }

    @Test fun `showContextMenu with PxInt forwards to showContextMenu with Int`() {
        mockView.showContextMenu(5f.px, 6f.px)
        verify(mockView).showContextMenu(5f, 6f)
        verifyNoMoreInteractions(mockView)
    }

    //region Scroll position
    @Test fun `scrollXPx returns from View scrollX`() {
        whenever(mockView.scrollX).thenReturn(7)
        assertThat(mockView.scrollXPx).isEqualTo(7.px)
    }

    @Test fun `scrollXPx writes to View scrollX`() {
        mockView.scrollXPx = 8.px
        verify(mockView).scrollX = 8
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `scrollYPx returns from View scrollY`() {
        whenever(mockView.scrollY).thenReturn(9)
        assertThat(mockView.scrollYPx).isEqualTo(9.px)
    }

    @Test fun `scrollYPx writes to View scrollY`() {
        mockView.scrollYPx = 10.px
        verify(mockView).scrollY = 10
        verifyNoMoreInteractions(mockView)
    }
    //endregion

    //region Size
    @Test fun `widthPx returns from View width`() {
        whenever(mockView.width).thenReturn(11)
        assertThat(mockView.widthPx).isEqualTo(11.px)
    }

    @Test fun `heightPx returns from View height`() {
        whenever(mockView.height).thenReturn(12)
        assertThat(mockView.heightPx).isEqualTo(12.px)
    }

    @Test fun `minimumWidthPx returns from View minimumWidth`() {
        whenever(mockView.minimumWidth).thenReturn(65)
        assertThat(mockView.minimumWidthPx).isEqualTo(65.px)
    }

    @Test fun `minimumWidthPx writes to View minimumWidth`() {
        mockView.minimumWidthPx = 66.px
        verify(mockView).minimumWidth = 66
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `minimumHeightPx returns from View minimumHeight`() {
        whenever(mockView.minimumHeight).thenReturn(67)
        assertThat(mockView.minimumHeightPx).isEqualTo(67.px)
    }

    @Test fun `minimumHeightPx writes to View minimumHeight`() {
        mockView.minimumHeightPx = 68.px
        verify(mockView).minimumHeight = 68
        verifyNoMoreInteractions(mockView)
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
        assertThat(mockView.cameraDistancePx).isEqualTo(17f.px)
    }

    @Test fun `cameraDistancePx writes to View cameraDistance`() {
        mockView.cameraDistancePx = 18f.px
        verify(mockView).cameraDistance = 18f
        verifyNoMoreInteractions(mockView)
    }

    //region Position
    @Test fun `topPx returns from View top`() {
        whenever(mockView.top).thenReturn(19)
        assertThat(mockView.topPx).isEqualTo(19.px)
    }

    @Test fun `bottomPx returns from View bottom`() {
        whenever(mockView.bottom).thenReturn(20)
        assertThat(mockView.bottomPx).isEqualTo(20.px)
    }

    @Test fun `leftPx returns from View left`() {
        whenever(mockView.left).thenReturn(21)
        assertThat(mockView.leftPx).isEqualTo(21.px)
    }

    @Test fun `rightPx returns from View right`() {
        whenever(mockView.right).thenReturn(22)
        assertThat(mockView.rightPx).isEqualTo(22.px)
    }

    @Test fun `xPx returns from View x`() {
        whenever(mockView.x).thenReturn(23f)
        assertThat(mockView.xPx).isEqualTo(23f.px)
    }

    @Test fun `xPx writes to View x`() {
        mockView.xPx = 24f.px
        verify(mockView).x = 24f
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `yPx returns from View y`() {
        whenever(mockView.y).thenReturn(25f)
        assertThat(mockView.yPx).isEqualTo(25f.px)
    }

    @Test fun `yPx writes to View y`() {
        mockView.yPx = 26f.px
        verify(mockView).y = 26f
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `zPx returns from View z`() {
        whenever(mockView.z).thenReturn(27f)
        assertThat(mockView.zPx).isEqualTo(27f.px)
    }

    @Test fun `zPx writes to View z`() {
        mockView.zPx = 28f.px
        verify(mockView).z = 28f
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `elevationPx returns from View elevation`() {
        whenever(mockView.elevation).thenReturn(29f)
        assertThat(mockView.elevationPx).isEqualTo(29f.px)
    }

    @Test fun `elevationPx writes to View elevation`() {
        mockView.elevationPx = 30f.px
        verify(mockView).elevation = 30f
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `translationXPx returns from View translationX`() {
        whenever(mockView.translationX).thenReturn(31f)
        assertThat(mockView.translationXPx).isEqualTo(31f.px)
    }

    @Test fun `translationXPx writes to View translationX`() {
        mockView.translationXPx = 32f.px
        verify(mockView).translationX = 32f
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `translationYPx returns from View translationY`() {
        whenever(mockView.translationY).thenReturn(33f)
        assertThat(mockView.translationYPx).isEqualTo(33f.px)
    }

    @Test fun `translationYPx writes to View translationY`() {
        mockView.translationYPx = 34f.px
        verify(mockView).translationY = 34f
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `translationZPx returns from View translationZ`() {
        whenever(mockView.translationZ).thenReturn(35f)
        assertThat(mockView.translationZPx).isEqualTo(35f.px)
    }

    @Test fun `translationZPx writes to View translationZ`() {
        mockView.translationZPx = 36f.px
        verify(mockView).translationZ = 36f
        verifyNoMoreInteractions(mockView)
    }
    //endregion

    @Test fun `offsetTopAndBottom with PxInt forwards to offsetTopAndBottom with Int`() {
        mockView.offsetTopAndBottom(37.px)
        verify(mockView).offsetTopAndBottom(37)
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `offsetLeftAndRight with PxInt forwards to offsetLeftAndRight with Int`() {
        mockView.offsetLeftAndRight(38.px)
        verify(mockView).offsetLeftAndRight(38)
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `scrollBy with both parameters forwards to scrollBy with both Ints`() {
        mockView.scrollBy(39.px, 40.px)
        verify(mockView).scrollBy(39, 40)
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `scrollBy with x forwards to scrollBy with x Int and y 0`() {
        mockView.scrollBy(x = 41.px)
        verify(mockView).scrollBy(41, 0)
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `scrollBy with y forwards to scrollBy with x 0 and y Int`() {
        mockView.scrollBy(y = 42.px)
        verify(mockView).scrollBy(0, 42)
        verifyNoMoreInteractions(mockView)
    }

    //region Padding
    @Test fun `paddingTopPx returns from View paddingTop`() {
        whenever(mockView.paddingTop).thenReturn(43)
        assertThat(mockView.paddingTopPx).isEqualTo(43.px)
    }

    @Test fun `paddingBottomPx returns from View paddingBottom`() {
        whenever(mockView.paddingBottom).thenReturn(44)
        assertThat(mockView.paddingBottomPx).isEqualTo(44.px)
    }

    @Test fun `paddingLeftPx returns from View paddingLeft`() {
        whenever(mockView.paddingLeft).thenReturn(45)
        assertThat(mockView.paddingLeftPx).isEqualTo(45.px)
    }

    @Test fun `paddingRightPx returns from View paddingRight`() {
        whenever(mockView.paddingRight).thenReturn(46)
        assertThat(mockView.paddingRightPx).isEqualTo(46.px)
    }

    @Test fun `paddingStartPx returns from View paddingStart`() {
        whenever(mockView.paddingStart).thenReturn(47)
        assertThat(mockView.paddingStartPx).isEqualTo(47.px)
    }

    @Test fun `paddingEndPx returns from View paddingEnd`() {
        whenever(mockView.paddingEnd).thenReturn(48)
        assertThat(mockView.paddingEndPx).isEqualTo(48.px)
    }

    @Test fun `setPadding with all parameters forwards to setPadding with all Ints`() {
        mockView.setPadding(49.px, 50.px, 51.px, 52.px)
        verify(mockView).setPadding(49, 50, 51, 52)
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `setPadding with no parameters forwards to setPadding with all current values`() {
        whenever(mockView.paddingLeft).thenReturn(53)
        whenever(mockView.paddingTop).thenReturn(54)
        whenever(mockView.paddingRight).thenReturn(55)
        whenever(mockView.paddingBottom).thenReturn(56)
        mockView.setPadding()

        verify(mockView).paddingLeft
        verify(mockView).paddingTop
        verify(mockView).paddingRight
        verify(mockView).paddingBottom
        verify(mockView).setPadding(53, 54, 55, 56)
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `setPaddingRelative with all parameters forwards to setPaddingRelative with all Ints`() {
        mockView.setPaddingRelative(57.px, 58.px, 59.px, 60.px)
        verify(mockView).setPaddingRelative(57, 58, 59, 60)
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `setPaddingRelative with no parameters forwards to setPaddingRelative with all current values`() {
        whenever(mockView.paddingStart).thenReturn(61)
        whenever(mockView.paddingTop).thenReturn(62)
        whenever(mockView.paddingEnd).thenReturn(63)
        whenever(mockView.paddingBottom).thenReturn(64)
        mockView.setPaddingRelative()

        verify(mockView).paddingStart
        verify(mockView).paddingTop
        verify(mockView).paddingEnd
        verify(mockView).paddingBottom
        verify(mockView).setPaddingRelative(61, 62, 63, 64)
        verifyNoMoreInteractions(mockView)
    }
    //endregion

    //region Location
    @Test fun `getLocationOnScreen forwards to View getLocationOnScreen`() {
        val intArray = IntArray(5) { it }
        val pxIntArray = PxIntArray(intArray)
        mockView.getLocationOnScreen(pxIntArray)
        verify(mockView).getLocationOnScreen(intArray)
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `getLocationInWindow forwards to View getLocationInWindow`() {
        val intArray = IntArray(6) { -it }
        val pxIntArray = PxIntArray(intArray)
        mockView.getLocationInWindow(pxIntArray)
        verify(mockView).getLocationInWindow(intArray)
        verifyNoMoreInteractions(mockView)
    }
    //endregion

    //region Nested scrolling
    @Test fun `dispatchNestedScroll with offsetInWindow forwards to View dispatchNestedScroll`() {
        val intArray = IntArray(5) { it }
        val pxIntArray = PxIntArray(intArray)
        mockView.dispatchNestedScroll(
            dxConsumed = 99.px, dyConsumed = 98.px,
            dxUnconsumed = 97.px, dyUnconsumed = 96.px,
            offsetInWindow = pxIntArray
        )
        verify(mockView).dispatchNestedScroll(99, 98, 97, 96, intArray)
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `dispatchNestedScroll without offsetInWindow forwards to View dispatchNestedScroll`() {
        mockView.dispatchNestedScroll(
            dxConsumed = 99.px, dyConsumed = 98.px,
            dxUnconsumed = 97.px, dyUnconsumed = 96.px
        )
        verify(mockView).dispatchNestedScroll(99, 98, 97, 96, null)
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `dispatchNestedPreScroll with consumed and offsetInWindow forwards to View dispatchNestedPreScroll`() {
        val consumedIntArray = IntArray(5) { it }
        val consumed = PxIntArray(consumedIntArray)
        val offsetInWindowIntArray = IntArray(50) { it }
        val offsetInWindow = PxIntArray(offsetInWindowIntArray)
        mockView.dispatchNestedPreScroll(
            dx = 1000.px, dy = 2000.px,
            consumed = consumed,
            offsetInWindow = offsetInWindow
        )
        verify(mockView).dispatchNestedPreScroll(1000, 2000, consumedIntArray, offsetInWindowIntArray)
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `dispatchNestedPreScroll with consumed forwards to View dispatchNestedPreScroll`() {
        val consumedIntArray = IntArray(500) { it }
        val consumed = PxIntArray(consumedIntArray)
        mockView.dispatchNestedPreScroll(
            dx = 1000.px, dy = 2000.px,
            consumed = consumed
        )
        verify(mockView).dispatchNestedPreScroll(1000, 2000, consumedIntArray, null)
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `dispatchNestedPreScroll with offsetInWindow forwards to View dispatchNestedPreScroll`() {
        val offsetInWindowIntArray = IntArray(500000) { it }
        val offsetInWindow = PxIntArray(offsetInWindowIntArray)
        mockView.dispatchNestedPreScroll(
            dx = 1000.px, dy = 2000.px,
            offsetInWindow = offsetInWindow
        )
        verify(mockView).dispatchNestedPreScroll(1000, 2000, null, offsetInWindowIntArray)
        verifyNoMoreInteractions(mockView)
    }

    @Test fun `dispatchNestedPPreScroll without consumed or offsetInWindow forwards to View dispatchNestedPreScroll`() {
        mockView.dispatchNestedPreScroll(
            dx = 7000.px, dy = 8000.px
        )
        verify(mockView).dispatchNestedPreScroll(7000, 8000, null, null)
        verifyNoMoreInteractions(mockView)
    }
    //endregion
}
