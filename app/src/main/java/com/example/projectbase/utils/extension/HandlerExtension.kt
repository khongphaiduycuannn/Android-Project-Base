package com.example.projectbase.utils.extension

import android.os.Handler
import android.os.Looper

fun Any.delayHandler(durationInMillis: Long, block: () -> Unit) {
    Handler(Looper.getMainLooper())
        .postDelayed({ block.invoke() }, durationInMillis)
}