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
import com.wordEasyRemember.wordeasyremember.activities.ActivityYZ
import com.wordEasyRemember.wordeasyremember.adapters.AdapterFragmentYZ

class FragmentYZ : Fragment(), AdapterFragmentYZ.Listener {

    private lateinit var recyclerViewYZ: RecyclerView
    private val adapterYZ = AdapterFragmentYZ(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_y_z, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewYZ = view.findViewById(R.id.recycler_view_YZ)
        recyclerViewYZ.layoutManager = LinearLayoutManager(activity)
        recyclerViewYZ.adapter = adapterYZ
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentYZ()
    }

    override fun onClick(viewModelWord: ViewModelWord) {
        startActivity(Intent(getActivity(), ActivityYZ::class.java).apply {
            putExtra("itemYZ", viewModelWord)
        })
    }
}