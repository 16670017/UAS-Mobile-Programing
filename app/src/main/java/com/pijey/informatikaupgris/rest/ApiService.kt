package com.pijey.informatikaupgris.rest

import com.pijey.informatikaupgris.BuildConfig
import com.pijey.informatikaupgris.model.RootDataModel
import retrofit.http.GET
import rx.Observable

interface ApiService {

    @GET("detil_jadwal?key=" + BuildConfig.API_KEY + "&npm=" + BuildConfig.NPM)
    fun getJadwalKuliah(
    ): Observable<RootDataModel>

    @GET("detil_pribadi?key=" + BuildConfig.API_KEY + "&npm=" + BuildConfig.NPM)
    fun getProfil(
    ): Observable<RootDataModel>
}