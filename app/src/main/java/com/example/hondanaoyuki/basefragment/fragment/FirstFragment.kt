package com.example.basefragment.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.basefragment.BaseFragment
import com.example.basefragment.R

class FirstFragment : BaseFragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val button: Button = view.findViewById(R.id.secondButton)
//        button.setOnClickListener { _ ->
//            replaceFragment(R.id.fragment_container, ThirdFragment())
//        }
    }
}