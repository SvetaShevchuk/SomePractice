package com.wordEasyRemember.wordeasyremember.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ItemWordGreyBinding

class AdapterFragmentPQR(val listener: Listener): RecyclerView.Adapter<AdapterFragmentPQR.ViewHolderPQR>() {

    var listWordPQR = listOf(
        ViewModelWord("pen","ручка", "Ручка лежит в пенале"),
        ViewModelWord("push","толкать", "Я толкаю пушку"),
        ViewModelWord("put","класть", "Класть ПУТёвку на стол"),
        ViewModelWord("read","читать", "Читать книгу и РЫДать над ней"),
        ViewModelWord("roll","катить", "Катить бочку на РОЛиках"),
        ViewModelWord("run","бежать",
            "Он бежал очень быстро, несмотря на РАНу на ноге")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPQR {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word_grey, parent, false)
        return ViewHolderPQR(view)
    }

    override fun onBindViewHolder(holder: ViewHolderPQR, position: Int) {
        holder.binding(listWordPQR[position], listener)
    }

    override fun getItemCount(): Int {
        return listWordPQR.size
    }

    class ViewHolderPQR(view: View): RecyclerView.ViewHolder(view) {
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