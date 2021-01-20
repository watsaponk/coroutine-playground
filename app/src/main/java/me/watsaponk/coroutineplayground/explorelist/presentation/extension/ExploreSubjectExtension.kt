package me.watsaponk.coroutineplayground.explorelist.presentation.extension

import me.watsaponk.coroutineplayground.explorelist.domain.ExploreSubject
import me.watsaponk.coroutineplayground.explorelist.presentation.model.ExploreSubjectUiModel

fun ExploreSubject.toUiModel(): ExploreSubjectUiModel {
    return ExploreSubjectUiModel(this.title)
}