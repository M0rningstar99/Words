package com.example.roomtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class WordsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
   lateinit var wordViewModel :WordViewModel
   lateinit var recyclerView: RecyclerView
   lateinit var myAdapter1: MyAdapter
   lateinit var myAdapter2: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_words, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wordViewModel =ViewModelProvider(requireActivity()).get(WordViewModel::class.java)
        recyclerView = requireActivity().findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        myAdapter1 = MyAdapter(false,wordViewModel)
        myAdapter2 =MyAdapter(true,wordViewModel)

        recyclerView.adapter = myAdapter1
        wordViewModel.getAllWordsLive().observe(requireActivity(), Observer<List<Word>> { words ->
            var temp = myAdapter1.itemCount
            myAdapter1.allWords = words
            myAdapter2.allWords = words
            if (temp != words.size) {
                myAdapter1.notifyDataSetChanged()
                myAdapter2.notifyDataSetChanged()
            }
        })
    }


}