package com.ipath.hospitaldevice.ui.main

import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.contec.pm10.code.connect.ContecSdk
import com.ipath.hospitaldevice.R
import com.ipath.hospitaldevice.databinding.MainFragmentBinding
import com.ipath.hospitaldevice.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


@AndroidEntryPoint
class MainFragment : BaseFragment<MainFragmentBinding, MainVM>(), MainNavigator, CoroutineScope {
    private var sdk: ContecSdk? = null
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()
    private val mainVM: MainVM by viewModels()

    override fun getViewModel(): MainVM{
        mainVM.setNavigator(this)
        return mainVM
    }

    override fun setupToolBar() {
    }

    override fun setupUI() {
        sdk = ContecSdk(context)
        sdk!!.init(false)
    }

    override fun setupObserver() {
    }


    override fun getBindingVariable(): Int {
        return BR.mainVM
    }

    override fun getLayoutId(): Int {
        return R.layout.main_fragment
    }

    override fun onClicked() {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToPatientFragment())
    }


}