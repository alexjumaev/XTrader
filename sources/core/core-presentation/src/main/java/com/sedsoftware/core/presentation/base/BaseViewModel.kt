package com.sedsoftware.core.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sedsoftware.core.utils.common.Failure
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    var viewModelFailure: MutableLiveData<Failure> = MutableLiveData()

    private val job: Job = Job()

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    protected fun handleFailure(failure: Failure) {
        this.viewModelFailure.value = failure
    }
}
