package pe.edu.logincompose.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CharacterDao {
    @Insert
    fun save(character: CharacterEntity)

    @Query("select * from characters where id=:id")
    fun getById(id: Int): CharacterEntity?

    @Delete
    fun delete(character: CharacterEntity)

    @Query("select * from characters")
    fun getAll(): List<CharacterEntity>
}