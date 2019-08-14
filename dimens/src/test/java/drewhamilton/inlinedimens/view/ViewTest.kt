package drewhamilton.inlinedimens.view

import android.view.View
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import drewhamilton.inlinedimens.PxInt
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
}
