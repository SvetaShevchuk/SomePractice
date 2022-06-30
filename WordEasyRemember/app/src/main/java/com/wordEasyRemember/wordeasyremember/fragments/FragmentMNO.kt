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
import com.wordEasyRemember.wordeasyremember.activities.ActivityJKL
import com.wordEasyRemember.wordeasyremember.activities.ActivityMNO
import com.wordEasyRemember.wordeasyremember.adapters.AdapterFragmentMNO

class FragmentMNO : Fragment(), AdapterFragmentMNO.Listener {
    private lateinit var recyclerViewMNO: RecyclerView
    private val adapterMNO = AdapterFragmentMNO(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_m_n_o, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewMNO = view.findViewById(R.id.recycler_view_MNO)
        recyclerViewMNO.layoutManager = LinearLayoutManager(activity)
        recyclerViewMNO.adapter = adapterMNO
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentMNO()
    }

    override fun onClick(viewModelWord: ViewModelWord) {
        startActivity(Intent(getActivity(), ActivityMNO::class.java).apply {
            putExtra("itemMNO", viewModelWord)
        })
    }
}