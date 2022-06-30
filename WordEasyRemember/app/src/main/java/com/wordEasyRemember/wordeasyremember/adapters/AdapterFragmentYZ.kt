package com.wordEasyRemember.wordeasyremember.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.databinding.ItemWordGreenBinding

class AdapterFragmentYZ(val listener: Listener): RecyclerView.Adapter<AdapterFragmentYZ.ViewHolderYZ>() {

    var listWordYZ = listOf(
        ViewModelWord("yard", "двор", "У нас во дворе валяется бутылочка с ЯДом")
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderYZ {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word_green, parent, false)
        return ViewHolderYZ(view)
    }

    override fun onBindViewHolder(holder: ViewHolderYZ, position: Int) {
        holder.bind(listWordYZ[position], listener)
    }

    override fun getItemCount(): Int {
        return listWordYZ.size
    }

    class ViewHolderYZ(view: View): RecyclerView.ViewHolder(view) {
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