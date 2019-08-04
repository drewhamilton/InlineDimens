package drewhamilton.inlinedimens

import android.graphics.Point
import android.graphics.Rect
import android.view.Display
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE, sdk = [28])
class DisplayTest {

    private val mockDisplay = mock<Display>()

    @Test fun `getSize with PxPoint forwards to getSize with Point`() {
        val point = Point(1, 2)
        val pxPoint = PxPoint(point)

        mockDisplay.getSize(pxPoint)
        verify(mockDisplay).getSize(point)
        verifyNoMoreInteractions(mockDisplay)
    }

    @Test fun `getRectSize with PxRect forwards to getRectSize with Rect`() {
        val rect = Rect(1, 2, 3, 4)
        val pxRect = PxRect(rect)

        mockDisplay.getRectSize(pxRect)
        verify(mockDisplay).getRectSize(rect)
        verifyNoMoreInteractions(mockDisplay)
    }

    @Test fun `getCurrentSizeRange with PxPoints forwards to getCurrentSizeRange with Points`() {
        val smallPoint = Point(1, 2)
        val smallPxPoint = PxPoint(smallPoint)
        val largePoint = Point(3, 4)
        val largePxPoint = PxPoint(largePoint)

        mockDisplay.getCurrentSizeRange(smallPxPoint, largePxPoint)
        verify(mockDisplay).getCurrentSizeRange(smallPoint, largePoint)
        verifyNoMoreInteractions(mockDisplay)
    }

    @Test fun `getRealSize with PxPoint forwards to getRealSize with Point`() {
        val point = Point(1, 2)
        val pxPoint = PxPoint(point)

        mockDisplay.getRealSize(pxPoint)
        verify(mockDisplay).getRealSize(point)
        verifyNoMoreInteractions(mockDisplay)
    }

    //region PxPoint
    @Test fun `PxPoint empty constructor uses Point empty constructor`() {
        val point = Point()
        val pxPoint = PxPoint()
        assertThat(pxPoint.x.value).isEqualTo(point.x)
        assertThat(pxPoint.y.value).isEqualTo(point.y)
    }

    @Test fun `PxPoint xy constructor uses Point xy constructor`() {
        val point = Point(1, 2)
        val pxPoint = PxPoint(PxInt(1), PxInt(2))
        assertThat(pxPoint.x.value).isEqualTo(point.x)
        assertThat(pxPoint.y.value).isEqualTo(point.y)
    }
    //endregion

    //region PxRect
    @Test fun `PxRect empty constructor uses Rect empty constructor`() {
        val rect = Rect()
        val pxRect = PxRect()
        assertThat(pxRect.left.value).isEqualTo(rect.left)
        assertThat(pxRect.top.value).isEqualTo(rect.top)
        assertThat(pxRect.right.value).isEqualTo(rect.right)
        assertThat(pxRect.bottom.value).isEqualTo(rect.bottom)
    }

    @Test fun `PxRect ltrb constructor uses Rect ltrb constructor`() {
        val rect = Rect(1, 2, 3, 4)
        val pxRect = PxRect(PxInt(1), PxInt(2), PxInt(3), PxInt(4))
        assertThat(pxRect.left.value).isEqualTo(rect.left)
        assertThat(pxRect.top.value).isEqualTo(rect.top)
        assertThat(pxRect.right.value).isEqualTo(rect.right)
        assertThat(pxRect.bottom.value).isEqualTo(rect.bottom)
    }
    //endregion
}
