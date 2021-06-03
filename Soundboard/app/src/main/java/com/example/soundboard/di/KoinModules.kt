package com.example.soundboard.di

import com.example.soundboard.sounds.AudioPlayer
import com.example.soundboard.sounds.SoundPoolPlayer
import com.example.soundboard.ui.SoundboardViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<AudioPlayer> { SoundPoolPlayer(androidContext()) }
}

val viewModelModule = module {
    viewModel { SoundboardViewModel(get()) }
}