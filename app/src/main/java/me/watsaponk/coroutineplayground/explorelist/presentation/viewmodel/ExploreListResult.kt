package me.watsaponk.coroutineplayground.explorelist.presentation.viewmodel

import me.watsaponk.coroutineplayground.explorelist.presentation.model.ExploreSubjectUiModel

sealed class ExploreListResult {

    data class LoadExploreSubjectResult(val subjects: List<ExploreSubjectUiModel>) : ExploreListResult()

}