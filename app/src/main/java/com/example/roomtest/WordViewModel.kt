package com.example.roomtest

import android.app.Application
import android.os.AsyncTask
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class WordViewModel(application: Application) : AndroidViewModel(application) {



    var wordRepository:WordRepository

    init {
        wordRepository = WordRepository(application)
    }



    fun insertWords(vararg words: Word) {
        wordRepository.insertWords(*words)
    }
    fun deleteWords(vararg words: Word) {
        wordRepository.deleteWords(*words)
    }
    fun deleteAllWords() {
        wordRepository.deleteAllWords()
    }
    fun updateWords(vararg words: Word) {
        wordRepository.updateWords(*words)
    }
    fun getAllWordsLive():LiveData<List<Word>>{
        return  wordRepository.getAllWordsLive()
    }







}