package com.example.soundboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.soundboard.R
import com.example.soundboard.databinding.ActivitySoundboardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SoundboardActivity : AppCompatActivity() {

    private val viewModel by viewModel<SoundboardViewModel>()
    private lateinit var binding: ActivitySoundboardBinding
    private lateinit var imageButtons: List<ImageButton>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySoundboardBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            imageButtons = listOf(it.ibMamic, it.ibSamuel, it.ibAlpacino)
            imageButtons.forEach { it.setOnClickListener { playTalkingSound(it) } }
        }
    }

    private fun playTalkingSound(imageButton: View) {
        viewModel.playTalkingSound(resources.getResourceEntryName(imageButton.id))
    }
}