package me.watsaponk.coroutineplayground.common

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class AppCoroutineContextProvider : CoroutineContextProvider {

    override val Main: CoroutineContext = Dispatchers.Main

    override val IO: CoroutineContext = Dispatchers.IO

}