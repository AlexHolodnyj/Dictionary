package com.example.dictionary.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "translatedWord_table")
data class TranslatedWord(
    val value: String,
    val translate: String,
    val isKnown: Boolean,
    val timesRepeated: Int = 0,

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)