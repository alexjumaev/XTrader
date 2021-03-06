package com.sedsoftware.core.presentation.extension

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.lifecycle.ViewModelProviders
import com.sedsoftware.core.utils.extension.orZero

inline fun <reified T : ViewModel> Fragment.viewModel(factory: Factory, body: T.() -> Unit): T {
    val viewModel = ViewModelProviders.of(this, factory)[T::class.java]
    viewModel.body()
    return viewModel
}

fun Fragment.string(@StringRes resId: Int): String =
    context?.string(resId).orEmpty()

fun Fragment.color(@ColorRes colorId: Int) =
    context?.let { ContextCompat.getColor(it, colorId) }.orZero()
