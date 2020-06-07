package com.np.notepad.fragment

import android.view.LayoutInflater
import android.view.View
import com.np.notepad.R
import com.np.notepad.base.BaseFragment
import com.np.notepad.databinding.FragmentContentLayoutBinding
import com.np.notepad.databinding.TopbarRightViewLayoutBinding
import com.np.notepad.util.LoggerUtils

class ContentFragment: BaseFragment() {
    //绑定XML布局文件
    private lateinit var binding: FragmentContentLayoutBinding

    override fun onCreateView(): View {
        binding = FragmentContentLayoutBinding.inflate(LayoutInflater.from(activity), null, false)
        initTopBar()
        if (arguments != null) {
            LoggerUtils.i(arguments.toString())
        }
        return binding.root
    }

    /**
     * 初始化bar
     */
    private fun initTopBar() {
        binding.topbar.addLeftBackImageButton()
            .setOnClickListener { popBackStack() }
        binding.topbar.setTitle("")
        //bar右边view
        val inflate = TopbarRightViewLayoutBinding.inflate(layoutInflater)
        binding.topbar.addRightView(
            inflate.root,
            R.id.topbar_right_view)
    }

    override fun translucentFull(): Boolean = true
}