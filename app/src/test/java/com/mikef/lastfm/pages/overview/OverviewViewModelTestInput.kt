package com.mikef.lastfm.pages.overview

import com.mikef.lastfm.database.entity.AlbumEntity
import com.mikef.lastfm.pages.overview.adapter.AlbumCollectionDataManager
import com.mikef.lastfm.pages.overview.adapter.OverviewDataManager
import com.mikef.lastfm.shared.adapter.AdapterData
import io.mockk.mockk
import org.junit.jupiter.params.provider.Arguments
import java.util.stream.Stream

@Suppress("unused")
class OverviewViewModelTestInput {

    companion object {

        @JvmStatic
        fun albumClickedInput(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("Cher", "Believe"),
                Arguments.of("Pink Floyd", "The Wall")
            )
        }

        @JvmStatic
        fun albumsInput(): Stream<Arguments> {
            val mockEntity1 = mockk<AlbumEntity>(relaxed = true)
            val mockEntity2 = mockk<AlbumEntity>(relaxed = true)
            val mockEntity3 = mockk<AlbumEntity>(relaxed = true)

            val list1 = listOf(mockEntity1, mockEntity2, mockEntity3)
            val list2 = listOf(mockEntity1, mockEntity3)
            val list3 = emptyList<AlbumEntity>()
            val dataManager = OverviewDataManager(AlbumCollectionDataManager())

            return Stream.of(
                Arguments.of(
                    AlbumsInput(
                        albums = list1,
                        expectedList = dataManager.buildList(list1.map { it.album })
                    ),
                ),
                Arguments.of(
                    AlbumsInput(
                        albums = list2,
                        expectedList = dataManager.buildList(list2.map { it.album })
                    ),
                ),
                Arguments.of(
                    AlbumsInput(
                        albums = list3,
                        expectedList = dataManager.buildList(list3.map { it.album })
                    ),
                )
            )
        }

    }

    data class AlbumsInput(
        val albums: List<AlbumEntity>,
        val expectedList: List<AdapterData<*>>
    )

}