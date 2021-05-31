package dev.drewhamilton.inlinedimens.demo

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.Display
import androidx.appcompat.app.AppCompatActivity
import dev.drewhamilton.inlinedimens.demo.databinding.DemoBinding
import dev.drewhamilton.inlinedimens.graphics.PxPoint
import dev.drewhamilton.inlinedimens.toDp
import dev.drewhamilton.inlinedimens.view.getRealSize
import dev.drewhamilton.inlinedimens.widget.textSizeDp
import dev.drewhamilton.inlinedimens.widget.textSizePx
import dev.drewhamilton.inlinedimens.widget.textSizeSp

class DemoActivity : AppCompatActivity() {

    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val screenSize = displayCompat.getRealSize()

        val screenWidth = screenSize.x
        binding.screenWidthView.text = getString(R.string.screenWidth, screenWidth, screenWidth.toDp())

        val screenHeight = screenSize.y
        binding.screenHeightView.text = getString(R.string.screenHeight, screenHeight, screenHeight.toDp())

        with(binding.textSizeView) {
            text = getString(R.string.textSize, textSizePx, textSizeDp, textSizeSp)
        }
    }

    private val displayCompat: Display?
        get() = if (Build.VERSION.SDK_INT >= 30) display else @Suppress("DEPRECATION") windowManager?.defaultDisplay


    private fun Display?.getRealSize(): PxPoint {
        val size = PxPoint()
        this?.getRealSize(size)
        return size
    }
}
