@file:JvmName("DisplayDimens")
package drewhamilton.inlinedimens.view

import android.view.Display
import androidx.annotation.RequiresApi
import drewhamilton.inlinedimens.PxInt
import drewhamilton.inlinedimens.graphics.PxPoint
import drewhamilton.inlinedimens.graphics.PxRect

/**
 * Fills [outSize] with the size of the display in [PxInt]. Value returned by this method does not necessarily represent
 * the actual raw size (native resolution) of the display.
 *
 * 1. The returned size may be adjusted to exclude certain system decor elements that are always visible.
 * 2. It may be scaled to provide compatibility with older applications that were originally designed for smaller
 *    displays.
 * 3. It can be different depending on the WindowManager to which the display belongs.
 *
 * - If requested from non-Activity context (e.g. Application context via
 * {@code (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE)}) it will report the size of
 * the entire display based on current rotation and with subtracted system decoration areas.
 * - If requested from activity (either using {@code getWindowManager()} or
 * {@code (WindowManager) getSystemService(Context.WINDOW_SERVICE)}) resulting size will correspond to current app
 * window size. In this case it can be smaller than physical size in multi-window mode.
 *
 * Typically for the purposes of layout apps should make a request from activity context to obtain size available for
 * the app content.
 */
fun Display.getSize(outSize: PxPoint) =
    getSize(outSize.point)

/**
 * Fills [outSize] with the size of the display as a rectangle, in [PxInt].
 */
fun Display.getRectSize(outSize: PxRect) =
    getRectSize(outSize.rect)

/**
 * Return the range of display sizes an application can expect to encounter under normal operation, as long as there is
 * no physical change in screen size. This is basically the sizes you will see as the orientation changes, taking into
 * account whatever screen decoration there is in each rotation. For example, the status bar is always at the top of the
 * screen, so it will reduce the height both in landscape and portrait, and the smallest height returned here will be
 * the smaller of the two.
 *
 * This is intended for applications to get an idea of the range of sizes they will encounter while going through device
 * rotations, to provide a stable UI through rotation. The sizes here take into account all standard system decorations
 * that reduce the size actually available to the application: the status bar, navigation bar, system bar, etc. It does
 * *not* take into account more transient elements like an IME soft keyboard.
 *
 * [outSmallestSize] is filled in with the smallest width and height that the application will encounter, in [PxInt].
 * The x (width) dimension here directly corresponds to [android.content.res.Configuration.smallestScreenWidthDp],
 * except the value here is in raw screen pixels rather than dp units. Your application may of course still get smaller
 * space yet if, for example, a soft keyboard is being displayed.
 * [outLargestSize] is filled in with the largest width and height that the application will encounter, in [PxInt]. Your
 * application may of course still get larger space than this if, for example, screen decorations like the status bar
 * are being hidden.
 */
@RequiresApi(16)
fun Display.getCurrentSizeRange(outSmallestSize: PxPoint, outLargestSize: PxPoint) =
    getCurrentSizeRange(outSmallestSize.point, outLargestSize.point)

/**
 * Fills [outSize] with the real size of the display in [PxInt] without subtracting any window decor or applying any
 * compatibility scale factors.
 *
 * The size is adjusted based on the current rotation of the display.
 *
 * The real size may be smaller than the physical size of the screen when the
 * window manager is emulating a smaller display (using adb shell wm size).
 */
@RequiresApi(17)
fun Display.getRealSize(outSize: PxPoint) {
    getRealSize(outSize.point)
}
