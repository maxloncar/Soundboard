package com.example.soundboard.sounds

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool

class SoundPoolPlayer(context: Context) : AudioPlayer {
    private val priority: Int = 1
    private val maxStreams: Int = 3
    private val srcQuality: Int = 1

    private val leftVolume = 1f
    private val rightVolume = 1f
    private val shouldLoop = 0
    private val playbackRate = 1f

    private val soundPool: SoundPool
    private var context: Context

    init {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build()
            soundPool = SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(maxStreams)
                .build()
        } else {
            soundPool = SoundPool(maxStreams, AudioManager.USE_DEFAULT_STREAM_TYPE, srcQuality)
        }
        this.context = context
    }

    override fun playTalkingSound(talkingSoundId: Int) {
        soundPool.setOnLoadCompleteListener { _, talkingSoundId, _ ->
            playSound(talkingSoundId)
        }
        soundPool.load(context, talkingSoundId, priority)
    }

    private fun playSound(talkingSoundId: Int) {
        soundPool.play(talkingSoundId, leftVolume, rightVolume, priority, shouldLoop, playbackRate)
    }
}