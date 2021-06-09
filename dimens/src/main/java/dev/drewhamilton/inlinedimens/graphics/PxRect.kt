package dev.drewhamilton.inlinedimens.graphics

import android.graphics.Rect
import dev.drewhamilton.inlinedimens.PxInt
import dev.drewhamilton.inlinedimens.px

/**
 * A [PxInt] unit-specific wrapper for [Rect].
 */
@JvmInline
value class PxRect(internal val rect: Rect) {

    constructor() : this(Rect())

    constructor(
        left: PxInt,
        top: PxInt,
        right: PxInt,
        bottom: PxInt
    ) : this(Rect(left.value, top.value, right.value, bottom.value))

    var left: PxInt
        get() = rect.left.px
        set(left) {
            rect.left = left.value
        }

    var top: PxInt
        get() = rect.top.px
        set(top) {
            rect.top = top.value
        }

    var right: PxInt
        get() = rect.right.px
        set(right) {
            rect.right = right.value
        }

    var bottom: PxInt
        get() = rect.bottom.px
        set(bottom) {
            rect.bottom = bottom.value
        }
}
