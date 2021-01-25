package me.watsaponk.coroutineplayground.explorelist.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import me.watsaponk.coroutineplayground.explorelist.domain.ExploreRepository
import me.watsaponk.coroutineplayground.explorelist.domain.ExploreSubject

class ExploreRepositoryImpl : ExploreRepository {

    override suspend fun getExploreSubjects(): List<ExploreSubject> {
        // TODO watch this https://www.youtube.com/watch?v=YrrUCSi72E8
        delay(2_000L)
        return withContext(Dispatchers.IO) {
            getEntities().map { entity ->
                entity.toModel()
            }
        }
    }

    private fun getEntities(): List<ExploreSubjectEntity> {
        return listOf(
            ExploreSubjectEntity(title = "Basic suspend function", null),
            ExploreSubjectEntity(title = "Coroutine Unit Test", null)
        )
    }

}