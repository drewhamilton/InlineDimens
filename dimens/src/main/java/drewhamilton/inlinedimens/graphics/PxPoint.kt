package drewhamilton.inlinedimens.graphics

import android.graphics.Point
import drewhamilton.inlinedimens.PxInt

/**
 * A [PxInt] unit-specific wrapper for [Point].
 */
inline class PxPoint(internal val point: Point) {

    constructor() : this(Point())

    constructor(x: PxInt, y: PxInt) : this (Point(x.value, y.value))

    var x: PxInt
        get() = PxInt(point.x)
        set(x) {
            point.x = x.value
        }

    var y: PxInt
        get() = PxInt(point.y)
        set(y) {
            point.y = y.value
        }
}
