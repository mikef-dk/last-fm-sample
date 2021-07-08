@file:Suppress("unused")

package com.mikef.lastfm.pages.album

import com.mikef.lastfm.R
import com.mikef.lastfm.network.data.album.Album
import com.mikef.lastfm.repository.RepoResult
import com.mikef.lastfm.repository.album.AlbumRepositoryImpl
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.params.provider.Arguments
import java.net.SocketTimeoutException
import java.util.stream.Stream

class AlbumInfoViewModelTestInput {

    companion object {

        @JvmStatic
        fun repoResultInput(): Stream<Arguments> {
            val mockedAlbum = mockk<Album>(relaxed = true) {
                every { artist } returns "Cher"
                every { name } returns "Believe"
                every { tracks } returns null
            }

            val savedResponse = AlbumRepositoryImpl.AlbumResponse(
                saved = true,
                album = mockedAlbum
            )
            val response = AlbumRepositoryImpl.AlbumResponse(
                saved = false,
                album = mockedAlbum
            )

            return Stream.of(
                Arguments.of(
                    Input(
                        artistName = "Cher",
                        albumName = "Believe",
                        repoResult = RepoResult.Success(response),
                        expectedErrorState = null,
                        expectedSaveState = false,
                        expectedSaveStateAfterAction = true,
                        expectedInvocationsSave = 1,
                        expectedInvocationsDelete = 0,
                        expectedViewState = AlbumInfoViewModel.ViewState(
                            albumName = "Believe",
                            artistName = "Cher",
                            albumCoverUrl = null,
                            listData = emptyList()
                        )
                    )
                ),
                Arguments.of(
                    Input(
                        artistName = "Cher",
                        albumName = "Believe",
                        repoResult = RepoResult.Success(savedResponse),
                        expectedErrorState = null,
                        expectedSaveState = true,
                        expectedSaveStateAfterAction = false,
                        expectedInvocationsSave = 0,
                        expectedInvocationsDelete = 1,
                        expectedViewState = AlbumInfoViewModel.ViewState(
                            albumName = "Believe",
                            artistName = "Cher",
                            albumCoverUrl = null,
                            listData = emptyList()
                        )
                    )
                ),
                Arguments.of(
                    Input(
                        artistName = "Cher",
                        albumName = "Believe",
                        repoResult = RepoResult.Failure(SocketTimeoutException()),
                        expectedErrorState = R.string.default_error,
                        expectedSaveState = null,
                        expectedInvocationsSave = 0,
                        expectedInvocationsDelete = 0,
                        expectedSaveStateAfterAction = null,
                        expectedViewState = null
                    )
                )
            )
        }

    }

    data class Input(
        val artistName: String,
        val albumName: String,
        val repoResult: RepoResult<AlbumRepositoryImpl.AlbumResponse>,
        val expectedSaveState: Boolean?,
        val expectedInvocationsSave: Int,
        val expectedInvocationsDelete: Int,
        val expectedSaveStateAfterAction: Boolean?,
        val expectedViewState: AlbumInfoViewModel.ViewState?,
        val expectedErrorState: Int?
    )

}