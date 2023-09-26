package pe.edu.logincompose.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CharacterEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao

    companion object {
        fun getInstance(context: Context): AppDatabase {
            val db = Room.databaseBuilder(context, AppDatabase::class.java, "rickmorty_db")
                .allowMainThreadQueries().build()
            return db
        }
    }
}