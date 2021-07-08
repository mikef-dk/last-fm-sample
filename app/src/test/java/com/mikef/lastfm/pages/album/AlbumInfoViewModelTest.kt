package com.mikef.lastfm.pages.album

import com.google.common.truth.Truth.assertThat
import com.mikef.lastfm.extensions.InstantExecutorExtension
import com.mikef.lastfm.getValueForTest
import com.mikef.lastfm.pages.album.adapter.AlbumInfoDataManager
import com.mikef.lastfm.repository.album.AlbumRepository
import com.mikef.lastfm.shared.navigation.NavigationDelegate
import io.mockk.coEvery
import io.mockk.coVerify
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
class AlbumInfoViewModelTest {

    private val dispatcher = TestCoroutineDispatcher()

    private val albumRepository = mockk<AlbumRepository>(relaxed = true)
    private val dataManager = AlbumInfoDataManager()
    private val navigationDelegate = mockk<NavigationDelegate>(relaxed = true)

    private val viewModel = AlbumInfoViewModel(albumRepository, dataManager)

    @BeforeEach
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @Nested
    inner class OnViewCreated {

        @ParameterizedTest(name = "Args passed -> input: {0}")
        @MethodSource("com.mikef.lastfm.pages.album.AlbumInfoViewModelTestInput#repoResultInput()")
        fun `Information is requested with correct parameters`(input: AlbumInfoViewModelTestInput.Input) {
            viewModel.onViewCreated(
                AlbumInfoFragmentArgs(
                    artistName = input.artistName,
                    albumName = input.albumName
                )
            )

            coVerify { albumRepository.getAlbumInfo(input.artistName, input.albumName) }
        }

        @ParameterizedTest(name = "Args passed -> input: {0}")
        @MethodSource("com.mikef.lastfm.pages.album.AlbumInfoViewModelTestInput#repoResultInput()")
        fun `Correct state is pushed depending on Repository result`(input: AlbumInfoViewModelTestInput.Input) {
            coEvery { albumRepository.getAlbumInfo(any(), any()) } returns input.repoResult

            viewModel.onViewCreated(
                AlbumInfoFragmentArgs(
                    artistName = input.artistName,
                    albumName = input.albumName
                )
            )

            assertThat(viewModel.savedState.getValueForTest()).isEqualTo(input.expectedSaveState)
            assertThat(viewModel.viewState.getValueForTest()).isEqualTo(input.expectedViewState)
            assertThat(viewModel.error.getValueForTest()).isEqualTo(input.expectedErrorState)
        }

    }

    @Nested
    inner class OnAlbumSavedClicked {

        @ParameterizedTest(name = "Args passed -> input: {0}")
        @MethodSource("com.mikef.lastfm.pages.album.AlbumInfoViewModelTestInput#repoResultInput()")
        fun `Updated saved state is emitted after toggling`(input: AlbumInfoViewModelTestInput.Input) {
            coEvery { albumRepository.getAlbumInfo(any(), any()) } returns input.repoResult

            viewModel.onViewCreated(
                AlbumInfoFragmentArgs(
                    artistName = input.artistName,
                    albumName = input.albumName
                )
            )
            viewModel.onAlbumSavedClicked()

            assertThat(viewModel.savedState.getValueForTest()).isEqualTo(input.expectedSaveStateAfterAction)
        }

        @ParameterizedTest(name = "Args passed -> input: {0}")
        @MethodSource("com.mikef.lastfm.pages.album.AlbumInfoViewModelTestInput#repoResultInput()")
        fun `Album is either saved or deleted depending on saved state`(input: AlbumInfoViewModelTestInput.Input) {
            coEvery { albumRepository.getAlbumInfo(any(), any()) } returns input.repoResult

            viewModel.onViewCreated(
                AlbumInfoFragmentArgs(
                    artistName = input.artistName,
                    albumName = input.albumName
                )
            )
            viewModel.onAlbumSavedClicked()

            coVerify(exactly = input.expectedInvocationsDelete) { albumRepository.deleteAlbum(any()) }
            coVerify(exactly = input.expectedInvocationsSave) { albumRepository.saveAlbum(any()) }
        }

    }

    @Nested
    inner class OnBackClicked {

        @Test
        fun `Previous view is shown`() {
            viewModel.onBackClicked(navigationDelegate)

            verify(exactly = 1) { navigationDelegate.goBack() }
        }

    }

}