package me.watsaponk.coroutineplayground.explorelist.presentation.viewmodel

import me.watsaponk.coroutineplayground.explorelist.presentation.model.ExploreSubjectUiModel

data class ExploreListViewState(
    val subjects: List<ExploreSubjectUiModel>,
    val isLoading: Boolean
) {

    companion object {

        fun idle(): ExploreListViewState {
            return ExploreListViewState(
                subjects = listOf(),
                isLoading = true
            )
        }

    }

}