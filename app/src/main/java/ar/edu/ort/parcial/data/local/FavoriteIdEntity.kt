package ar.edu.ort.parcial.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteIdEntity(
    @PrimaryKey val id: String
)
