package com.ipath.hospitaldevice.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

import java.util.concurrent.Executors

/*
@Database(
    entities = [RecentSearch::class],
    version = 2,
    exportSchema = false
)
@TypeConverters()
abstract class AppDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "feedUp_database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .setQueryCallback({ sqlQuery, bindArgs ->
                }, Executors.newSingleThreadExecutor())
                .build()

    }
    abstract fun recentSearchDao(): RecentSearchDao
}*/
