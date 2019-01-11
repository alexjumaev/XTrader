package com.sedsoftware.screens.main

import androidx.navigation.Navigation
import com.sedsoftware.core.di.holder.ActivityToolsHolder
import com.sedsoftware.core.di.provider.MainActivityToolsProvider
import com.sedsoftware.core.navigation.NavControllerHolder
import com.sedsoftware.core.presentation.base.BaseActivity
import com.sedsoftware.screens.main.di.MainActivityComponent
import javax.inject.Inject

class MainActivity : BaseActivity(), ActivityToolsHolder {

    @Inject
    lateinit var navControllerHolder: NavControllerHolder

    private val mainActivityComponent: MainActivityComponent by lazy {
        MainActivityComponent.Initializer.init(appComponent)
    }

    override val layoutResId: Int
        get() = R.layout.activity_main

    override fun inject() {
        mainActivityComponent.inject(this)
    }

    override fun getActivityToolsProvider(): MainActivityToolsProvider =
        mainActivityComponent

    override fun onPause() {
        navControllerHolder.removeNavController()
        super.onPause()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        val controller = Navigation.findNavController(this, R.id.nav_controller_main)
        navControllerHolder.setNavController(controller)
    }
}
