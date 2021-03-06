package com.sedsoftware.screens.main.di

import com.sedsoftware.core.di.provider.NavigationProvider
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        NavigationModule::class
    ]
)
@Singleton
interface NavigationComponent : NavigationProvider {

    class Initializer private constructor() {
        companion object {

            fun init(): NavigationProvider {

                return DaggerNavigationComponent.builder()
                    .build()
            }
        }
    }
}
