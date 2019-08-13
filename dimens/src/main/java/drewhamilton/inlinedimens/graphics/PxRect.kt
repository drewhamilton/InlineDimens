package drewhamilton.inlinedimens.graphics

import android.graphics.Rect
import drewhamilton.inlinedimens.PxInt

/**
 * A [PxInt] unit-specific wrapper for [Rect].
 */
inline class PxRect(internal val rect: Rect) {

    constructor() : this(Rect())

    constructor(
        left: PxInt,
        top: PxInt,
        right: PxInt,
        bottom: PxInt
    ) : this(Rect(left.value, top.value, right.value, bottom.value))

    var left: PxInt
        get() = PxInt(rect.left)
        set(left) {
            rect.left = left.value
        }

    var top: PxInt
        get() = PxInt(rect.top)
        set(top) {
            rect.top = top.value
        }

    var right: PxInt
        get() = PxInt(rect.right)
        set(right) {
            rect.right = right.value
        }

    var bottom: PxInt
        get() = PxInt(rect.bottom)
        set(bottom) {
            rect.bottom = bottom.value
        }
}
