package com.example.dictionary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.dictionary.data.TranslatedWordDatabase
import com.example.dictionary.model.TranslatedWord
import com.example.dictionary.repository.TranslatedWordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TranslatedWordViewModel(application: Application) : AndroidViewModel(application) {
    val readAllTranslatedWords: LiveData<List<TranslatedWord>>
    private val repository: TranslatedWordRepository

    init {
        val translatedWordDao = TranslatedWordDatabase.getDataBase(application).translatedWordDao()
        repository = TranslatedWordRepository(translatedWordDao)
        readAllTranslatedWords = repository.readAllTranslateWords
    }

    fun addTranslatedWord(translatedWord: TranslatedWord) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTranslatedWord(translatedWord)
        }
    }
}