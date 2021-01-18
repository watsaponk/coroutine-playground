package me.watsaponk.coroutineplayground.explorelist.domain

interface ExploreRepository {

    fun getExploreSubjects(): List<ExploreSubject>

}