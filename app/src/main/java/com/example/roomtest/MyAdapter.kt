package com.example.roomtest

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val number: TextView = itemView.findViewById(R.id.textView)
    val english: TextView = itemView.findViewById(R.id.textView2)
    val chinese: TextView = itemView.findViewById(R.id.textView3)
    val switch: Switch = itemView.findViewById(R.id.switch2)
}


class MyAdapter : RecyclerView.Adapter<MyViewHolder> {
    var useCardView: Boolean = false
    var wordViewModel: WordViewModel
    var allWords: List<Word> = ArrayList<Word>()


    constructor(useCardView: Boolean, wordViewModel: WordViewModel) {
        this.useCardView = useCardView
        this.wordViewModel = wordViewModel
    }

    fun setAllWords1(allWords: List<Word>): Unit {
        this.allWords = allWords
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)

        val itemView = if (useCardView) {
            layoutInflater.inflate(R.layout.cell_card_2, parent, false)
        } else {
            layoutInflater.inflate(R.layout.cell_normal_2, parent, false)
        }
        val holder = MyViewHolder(itemView)
//        holder.itemView.setOnClickListener {
//            var uri = Uri.parse("https://m.youdao.com/dict?le=eng&q=" + holder.english.text)
//            var intent = Intent(Intent.ACTION_VIEW)
//            intent.data = uri
//            holder.itemView.context.startActivity(intent)
//        }
        holder.switch.setOnCheckedChangeListener { buttonView, isChecked ->
            var word: Word = holder.itemView.getTag(R.id.word_for_view_holder) as Word
            if (isChecked) {
                holder.chinese.setVisibility(View.GONE)
                word.invisible = true
                wordViewModel.updateWords(word)
            } else {
                holder.chinese.setVisibility(View.VISIBLE)
                word.invisible = false
                wordViewModel.updateWords(word)
            }
        }
        return holder

    }

    override fun getItemCount(): Int {
        return allWords.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var word = allWords.get(position)
        holder.itemView.setTag(R.id.word_for_view_holder, word)
        holder.number.text = (position + 1).toString()
        holder.english.text = word.word.toString()
        holder.chinese.text = word.Cmean.toString()



        if (word.invisible) {
            holder.chinese.setVisibility(View.GONE)
            holder.switch.setChecked(true)
        } else {
            holder.chinese.setVisibility(View.VISIBLE)
            holder.switch.setChecked(false)
        }


    }


}