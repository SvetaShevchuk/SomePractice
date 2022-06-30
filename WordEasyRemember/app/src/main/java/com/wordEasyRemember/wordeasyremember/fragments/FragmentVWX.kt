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
import com.wordEasyRemember.wordeasyremember.activities.ActivityVWX
import com.wordEasyRemember.wordeasyremember.adapters.AdapterFragmentVWX


class FragmentVWX : Fragment(), AdapterFragmentVWX.Listener {

    private lateinit var recyclerViewVWX: RecyclerView
    private val adapterVWX = AdapterFragmentVWX(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_v_w_x, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewVWX = view.findViewById(R.id.recycler_view_VWX)
        recyclerViewVWX.layoutManager = LinearLayoutManager(activity)
        recyclerViewVWX.adapter = adapterVWX
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentVWX()
    }

    override fun onClick(viewModelWord: ViewModelWord) {
        startActivity(Intent(getActivity(), ActivityVWX::class.java).apply {
            putExtra("itemVWX", viewModelWord)
        })
    }
}