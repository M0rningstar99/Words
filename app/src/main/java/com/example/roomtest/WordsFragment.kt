package com.example.roomtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.nio.FloatBuffer

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
   lateinit var floatingActionButton: FloatingActionButton
   lateinit var filteredWords:LiveData<List<Word>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        //显示右上角的menu
        setHasOptionsMenu(true)
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
        //        recyclerView = requireActivity().findViewById(R.id.recyclerview)
        recyclerView = view.findViewById(R.id.recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        myAdapter1 = MyAdapter(false,wordViewModel)
        myAdapter2 =MyAdapter(true,wordViewModel)

        recyclerView.adapter = myAdapter1
        filteredWords = wordViewModel.getAllWordsLive()
        filteredWords.observe(requireActivity(), Observer<List<Word>> { words ->
            var temp = myAdapter1.itemCount
            myAdapter1.allWords = words
            myAdapter2.allWords = words
            if (temp != words.size) {
                myAdapter1.notifyDataSetChanged()
                myAdapter2.notifyDataSetChanged()
            }
        })
        floatingActionButton = view.findViewById(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener{
            var navC = Navigation.findNavController(view)
            navC.navigate(R.id.action_wordsFragment_to_addFragment)

        }
    }

    //添加右上角的功能条
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu,menu)
        var searchView=menu.findItem(R.id.app_bar_search).actionView as SearchView
        //设置搜索框的最大宽度
        searchView.maxWidth = 1000
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Handle query submission
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Handle query text change
                var patten:String = newText?.trim() ?: ""
                //每次使用都需要先停止之前观察
              filteredWords.removeObservers(requireActivity())
                filteredWords = wordViewModel.findWordsWithPatten(patten)
                filteredWords.observe(requireActivity(), Observer<List<Word>> { words ->
                    var temp = myAdapter1.itemCount
                    myAdapter1.allWords = words
                    myAdapter2.allWords = words
                    if (temp != words.size) {
                        myAdapter1.notifyDataSetChanged()
                        myAdapter2.notifyDataSetChanged()
                    }
                })


                return true
            }
        })
    }


}