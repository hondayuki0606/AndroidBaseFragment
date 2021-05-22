package com.example.basefragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

open class BaseFragment : Fragment() {

    fun replaceFragment(resId: Int?, fragment:Fragment?) {
        val fragmentManager: FragmentManager? = fragmentManager
        val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
        transaction.replace(resId!!, fragment!!)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}