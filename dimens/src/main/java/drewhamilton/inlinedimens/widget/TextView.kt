package drewhamilton.inlinedimens.widget

import android.util.TypedValue
import android.widget.TextView
import androidx.core.widget.TextViewCompat
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

//region setAutoSizeTextTypeUniformWithConfiguration
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
    TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(
        this,
        IntArray(presetSizes.size) { index -> presetSizes[index].value },
        TypedValue.COMPLEX_UNIT_PX
    )

/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit within the layout bounds. If
 * at least one value from [presetSizes] is valid then the type of auto-size is set to
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * Throws [IllegalArgumentException] if all of the [presetSizes] are invalid.
 */
fun TextView.setAutoSizeTextTypeUniformWithPresetSizes(presetSizes: Array<DpInt>) =
    TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(
        this,
        IntArray(presetSizes.size) { index -> presetSizes[index].value },
        TypedValue.COMPLEX_UNIT_DIP
    )

/**
 * Specify whether this widget should automatically scale the text to try to perfectly fit within the layout bounds. If
 * at least one value from [presetSizes] is valid then the type of auto-size is set to
 * [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM].
 *
 * Throws [IllegalArgumentException] if all of the [presetSizes] are invalid.
 */
fun TextView.setAutoSizeTextTypeUniformWithPresetSizes(presetSizes: Array<SpInt>) =
    TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(
        this,
        IntArray(presetSizes.size) { index -> presetSizes[index].value },
        TypedValue.COMPLEX_UNIT_SP
    )
//endregion
