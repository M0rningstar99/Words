package com.example.roomtest

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
  class Word {
    //主键
    @PrimaryKey(autoGenerate = true)
      var id:Int = 0
    //属性
    @ColumnInfo(name = "english")
     var word:String = ""
    @ColumnInfo(name = "chinese")
     var Cmean  = ""
    @ColumnInfo(name = "chinese_invisible")
    var invisible  = false



    constructor(word: String, Cmean: String) {
        this.word = word
        this.Cmean = Cmean
    }











}