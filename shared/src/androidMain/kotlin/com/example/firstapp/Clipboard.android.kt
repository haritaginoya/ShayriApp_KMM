package com.example.firstapp
import android.R.attr
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Log

actual fun copyTextToClipboard(text: String,context: Any?) {
    Log.d("=======", "copyTextToClipboard: $text")
    val androidContext = context as? Context?: return

    val clipboard = androidContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("Hdshhfgfhs", text)
    clipboard.setPrimaryClip(clip)


}
