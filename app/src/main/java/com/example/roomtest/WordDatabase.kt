package com.example.roomtest

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


//singleton
@Database(entities = [Word::class], version = 4, exportSchema = false)
abstract  class WordDatabase  : RoomDatabase() {
    companion object {
        private  var INSTANCE: WordDatabase? = null
        val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE word ADD COLUMN temp_data INTEGER NOT NULL DEFAULT 1")
            }
        }

        val migration_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE word_temp (id INTEGER PRIMARY KEY NOT NULL ,english TEXT NOT NULL,"+
                "chinese TEXT NOT NULL)")
                database.execSQL("INSERT INTO word_temp (id,english,chinese) SELECT id,english,chinese FROM word")
                database.execSQL("DROP TABLE Word")
                database.execSQL("ALTER TABLE word_temp RENAME to word")
            }
        }
        val migration_3_4 = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE word ADD COLUMN chinese_invisible INTEGER NOT NULL DEFAULT 0")
            }
        }


        @Synchronized
        fun getDatabase(context: Context): WordDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    WordDatabase::class.java,
                    "word_database"
                )
//                .allowMainThreadQueries()
                    .addMigrations(migration_3_4)
                    .build()
            }
            return INSTANCE
        }


    }

    abstract fun getWordDao(): WordDao

}


