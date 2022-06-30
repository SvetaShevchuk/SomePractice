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
import com.wordEasyRemember.wordeasyremember.activities.ActivityMNO
import com.wordEasyRemember.wordeasyremember.activities.ActivityPQR
import com.wordEasyRemember.wordeasyremember.adapters.AdapterFragmentPQR


class FragmentPQR : Fragment(), AdapterFragmentPQR.Listener {
    private lateinit var recyclerViewPQR: RecyclerView
    private val adapterPQR = AdapterFragmentPQR(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_p_q_r, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewPQR = view.findViewById(R.id.recycler_view_PQR)
        recyclerViewPQR.layoutManager = LinearLayoutManager(activity)
        recyclerViewPQR.adapter = adapterPQR
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentPQR()
    }

    override fun onClick(viewModelWord: ViewModelWord) {
        startActivity(Intent(getActivity(), ActivityPQR::class.java).apply {
            putExtra("itemPQR", viewModelWord)
        })
    }
}