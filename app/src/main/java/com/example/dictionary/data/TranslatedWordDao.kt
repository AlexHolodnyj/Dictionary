package com.example.dictionary.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dictionary.model.TranslatedWord

@Dao
interface TranslatedWordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTranslatedWord(translatedWord: TranslatedWord)

    @Query(value = "SELECT * FROM translatedWord_table ORDER BY id ASC")
    fun readALlTranslatedWords(): LiveData<List<TranslatedWord>>
}