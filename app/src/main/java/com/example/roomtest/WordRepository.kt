package com.example.roomtest

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData


class WordRepository(context: Context) {
    private val wordDao: WordDao
    val allWordsList: LiveData<List<Word>>
    var wordDatabase: WordDatabase?

    init {
        wordDatabase = WordDatabase.getDatabase(context.applicationContext)
        wordDao = wordDatabase!!.getWordDao()
        allWordsList = wordDao.getAllWordsLive()
    }


    fun insertWords(vararg words: Word) {
        val insertAsyncTask = InsertAsyncTask()
        insertAsyncTask.wordDao = wordDao
        insertAsyncTask.execute(*words)
    }

    fun deleteWords(vararg words: Word) {
        val deleteAsyncTask = DeleteAsyncTask()
        deleteAsyncTask.wordDao = wordDao
        deleteAsyncTask.execute(*words)
    }

    fun deleteAllWords() {
        val deleteAllAsyncTask = DeleteAllAsyncTask()
        deleteAllAsyncTask.wordDao = wordDao
        deleteAllAsyncTask.execute()
    }

    fun updateWords(vararg words: Word) {
        val updateAsyncTask = UpdateAsyncTask()
        updateAsyncTask.wordDao = wordDao
        updateAsyncTask.execute(*words)
    }

    fun getAllWordsLive(): LiveData<List<Word>> {
        return allWordsList
    }

    fun findWordsWithPatten(patten:String): LiveData<List<Word>>{
        return wordDao.findWordsWithPatten("%"+ patten +"%")
    }


    class InsertAsyncTask : AsyncTask<Word, Void, Void>() {
        lateinit var wordDao: WordDao
        override fun doInBackground(vararg words: Word): Void? {
            wordDao.insertWords(*words)
            return null
        }


    }

    class DeleteAllAsyncTask : AsyncTask<Word, Void, Void>() {
        lateinit var wordDao: WordDao
        override fun doInBackground(vararg words: Word): Void? {
            wordDao.deleteAllWords()
            return null
        }


    }

    class UpdateAsyncTask : AsyncTask<Word, Void, Void>() {
        lateinit var wordDao: WordDao
        override fun doInBackground(vararg words: Word): Void? {
            wordDao.updateWords(*words)
            return null
        }


    }

    class DeleteAsyncTask : AsyncTask<Word, Void, Void>() {
        lateinit var wordDao: WordDao
        override fun doInBackground(vararg words: Word): Void? {
            wordDao.delectWords(*words)
            return null
        }
    }
}