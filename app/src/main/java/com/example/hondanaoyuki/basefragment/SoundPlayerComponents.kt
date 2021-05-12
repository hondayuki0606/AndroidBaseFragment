package com.example.hondanaoyuki.basefragment

import android.R
import android.content.Context
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.net.Uri


object SoundPlayerComponents {

    // MediaPlayer のインスタンス生成
    var mediaPlayer: MediaPlayer? = null

    var mOnCompletionListener = OnCompletionListener{
///        mediaPlayer!!.start()
    }
    
    fun startSound(context: Context?, rId: Int?, str: String?) {
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(context!!, rId!!)
            mediaPlayer!!.setOnCompletionListener(mOnCompletionListener)
        } else {
            mediaPlayer!!.reset()
            val uri = Uri.parse("android.resource://" + str + "/raw/voice")
//            val uri = Uri.parse("android.resource://" + str + "/" + rId)
            mediaPlayer!!.setDataSource(context!!, uri);
            mediaPlayer!!.prepare();
        }
        mediaPlayer!!.start()
    }

    fun stopSound()  {
        mediaPlayer!!.stop()
    }

    fun isPlaying(): Boolean {
        if(mediaPlayer == null) {
            return false
        }
        return mediaPlayer!!.isPlaying()
    }
}
