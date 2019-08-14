@file:JvmName("TextViewDimens")
package drewhamilton.inlinedimens.widget

import android.util.TypedValue
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import drewhamilton.inlinedimens.DimenInt
import drewhamilton.inlinedimens.Dp
import drewhamilton.inlinedimens.DpInt
import drewhamilton.inlinedimens.Px
import drewhamilton.inlinedimens.PxInt
import drewhamilton.inlinedimens.Sp
import drewhamilton.inlinedimens.SpInt
import drewhamilton.inlinedimens.toDp
import drewhamilton.inlinedimens.toSp

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
    get() = textSizePx.toDp(context)
    set(size) {
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, size.value)
    }

/**
 * The size in sp of the default text size of this [TextView].
 *
 * Note: if this TextView has the auto-size feature enabled than setting this value is no-op.
 */
var TextView.textSizeSp: Sp
    get() = textSizePx.toSp(context)
    set(size) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, size.value)
    }
//endregion

//region setAutoSizeTextTypeUniformWithConfiguration
/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit within the layout bounds. If
 * [minSize], [maxSize], and [stepGranularity] are valid the type of auto-size is set to
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * Throws [IllegalArgumentException] if any of the configuration params are invalid.
 */
fun TextView.setAutoSizeTextTypeUniformWithConfiguration(minSize: PxInt, maxSize: PxInt, stepGranularity: PxInt) =
    setAutoSizeTextTypeUniformWithConfiguration(minSize, maxSize, stepGranularity, TypedValue.COMPLEX_UNIT_PX)

/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit within the layout bounds. If
 * [minSize], [maxSize], and [stepGranularity] are valid the type of auto-size is set to
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * Throws [IllegalArgumentException] if any of the configuration params are invalid.
 */
fun TextView.setAutoSizeTextTypeUniformWithConfiguration(minSize: DpInt, maxSize: DpInt, stepGranularity: DpInt) =
    setAutoSizeTextTypeUniformWithConfiguration(minSize, maxSize, stepGranularity, TypedValue.COMPLEX_UNIT_DIP)

/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit within the layout bounds. If
 * [minSize], [maxSize], and [stepGranularity] are valid the type of auto-size is set to
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * Throws [IllegalArgumentException] if any of the configuration params are invalid.
 */
fun TextView.setAutoSizeTextTypeUniformWithConfiguration(minSize: SpInt, maxSize: SpInt, stepGranularity: SpInt) =
    setAutoSizeTextTypeUniformWithConfiguration(minSize, maxSize, stepGranularity, TypedValue.COMPLEX_UNIT_SP)

private fun TextView.setAutoSizeTextTypeUniformWithConfiguration(
    minSize: DimenInt,
    maxSize: DimenInt,
    stepGranularity: DimenInt,
    unit: Int
) = TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
    this,
    minSize.value, maxSize.value,
    stepGranularity.value,
    unit
)
//endregion

//region setAutoSizeTextTypeUniformWithPresetSizes
/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit within the layout bounds. If
 * at least one value from [presetSizes] is valid then the type of auto-size is set to
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * Throws [IllegalArgumentException] if all of the [presetSizes] are invalid.
 */
fun TextView.setAutoSizeTextTypeUniformWithPresetSizes(presetSizes: Array<PxInt>) =
    setAutoSizeTextTypeUniformWithPresetSizes(presetSizes, TypedValue.COMPLEX_UNIT_PX)

/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit within the layout bounds. If
 * at least one value from [presetSizes] is valid then the type of auto-size is set to
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * Throws [IllegalArgumentException] if all of the [presetSizes] are invalid.
 */
fun TextView.setAutoSizeTextTypeUniformWithPresetSizes(presetSizes: Array<DpInt>) =
    setAutoSizeTextTypeUniformWithPresetSizes(presetSizes, TypedValue.COMPLEX_UNIT_DIP)

/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit within the layout bounds. If
 * at least one value from [presetSizes] is valid then the type of auto-size is set to
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * Throws [IllegalArgumentException] if all of the [presetSizes] are invalid.
 */
fun TextView.setAutoSizeTextTypeUniformWithPresetSizes(presetSizes: Array<SpInt>) =
    setAutoSizeTextTypeUniformWithPresetSizes(presetSizes, TypedValue.COMPLEX_UNIT_SP)

private fun TextView.setAutoSizeTextTypeUniformWithPresetSizes(presetSizes: Array<out DimenInt>, unit: Int) =
    TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(this, presetSizes.values(), unit)

private fun Array<out DimenInt>.values() = IntArray(size) { index -> this[index].value }
//endregion
