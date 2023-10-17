package com.example.dictionary.repository

import androidx.lifecycle.LiveData
import com.example.dictionary.data.TranslatedWordDao
import com.example.dictionary.model.TranslatedWord

class TranslatedWordRepository(private val translatedWordDao: TranslatedWordDao) {
    val readAllTranslateWords: LiveData<List<TranslatedWord>> =
        translatedWordDao.readALlTranslatedWords()

    suspend fun addTranslatedWord(translatedWord: TranslatedWord) =
        translatedWordDao.addTranslatedWord(translatedWord)
}