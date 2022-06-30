package com.wordEasyRemember.wordeasyremember.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ItemWordGreyBinding

class AdapterFragmentVWX(val listener: Listener): RecyclerView.Adapter<AdapterFragmentVWX.ViewHolderVWX>(){

    var listWordVWX = listOf(
        ViewModelWord("wall", "стена",
            "Возле стены стояла девушка с очень длинными ВОЛосами"),
        ViewModelWord("win", "выиграть","Я выиграл дорогое ВИНо")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderVWX {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word_grey, parent, false)
        return ViewHolderVWX(view)
    }

    override fun onBindViewHolder(holder: ViewHolderVWX, position: Int) {
        holder.bind(listWordVWX[position], listener)
    }

    override fun getItemCount(): Int {
        return listWordVWX.size
    }


    class ViewHolderVWX(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemWordGreyBinding.bind(view)
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