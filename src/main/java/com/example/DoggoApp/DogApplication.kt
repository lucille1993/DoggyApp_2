package com.example.DoggoApp

import android.app.Application
import com.example.DoggoApp.database.AppDatabase

class DogApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}