package com.example.DoggoApp.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "DogImages")
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "image_url")
    val imageUrl: String) {
}