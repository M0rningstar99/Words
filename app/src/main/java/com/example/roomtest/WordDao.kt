package com.example.roomtest

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface WordDao {
    @Insert
    fun insertWords(vararg  words: Word)

    @Update
    fun updateWords(vararg  words: Word)

    @Delete
    fun delectWords(vararg words:Word)

    @Query("DELETE FROM WORD")
    fun deleteAllWords()

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
    fun getAllWordsLive(): LiveData<List<Word>>


    @Query("SELECT * FROM WORD WHERE english LIKE :patten  ORDER BY ID DESC")
    fun findWordsWithPatten(patten:String): LiveData<List<Word>>

}