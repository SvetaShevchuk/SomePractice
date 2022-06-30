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
import com.wordEasyRemember.wordeasyremember.activities.ActivityDEF
import com.wordEasyRemember.wordeasyremember.activities.ActivityGHI
import com.wordEasyRemember.wordeasyremember.adapters.AdapterFragmentGHI

class FragmentGHI : Fragment(), AdapterFragmentGHI.Listener {
    lateinit var recyclerViewGHI : RecyclerView
    private var adapterGHI = AdapterFragmentGHI(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ghi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewGHI = view.findViewById(R.id.recycler_view_GHI)
        recyclerViewGHI.layoutManager = LinearLayoutManager(activity)
        recyclerViewGHI.adapter = adapterGHI
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentGHI()
    }

    override fun onClick(viewModelWord: ViewModelWord) {
        startActivity(Intent(getActivity(), ActivityGHI::class.java).apply {
            putExtra("itemGHI", viewModelWord)
        })
    }
}