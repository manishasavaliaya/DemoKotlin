package com.ipath.hospitaldevice.di


import android.content.Context
import com.ipath.hospitaldevice.BuildConfig

import com.ipath.hospitaldevice.data.remote.api.ApiHelper



import com.ipath.hospitaldevice.data.remote.api.ApiService
import com.ipath.hospitaldevice.utils.ApiUtil.Companion.API_URL
import com.ipath.hospitaldevice.utils.UserPreferenceHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideBaseUrl() = API_URL

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(providesOkhttpInterceptor())
            .addInterceptor(loggingInterceptor)
            .connectTimeout(2, TimeUnit.MINUTES)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .connectTimeout(2, TimeUnit.MINUTES)
            .addInterceptor(providesOkhttpInterceptor())
            .build()
    }

    @Singleton
    @Provides
    fun providesOkhttpInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val original: Request = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
                .addHeader("Accept", "application/JSON")
            requestBuilder.addHeader("Authorization", "Bearer ${userPreferenceHelper().token}")
            requestBuilder.addHeader("Content-Type", "form-data")
            requestBuilder.addHeader(
                "user-agent",
                "PostmanRuntime/7.28.4"
            )
            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideApiHelper(apiService: ApiService) = ApiHelper(apiService)

 /*   @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideRecentSearchDao(appDatabase: AppDatabase) =
        appDatabase.recentSearchDao()*/

    @Singleton
    @Provides
    fun userPreferenceHelper(): UserPreferenceHelper = UserPreferenceHelper()


}