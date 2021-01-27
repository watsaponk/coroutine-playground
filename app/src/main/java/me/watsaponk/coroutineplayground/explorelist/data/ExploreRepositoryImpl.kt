package me.watsaponk.coroutineplayground.explorelist.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import me.watsaponk.coroutineplayground.common.CoroutineContextProvider
import me.watsaponk.coroutineplayground.explorelist.domain.ExploreRepository
import me.watsaponk.coroutineplayground.explorelist.domain.ExploreSubject

class ExploreRepositoryImpl constructor(private val contextProvider: CoroutineContextProvider) : ExploreRepository {

    override suspend fun getExploreSubjects(): List<ExploreSubject> {
        // TODO watch this https://www.youtube.com/watch?v=YrrUCSi72E8
        return withContext(contextProvider.IO) {
            delay(2_000L)
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