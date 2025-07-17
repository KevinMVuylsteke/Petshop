package ar.edu.ort.parcial.data.local

import androidx.room.*

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorites WHERE id = :id LIMIT 1")
    suspend fun getById(id: String): FavoriteIdEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorite: FavoriteIdEntity)

    @Delete
    suspend fun delete(favorite: FavoriteIdEntity)
}