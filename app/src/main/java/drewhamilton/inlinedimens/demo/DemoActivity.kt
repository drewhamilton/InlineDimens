package drewhamilton.inlinedimens.demo

import android.os.Bundle
import android.view.Display
import androidx.appcompat.app.AppCompatActivity
import drewhamilton.inlinedimens.view.PxPoint
import drewhamilton.inlinedimens.getRealSize
import drewhamilton.inlinedimens.widget.textSizeDp
import drewhamilton.inlinedimens.widget.textSizePx
import drewhamilton.inlinedimens.widget.textSizeSp
import drewhamilton.inlinedimens.toDp
import drewhamilton.inlinedimens.toDpInt
import drewhamilton.inlinedimens.toPxInt
import drewhamilton.inlinedimens.toSpInt
import kotlinx.android.synthetic.main.demo.screenHeightView
import kotlinx.android.synthetic.main.demo.screenWidthView
import kotlinx.android.synthetic.main.demo.textSizeView

class DemoActivity : AppCompatActivity() {

    // TODO WORKAROUND: Using inline values without explicit Int type declaration causes a lint error
    //  (File a bug for this somewhere)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo)

        val screenSize = windowManager.defaultDisplay.getRealSize()

        val screenWidth = screenSize.x
        val screenWidthPx: Int = screenWidth.value
        val screenWidthDp: Int = screenWidth.toDp().toDpInt().value
        screenWidthView.text = getString(R.string.screenWidth, screenWidthPx, screenWidthDp)

        val screenHeight = screenSize.y
        val screenHeightPx: Int = screenHeight.value
        val screenHeightDp: Int = screenHeight.toDp().toDpInt().value
        screenHeightView.text = getString(R.string.screenHeight, screenHeightPx, screenHeightDp)

        val textSizePx: Int = textSizeView.textSizePx.toPxInt().value
        val textSizeDp: Int = textSizeView.textSizeDp.toDpInt().value
        val textSizeSp: Int = textSizeView.textSizeSp.toSpInt().value
        textSizeView.text = getString(R.string.textSize, textSizePx, textSizeDp, textSizeSp)
    }

    private fun Display.getRealSize(): PxPoint {
        val size = PxPoint()
        getRealSize(size)
        return size
    }
}
