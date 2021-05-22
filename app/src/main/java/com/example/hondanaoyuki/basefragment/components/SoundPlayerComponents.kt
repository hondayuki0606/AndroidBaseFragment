package com.example.hondanaoyuki.basefragment.components

import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.net.Uri
import com.example.hondanaoyuki.basefragment.application.App
import java.io.IOException

class SoundPlayerComponents {

    companion object {
        const val PATH2 ="android.resource://com.example.hondanaoyuki.basefragment/raw/voice"
        const val PATH3 = "android.resource://com.example.hondanaoyuki.basefragment/"
    }

    private var mMediaPlayer: MediaPlayer? = MediaPlayer()

    private var mOnCompletionListener: OnCompletionListener? = null

    fun start(rId: Int?) {

        try {

            if(mOnCompletionListener != null) {
                mMediaPlayer!!.setOnCompletionListener(mOnCompletionListener)
            }

            mMediaPlayer!!.reset()
            mMediaPlayer!!.setDataSource(App.instance, Uri.parse(PATH3 + rId))
            mMediaPlayer!!.prepare()
            mMediaPlayer!!.start()
        } catch (e: IllegalArgumentException) {
            println(e)
        } catch (e: IOException) {
            println(e)
        }
    }

    fun setOnCompletionListener(onCompletionListener: OnCompletionListener) {
        mOnCompletionListener = onCompletionListener
    }


    fun stop() {
        try {
            mMediaPlayer!!.stop()
        } catch (e: IllegalArgumentException) {
            println(e)
        }
    }

    fun restart() {
        try {
            mMediaPlayer!!.start()
        } catch (e: IllegalArgumentException) {
            println(e)
        }
    }

    fun pause() {
        try {
            mMediaPlayer!!.pause()
        } catch (e: IllegalArgumentException) {
            println(e)
        } catch (e: IOException) {
            println(e)
        }
    }

    fun isPlaying(): Boolean {
        return mMediaPlayer!!.isPlaying()
    }
}
