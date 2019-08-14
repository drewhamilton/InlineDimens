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

/**
 * The distance along the Z axis (orthogonal to the X/Y plane on which views are drawn) from the camera to this view.
 * The camera's distance affects 3D transformations, for instance rotations around the X and Y axis. If the rotationX or
 * rotationY properties are changed and this view is large (more than half the size of the screen), it is recommended to
 * always use a camera distance that's greater than the height (X axis rotation) or the width (Y axis rotation) of this
 * view.
 *
 * The distance of the camera from the view plane can have an affect on the perspective distortion of the view when it
 * is rotated around the x or y axis. For example, a large distance will result in a large viewing angle, and there will
 * not be much perspective distortion of the view as it rotates. A short distance may cause much more perspective
 * distortion upon rotation, and can also result in some drawing artifacts if the rotated view ends up partially behind
 * the camera (which is why the recommendation is to use a distance at least as far as the size of the view, if the view
 * is to be rotated.)
 *
 * The distance is expressed in "depth pixels." The default distance depends on the screen density. For instance, on a
 * medium density display, the default distance is 1280. On a high density display, the default distance is 1920.
 *
 * If you want to specify a distance that leads to visually consistent results across various densities, specify a value
 * in dp before converting it to set this property:
 *
 * view.cameraDistancePx = Dp(distance).toPx()
 */
@get:RequiresApi(16)
var View.cameraDistancePx: Px
    get() = Px(cameraDistance)
    set(distance) {
        cameraDistance = distance.value
    }

//region Position
/**
 * Top position of this view relative to its parent.
 *
 * This property is not mutable because [View.setTop] is meant to be called by the layout system and should not
 * generally be called otherwise, because the property may be changed at any time by the layout.
 */
val View.topPx get() = PxInt(top)

/**
 * Bottom position of this view relative to its parent.
 *
 * This property is not mutable because [View.setBottom] is meant to be called by the layout system and should not
 * generally be called otherwise, because the property may be changed at any time by the layout.
 */
val View.bottomPx get() = PxInt(bottom)

/**
 * Left position of this view relative to its parent.
 *
 * This property is not mutable because [View.setLeft] is meant to be called by the layout system and should not
 * generally be called otherwise, because the property may be changed at any time by the layout.
 */
val View.leftPx get() = PxInt(left)

/**
 * Right position of this view relative to its parent.
 *
 * This property is not mutable because [View.setRight] is meant to be called by the layout system and should not
 * generally be called otherwise, because the property may be changed at any time by the layout.
 */
val View.rightPx get() = PxInt(right)

/**
 * The visual x position of this view, in px. This is equivalent to the [View.getTranslationX] property plus the current
 * [View.getLeft] property.
 *
 * Changing this value is equivalent to setting the [View.setTranslationX] property to be the difference between the x
 * value passed in and the current [View.getLeft] property.
 */
var View.xPx
    get() = Px(x)
    set(x) {
        this.x = x.value
    }

/**
 * The visual y position of this view, in px. This is equivalent to the [View.getTranslationY] property plus the current
 * [View.getTop] property.
 *
 * Changing this value is equivalent to setting the [View.setTranslationY] property to be the difference between the y
 * value passed in and the current [View.getTop] property.
 */
var View.yPx
    get() = Px(y)
    set(y) {
        this.y = y.value
    }

/**
 * The visual z position of this view, in px. This is equivalent to the [View.getTranslationZ] property plus the current
 * [View.getElevation] property.
 *
 * Changing this value is equivalent to setting the [View.setTranslationZ] property to be the difference between the z
 * value passed in and the current [View.getElevation] property.
 */
@get:RequiresApi(21)
@set:RequiresApi(21)
var View.zPx
    get() = Px(z)
    set(z) {
        this.z = z.value
    }

/**
 * The base elevation of this view relative to its parent, in px.
 */
@get:RequiresApi(21)
@set:RequiresApi(21)
var View.elevationPx
    get() = Px(elevation)
    set(elevation) {
        this.elevation = elevation.value
    }
//endregion
