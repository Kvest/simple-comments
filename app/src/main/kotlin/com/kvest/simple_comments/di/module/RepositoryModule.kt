package com.kvest.simple_comments.di.module

import com.kvest.simple_comments.data.FirebaseRepository
import com.kvest.simple_comments.data.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by kvest on 3/22/18.
 */
@Module
class RepositoryModule {
    @Provides @Singleton
    fun provideRepository(): Repository = FirebaseRepository()
}