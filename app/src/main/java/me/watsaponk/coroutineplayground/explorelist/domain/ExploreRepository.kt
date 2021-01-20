package me.watsaponk.coroutineplayground.explorelist.domain

interface ExploreRepository {

    suspend fun getExploreSubjects(): List<ExploreSubject>

}