package dev.drewhamilton.inlinedimens.graphics

import android.graphics.Rect
import com.google.common.truth.Truth
import dev.drewhamilton.inlinedimens.PxInt
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class PxRectTest {

    @Test fun `PxRect empty constructor uses Rect empty constructor`() {
        val rect = Rect()
        val pxRect = PxRect()
        Truth.assertThat(pxRect.left.value).isEqualTo(rect.left)
        Truth.assertThat(pxRect.top.value).isEqualTo(rect.top)
        Truth.assertThat(pxRect.right.value).isEqualTo(rect.right)
        Truth.assertThat(pxRect.bottom.value).isEqualTo(rect.bottom)
    }

    @Test fun `PxRect ltrb constructor uses Rect ltrb constructor`() {
        val rect = Rect(1, 2, 3, 4)
        val pxRect = PxRect(
            PxInt(1),
            PxInt(2),
            PxInt(3),
            PxInt(4)
        )
        Truth.assertThat(pxRect.left.value).isEqualTo(rect.left)
        Truth.assertThat(pxRect.top.value).isEqualTo(rect.top)
        Truth.assertThat(pxRect.right.value).isEqualTo(rect.right)
        Truth.assertThat(pxRect.bottom.value).isEqualTo(rect.bottom)
    }
}
