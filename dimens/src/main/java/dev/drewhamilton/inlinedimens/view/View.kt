package dev.drewhamilton.inlinedimens.view

import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import dev.drewhamilton.inlinedimens.Px
import dev.drewhamilton.inlinedimens.PxInt
import dev.drewhamilton.inlinedimens.arrays.PxIntArray
import dev.drewhamilton.inlinedimens.graphics.PxRect
import dev.drewhamilton.inlinedimens.px

//region Fading edge length
/**
 * Returns the size in px of the vertical faded edges used to indicate that more content in this view is visible.
 *
 * Returns 0 if vertical faded edges are not enabled for this view.
 *
 * @attr ref android.R.styleable#View_fadingEdgeLength
 */
val View.verticalFadingEdgeLengthPx get() = verticalFadingEdgeLength.px

/**
 * Returns the size in px of the horizontal faded edges used to indicate that more content in this view is visible.
 *
 * Returns 0 if horizontal faded edges are not enabled for this view.
 *
 * @attr ref android.R.styleable#View_fadingEdgeLength
 */
val View.horizontalFadingEdgeLengthPx get() = horizontalFadingEdgeLength.px

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
val View.verticalScrollbarWidthPx get() = verticalScrollbarWidth.px

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
    get() = scrollX.px
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
    get() = scrollY.px
    set(value) {
        scrollY = value.value
    }
//endregion

//region Size
/**
 * The width of your view, in px.
 */
val View.widthPx get() = width.px

/**
 * The height of your view, in px.
 */
val View.heightPx get() = height.px

/**
 * The minimum width of the view.
 *
 * When set, it is not guaranteed the view will be able to achieve this minimum width (for example, if its parent layout
 * constrains it with less available width).
 */
var View.minimumWidthPx
    get() = ViewCompat.getMinimumWidth(this).px
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
    get() = ViewCompat.getMinimumHeight(this).px
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
    get() = cameraDistance.px
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
val View.topPx get() = top.px

/**
 * Bottom position of this view relative to its parent.
 *
 * This property is not mutable because [View.setBottom] is meant to be called by the layout system and should not
 * generally be called otherwise, because the property may be changed at any time by the layout.
 */
val View.bottomPx get() = bottom.px

/**
 * Left position of this view relative to its parent.
 *
 * This property is not mutable because [View.setLeft] is meant to be called by the layout system and should not
 * generally be called otherwise, because the property may be changed at any time by the layout.
 */
val View.leftPx get() = left.px

/**
 * Right position of this view relative to its parent.
 *
 * This property is not mutable because [View.setRight] is meant to be called by the layout system and should not
 * generally be called otherwise, because the property may be changed at any time by the layout.
 */
val View.rightPx get() = right.px

/**
 * The visual x position of this view, in px. This is equivalent to the [translationXPx] property plus the current
 * [leftPx] property.
 *
 * Changing this value is equivalent to setting the [View.setTranslationX] property to be the difference between the x
 * value passed in and the current [leftPx] property.
 */
var View.xPx
    get() = x.px
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
    get() = y.px
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
    get() = ViewCompat.getZ(this).px
    set(z) {
        ViewCompat.setZ(this, z.value)
    }

/**
 * The base elevation of this view relative to its parent, in px.
 *
 * Always equals 0 on Android SDK < 21.
 */
var View.elevationPx
    get() = ViewCompat.getElevation(this).px
    set(elevation) {
        ViewCompat.setElevation(this, elevation.value)
    }

/**
 * The horizontal location of this view relative to its [leftPx] position. This position is post-layout, in addition to
 * wherever the object's layout placed it.
 */
var View.translationXPx
    get() = translationX.px
    set(translationX) {
        this.translationX = translationX.value
    }

/**
 * The vertical location of this view relative to its [topPx] position. This position is post-layout, in addition to
 * wherever the object's layout placed it.
 */
var View.translationYPx
    get() = translationY.px
    set(translationY) {
        this.translationY = translationY.value
    }

/**
 * The depth location of this view relative to its [elevationPx].
 *
 * Always equals 0 on SDK < 21.
 */
var View.translationZPx
    get() = ViewCompat.getTranslationZ(this).px
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
fun View.scrollBy(x: PxInt = 0.px, y: PxInt = 0.px) = scrollBy(x.value, y.value)

