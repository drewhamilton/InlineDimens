@file:JvmName("ResourcesDimens")
package drewhamilton.inlinedimens.content.res

import android.content.res.Resources
import androidx.annotation.DimenRes
import drewhamilton.inlinedimens.Px
import drewhamilton.inlinedimens.PxInt

/**
 * Retrieve a dimensional in px for a particular resource [id]. If the dimen is specified in dp or sp, unit conversions
 * are based on the current display metrics associated with [this] resources.
 *
 * The value 0 is an invalid identifier. [Resources.NotFoundException] is thrown if the given [id] does not exist.
 */
fun Resources.getDimensionPx(@DimenRes id: Int) = Px(getDimension(id))

/**
 * Retrieve a dimensional in px for a particular resource [id] for use as an offset in raw pixels. This is the same as
 * [getDimensionPx], except the returned value is converted to integer pixels for you.  An offset conversion involves
 * simply truncating the base value to an integer.
 *
 * The value 0 is an invalid identifier. [Resources.NotFoundException] is thrown if the given [id] does not exist.
 */
fun Resources.getDimensionPxOffset(@DimenRes id: Int) = PxInt(getDimensionPixelOffset(id))

/**
 * Retrieve a dimensional in px for a particular resource ID for use as a size in raw pixels. This is the same as
 * [getDimensionPx], except the returned value is converted to integer pixels for use as a size.  A size conversion
 * involves rounding the base value, and ensuring that a non-zero base value is at least one pixel in size.
 *
 * The value 0 is an invalid identifier. [Resources.NotFoundException] is thrown if the given [id] does not exist.
 */
fun Resources.getDimensionPxSize(@DimenRes id: Int) = PxInt(getDimensionPixelSize(id))
