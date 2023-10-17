package com.example.dictionary.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dictionary.model.TranslatedWord

@Database(entities = [TranslatedWord::class], version = 1, exportSchema = false)
abstract class TranslatedWordDatabase : RoomDatabase() {

    abstract fun translatedWordDao(): TranslatedWordDao

    companion object {
        private var INSTANCE: TranslatedWordDatabase? = null

        fun getDataBase(context: Context): TranslatedWordDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TranslatedWordDatabase::class.java,
                    "translatedWord_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}