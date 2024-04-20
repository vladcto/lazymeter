package com.vladcto.lazymeter.platform.di

import android.app.Application
import androidx.room.Room
import com.vladcto.lazymeter.platform.room.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class AppModule : Application() {
    @Provides
    fun provideAppDatabase(): AppDatabase {
        return Room.databaseBuilder(
            context = applicationContext,
            AppDatabase::class.java,
            "lazymeter-db"
        ).build()
    }
}