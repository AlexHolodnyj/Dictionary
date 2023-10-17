package com.example.dictionary.fragments.words

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dictionary.databinding.FragmentAddNewTranslatedWordBinding
import com.example.dictionary.model.TranslatedWord
import com.example.dictionary.viewmodel.TranslatedWordViewModel

class AddNewTranslatedWordFragment : Fragment() {
    private lateinit var translatedWordViewModel: TranslatedWordViewModel
    private lateinit var binding: FragmentAddNewTranslatedWordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentAddNewTranslatedWordBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddNewTranslatedWordBinding.inflate(inflater, container, false)
        translatedWordViewModel = ViewModelProvider(this)[TranslatedWordViewModel::class.java]

        binding.addNewTranslatedWordBtn.setOnClickListener {
            insertDataToDatabase()
        }

        return binding.root
    }

    private fun insertDataToDatabase() {
        val value = binding.wordEt.text
        val translate = binding.translateEt.text
        val isKnown = binding.isKnownCb.isChecked

        if (inputCheck(value, translate)) {
            translatedWordViewModel.addTranslatedWord(
                TranslatedWord(
                    value.toString(),
                    translate.toString(),
                    isKnown
                )
            )
            findNavController().popBackStack()
        } else {
            Toast.makeText(
                requireContext(),
                "Fields word and translate have not have to be empty",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun inputCheck(value: Editable, translate: Editable): Boolean =
        !(value.isBlank() || translate.isBlank())
}