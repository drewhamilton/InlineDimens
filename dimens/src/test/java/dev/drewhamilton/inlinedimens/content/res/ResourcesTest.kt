package dev.drewhamilton.inlinedimens.content.res

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.whenever
import dev.drewhamilton.inlinedimens.Px
import dev.drewhamilton.inlinedimens.PxInt
import dev.drewhamilton.inlinedimens.TestValues
import org.junit.Test

class ResourcesTest {

    private val testId = 432
    private val testPixelSize = 934
    private val testPixelOffset = 2348
    private val testDimension = 234.5345f

    @Test fun `getDimensionPx gets from getDimension`() {
        whenever(TestValues.mockResources.getDimension(testId)).thenReturn(testDimension)
        assertThat(TestValues.mockResources.getDimensionPx(testId))
            .isEqualTo(Px(testDimension))
    }

    @Test fun `getDimensionPxOffset gets from getDimensionPixelOffset`() {
        whenever(TestValues.mockResources.getDimensionPixelOffset(testId)).thenReturn(testPixelOffset)
        assertThat(TestValues.mockResources.getDimensionPxOffset(testId))
            .isEqualTo(PxInt(testPixelOffset))
    }

    @Test fun `getDimensionPxSize gets from getDimensionPixelSize`() {
        whenever(TestValues.mockResources.getDimensionPixelSize(testId)).thenReturn(testPixelSize)
        assertThat(TestValues.mockResources.getDimensionPxSize(testId))
            .isEqualTo(PxInt(testPixelSize))
    }
}
