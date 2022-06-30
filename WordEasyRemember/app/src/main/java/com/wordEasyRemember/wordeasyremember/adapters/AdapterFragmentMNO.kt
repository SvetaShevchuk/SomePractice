package com.wordEasyRemember.wordeasyremember.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ItemWordBlueBinding

class AdapterFragmentMNO(val listener: Listener): RecyclerView.Adapter<AdapterFragmentMNO.ViewHolderMNO>() {

    var listWordMNO = listOf(
        ViewModelWord("magazine", "журнал",
            "Я зашёл в МАГАЗИН, где продавались только журналы"),
        ViewModelWord("meet", "встретить", "Мы встретились на МИТинге"),
        ViewModelWord("new", "новый", "Я НЮхаю свои новые туфли")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMNO {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word_blue, parent, false)
        return ViewHolderMNO(view)
    }

    override fun onBindViewHolder(holder: ViewHolderMNO, position: Int) {
        holder.binding(listWordMNO[position], listener)
    }

    override fun getItemCount(): Int {
        return listWordMNO.size
    }

    class ViewHolderMNO(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemWordBlueBinding.bind(view)
        fun binding(viewModelWord: ViewModelWord, listener: Listener){
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