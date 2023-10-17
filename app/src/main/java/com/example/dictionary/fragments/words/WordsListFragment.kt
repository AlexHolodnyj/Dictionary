package com.example.dictionary.fragments.words

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionary.R
import com.example.dictionary.databinding.FragmentWordsListBinding
import com.example.dictionary.viewmodel.TranslatedWordViewModel


class WordsListFragment : Fragment() {

    private lateinit var binding: FragmentWordsListBinding
    private lateinit var translatedWordViewModel: TranslatedWordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentWordsListBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWordsListBinding.inflate(inflater, container, false)
        binding.addTranslatedWordFab.setOnClickListener {
            findNavController().navigate(R.id.addNewTranslatedWordFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = WordsListAdapter()
        val recyclerView = binding.wordsListRecyclerView

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        translatedWordViewModel = ViewModelProvider(this)[TranslatedWordViewModel::class.java]
        translatedWordViewModel.readAllTranslatedWords.observe(
            viewLifecycleOwner,
            Observer { translatedWords ->
                adapter.setData(translatedWords)
            })
    }


}