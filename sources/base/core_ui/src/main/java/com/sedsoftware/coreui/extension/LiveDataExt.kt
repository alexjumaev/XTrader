package com.sedsoftware.coreui.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.sedsoftware.coreui.common.LiveDataChannel


fun <T> LiveData<T>.observeChannel(lifecycleOwner: LifecycleOwner): LiveDataChannel<T> {
    val channel = LiveDataChannel(this)
    observe(lifecycleOwner, channel)
    lifecycleOwner.lifecycle.addObserver(channel)
    return channel
}

fun <T> LiveData<T>.observeChannel(): LiveDataChannel<T> {
    val channel = LiveDataChannel(this)
    observeForever(channel)
    return channel
}