//region Padding
/**
 * The top padding of this view.
 */
val View.paddingTopPx get() = paddingTop.px

/**
 * The bottom padding of this view.
 */
val View.paddingBottomPx get() = paddingBottom.px

/**
 * The left padding of this view.
 */
val View.paddingLeftPx get() = paddingLeft.px

/**
 * The right padding of this view.
 */
val View.paddingRightPx get() = paddingRight.px

/**
 * The start padding of this view depending on its resolved layout direction. If there are inset and enabled scrollbars,
 * this value may include the space required to display the scrollbars as well.
 */
val View.paddingStartPx get() = ViewCompat.getPaddingStart(this).px

/**
 * The end padding of this view depending on its resolved layout direction. If there are inset and enabled scrollbars,
 * this value may include the space required to display the scrollbars as well.
 */
val View.paddingEndPx get() = ViewCompat.getPaddingEnd(this).px

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

//region Location
/**
 * Computes the coordinates of this view on the screen. The argument must be an array of size 2. After the function
 * returns, the array contains the x and y location in that order.
 */
fun View.getLocationOnScreen(outLocation: PxIntArray) = getLocationOnScreen(outLocation.values)

/**
 * Computes the coordinates of this view in its window. The argument must be an array of size 2. After the function
 * returns, the array contains the x and y location in that order, in px.
 */
fun View.getLocationInWindow(outLocation: PxIntArray) = getLocationInWindow(outLocation.values)
//endregion

//region Nested scrolling
/**
 * Dispatch one step of a nested scroll in progress.
 *
 * Implementations of views that support nested scrolling should call this to report info about a scroll in progress to
 * the current nested scrolling parent. If a nested scroll is not currently in progress or nested scrolling is not
 * enabled for this view this method does nothing.
 *
 * Compatible View implementations should also call [dispatchNestedPreScroll] before consuming a component of the scroll
 * event themselves.
 *
 * @param dxConsumed Horizontal distance in px consumed by this view during this scroll step
 * @param dyConsumed Vertical distance in px consumed by this view during this scroll step
 * @param dxUnconsumed Horizontal scroll distance in px not consumed by this view
 * @param dyUnconsumed Horizontal scroll distance in px not consumed by this view
 * @param offsetInWindow If not null, on return this will contain the offset in local view coordinates of this view from
 *        before this operation to after it completes. View implementations may use this to adjust expected input
 *        coordinate tracking.
 * @return true if the event was dispatched, false if it could not be dispatched.
 */
fun View.dispatchNestedScroll(
    dxConsumed: PxInt, dyConsumed: PxInt,
    dxUnconsumed: PxInt, dyUnconsumed: PxInt,
    offsetInWindow: PxIntArray? = null
): Boolean = ViewCompat.dispatchNestedScroll(
    this,
    dxConsumed.value, dyConsumed.value,
    dxUnconsumed.value, dyUnconsumed.value,
    offsetInWindow?.values
)

/**
 * Dispatch one step of a nested scroll in progress before this view consumes any portion of it.
 *
 * Nested pre-scroll events are to nested scroll events what touch intercept is to touch. dispatchNestedPreScroll offers
 * an opportunity for the parent view in a nested scrolling operation to consume some or all of the scroll operation
 * before the child view consumes it.
 *
 * @param dx Horizontal scroll distance in pixels
 * @param dy Vertical scroll distance in pixels
 * @param consumed Output. If not null, consumed[0] will contain the consumed component of dx and consumed[1] the
 *        consumed dy.
 * @param offsetInWindow If not null, on return this will contain the offset in local view coordinates of this view from
 *        before this operation to after it completes. View implementations may use this to adjust expected input
 *        coordinate tracking.
 * @return true if the parent consumed some or all of the scroll delta
 */
fun View.dispatchNestedPreScroll(
    dx: PxInt, dy: PxInt,
    consumed: PxIntArray? = null,
    offsetInWindow: PxIntArray? = null
): Boolean = ViewCompat.dispatchNestedPreScroll(this, dx.value, dy.value, consumed?.values, offsetInWindow?.values)
//endregion

// TODO?: Implement "dispatch" functions that pixel velocity handling such as dispatchNestedFling
