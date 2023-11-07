package com.lvt.voiceeffects

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lvt.voiceeffects.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setContentView(R.layout.activity_main)

        binding.imgAlien.setOnClickListener {
            toggleSoundOff()
            toggleSoundOn(R.raw.alien)
        }

        binding.imgDeath.setOnClickListener {
            toggleSoundOff()
            toggleSoundOn(R.raw.death)
        }

        binding.imgDrunk.setOnClickListener {
            toggleSoundOff()
            toggleSoundOn(R.raw.drunk)
        }

        binding.imgGhost.setOnClickListener {
            toggleSoundOff()
            toggleSoundOn(R.raw.ghost)
        }

        binding.imgRobot.setOnClickListener {
            toggleSoundOff()
            toggleSoundOn(R.raw.robot)
        }

        binding.imgZombie.setOnClickListener {
            toggleSoundOff()
            toggleSoundOn(R.raw.zombie)
        }


    }

    private fun toggleSoundOff() {
        try {
            mediaPlayer?.let {
                it.stop()
                it.release()
            }
        } catch (e: IllegalStateException) {

        }
    }

    private fun toggleSoundOn(sound: Int) {
        mediaPlayer = MediaPlayer.create(this, sound)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()
    }
}