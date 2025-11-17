package com.modwanz.manager.di

import com.modwanz.manager.downloader.api.SupportwanzAPI
import com.modwanz.manager.downloader.api.MusicAPI
import com.modwanz.manager.downloader.api.VancedAPI
import com.modwanz.manager.network.util.BASE
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

//TODO Add mirror support
val apiModule = module {

    fun provideVancedAPI(
        okHttpClient: OkHttpClient
    ): ModwanzAPI {
        return Retrofit.Builder()
            .baseUrl(BASE)
            .client(okHttpClient)
            .build()
            .create()
    }

    fun provideMusicAPI(
        okHttpClient: OkHttpClient
    ): MusicAPI {
        return Retrofit.Builder()
            .baseUrl(BASE)
            .client(okHttpClient)
            .build()
            .create()
    }

    fun provideSupportwanzAPI(
        okHttpClient: OkHttpClient
    ): SupportwanzAPI {
        return Retrofit.Builder()
            .baseUrl("https://github.com/Modwanz/SupportWanz/")
            .client(okHttpClient)
            .build()
            .create(SupportwanzAPI::class.java)
    }

    single { provideVancedAPI(get()) }
    single { provideMusicAPI(get()) }
    single { provideSupportwanzAPI(get()) }
}
