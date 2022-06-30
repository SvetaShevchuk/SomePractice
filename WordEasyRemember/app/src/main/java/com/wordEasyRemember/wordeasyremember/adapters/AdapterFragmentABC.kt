package com.wordEasyRemember.wordeasyremember.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ItemWordPinkBinding

class AdapterFragmentABC(val listener: Listener): RecyclerView.Adapter<AdapterFragmentABC.ViewHolderA>() {

    private var listWordABC = listOf(
        ViewModelWord("abyss", "бездна", "БИСквит упал в бездну"),
        ViewModelWord("ask", "спрашивать",
            "Я спрашиваю в аптеке, сколькл стоит АСКорбинка"),
        ViewModelWord("bag", "сумка", "Я убегала от БЕГемота и на БЕГу застёгивала сумку"),
        ViewModelWord("become", "становиться",
            "Телёнок вырастет и станет большим БЫКОМ"),
        ViewModelWord("bend", "гнуть", "Гнуть БЕНгальские огни"),
        ViewModelWord("book", "книга", "Сверху на книге лежал красивый БУКет"),
        ViewModelWord("better", "лучше", "БЕТОнный пол лучше, чем деревянный"),
        ViewModelWord("boy", "мальчик", "Мальчик вступил в БОЙ с другими мальчиками"),
        ViewModelWord("buy", "покупать", "Я покупаю БАЙдарку"),
        ViewModelWord("can", "мочь, уметь", "КЕНгуру может носить дитя в своей сумке"),
        ViewModelWord("catch", "ловить, поймать",
            "Я поймал на удочку КЕТЧуп"),
        ViewModelWord("collect", "собирать","Собрался весь КОЛЛЕКТив"),
        ViewModelWord("comb", "расчёска",
            "Я пытаюсь расчёской расчесать у себя на голове КОМ из волос"),
        ViewModelWord("come", "приходить",
            "Все пришли на встречу возле КАМина"),
        ViewModelWord("cook", "готовить", "Я готовлю КУКурузу"),
        ViewModelWord("cost", "стоить", "Интересно, сколько стоят эти игральные КОСТи?"),
        ViewModelWord("crawl", "ползать", "По лужайке ползает КРОЛик"),
        ViewModelWord("cross", "пересекать", "Я пересекаю дорогу в КРОССовках")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderA {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word_pink, parent, false)
        return ViewHolderA(view)
    }

    override fun onBindViewHolder(holder: ViewHolderA, position: Int) {
        holder.bind(listWordABC[position], listener)
        //holder.itemView.animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.layout_animation)
    }

    override fun getItemCount(): Int {
        return listWordABC.size
    }

    class ViewHolderA(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemWordPinkBinding.bind(view)
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