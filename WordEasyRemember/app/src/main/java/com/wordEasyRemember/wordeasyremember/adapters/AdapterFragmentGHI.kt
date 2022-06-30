package com.wordEasyRemember.wordeasyremember.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ItemWordGreenBinding

class AdapterFragmentGHI(val listener: Listener): RecyclerView.Adapter<AdapterFragmentGHI.ViewHolderGHI>() {

     var listWordGHI = listOf(
         ViewModelWord("glad", "собака", "Собачка радостная, потому что её поГЛАДили"),
         ViewModelWord("glass", "стакан",
             "В стакане лежал искусственный человеческий ГЛАЗ"),
        ViewModelWord("glasses", "очки", "Слово 'очки' начинается на ГЛАСную букву"),
        ViewModelWord("go", "идти", "ГОлубь идёт по лужайке"),
        ViewModelWord("hold", "держать",
            "Нужно держать продукты в ХОЛОДильнике")
     )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGHI {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word_green, parent, false)
        return ViewHolderGHI(view)
    }

    override fun onBindViewHolder(holder: ViewHolderGHI, position: Int) {
        holder.bind(listWordGHI[position], listener)
    }

    override fun getItemCount(): Int {
        return listWordGHI.size
    }


    class ViewHolderGHI(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemWordGreenBinding.bind(view)
        fun bind(viewModelWord: ViewModelWord, listener: Listener){
            binding.tvWord.text = viewModelWord.word
            itemView.setOnClickListener {
                listener.onClick(viewModelWord)
            }
        }

    }

    interface  Listener {
        fun onClick(viewModelWord: ViewModelWord)
    }

}