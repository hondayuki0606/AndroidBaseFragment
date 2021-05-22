package com.example.hondanaoyuki.basefragment.activity

import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.hondanaoyuki.basefragment.R
import com.example.hondanaoyuki.basefragment.application.App
import com.example.hondanaoyuki.basefragment.components.SoundPlayerComponents
import com.example.hondanaoyuki.basefragment.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    var mOnCompletionListener = OnCompletionListener {
        val b:App = App.instance
    }

    val mSoundPlayer = SoundPlayerComponents()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction =
                fragmentManager.beginTransaction()

        // BackStackを設定
        fragmentTransaction.addToBackStack(null)

        // パラメータを設定
        fragmentTransaction.replace(
                R.id.fragment_container,
                MainFragment()
        )
        fragmentTransaction.commit()


    }
}
