package dev.drewhamilton.inlinedimens.view

import android.view.ViewGroup
import androidx.core.view.MarginLayoutParamsCompat
import dev.drewhamilton.inlinedimens.PxInt

//region LayoutParams
/**
 * Information about how wide the view wants to be. Can be one of the constants [ViewGroup.LayoutParams.MATCH_PARENT] or
 * [ViewGroup.LayoutParams.WRAP_CONTENT], or an exact size. Note that both MATCH_PARENT and WRAP_CONTENT will be wrapped
 * in the return [PxInt] type.
 */
var ViewGroup.LayoutParams.widthPx: PxInt
    get() = PxInt(width)
    set(widthPx) {
        width = widthPx.value
    }

/**
 * Information about how tall the view wants to be. Can be one of the constants [ViewGroup.LayoutParams.MATCH_PARENT] or
 * [ViewGroup.LayoutParams.WRAP_CONTENT], or an exact size. Note that both MATCH_PARENT and WRAP_CONTENT will be wrapped
 * in the return [PxInt] type.
 */
var ViewGroup.LayoutParams.heightPx: PxInt
    get() = PxInt(height)
    set(heightPx) {
        height = heightPx.value
    }
//endregion

//region MarginLayoutParams
/**
 * The left margin in px of the child. Margin values should be positive. Call [ViewGroup.setLayoutParams] after
 * reassigning a new value to this property.
 */
var ViewGroup.MarginLayoutParams.leftMarginPx: PxInt
    get() = PxInt(leftMargin)
    set(leftMarginPx) {
        leftMargin = leftMarginPx.value
    }

/**
 * The top margin in px of the child. Margin values should be positive. Call [ViewGroup.setLayoutParams] after
 * reassigning a new value to this property.
 */
var ViewGroup.MarginLayoutParams.topMarginPx: PxInt
    get() = PxInt(topMargin)
    set(topMarginPx) {
        topMargin = topMarginPx.value
    }

/**
 * The right margin in px of the child. Margin values should be positive. Call [ViewGroup.setLayoutParams] after
 * reassigning a new value to this property.
 */
var ViewGroup.MarginLayoutParams.rightMarginPx: PxInt
    get() = PxInt(rightMargin)
    set(rightMarginPx) {
        rightMargin = rightMarginPx.value
    }

/**
 * The bottom margin in px of the child. Margin values should be positive. Call [ViewGroup.setLayoutParams] after
 * reassigning a new value to this property.
 */
var ViewGroup.MarginLayoutParams.bottomMarginPx: PxInt
    get() = PxInt(bottomMargin)
    set(bottomMarginPx) {
        bottomMargin = bottomMarginPx.value
    }

/**
 * The relative starting margin.
 *
 * On platform versions supporting bidirectional text and layouts this value will be resolved into the LayoutParams
 * object's left or right margin as appropriate when the associated View is attached to a window or when the layout
 * direction of that view changes.
 */
var ViewGroup.MarginLayoutParams.startMarginPx: PxInt
    get() = PxInt(MarginLayoutParamsCompat.getMarginStart(this))
    set(startMarginPx) {
        MarginLayoutParamsCompat.setMarginStart(this, startMarginPx.value)
    }

/**
 * The relative end margin.
 *
 * On platform versions supporting bidirectional text and layouts this value will be resolved into the LayoutParams
 * object's left or right margin as appropriate when the associated View is attached to a window or when the layout
 * direction of that view changes.
 */
var ViewGroup.MarginLayoutParams.endMarginPx: PxInt
    get() = PxInt(MarginLayoutParamsCompat.getMarginEnd(this))
    set(endMarginPx) {
        MarginLayoutParamsCompat.setMarginEnd(this, endMarginPx.value)
    }

/**
 * Sets the margins, in px. A call to [android.view.View.requestLayout] needs to be done so that the new margins are
 * taken into account. Left and right margins may be overridden by [android.view.View.requestLayout] depending on layout
 * direction.
 *
 * Margin values should be positive.
 */
fun ViewGroup.MarginLayoutParams.setMargins(left: PxInt, top: PxInt, right: PxInt, bottom: PxInt) =
    setMargins(left.value, top.value, right.value, bottom.value)
//endregion
