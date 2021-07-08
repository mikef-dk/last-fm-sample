package com.mikef.lastfm.pages.overview

import com.google.common.truth.Truth.assertThat
import com.mikef.lastfm.database.dao.AlbumDao
import com.mikef.lastfm.extensions.InstantExecutorExtension
import com.mikef.lastfm.getValueForTest
import com.mikef.lastfm.pages.overview.adapter.AlbumCollectionDataManager
import com.mikef.lastfm.pages.overview.adapter.OverviewDataManager
import com.mikef.lastfm.shared.navigation.NavigationDelegate
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

@ExtendWith(InstantExecutorExtension::class)
class OverviewViewModelTest {

    private val dispatcher = TestCoroutineDispatcher()

    private val albumDao = mockk<AlbumDao>()
    private val navigationDelegate = mockk<NavigationDelegate>(relaxed = true)

    private val viewModel =
        OverviewViewModel(OverviewDataManager(AlbumCollectionDataManager()), albumDao)

    @BeforeEach
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @Nested
    inner class OnViewCreated {

        @ParameterizedTest(name = "Args passed -> input: {0}")
        @MethodSource("com.mikef.lastfm.pages.main.MainViewModelTestInput#albumsInput()")
        fun `ViewState with all saved albums is emitted`(input: OverviewViewModelTestInput.AlbumsInput) {
            coEvery { albumDao.getAlbums() } returns input.albums

            viewModel.onViewCreated()

            assertThat(viewModel.viewState.getValueForTest()).isEqualTo(input.expectedList)
        }

    }

    @Nested
    inner class Navigation {

        @Nested
        inner class OnAlbumClicked {

            @ParameterizedTest(name = "Args passed -> artistName: {0}, albumName: {1}")
            @MethodSource("com.mikef.lastfm.pages.main.MainViewModelTestInput#albumClickedInput()")
            fun `Album info is opened with correct params`(artistName: String, albumName: String) {
                viewModel.onAlbumClicked(navigationDelegate, artistName, albumName)

                verify(exactly = 1) {
                    navigationDelegate.navigateToAlbumInfo(
                        artistName = artistName,
                        albumName = albumName
                    )
                }
            }

        }

        @Nested
        inner class OnSearchClicked {

            @Test
            fun `Search page is opened`() {
                viewModel.onSearchClicked(navigationDelegate)

                verify(exactly = 1) { navigationDelegate.navigateToSearch() }
            }

        }

    }

}