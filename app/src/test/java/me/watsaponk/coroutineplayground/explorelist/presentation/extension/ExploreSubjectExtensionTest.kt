package me.watsaponk.coroutineplayground.explorelist.presentation.extension

import me.watsaponk.coroutineplayground.explorelist.domain.ExploreSubject
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ExploreSubjectExtensionTest {

    @Test
    fun `When convert ExploreSubject to UiModel`() {
        // GIVEN
        val exploreSubject = ExploreSubject("title", "description")

        // WHEN
        val uiModel = exploreSubject.toUiModel()

        // THEN
        Assert.assertEquals(exploreSubject.title, uiModel.display)
    }

}