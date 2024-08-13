package com.example.roomtest

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AddFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var activity1: FragmentActivity
    lateinit var button: Button
    lateinit var english: EditText
    lateinit var chinese: EditText
    lateinit var inputMethodManager: InputMethodManager



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
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        activity1 = requireActivity()
        var wordViewModel:WordViewModel = ViewModelProvider(activity1).get(WordViewModel::class.java)
        button = activity1.findViewById(R.id.button)
        english = activity1.findViewById(R.id.english)
        chinese = activity1.findViewById(R.id.chinese)
        button.isEnabled = false
        english.requestFocus()
        inputMethodManager = activity1.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(english,0)
        var textWatcher = object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var english = english.text
                var chinese = chinese.text
                button.isEnabled = !english.isEmpty() && !chinese.isEmpty()

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        }
        english.addTextChangedListener(textWatcher)
        chinese.addTextChangedListener(textWatcher)
        button.setOnClickListener{
            var english = english.getText().toString().trim()
            var chinese = chinese.getText().toString().trim()
            var word = Word(english,chinese)
            wordViewModel.insertWords(word)
            var navController = Navigation.findNavController(view)
            navController.navigateUp()


        }

    }




}