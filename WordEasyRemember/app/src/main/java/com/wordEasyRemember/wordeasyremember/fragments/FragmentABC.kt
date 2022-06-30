package com.wordEasyRemember.wordeasyremember.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wordEasyRemember.wordeasyremember.MainActivity
import com.wordEasyRemember.wordeasyremember.R
import com.wordEasyRemember.wordeasyremember.ViewModelWord
import com.wordEasyRemember.wordeasyremember.activities.ActivityABC
import com.wordEasyRemember.wordeasyremember.adapters.AdapterFragmentABC


class FragmentABC : Fragment(), AdapterFragmentABC.Listener {
    lateinit var recyclerViewA : RecyclerView
    private var adapterA = AdapterFragmentABC(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_abc, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewA = view.findViewById(R.id.recycler_view_A)
        recyclerViewA.layoutManager = LinearLayoutManager(activity)
        recyclerViewA.adapter = adapterA
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentABC()
    }

    override fun onClick(viewModelWord: ViewModelWord) {
        startActivity(Intent(getActivity(), ActivityABC::class.java).apply {
            putExtra("itemABC", viewModelWord)
        })
    }
}