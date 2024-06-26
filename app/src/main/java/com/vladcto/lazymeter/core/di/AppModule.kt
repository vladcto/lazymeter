package com.vladcto.lazymeter.core.di

import android.content.Context
import androidx.room.Room
import com.vladcto.lazymeter.core.room.AppDatabase
import com.vladcto.lazymeter.data.lazy.infra.LazyUnitDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {
    @Provides
    fun provideAppDatabase(
        @ApplicationContext appContext: Context,
    ): AppDatabase {
        return Room.databaseBuilder(
            context = appContext,
            AppDatabase::class.java,
            "lazymeter-db",
        ).build()
    }

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): LazyUnitDao = appDatabase.lazyUnitDao()
}
