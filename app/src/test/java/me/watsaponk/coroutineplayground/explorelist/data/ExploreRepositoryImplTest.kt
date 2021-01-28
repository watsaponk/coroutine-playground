package me.watsaponk.coroutineplayground.explorelist.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import me.watsaponk.coroutineplayground.common.TestCoroutineContextProvider
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class ExploreRepositoryImplTest {

    private lateinit var sut: ExploreRepositoryImpl

    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        sut = ExploreRepositoryImpl(TestCoroutineContextProvider(testCoroutineDispatcher))
    }

    @After
    fun tearDown() {
        testCoroutineDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `When get entities success`() = testCoroutineDispatcher.runBlockingTest {
        // GIVEN

        // WHEN
        val entities = sut.getExploreSubjects()

        // THEN
        Assert.assertTrue(entities.isNotEmpty())
        Assert.assertEquals(2, entities.size)
    }

}