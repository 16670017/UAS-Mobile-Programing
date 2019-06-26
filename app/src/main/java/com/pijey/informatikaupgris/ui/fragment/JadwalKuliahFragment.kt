package com.pijey.informatikaupgris.ui.fragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pijey.informatikaupgris.R
import com.pijey.informatikaupgris.adapter.JadwalPribadiAdapter
import com.pijey.informatikaupgris.model.DataItemModel
import com.pijey.informatikaupgris.rest.ApiService
import com.pijey.informatikaupgris.rest.RetroConfig
import kotlinx.android.synthetic.main.activity_jadwal_kuliah_fragment.view.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class JadwalKuliahFragment : Fragment() {
    private var items: ArrayList<DataItemModel> = arrayListOf()
    private lateinit var rv: RecyclerView
    private lateinit var mAdapter: JadwalPribadiAdapter
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.activity_jadwal_kuliah_fragment, container, false)
        rv = view.rv
        val apiService: ApiService = RetroConfig.provideApi()
        apiService.getJadwalKuliah()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    items.clear()
                    items = it.data as ArrayList<DataItemModel>
                    mAdapter = JadwalPribadiAdapter(items, activity)
                    rv.visibility = View.VISIBLE
                    rv.layoutManager = LinearLayoutManager(activity)
                    rv.adapter = mAdapter

                }, {
                    error("Error" + it.message)
                })

        return view
    }

    private fun getDatas() {

    }


}
