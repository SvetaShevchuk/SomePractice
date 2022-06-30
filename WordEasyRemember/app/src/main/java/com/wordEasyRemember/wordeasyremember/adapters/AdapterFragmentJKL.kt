package com.wordEasyRemember.wordeasyremember.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ItemWordGreyBinding

class AdapterFragmentJKL(val listener: Listener): RecyclerView.Adapter<AdapterFragmentJKL.ViewHolderJKL>() {

    var listWordGHI = listOf(
        ViewModelWord("like", "любить, нравиться", "Мне нравится порода ЛАЙКа"),
        ViewModelWord("listen", "слушать",
            "Мужчина с ЛЫСИНой слушает музыку в наушниках"),
        ViewModelWord("look", "смотреть", "Я с интересом смотрю на большой ЛУК")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFragmentJKL.ViewHolderJKL {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word_grey, parent, false)
        return ViewHolderJKL(view)
    }

    override fun onBindViewHolder(holder: AdapterFragmentJKL.ViewHolderJKL, position: Int) {
        holder.binding(listWordGHI[position], listener)
    }

    override fun getItemCount(): Int {
        return listWordGHI.size
    }

    class ViewHolderJKL(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemWordGreyBinding.bind(view)
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