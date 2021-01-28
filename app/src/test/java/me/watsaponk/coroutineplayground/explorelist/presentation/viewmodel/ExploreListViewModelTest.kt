package me.watsaponk.coroutineplayground.explorelist.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import me.watsaponk.coroutineplayground.explorelist.domain.ExploreRepository
import me.watsaponk.coroutineplayground.explorelist.domain.ExploreSubject
import me.watsaponk.coroutineplayground.explorelist.presentation.extension.toUiModel
import me.watsaponk.coroutineplayground.explorelist.presentation.model.ExploreSubjectUiModel
import org.junit.Rule
import org.junit.Before
import org.junit.After
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class ExploreListViewModelTest {

    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    @get:Rule
    var rule = InstantTaskExecutorRule()

    private val repository = mockk<ExploreRepository>()

    @InjectMockKs
    private lateinit var viewModel: ExploreListViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testCoroutineDispatcher)
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testCoroutineDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `When load explore subject success`() {
        // GIVEN
        val uiModel = ExploreSubjectUiModel("aa")

        mockkStatic("me.watsaponk.coroutineplayground.explorelist.presentation.extension.ExploreSubjectExtensionKt")
        every { any<ExploreSubject>().toUiModel() } returns uiModel
        coEvery { repository.getExploreSubjects() } returns listOf(ExploreSubject("a", "b"))

        val idleViewState = ExploreListViewState.idle()
        val expectedViewState = idleViewState.copy(
            isLoading = false,
            subjects = listOf(uiModel)
        )

        val spyObserver = spyk<Observer<ExploreListViewState>>()
        viewModel.state().observeForever(spyObserver)

        // WHEN
        viewModel.dispatch(ExploreListAction.LoadExploreSubjectAction)

        // THEN
        val viewStates = mutableListOf<ExploreListViewState>()
        verify { spyObserver.onChanged(capture(viewStates)) }
        coVerify { repository.getExploreSubjects() }

        with(viewStates) {
            assertEquals(idleViewState, get(0))
            assertEquals(expectedViewState, get(1))
        }
    }

    @Test
    fun `When load explore subject second time should do nothing`() {
        // GIVEN
        val uiModel = ExploreSubjectUiModel("aa")

        mockkStatic("me.watsaponk.coroutineplayground.explorelist.presentation.extension.ExploreSubjectExtensionKt")
        every { any<ExploreSubject>().toUiModel() } returns uiModel
        coEvery { repository.getExploreSubjects() } returns listOf(ExploreSubject("a", "b"))

        val idleViewState = ExploreListViewState.idle()
        val expectedViewState = idleViewState.copy(
            isLoading = false,
            subjects = listOf(uiModel)
        )

        val spyObserver = spyk<Observer<ExploreListViewState>>()
        viewModel.state().observeForever(spyObserver)

        // WHEN
        viewModel.dispatch(ExploreListAction.LoadExploreSubjectAction)
        viewModel.dispatch(ExploreListAction.LoadExploreSubjectAction)

        // THEN
        val viewStates = mutableListOf<ExploreListViewState>()
        verify { spyObserver.onChanged(capture(viewStates)) }
        coVerify(exactly = 1) { repository.getExploreSubjects() }

        with(viewStates) {
            assertEquals(2, size)
            assertEquals(idleViewState, get(0))
            assertEquals(expectedViewState, get(1))
        }
    }

}