package drewhamilton.inlinedimens.view

import android.view.View
import androidx.annotation.RequiresApi
import drewhamilton.inlinedimens.Px
import drewhamilton.inlinedimens.PxInt
import drewhamilton.inlinedimens.graphics.PxRect

//region Fading edge length
/**
 * Returns the size in px of the vertical faded edges used to indicate that more content in this view is visible.
 *
 * Returns 0 if vertical faded edges are not enabled for this view.
 *
 * @attr ref android.R.styleable#View_fadingEdgeLength
 */
val View.verticalFadingEdgeLengthPx get() = PxInt(verticalFadingEdgeLength)

/**
 * Returns the size in px of the horizontal faded edges used to indicate that more content in this view is visible.
 *
 * Returns 0 if horizontal faded edges are not enabled for this view.
 *
 * @attr ref android.R.styleable#View_fadingEdgeLength
 */
val View.horizontalFadingEdgeLengthPx get() = PxInt(horizontalFadingEdgeLength)

/**
 * Set the [length] of the faded edge used to indicate that more content in this view is available. Will not change
 * whether the fading edge is enabled; use [View.setVerticalFadingEdgeEnabled] or [View.setHorizontalFadingEdgeEnabled]
 * to enable the fading edge for the vertical or horizontal fading edges.
 */
fun View.setFadingEdgeLength(length: PxInt) = setFadingEdgeLength(length.value)
//endregion

/**
 * Returns the width in px of the vertical scrollbar, or 0 if there is no vertical scrollbar.
 */
val View.verticalScrollbarWidthPx get() = PxInt(verticalScrollbarWidth)

/**
 * Shows the context menu for this view anchored to the specified view-relative coordinate.
 *
 * [x] is the X coordinate in px relative to the view to which the menu should be anchored. [y] is the Y coordinate in
 * px relative to the view to which the menu should be anchored. For either parameter, use [Float.NaN] to disable
 * anchoring for the respective coordinate.
 *
 * Returns true if the context menu was shown, false otherwise.
 */
@RequiresApi(24)
fun View.showContextMenu(x: Px, y: Px) = showContextMenu(x.value, y.value)

//region Scroll position
/**
 * Return the scrolled left position of this view in px. This is the left edge of the displayed part of your view. You
 * do not need to draw any pixels farther left, since those are outside of the frame of your view on screen.
 *
 * Set the horizontal scrolled position of your view. This will cause a call to [View.onScrollChanged] and the view will
 * be invalidated.
 */
var View.scrollXPx
    get() = PxInt(scrollX)
    set(value) {
        scrollX = value.value
    }

/**
 * Return the scrolled top position of this view in px. This is the top edge of the displayed part of your view. You do
 * not need to draw any pixels above it, since those are outside of the frame of your view on screen.
 *
 * Set the vertical scrolled position of your view. This will cause a call to [View.onScrollChanged] and the view will
 * be invalidated.
 */
var View.scrollYPx
    get() = PxInt(scrollY)
    set(value) {
        scrollY = value.value
    }
//endregion

//region Size
/**
 * The width of your view, in px.
 */
val View.widthPx get() = PxInt(width)

/**
 * The height of your view, in px.
 */
val View.heightPx get() = PxInt(height)
//endregion

/**
 * Fill in [outRect] with the visible drawing bounds of your view. Fills in the output rectangle with the values from
 * [View.getScrollX], [View.getScrollY], [View.getWidth], and [View.getHeight]. These bounds do not account for any
 * transformation properties currently set on the view, such as [View.setScaleX] or [View.setRotation].
 *
 * @param outRect The (scrolled) drawing bounds of the view.
 */
fun View.getDrawingRect(outRect: PxRect) = getDrawingRect(outRect.rect)
