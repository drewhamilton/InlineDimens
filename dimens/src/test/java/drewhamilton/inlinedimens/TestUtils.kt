package drewhamilton.inlinedimens

import android.os.Build
import java.lang.reflect.Field
import java.lang.reflect.Modifier

internal fun spoofSdkInt(sdkInt: Int) {
    val sdkIntField = Build.VERSION::class.java.getField("SDK_INT")
    sdkIntField.isAccessible = true

    val sdkIntModifiersField = Field::class.java.getDeclaredField("modifiers")
    sdkIntModifiersField.isAccessible = true
    sdkIntModifiersField.setInt(sdkIntField, sdkIntField.modifiers and Modifier.FINAL.inv())

    sdkIntField.setInt(null, sdkInt)
}
