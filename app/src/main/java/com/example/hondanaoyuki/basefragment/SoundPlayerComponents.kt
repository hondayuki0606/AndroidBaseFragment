package com.example.hondanaoyuki.basefragment

import android.content.Context
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.net.Uri
import java.io.IOException

object SoundPlayerComponents {

    // MediaPlayer のインスタンス生成
    var mMediaPlayer: MediaPlayer? = null

    // OnCompletionListener のインスタンス生成
    var mOnCompletionListener: OnCompletionListener? = null

    fun startSound(context: Context?, rId: Int?, onCompletionListener: OnCompletionListener) {

        try {
            if (mMediaPlayer == null) {
                mMediaPlayer = MediaPlayer()
                mMediaPlayer!!.setOnCompletionListener(onCompletionListener)
                mOnCompletionListener = onCompletionListener
            }
            mMediaPlayer!!.reset()
//            val uri = Uri.parse("android.resource://com.example.hondanaoyuki.basefragment/raw/voice")
            val uri = Uri.parse("android.resource://com.example.hondanaoyuki.basefragment/" + rId)
            mMediaPlayer!!.setDataSource(context!!, uri)
            mMediaPlayer!!.prepare()
            mMediaPlayer!!.start()
        } catch (e: IllegalArgumentException) {
            println(e)
        } catch (e: IOException) {
            println(e)
        }
    }

    fun stopSound() {
        if (mMediaPlayer == null) return

        try {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
        } catch (e: IllegalArgumentException) {
            println(e)
        } catch (e: IOException) {
            println(e)
        }
    }

    fun isPlaying(): Boolean {
        if (mMediaPlayer == null) {
            return false
        }
        return mMediaPlayer!!.isPlaying()
    }
}
