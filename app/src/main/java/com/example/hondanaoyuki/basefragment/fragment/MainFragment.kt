package com.example.hondanaoyuki.basefragment.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.hondanaoyuki.basefragment.BaseFragment
import com.example.hondanaoyuki.basefragment.R

class MainFragment : BaseFragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firstButton: Button = view.findViewById(R.id.first_button)
        firstButton.setOnClickListener { _ ->
            replaceFragment(R.id.fragment_container, FirstFragment())
        }
        val secondButton: Button = view.findViewById(R.id.second_button)
        secondButton.setOnClickListener { _ ->
            replaceFragment(R.id.fragment_container, SecondFragment())
        }
        val thirdButton: Button = view.findViewById(R.id.third_button)
        thirdButton.setOnClickListener { _ ->
            replaceFragment(R.id.fragment_container, ThirdFragment())
        }
    }
}