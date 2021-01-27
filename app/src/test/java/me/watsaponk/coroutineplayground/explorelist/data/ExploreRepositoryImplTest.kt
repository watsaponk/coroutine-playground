package me.watsaponk.coroutineplayground.explorelist.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import me.watsaponk.coroutineplayground.common.TestCoroutineContextProvider
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class ExploreRepositoryImplTest {

    private lateinit var sut: ExploreRepositoryImpl

    private val testCoroutineContextProvider = TestCoroutineContextProvider()

    @Before
    fun setUp() {
        sut = ExploreRepositoryImpl(testCoroutineContextProvider)
    }

    @Test
    fun `When get entities success`() = testCoroutineContextProvider.testCoroutineDispatcher.runBlockingTest {
        // GIVEN

        // WHEN
        val entities = sut.getExploreSubjects()

        // THEN
        Assert.assertTrue(entities.isNotEmpty())
        Assert.assertEquals(2, entities.size)
    }

}