package drewhamilton.inlinedimens.demo

import android.os.Bundle
import android.view.Display
import androidx.appcompat.app.AppCompatActivity
import drewhamilton.inlinedimens.PxPoint
import drewhamilton.inlinedimens.getRealSize
import drewhamilton.inlinedimens.textSizeDp
import drewhamilton.inlinedimens.textSizePx
import drewhamilton.inlinedimens.textSizeSp
import drewhamilton.inlinedimens.toDp
import drewhamilton.inlinedimens.toDpInt
import drewhamilton.inlinedimens.toPxInt
import drewhamilton.inlinedimens.toSpInt
import kotlinx.android.synthetic.main.demo.screenHeightView
import kotlinx.android.synthetic.main.demo.screenWidthView
import kotlinx.android.synthetic.main.demo.textSizeView

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo)

        val screenSize = windowManager.defaultDisplay.getRealSize()

        val screenWidth = screenSize.x
        screenWidthView.text = getString(
            R.string.screenWidth,
            screenWidth.value, screenWidth.toDp(this).toDpInt().value
        )

        val screenHeight = screenSize.y
        screenHeightView.text = getString(
            R.string.screenHeight,
            screenHeight.value, screenHeight.toDp(this).toDpInt().value
        )

        textSizeView.text = getString(
            R.string.textSize,
            textSizeView.textSizePx.toPxInt().value,
            textSizeView.textSizeDp.toDpInt().value,
            textSizeView.textSizeSp.toSpInt().value
        )
    }

    private fun Display.getRealSize(): PxPoint {
        val size = PxPoint()
        getRealSize(size)
        return size
    }
}
