package com.example.basefragment

import android.os.Parcel
import android.os.Parcelable
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import android.widget.RemoteViews.RemoteView
import android.widget.LinearLayout as LinearLayout1

@RemoteView
public class BaseView() :  Parcelable {
    private val children = SparseArray<SparseArray<Any>>()

    constructor(parcel: Parcel) : this() {
       val s =1
    }
//
//    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
//
//    }
//
//    // FrameLayout と同じ引数でコンストラクターを作成
//    override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams) {
////        Log.d(Consts.LOG_TAG, "addView(View, int, ViewGroup.LayoutParams), " + "(" + child.getClass().getCanonicalName() + ", " + index + ")")
//        val sa = SparseArray<Any>(3)
//        sa.put(0, child)
//        sa.put(1, index)
//        sa.put(2, params)
//        children.put(child.getId(), sa)
//    }
//
//    fun attach(id: Int) {
////        Log.d(Consts.LOG_TAG, "attach(" + id + ")" + this.childCount)
//        removeAllViews()
//        val sa = children[id]
//        super.addView(sa[0] as View, (sa[1] as Int), sa[2] as LayoutParams)
//    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BaseView> {
        override fun createFromParcel(parcel: Parcel): BaseView {
            return BaseView(parcel)
        }

        override fun newArray(size: Int): Array<BaseView?> {
            return arrayOfNulls(size)
        }
    }
}