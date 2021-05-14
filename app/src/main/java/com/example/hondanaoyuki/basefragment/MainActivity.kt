package com.example.hondanaoyuki.basefragment

import android.content.Context
import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var mOnCompletionListener = OnCompletionListener {

        val s: Int = 1
    }

    val mCom:SoundPlayerComponents = SoundPlayerComponents()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener { _ ->

            mCom.setOnCompletionListener(mOnCompletionListener)
            if (mCom.isPlaying()) {
                mCom.stop()
            } else {
                val s : String = getPackageName().toString()
                mCom.start(R.raw.voice)
            }
//            App.get
//            val Context : Context = App.getAppContext()
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
