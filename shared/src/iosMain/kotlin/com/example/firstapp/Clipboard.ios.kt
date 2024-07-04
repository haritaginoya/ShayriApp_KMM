package com.example.firstapp
import platform.UIKit.UIPasteboard
import kotlin.coroutines.CoroutineContext

actual fun copyTextToClipboard(text: String, context: Any?) {
    val pasteboard = UIPasteboard.generalPasteboard()
    pasteboard.setString(text)
}