package me.watsaponk.coroutineplayground.common

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {

    val Main: CoroutineContext

    val IO: CoroutineContext

}