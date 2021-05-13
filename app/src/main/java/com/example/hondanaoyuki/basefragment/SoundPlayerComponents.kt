package com.example.hondanaoyuki.basefragment

import android.content.Context
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.net.Uri
import java.io.IOException

object SoundPlayerComponents {


    const val PATH2 ="android.resource://com.example.hondanaoyuki.basefragment/raw/voice"
    const val PATH3 = "android.resource://com.example.hondanaoyuki.basefragment/"

    var mContext: Context? = null

    var mMediaPlayer: MediaPlayer? = null

    fun start(context: Context?, rId: Int?, onCompletionListener: OnCompletionListener?) {

        if (context == null || rId == null) return

        try {
            if (mMediaPlayer == null) {
                mContext = context
                mMediaPlayer = MediaPlayer()
                if(onCompletionListener != null) {
                    mMediaPlayer!!.setOnCompletionListener(onCompletionListener)
                }
            }
            mMediaPlayer!!.reset()
//            val uri = Uri.parse(PATH2)
            val uri = Uri.parse(PATH3 + rId)
            mMediaPlayer!!.setDataSource(mContext!!, uri)
            mMediaPlayer!!.prepare()
            mMediaPlayer!!.start()
        } catch (e: IllegalArgumentException) {
            println(e)
        } catch (e: IOException) {
            println(e)
        }
    }

    fun stop() {
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

    fun restart() {
        if (mMediaPlayer == null) return

        try {
            mMediaPlayer!!.start()
        } catch (e: IllegalArgumentException) {
            println(e)
        } catch (e: IOException) {
            println(e)
        }
    }

    fun pause() {
        if (mMediaPlayer == null) return

        try {
            mMediaPlayer!!.pause()
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
