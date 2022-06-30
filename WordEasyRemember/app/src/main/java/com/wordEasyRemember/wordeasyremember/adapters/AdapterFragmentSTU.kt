package com.wordEasyRemember.wordeasyremember.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ItemWordPinkBinding

class AdapterFragmentSTU(val listener: Listener): RecyclerView.Adapter<AdapterFragmentSTU.ViewHolderSTU>() {

    var listWordSTU = listOf(
        ViewModelWord("sad", "грустный", "Я грустный сел в СЕДло"),
        ViewModelWord("sell", "продавать", "Я продаю СЕЛёдку"),
        ViewModelWord("sleep", "спать", "У меня СЛИПаются глаза, я хочу спать"),
        ViewModelWord("sock", "носок", "На ноСОК разлили СОК"),
        ViewModelWord("son", "сын", "Покатал сына на САНках"),
        ViewModelWord("star", "звезда", "У СТАРика на шапке была красная звезда"),
        ViewModelWord("supper", "ужин", "САПёр пришёл на ужин в ресторан"),
        ViewModelWord("sweet", "конфета, сладкий",
            "Я завернул в свой СВИТер килограмм сладких конфет"),
        ViewModelWord("swing", "раскачивать", "СВИНья раскачивает лодку"),
        ViewModelWord("take", "брать", "Я беру сТЭЙК"),
        ViewModelWord("talk", "говорить", "Электрик говорил про ТОК"),
        ViewModelWord("tall", "высокий", "Высокие ТОЛстые жирафы ТОЛкают друг друга"),
        ViewModelWord("tea", "чай", "ТИгр пьёт чай"),
        ViewModelWord("teeth", "зубы", "Стиснуть зубы, как тиски"),
        ViewModelWord("tell", "говорить, сказать", "Разговаривать по ТЕЛефону"),
        ViewModelWord("think", "думать", "Думаю, стирать ли джинсы с СИНЬКой или нет"),
        ViewModelWord("tie", "галстук", "Я смог завязать галстук по ТАЙмеру за 30 секунд"),
        ViewModelWord("tooth", "зуб", "Когда я был на спектакле в ТЮЗеб у меня выпал зуб"),
        ViewModelWord("touch", "трогать, касаться", "Я трогаю ТАЧку")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSTU {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word_pink, parent, false)
        return ViewHolderSTU(view)
    }

    override fun onBindViewHolder(holder: ViewHolderSTU, position: Int) {
        holder.bind(listWordSTU[position], listener)
    }

    override fun getItemCount(): Int {
        return listWordSTU.size
    }

    class ViewHolderSTU(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemWordPinkBinding.bind(view)
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