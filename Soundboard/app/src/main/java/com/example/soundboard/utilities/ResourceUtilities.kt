package com.example.soundboard.utilities

import android.media.ToneGenerator
import com.example.soundboard.R

fun getTalkingSound(soundName: String) : Int {
    return when (soundName) {
        "ib_mamic" -> R.raw.mamic
        "ib_samuel" -> R.raw.samuel
        "ib_alpacino" -> R.raw.alpacino
        else -> ToneGenerator.TONE_CDMA_SIGNAL_OFF
    }
}