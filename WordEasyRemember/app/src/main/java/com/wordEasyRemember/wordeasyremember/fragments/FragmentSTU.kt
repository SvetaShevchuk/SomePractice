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
import com.wordEasyRemember.wordeasyremember.activities.ActivityPQR
import com.wordEasyRemember.wordeasyremember.activities.ActivitySTU
import com.wordEasyRemember.wordeasyremember.adapters.AdapterFragmentSTU


class FragmentSTU : Fragment(), AdapterFragmentSTU.Listener {

    private lateinit var recyclerViewSTU: RecyclerView
    private val adapterSTU = AdapterFragmentSTU(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_s_t_u, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewSTU = view.findViewById(R.id.recycler_view_STU)
        recyclerViewSTU.layoutManager = LinearLayoutManager(activity)
        recyclerViewSTU.adapter = adapterSTU
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentSTU()
    }

    override fun onClick(viewModelWord: ViewModelWord) {
        startActivity(Intent(getActivity(), ActivitySTU::class.java).apply {
            putExtra("itemSTU", viewModelWord)
        })
    }
}