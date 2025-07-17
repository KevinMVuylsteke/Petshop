package ar.edu.ort.parcial.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteIdEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}
