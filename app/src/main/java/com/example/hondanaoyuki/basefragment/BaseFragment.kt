package com.example.hondanaoyuki.basefragment


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


// Fragmentクラスを継承します
open class BaseFragment : Fragment() {

    fun replaceFragment(e: Int?, fragment:Fragment?){
        // FragmentManagerからFragmentTransactionを作成
        val fragmentManager: FragmentManager? = fragmentManager
        val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
        transaction.replace(e!!, fragment!!)
        transaction.addToBackStack(null)

        transaction.commit()
    }

}