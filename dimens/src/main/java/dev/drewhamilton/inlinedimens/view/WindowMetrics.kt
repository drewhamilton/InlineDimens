package dev.drewhamilton.inlinedimens.view

import android.view.WindowMetrics
import androidx.annotation.RequiresApi
import dev.drewhamilton.inlinedimens.graphics.PxRect

/**
 * Returns the bounds of the area associated with this window or visual context.
 *
 * **Note that the size of the reported bounds can have different size than [Display.getSize][getSize].** This method
 * reports the window size including all system bar areas, while [getSize] reports the area excluding navigation bars
 * and display cutout areas.
 */
@get:RequiresApi(30)
val WindowMetrics.boundsPx: PxRect
    get() = PxRect(bounds)
