package drewhamilton.inlinedimens.view

import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
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

/**
 * The minimum width of the view.
 *
 * When set, it is not guaranteed the view will be able to achieve this minimum width (for example, if its parent layout
 * constrains it with less available width).
 */
var View.minimumWidthPx
    get() = PxInt(ViewCompat.getMinimumWidth(this))
    set(minWidth) {
        minimumWidth = minWidth.value
    }

/**
 * The minimum height of the view.
 *
 * When set, it is not guaranteed the view will be able to achieve this minimum height (for example, if its parent
 * layout constrains it with less available height).
 */
var View.minimumHeightPx
    get() = PxInt(ViewCompat.getMinimumHeight(this))
    set(minHeight) {
        minimumHeight = minHeight.value
    }
//endregion

/**
 * Fill in [outRect] with the visible drawing bounds of your view. Fills in the output rectangle with the values from
 * [scrollXPx], [scrollYPx], [widthPx], and [heightPx]. These bounds do not account for any transformation properties
 * currently set on the view, such as [View.setScaleX] or [View.setRotation].
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
 * The visual x position of this view, in px. This is equivalent to the [translationXPx] property plus the current
 * [leftPx] property.
 *
 * Changing this value is equivalent to setting the [View.setTranslationX] property to be the difference between the x
 * value passed in and the current [leftPx] property.
 */
var View.xPx
    get() = Px(x)
    set(x) {
        this.x = x.value
    }

/**
 * The visual y position of this view, in px. This is equivalent to the [translationYPx] property plus the current
 * [topPx] property.
 *
 * Changing this value is equivalent to setting the [View.setTranslationY] property to be the difference between the y
 * value passed in and the current [topPx] property.
 */
var View.yPx
    get() = Px(y)
    set(y) {
        this.y = y.value
    }

/**
 * The visual z position of this view, in px. This is equivalent to the [translationZPx] property plus the current
 * [elevationPx] property.
 *
 * Changing this value is equivalent to setting the [View.setTranslationZ] property to be the difference between the z
 * value passed in and the current [elevationPx] property.
 *
 * Always equals 0 on Android SDK < 21.
 */
var View.zPx
    get() = Px(ViewCompat.getZ(this))
    set(z) {
        ViewCompat.setZ(this, z.value)
    }

/**
 * The base elevation of this view relative to its parent, in px.
 *
 * Always equals 0 on Android SDK < 21.
 */
var View.elevationPx
    get() = Px(ViewCompat.getElevation(this))
    set(elevation) {
        ViewCompat.setElevation(this, elevation.value)
    }

/**
 * The horizontal location of this view relative to its [leftPx] position. This position is post-layout, in addition to
 * wherever the object's layout placed it.
 */
var View.translationXPx
    get() = Px(translationX)
    set(translationX) {
        this.translationX = translationX.value
    }

/**
 * The vertical location of this view relative to its [topPx] position. This position is post-layout, in addition to
 * wherever the object's layout placed it.
 */
var View.translationYPx
    get() = Px(translationY)
    set(translationY) {
        this.translationY = translationY.value
    }

/**
 * The depth location of this view relative to its [elevationPx].
 *
 * Always equals 0 on SDK < 21.
 */
var View.translationZPx
    get() = Px(ViewCompat.getTranslationZ(this))
    set(translationZ) {
        ViewCompat.setTranslationZ(this, translationZ.value)
    }
//endregion

/**
 * Offset this view's vertical location by the specified number of pixels.
 */
fun View.offsetTopAndBottom(offset: PxInt) = offsetTopAndBottom(offset.value)

/**
 * Offset this view's horizontal location by the specified number of pixels.
 */
fun View.offsetLeftAndRight(offset: PxInt) = offsetLeftAndRight(offset.value)

/**
 * Move the scrolled position of your view by [x] px horizontally and [y] px vertically. This will cause a call to
 * [View.onScrollChanged] and the view will be invalidated.
 *
 * [x] and [y] both default to 0 so you can choose a single axis along which to scroll.
 */
fun View.scrollBy(x: PxInt = PxInt(0), y: PxInt = PxInt(0)) = scrollBy(x.value, y.value)

//region Padding
/**
 * The top padding of this view.
 */
val View.paddingTopPx get() = PxInt(paddingTop)

/**
 * The bottom padding of this view.
 */
val View.paddingBottomPx get() = PxInt(paddingBottom)

/**
 * The left padding of this view.
 */
val View.paddingLeftPx get() = PxInt(paddingLeft)

/**
 * The right padding of this view.
 */
val View.paddingRightPx get() = PxInt(paddingRight)

/**
 * The start padding of this view depending on its resolved layout direction. If there are inset and enabled scrollbars,
 * this value may include the space required to display the scrollbars as well.
 */
val View.paddingStartPx get() = PxInt(ViewCompat.getPaddingStart(this))

/**
 * The end padding of this view depending on its resolved layout direction. If there are inset and enabled scrollbars,
 * this value may include the space required to display the scrollbars as well.
 */
val View.paddingEndPx get() = PxInt(ViewCompat.getPaddingEnd(this))

/**
 * Sets the padding. The view may add on the space required to display the scrollbars, depending on the style and
 * visibility of the scrollbars. So the values of [paddingLeftPx], [paddingTopPx], [paddingRightPx], and
 * [paddingBottomPx] may be different from the values set in this call.
 *
 * Each parameter defaults to the current value, so a subset of sides can be padded easily.
 */
fun View.setPadding(
    left: PxInt = paddingLeftPx,
    top: PxInt = paddingTopPx,
    right: PxInt = paddingRightPx,
    bottom: PxInt = paddingBottomPx
) = setPadding(left.value, top.value, right.value, bottom.value)

/**
 * Sets the relative padding. The view may add on the space required to display the scrollbars, depending on the style
 * and visibility of the scrollbars. So the values returned from [paddingStartPx], [paddingTopPx], [paddingEndPx] and
 * [paddingBottomPx] may be different from the values set in this call.
 *
 * Each parameter defaults to the current value, so a subset of sides can be padded easily.
 */
fun View.setPaddingRelative(
    start: PxInt = paddingStartPx,
    top: PxInt = paddingTopPx,
    end: PxInt = paddingEndPx,
    bottom: PxInt = paddingBottomPx
) = ViewCompat.setPaddingRelative(this, start.value, top.value, end.value, bottom.value)
//endregion

// TODO MISSING: Implement functions that mutate int arrays such as getLocationInWindow and dispatchNestedScroll

// TODO MISSING: Implement "dispatch" functions that pixel velocity handling such as dispatchNestedFling
