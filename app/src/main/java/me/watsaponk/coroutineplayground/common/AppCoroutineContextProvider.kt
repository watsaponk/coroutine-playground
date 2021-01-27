package me.watsaponk.coroutineplayground.common

import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class AppCoroutineContextProvider @Inject constructor() : CoroutineContextProvider {

    override val Main: CoroutineContext = Dispatchers.Main

    override val IO: CoroutineContext = Dispatchers.IO

}