package com.techskaud.bmidieasestracker.di


import com.techskaud.bmidieasestracker.repository.BaseRepository
import com.techskaud.bmidieasestracker.retrofit.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun provideMainRepository(
        retrofit: ApiInterface,
    ): BaseRepository {
        return BaseRepository(retrofit)
    }

}