package drewhamilton.inlinedimens

import android.content.res.Resources
import androidx.annotation.DimenRes

fun Resources.getDimensionPxSize(@DimenRes id: Int) = PxInt(getDimensionPixelSize(id))

fun Resources.getDimensionPxOffset(@DimenRes id: Int) = PxInt(getDimensionPixelOffset(id))

fun Resources.getDimensionPx(@DimenRes id: Int) = Px(getDimension(id))
