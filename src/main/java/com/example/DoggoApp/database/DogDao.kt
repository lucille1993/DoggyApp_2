package com.example.DoggoApp.database
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface DogDao {

    @Query("SELECT * FROM DogImages")
    fun getAllDogImages(): Flow<List<DogEntity>>

    @Query("SELECT * FROM DogImages ORDER BY id DESC LIMIT 1")
    fun getMostRecentlyAddDog() : DogEntity

    @Query("DELETE from DogImages where id=(select max(id)-1 from DogImages)")
    suspend fun deleteDog()

    @Insert
    suspend fun addDogImage(dogEntity: DogEntity)

}