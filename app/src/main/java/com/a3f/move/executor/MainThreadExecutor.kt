package com.a3f.move.executor

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

class MainThreadExecutor: Executor {

    private val handler = Handler(Looper.getMainLooper())

    override fun execute(p0: Runnable) {
        handler.post(p0)
    }
}