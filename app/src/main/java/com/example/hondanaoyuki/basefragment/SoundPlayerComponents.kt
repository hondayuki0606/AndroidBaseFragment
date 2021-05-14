package com.example.hondanaoyuki.basefragment

import android.content.Context
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

    var mContext: Context? = null

    private var mMediaPlayer: MediaPlayer? = null

    private var mOnCompletionListener: OnCompletionListener? = null

    fun start(rId: Int?) {

        if (mContext == null || rId == null) return

        try {

                if(mOnCompletionListener != null) {
                    mMediaPlayer!!.setOnCompletionListener(mOnCompletionListener)
                }

            mMediaPlayer!!.reset()
            mMediaPlayer!!.setDataSource(mContext!!, Uri.parse(PATH3 + rId))
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
        if (mContext == null || mMediaPlayer == null) return

        try {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
            mOnCompletionListener = null
        } catch (e: IllegalArgumentException) {
            println(e)
        }
    }

    fun restart() {
        if (mContext == null || mMediaPlayer == null) return

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

    init {
        mMediaPlayer = MediaPlayer()
        mContext = App.getAppContext()
    }
}
