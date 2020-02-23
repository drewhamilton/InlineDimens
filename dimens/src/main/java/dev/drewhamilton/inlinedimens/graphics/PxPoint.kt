package dev.drewhamilton.inlinedimens.graphics

import android.graphics.Point
import dev.drewhamilton.inlinedimens.PxInt
import dev.drewhamilton.inlinedimens.px

/**
 * A [PxInt] unit-specific wrapper for [Point].
 */
inline class PxPoint(internal val point: Point) {

    constructor() : this(Point())

    constructor(x: PxInt, y: PxInt) : this(Point(x.value, y.value))

    var x: PxInt
        get() = point.x.px
        set(x) {
            point.x = x.value
        }

    var y: PxInt
        get() = point.y.px
        set(y) {
            point.y = y.value
        }
}
