package com.example.hondanaoyuki.basefragment

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var mOnCompletionListener = MediaPlayer.OnCompletionListener {

        val s: Int = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener { _ ->

            if(SoundPlayerComponents.isPlaying()) {
                SoundPlayerComponents.stop()
            } else {
                val s : String = getPackageName().toString()
                SoundPlayerComponents.start(this, R.raw.voice, mOnCompletionListener)
            }

            val fragmentManager = supportFragmentManager
            val fragmentTransaction =
                    fragmentManager.beginTransaction()

            // BackStackを設定
            fragmentTransaction.addToBackStack(null)

            // パラメータを設定
            fragmentTransaction.replace(
                    R.id.fragment_container,
                    SecondFragment()
            )
            fragmentTransaction.commit()
        }
    }
}
