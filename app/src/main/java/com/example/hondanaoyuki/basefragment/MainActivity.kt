package com.example.hondanaoyuki.basefragment

import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var mOnCompletionListener = OnCompletionListener {

        val s: Int = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener { _ ->

            SoundPlayerComponents.mContext = this
            SoundPlayerComponents.mOnCompletionListener = mOnCompletionListener
            if (SoundPlayerComponents.isPlaying()) {
                SoundPlayerComponents.stop()
            } else {
                val s : String = getPackageName().toString()
                SoundPlayerComponents.start(R.raw.voice)
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
