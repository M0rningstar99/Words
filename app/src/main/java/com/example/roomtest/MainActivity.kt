package com.example.roomtest

import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.RoomDatabase

class MainActivity : AppCompatActivity() {

//
//    lateinit var textView: TextView
//    lateinit var button: Button
//    lateinit var button2: Button
//    lateinit var button3: Button
//    lateinit var button4: Button
//
//    lateinit var wordViewModel: WordViewModel
//    lateinit var recyclerView: RecyclerView
//    lateinit var myAdapter1: MyAdapter
//    lateinit var myAdapter2: MyAdapter
//    lateinit var aSwitch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        recyclerView = findViewById(R.id.recycler)
//        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)
//        myAdapter1  = MyAdapter(false,wordViewModel)
//        myAdapter2  = MyAdapter(true,wordViewModel)
//        recyclerView.setLayoutManager(LinearLayoutManager(this))
//        recyclerView.setAdapter(myAdapter1)
//        aSwitch = findViewById(R.id.switch1)
//
//        aSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
//            if (isChecked) {
//                recyclerView.adapter = myAdapter2
//            } else {
//                recyclerView.adapter = myAdapter1
//            }
//        }
//
//
////        updateView()
//        wordViewModel.getAllWordsLive().observe(this, Observer<List<Word>> { words ->
//            var temp = myAdapter1.itemCount
//            myAdapter1.allWords = words
//            myAdapter2.allWords = words
//            if (temp != words.size) {
//                myAdapter1.notifyDataSetChanged()
//                myAdapter2.notifyDataSetChanged()
//            }
//        })
//
////        textView = findViewById(R.id.textView)
//        button = findViewById(R.id.button)
////        button2 = findViewById(R.id.button2)
//        button3 = findViewById(R.id.button3)
////        button4 = findViewById(R.id.button4)
//
//        button3.setOnClickListener {
//            wordViewModel.deleteAllWords()
////            wordDao.deleteAllWords()
////            updateView()
//        }
////        button2.setOnClickListener {
////            var word = Word("hi", "你好呀")
////            word.id = 20
////            wordViewModel.updateWords(word)
//////            wordDao.updateWords(word)
//////            updateView()
////        }
//
////        button4.setOnClickListener {
////            var word = Word("hi", "你好呀")
////            word.id = 60
////            wordViewModel.deleteWords(word)
//////            wordDao.delectWords(word)
//////            updateView()
////        }
//
//        button.setOnClickListener {
//            var english = arrayOf(
//                "hello",
//                "world",
//                "android",
//                "google",
//                "studio",
//                "project",
//                "database",
//                "recycler",
//                "view",
//                "String",
//                "value",
//                "integer"
//            )
//            var chinese = arrayOf(
//                "你好",
//                "世界",
//                "安卓",
//                "谷歌",
//                "工作室",
//                "项目",
//                "数据库",
//                "回收站",
//                "试图",
//                "字符串",
//                "价值",
//                "整数"
//
//            )
//            for(i in 0..<english.size){
//                wordViewModel.insertWords(Word(english[i],chinese[i]))
//            }
////            wordViewModel.insertWords(word1, word2)
////            wordDao.insertWords(word1, word2)
//
////            updateView()
//
//
//        }
//    }
//
//    //    fun updateView(){
////        var list = wordDao.getAllWords()
////        var text = ""
////        for(i in 0..<list.size){
////            var word = list.get(i)
////            text += word.id.toString()+ ":" + word.word + "= " + word.Cmean
////        }
////        textView = findViewById(R.id.textView)
////        textView.setText(text)
////    }
//
    }
}