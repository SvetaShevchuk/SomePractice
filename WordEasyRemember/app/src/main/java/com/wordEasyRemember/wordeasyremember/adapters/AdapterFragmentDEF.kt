package com.wordEasyRemember.wordeasyremember.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ItemWordGreyBinding

class AdapterFragmentDEF(val listener: Listener): RecyclerView.Adapter<AdapterFragmentDEF.ViewHolderDEF>() {
    private var listWordDEF = listOf(
        ViewModelWord("door", "дверь",
            "Я установил себе очень ДОРогую надёжную дверь"),
        ViewModelWord("dress", "платье", "Девочка в платье ДРЕССирует собаку"),
        ViewModelWord("fall", "падать", "ФОЛьга упала на пол"),
        ViewModelWord("fence", "забор", "Я взяла ФЕН и Сушу краску на заборе"),
        ViewModelWord("fish", "рыба", "На моей ФИШке была изображена рыбка"),
        ViewModelWord("floor", "пол, этаж", "На полу валялись разноцветные ФЛОмастеры"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDEF {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word_grey, parent, false)
        return ViewHolderDEF(view)
    }

    override fun onBindViewHolder(holder: ViewHolderDEF, position: Int) {
        holder.bind(listWordDEF[position], listener)
    }

    override fun getItemCount(): Int {
        return listWordDEF.size
    }

    class ViewHolderDEF(view:View): RecyclerView.ViewHolder(view) {
        val binding = ItemWordGreyBinding.bind(view)
        fun bind(viewModelWord: ViewModelWord, listener: Listener) = with(binding){
            tvWord.text = viewModelWord.word
            itemView.setOnClickListener {
                listener.onClick(viewModelWord)
            }
        }
    }

    interface  Listener {
        fun onClick(viewModelWord: ViewModelWord)
    }
}