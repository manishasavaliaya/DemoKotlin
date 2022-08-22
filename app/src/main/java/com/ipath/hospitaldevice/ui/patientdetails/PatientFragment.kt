package com.ipath.hospitaldevice.ui.patientdetails

import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import com.ipath.hospitaldevice.R
import com.ipath.hospitaldevice.databinding.MainFragmentBinding
import com.ipath.hospitaldevice.base.BaseFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


class PatientFragment : BaseFragment<MainFragmentBinding, PatientVM>(), PatientNavigator, CoroutineScope {

    private val patientVM: PatientVM by viewModels()

    override fun getViewModel(): PatientVM{
        patientVM.setNavigator(this)
        return patientVM
    }
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()


    override fun setupToolBar() {

    }

    override fun getBindingVariable(): Int {
        return BR.pfragment
    }

    override fun getLayoutId(): Int {
       return R.layout.patient_fragment
    }

    override fun setupUI() {

    }

    override fun setupObserver() {

    }

    override fun onEventClicked() {
//        findNavController().navigate(WelcomeFragmentDirections.Fragment_to_patientFragment)
    }
}