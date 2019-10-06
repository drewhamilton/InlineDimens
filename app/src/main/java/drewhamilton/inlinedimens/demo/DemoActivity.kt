package drewhamilton.inlinedimens.demo

import android.os.Bundle
import android.view.Display
import androidx.appcompat.app.AppCompatActivity
import drewhamilton.inlinedimens.demo.databinding.DemoBinding
import drewhamilton.inlinedimens.graphics.PxPoint
import drewhamilton.inlinedimens.toDp
import drewhamilton.inlinedimens.toDpInt
import drewhamilton.inlinedimens.toPxInt
import drewhamilton.inlinedimens.toSpInt
import drewhamilton.inlinedimens.view.getRealSize
import drewhamilton.inlinedimens.widget.textSizeDp
import drewhamilton.inlinedimens.widget.textSizePx
import drewhamilton.inlinedimens.widget.textSizeSp

class DemoActivity : AppCompatActivity() {

    private lateinit var binding: DemoBinding

    // TODO WORKAROUND: Using inline values without explicit Int type declaration causes a lint error
    //  (File a bug for this somewhere)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val screenSize = windowManager.defaultDisplay.getRealSize()

        val screenWidth = screenSize.x
        val screenWidthPx: Int = screenWidth.value
        val screenWidthDp: Int = screenWidth.toDp().toDpInt().value
        binding.screenWidthView.text = getString(R.string.screenWidth, screenWidthPx, screenWidthDp)

        val screenHeight = screenSize.y
        val screenHeightPx: Int = screenHeight.value
        val screenHeightDp: Int = screenHeight.toDp().toDpInt().value
        binding.screenHeightView.text = getString(R.string.screenHeight, screenHeightPx, screenHeightDp)

        val textSizePx: Int = binding.textSizeView.textSizePx.toPxInt().value
        val textSizeDp: Int = binding.textSizeView.textSizeDp.toDpInt().value
        val textSizeSp: Int = binding.textSizeView.textSizeSp.toSpInt().value
        binding.textSizeView.text = getString(R.string.textSize, textSizePx, textSizeDp, textSizeSp)
    }

    private fun Display.getRealSize(): PxPoint {
        val size = PxPoint()
        getRealSize(size)
        return size
    }
}
