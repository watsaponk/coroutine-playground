package me.watsaponk.coroutineplayground.explorelist.presentation.extension

import android.view.View

fun View.setVisibility(isDisplay: Boolean) {
    this.visibility = if (isDisplay) {
        View.VISIBLE
    } else {
        View.GONE
    }
}