package com.ozcanalasalvar.core.di.module

import com.ozcanalasalvar.core.BuildConfig
import com.ozcanalasalvar.core.network.service.Service
import com.ozcanalasalvar.core.repository.data_source.RemoteDataSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOKHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(1000, TimeUnit.SECONDS)
            .connectTimeout(1000, TimeUnit.SECONDS)
            .build()

    }


    @Singleton
    @Provides
    fun provideGSON(): MoshiConverterFactory {
        return MoshiConverterFactory.create()

    }

    @Singleton
    @Provides
    fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        gsonConverterFactory: MoshiConverterFactory,
        okHttpClient: OkHttpClient,
        adapterFactory: RxJava2CallAdapterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .addCallAdapterFactory(adapterFactory)
        .build()


    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): Service = retrofit.create(
        Service::class.java
    )


    @Singleton
    @Provides
    fun provideRemoteDataSource(
        service: Service
    ): RemoteDataSource =
        RemoteDataSource(
            service
        )

}