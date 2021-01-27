package me.watsaponk.coroutineplayground.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import me.watsaponk.coroutineplayground.common.AppCoroutineContextProvider
import me.watsaponk.coroutineplayground.common.CoroutineContextProvider

@Module
@InstallIn(ApplicationComponent::class)
abstract class ApplicationModule {

    @Binds
    abstract fun bindCoroutineContextProvider(impl: AppCoroutineContextProvider): CoroutineContextProvider

}