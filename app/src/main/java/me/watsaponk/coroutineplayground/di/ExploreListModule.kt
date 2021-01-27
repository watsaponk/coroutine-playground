package me.watsaponk.coroutineplayground.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import me.watsaponk.coroutineplayground.explorelist.data.ExploreRepositoryImpl
import me.watsaponk.coroutineplayground.explorelist.domain.ExploreRepository

@InstallIn(ApplicationComponent::class)
@Module
abstract class ExploreListModule {

    @Binds
    abstract fun bindExploreRepository(impl: ExploreRepositoryImpl): ExploreRepository

}