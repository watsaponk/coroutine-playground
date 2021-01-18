package me.watsaponk.coroutineplayground.explorelist.data

import me.watsaponk.coroutineplayground.explorelist.domain.ExploreRepository
import me.watsaponk.coroutineplayground.explorelist.domain.ExploreSubject

class ExploreRepositoryImpl : ExploreRepository {

    override fun getExploreSubjects(): List<ExploreSubject> {
        Thread.sleep(1_000L)
        return getEntities().map { entity ->
            entity.toModel()
        }
    }

    private fun getEntities(): List<ExploreSubjectEntity> {
        return listOf(
            ExploreSubjectEntity(title = "Basic suspend function", null),
            ExploreSubjectEntity(title = "Coroutine Unit Test", null)
        )
    }

}