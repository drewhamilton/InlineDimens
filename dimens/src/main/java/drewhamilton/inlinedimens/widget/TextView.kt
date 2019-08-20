package drewhamilton.inlinedimens.widget

import android.util.TypedValue
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.widget.TextViewCompat
import drewhamilton.inlinedimens.Dp
import drewhamilton.inlinedimens.DpInt
import drewhamilton.inlinedimens.Px
import drewhamilton.inlinedimens.PxInt
import drewhamilton.inlinedimens.Sp
import drewhamilton.inlinedimens.SpInt
import drewhamilton.inlinedimens.arrays.DpIntArray
import drewhamilton.inlinedimens.arrays.PxIntArray
import drewhamilton.inlinedimens.arrays.SpIntArray
import drewhamilton.inlinedimens.toDp
import drewhamilton.inlinedimens.toSp

//region Auto-size
/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit within the layout bounds. If
 * at least one value from [presetSizes] is valid then the type of auto-size is set to
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * Throws [IllegalArgumentException] if all of the [presetSizes] are invalid.
 */
fun TextView.setAutoSizeTextTypeUniformWithPresetSizes(presetSizes: PxIntArray) =
    TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(this, presetSizes.values, TypedValue.COMPLEX_UNIT_PX)

/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit within the layout bounds. If
 * at least one value from [presetSizes] is valid then the type of auto-size is set to
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * Throws [IllegalArgumentException] if all of the [presetSizes] are invalid.
 */
fun TextView.setAutoSizeTextTypeUniformWithPresetSizes(presetSizes: DpIntArray) =
    TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(this, presetSizes.values, TypedValue.COMPLEX_UNIT_DIP)

/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit within the layout bounds. If
 * at least one value from [presetSizes] is valid then the type of auto-size is set to
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * Throws [IllegalArgumentException] if all of the [presetSizes] are invalid.
 */
fun TextView.setAutoSizeTextTypeUniformWithPresetSizes(presetSizes: SpIntArray) =
    TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(this, presetSizes.values, TypedValue.COMPLEX_UNIT_SP)

/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit within the layout bounds. If
 * [minSize], [maxSize], and [stepGranularity] are valid the type of auto-size is set to
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * Throws [IllegalArgumentException] if any of the configuration params are invalid.
 */
fun TextView.setAutoSizeTextTypeUniformWithConfiguration(minSize: PxInt, maxSize: PxInt, stepGranularity: PxInt) =
    TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
        this,
        minSize.value, maxSize.value,
        stepGranularity.value,
        TypedValue.COMPLEX_UNIT_PX
    )

/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit within the layout bounds. If
 * [minSize], [maxSize], and [stepGranularity] are valid the type of auto-size is set to
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * Throws [IllegalArgumentException] if any of the configuration params are invalid.
 */
fun TextView.setAutoSizeTextTypeUniformWithConfiguration(minSize: DpInt, maxSize: DpInt, stepGranularity: DpInt) =
    TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
        this,
        minSize.value, maxSize.value,
        stepGranularity.value,
        TypedValue.COMPLEX_UNIT_DIP
    )

/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit within the layout bounds. If
 * [minSize], [maxSize], and [stepGranularity] are valid the type of auto-size is set to
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * Throws [IllegalArgumentException] if any of the configuration params are invalid.
 */
fun TextView.setAutoSizeTextTypeUniformWithConfiguration(minSize: SpInt, maxSize: SpInt, stepGranularity: SpInt) =
    TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
        this,
        minSize.value, maxSize.value,
        stepGranularity.value,
        TypedValue.COMPLEX_UNIT_SP
    )

/**
 * The current auto-size step granularity in px.
 */
val TextView.autoSizeStepGranularityPx get() = PxInt(TextViewCompat.getAutoSizeStepGranularity(this))

/**
 * The current auto-size minimum text size in px (the default is 12sp). Note that if auto-size has not been configured
 * this returns -1.
 */
val TextView.autoSizeMinTextSizePx get() = PxInt(TextViewCompat.getAutoSizeMinTextSize(this))

/**
 * The current auto-size maximum text size in px (the default is 112sp). Note that if auto-size has not been configured
 * this returns -1.
 */
val TextView.autoSizeMaxTextSizePx get() = PxInt(TextViewCompat.getAutoSizeMaxTextSize(this))

/**
 * The current auto-size sizes array (in px).
 */
val TextView.autoSizeTextAvailableSizesPx get() = PxIntArray(TextViewCompat.getAutoSizeTextAvailableSizes(this))
//endregion

//region Line and baseline heights
/**
 * The vertical distance between lines of text, in px. Note that markup within the text can cause individual lines to be
 * taller or shorter than this height, and the layout may contain additional first- or last-line padding.
 */
var TextView.lineHeightPx
    get() = PxInt(lineHeight)
    set(lineHeight) {
        TextViewCompat.setLineHeight(this, lineHeight.value)
    }

/**
 * The distance between the first text baseline and the top of this TextView.
 *
 * When set, updates the top padding of the TextView so that firstBaselineToTopHeight is equal to the distance between
 * the first text baseline and the top of this TextView.
 *
 * Note that if [android.graphics.Paint.FontMetrics.top] or [android.graphics.Paint.FontMetrics.ascent] was already
 * greater than [TextView.getFirstBaselineToTopHeight], the top padding is not updated.
 */
var TextView.firstBaselineToTopHeightPx
    get() = PxInt(TextViewCompat.getFirstBaselineToTopHeight(this))
    set(firstBaselineToTopHeight) {
        TextViewCompat.setFirstBaselineToTopHeight(this, firstBaselineToTopHeight.value)
    }

