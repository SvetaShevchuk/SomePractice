package com.wordEasyRemember.wordeasyremember.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.activities.ActivityABC
import com.wordEasyRemember.wordeasyremember.activities.ActivityDEF
import com.wordEasyRemember.wordeasyremember.adapters.AdapterFragmentDEF


class FragmentDEF : Fragment(), AdapterFragmentDEF.Listener {
    lateinit var recyclerViewDEF : RecyclerView
    private val adapterDEF = AdapterFragmentDEF(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_def, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewDEF = view.findViewById(R.id.recycler_view_DEF)
        recyclerViewDEF.layoutManager = LinearLayoutManager(activity)
        recyclerViewDEF.adapter = adapterDEF
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentDEF()
    }

    override fun onClick(viewModelWord: ViewModelWord) {
        startActivity(Intent(getActivity(), ActivityDEF::class.java).apply {
            putExtra("itemDEF", viewModelWord)
        })
    }
}