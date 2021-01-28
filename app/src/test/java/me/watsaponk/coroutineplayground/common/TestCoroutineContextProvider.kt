package me.watsaponk.coroutineplayground.common

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi
class TestCoroutineContextProvider(testCoroutineDispatcher: TestCoroutineDispatcher) : CoroutineContextProvider {

    override val Main: CoroutineContext = testCoroutineDispatcher

    override val IO: CoroutineContext = testCoroutineDispatcher

}