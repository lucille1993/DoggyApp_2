package com.example.DoggoApp.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase




@Database(entities = [DogEntity::class], version = 1)
// Create one database to be accessed by all parts of the app
abstract class AppDatabase: RoomDatabase() {
    abstract fun dogImageDao(): DogDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        public fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}