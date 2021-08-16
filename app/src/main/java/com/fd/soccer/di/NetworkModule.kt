package com.fd.soccer.di

import android.app.Application
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.fd.soccer.data.remote.ApiService
import com.fd.soccer.util.Constant
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 10L

val NetworkModule = module {

    single { createOkHttpClient(androidApplication()) }

    single { createRetrofit(get(), Constant.BASE_URL) }

    single { createService(get()) }

}

fun createOkHttpClient(application: Application): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(ChuckerInterceptor.Builder(application).build()).build()
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun createService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}
