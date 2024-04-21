package com.vladcto.lazymeter.platform.di

import android.app.Application
import androidx.room.Room
import com.vladcto.lazymeter.platform.room.AppDatabase
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LazymeterApp : Application()