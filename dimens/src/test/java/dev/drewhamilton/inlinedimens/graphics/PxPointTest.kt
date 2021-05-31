package dev.drewhamilton.inlinedimens.graphics

import android.graphics.Point
import com.google.common.truth.Truth
import dev.drewhamilton.inlinedimens.PxInt
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class PxPointTest {

    @Test fun `PxPoint empty constructor uses Point empty constructor`() {
        val point = Point()
        val pxPoint = PxPoint()
        Truth.assertThat(pxPoint.x.value).isEqualTo(point.x)
        Truth.assertThat(pxPoint.y.value).isEqualTo(point.y)
    }

    @Test fun `PxPoint xy constructor uses Point xy constructor`() {
        val point = Point(1, 2)
        val pxPoint = PxPoint(PxInt(1), PxInt(2))
        Truth.assertThat(pxPoint.x.value).isEqualTo(point.x)
        Truth.assertThat(pxPoint.y.value).isEqualTo(point.y)
    }
}
