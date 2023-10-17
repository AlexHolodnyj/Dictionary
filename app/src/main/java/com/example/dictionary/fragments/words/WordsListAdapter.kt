package com.example.dictionary.fragments.words

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.R
import com.example.dictionary.model.TranslatedWord


class WordsListAdapter : RecyclerView.Adapter<WordsListAdapter.ViewHolder>() {
    private var translatedWordsList = emptyList<TranslatedWord>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordTv: TextView
        val translateTv: TextView
        val timesRepeatedTv: TextView
        val rowLayout: ConstraintLayout

        init {
            wordTv = itemView.findViewById(R.id.word_tv)
            translateTv = itemView.findViewById(R.id.translate_tv)
            timesRepeatedTv = itemView.findViewById(R.id.timesRepeated_tv)
            rowLayout = itemView.findViewById(R.id.rowTranslatedWord)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.words_row, parent, false)
        )
    }

    override fun getItemCount(): Int = translatedWordsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = translatedWordsList[position]

        holder.wordTv.text = currentItem.value
        holder.translateTv.text = currentItem.translate
        holder.timesRepeatedTv.text = "Reapeted: ${currentItem.timesRepeated} times"

        holder.rowLayout.setOnClickListener {
            Toast.makeText(it.context, "Navigate to ${holder.wordTv.text}", Toast.LENGTH_SHORT)
                .show()
        }
    }

    fun setData(translatedWords: List<TranslatedWord>) {
        this.translatedWordsList = translatedWords
        notifyDataSetChanged()
    }

}