package com.sedsoftware.core.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sedsoftware.core.di.App
import com.sedsoftware.core.di.provider.ApplicationProvider

abstract class BaseActivity : AppCompatActivity() {

    abstract fun inject()
    abstract fun getLayoutId(): Int

    protected val appComponent: ApplicationProvider by lazy(mode = LazyThreadSafetyMode.NONE) {
        (applicationContext as App).getAppComponent()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }
}