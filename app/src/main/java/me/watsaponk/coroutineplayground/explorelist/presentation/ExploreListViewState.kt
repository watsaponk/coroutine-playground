package me.watsaponk.coroutineplayground.explorelist.presentation

import me.watsaponk.coroutineplayground.explorelist.domain.ExploreSubject

data class ExploreListViewState(val subjects: List<ExploreSubject>) {

    companion object {

        fun idle(): ExploreListViewState {
            return ExploreListViewState(listOf())
        }

    }

}