/**
 * The distance between the last text baseline and the bottom of this TextView.
 *
 * When set, updates the bottom padding of the TextView so that lastBaselineToBottomHeight is equal to the distance
 * between the last text baseline and the bottom of this TextView.
 *
 * Note that if [android.graphics.Paint.FontMetrics.bottom] or [android.graphics.Paint.FontMetrics.descent] was already
 * greater than [TextView.getLastBaselineToBottomHeight], the top padding is not updated.
 */
var TextView.lastBaselineToBottomHeightPx
    get() = PxInt(TextViewCompat.getLastBaselineToBottomHeight(this))
    set(lastBaselineToBottomHeight) {
        TextViewCompat.setLastBaselineToBottomHeight(this, lastBaselineToBottomHeight.value)
    }
//endregion

//region Text size
/**
 * The size in px of the default text size of this [TextView].
 *
 * Note: if this TextView has the auto-size feature enabled than setting this value is no-op.
 */
var TextView.textSizePx: Px
    get() = Px(textSize)
    set(size) {
        setTextSize(TypedValue.COMPLEX_UNIT_PX, size.value)
    }

/**
 * The size in dp of the default text size of this [TextView].
 *
 * Note: if this TextView has the auto-size feature enabled than setting this value is no-op.
 */
var TextView.textSizeDp: Dp
    get() = textSizePx.toDp(resources)
    set(size) {
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, size.value)
    }

/**
 * The size in sp of the default text size of this [TextView].
 *
 * Note: if this TextView has the auto-size feature enabled than setting this value is no-op.
 */
var TextView.textSizeSp: Sp
    get() = textSizePx.toSp(resources)
    set(size) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, size.value)
    }
//endregion

//region View size
/**
 * The minimum height of this TextView in px, or -1 if the minimum height was set using [TextView.setMinLines] or
 * [TextView.setLines].
 *
 * When set, sets the height of the TextView to be at least this tall. This value is used for height calculation if
 * LayoutParams does not force TextView to have an exact height. Setting this value overrides previous minimum height
 * configurations such as [TextView.setMinLines] or [TextView.setLines].
 *
 * The value given here is different than [android.view.View.setMinimumHeight]. Between this value and the value set in
 * [android.view.View.setMinimumHeight], the greater one is used to decide the final height.
 */
@get:RequiresApi(16)
var TextView.minHeightPx
    get() = PxInt(minHeight)
    set(minPixels) {
        minHeight = minPixels.value
    }

/**
 * The maximum height of this TextView in px, or -1 if the maximum height was set using [TextView.setMaxLines] or
 * [TextView.setLines].
 *
 * When set, sets the height of the TextView to be at most this tall. This value is used for height calculation if
 * LayoutParams does not force TextView to have an exact height. Setting this value overrides previous maximum height
 * configurations such as [TextView.setMaxLines] or [TextView.setLines].
 */
@get:RequiresApi(16)
var TextView.maxHeightPx
    get() = PxInt(maxHeight)
    set(maxPixels) {
        maxHeight = maxPixels.value
    }

/**
 * The height of the TextView in px.
 *
 * This value is used for height calculation if LayoutParams does not force TextView to have an exact height. Setting
 * this value overrides previous minimum/maximum height configurations such as [minHeightPx] or [maxHeightPx].
 */
var TextView.heightPx
    get() = PxInt(height)
    set(pixels) {
        height = pixels.value
    }

/**
 * The minimum width of this TextView in px, or -1 if the minimum width was set using [TextView.setMinEms] or
 * [TextView.setEms].
 *
 * When set, sets the width of the TextView to be at least this wide. This value is used for width calculation if
 * LayoutParams does not force TextView to have an exact width. Setting this value overrides previous minimum width
 * configurations such as [TextView.setMinEms] or [TextView.setEms].
 *
 * The value given here is different than [android.view.View.setMinimumWidth]. Between this value and the value set in
 * [android.view.View.setMinimumWidth], the greater one is used to decide the final width.
 */
@get:RequiresApi(16)
var TextView.minWidthPx
    get() = PxInt(minWidth)
    set(minPixels) {
        minWidth = minPixels.value
    }

/**
 * The maximum width of this TextView in px, or -1 if the maximum width was set using [TextView.setMaxEms] or
 * [TextView.setEms].
 *
 * When set, sets the width of the TextView to be at most this wide. This value is used for width calculation if
 * LayoutParams does not force TextView to have an exact width. Setting this value overrides previous maximum width
 * configurations such as [TextView.setMaxEms] or [TextView.setEms].
 */
@get:RequiresApi(16)
var TextView.maxWidthPx
    get() = PxInt(maxWidth)
    set(maxPixels) {
        maxWidth = maxPixels.value
    }

/**
 * The width of the TextView in px.
 *
 * This value is used for width calculation if LayoutParams does not force TextView to have an exact width. Setting
 * this value overrides previous minimum/maximum width configurations such as [minWidthPx] or [maxWidthPx].
 */
var TextView.widthPx
    get() = PxInt(width)
    set(pixels) {
        width = pixels.value
    }
//endregion

//region Line spacing
/**
 * Sets line spacing for this TextView. Each line other than the last line will have its height multiplied by
 * [multiplier] and have [add] px added to it.
 */
fun TextView.setLineSpacing(add: Px, multiplier: Float) = setLineSpacing(add.value, multiplier)

@get:RequiresApi(16)
val TextView.lineSpacingExtraPx get() = Px(lineSpacingExtra)
//endregion
