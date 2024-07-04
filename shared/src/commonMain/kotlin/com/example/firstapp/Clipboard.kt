package com.example.firstapp

import kotlin.coroutines.CoroutineContext

expect fun copyTextToClipboard(text: String, context: Any? = null)