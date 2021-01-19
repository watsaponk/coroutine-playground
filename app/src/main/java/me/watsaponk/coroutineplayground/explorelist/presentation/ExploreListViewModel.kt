package me.watsaponk.coroutineplayground.explorelist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.watsaponk.coroutineplayground.explorelist.data.ExploreRepositoryImpl
import me.watsaponk.coroutineplayground.explorelist.domain.ExploreSubject

class ExploreListViewModel : ViewModel() {

    private val repository by lazy {
        ExploreRepositoryImpl()
    }

    private var currentState = ExploreListViewState.idle()

    private val exploreSubjectsLiveData = MutableLiveData<ExploreListViewState>().apply {
        postValue(currentState)
    }

    private var isInitialized = false

    fun state(): LiveData<ExploreListViewState> {
        return exploreSubjectsLiveData
    }

    fun dispatch(action: ExploreListAction) {
        if (action is ExploreListAction.InitialAction) {
            if(!isInitialized){
                isInitialized = true
                reducer(repository.getExploreSubjects())
            }
        }
    }

    private fun reducer(subjects: List<ExploreSubject>) {
        currentState = currentState.copy(
            subjects = subjects
        )
        exploreSubjectsLiveData.postValue(currentState)
    }

}