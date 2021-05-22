package com.example.basefragment.fragment

// 下位のバージョンにも対応させる場合はsupport-v4パッケージを使用します
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basefragment.BaseFragment
import com.example.basefragment.R


// Fragmentクラスを継承します
class ThirdFragment : BaseFragment() {
    // Fragmentで表示するViewを作成するメソッド
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        // 先ほどのレイアウトをここでViewとして作成します
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

}