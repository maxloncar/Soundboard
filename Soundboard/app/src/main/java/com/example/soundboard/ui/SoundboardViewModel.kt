package com.example.soundboard.ui

import androidx.lifecycle.ViewModel
import com.example.soundboard.sounds.AudioPlayer
import com.example.soundboard.utilities.getTalkingSound

class SoundboardViewModel (private val audioPlayer: AudioPlayer) : ViewModel() {
    fun playTalkingSound(talkingSoundId: String) {
        audioPlayer.playTalkingSound(getTalkingSound(talkingSoundId))
    }
}