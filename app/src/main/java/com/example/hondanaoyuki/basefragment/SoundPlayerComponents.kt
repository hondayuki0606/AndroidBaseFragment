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

    var mOnCompletionListener: OnCompletionListener? = null

    fun start(rId: Int?) {

        if (mContext == null || rId == null) return

        try {
            if (mMediaPlayer == null) {
                mMediaPlayer = MediaPlayer()
                if(mOnCompletionListener != null) {
                    mMediaPlayer!!.setOnCompletionListener(mOnCompletionListener)
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
        if (mContext == null || mMediaPlayer == null) return

        try {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
            mOnCompletionListener = null
        } catch (e: IllegalArgumentException) {
            println(e)
        } catch (e: IOException) {
            println(e)
        }
    }

    fun restart() {
        if (mContext == null || mMediaPlayer == null) return

        try {
            mMediaPlayer!!.start()
        } catch (e: IllegalArgumentException) {
            println(e)
        } catch (e: IOException) {
            println(e)
        }
    }

    fun pause() {
        if (mContext == null || mMediaPlayer == null) return

        try {
            mMediaPlayer!!.pause()
        } catch (e: IllegalArgumentException) {
            println(e)
        } catch (e: IOException) {
            println(e)
        }
    }

    fun isPlaying(): Boolean {
        if (mContext == null || mMediaPlayer == null) {
            return false
        }
        return mMediaPlayer!!.isPlaying()
    }
}
