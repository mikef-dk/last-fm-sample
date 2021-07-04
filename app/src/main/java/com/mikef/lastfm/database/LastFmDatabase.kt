package com.mikef.lastfm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mikef.lastfm.database.converter.Converters
import com.mikef.lastfm.database.dao.AlbumDao
import com.mikef.lastfm.database.entity.AlbumEntity

@Database(
    entities = [AlbumEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class LastFmDatabase : RoomDatabase() {

    abstract fun albumDao(): AlbumDao

    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        @Volatile
        private var INSTANCE: LastFmDatabase? = null

        fun getInstance(context: Context): LastFmDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                LastFmDatabase::class.java,
                "last_fm_database"
            )
                .fallbackToDestructiveMigration()
                .build()
    }

}