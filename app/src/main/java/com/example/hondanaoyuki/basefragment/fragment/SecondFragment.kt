package com.example.basefragment.fragment

// 下位のバージョンにも対応させる場合はsupport-v4パッケージを使用します
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.basefragment.BaseFragment
import com.example.basefragment.R

// Fragmentクラスを継承します
class SecondFragment : BaseFragment() {
    // Fragmentで表示するViewを作成するメソッド
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        // 先ほどのレイアウトをここでViewとして作成します
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.secondButton)
        val a: Context = requireContext()
        button.setOnClickListener { _ ->
            replaceFragment(R.id.fragment_container, ThirdFragment())
        }

    }

}