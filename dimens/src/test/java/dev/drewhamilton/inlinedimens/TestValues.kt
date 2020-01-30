package dev.drewhamilton.inlinedimens

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock

object TestValues {

    const val DENSITY = 2.5f
    const val SCALED_DENSITY = 7.5f

    val displayMetrics = DisplayMetrics().apply {
        density = DENSITY
        scaledDensity = SCALED_DENSITY
    }

    val mockResources: Resources = mock {
        on { displayMetrics } doReturn displayMetrics
    }

    val mockContext: Context = mock {
        on { resources } doReturn mockResources
    }
}
