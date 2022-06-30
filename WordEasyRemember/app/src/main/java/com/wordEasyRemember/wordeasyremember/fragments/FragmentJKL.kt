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
import com.wordEasyRemember.wordeasyremember.activities.ActivityGHI
import com.wordEasyRemember.wordeasyremember.activities.ActivityJKL
import com.wordEasyRemember.wordeasyremember.adapters.AdapterFragmentJKL


class FragmentJKL : Fragment(), AdapterFragmentJKL.Listener {
    private lateinit var recyclerViewJKL: RecyclerView
    private val adapterJKL = AdapterFragmentJKL(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_j_k_l, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewJKL = view.findViewById(R.id.recycler_view_JKL)
        recyclerViewJKL.layoutManager = LinearLayoutManager(activity)
        recyclerViewJKL.adapter = adapterJKL
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentJKL()
    }

    override fun onClick(viewModelWord: ViewModelWord) {
        startActivity(Intent(getActivity(), ActivityJKL::class.java).apply {
            putExtra("itemJKL", viewModelWord)
        })
    }
}