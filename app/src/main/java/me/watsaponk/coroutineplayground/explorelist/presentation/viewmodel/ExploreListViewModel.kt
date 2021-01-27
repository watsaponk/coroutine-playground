package me.watsaponk.coroutineplayground.explorelist.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.watsaponk.coroutineplayground.explorelist.domain.ExploreRepository
import me.watsaponk.coroutineplayground.explorelist.presentation.extension.toUiModel

class ExploreListViewModel @ViewModelInject constructor(private var repository: ExploreRepository) : ViewModel() {

    private var currentState = ExploreListViewState.idle()

    private val exploreSubjectsLiveData = MutableLiveData<ExploreListViewState>().apply {
        postValue(currentState)
    }

    private var isInitialized = false

    fun state(): LiveData<ExploreListViewState> {
        return exploreSubjectsLiveData
    }

    fun dispatch(action: ExploreListAction) {
        viewModelScope.launch {
            if (action is ExploreListAction.LoadExploreSubjectAction) {
                if (!isInitialized) {
                    isInitialized = true
                    val result = repository.getExploreSubjects().map { exploreSubject ->
                        exploreSubject.toUiModel()
                    }
                    reducer(ExploreListResult.LoadExploreSubjectResult(result))
                }
            }
        }
    }

    private fun reducer(result: ExploreListResult) {
        if (result is ExploreListResult.LoadExploreSubjectResult) {
            currentState = currentState.copy(
                subjects = result.subjects,
                isLoading = false
            )
            exploreSubjectsLiveData.postValue(currentState)
        }
    }

}