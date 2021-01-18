package me.watsaponk.coroutineplayground.explorelist.data

import me.watsaponk.coroutineplayground.explorelist.domain.ExploreSubject

fun ExploreSubjectEntity.toModel(): ExploreSubject {
    return ExploreSubject(
        title = this.title ?: "",
        description = this.description ?: ""
    )
}