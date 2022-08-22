
package com.ipath.hospitaldevice.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel<*>> : Fragment(),
    FragmentListener {

    var viewDataBinding: T? = null
    private var rootView: View? = null
    var mViewModel: V? = null
    var isMapFragment = false

    /**
     *  Override below method for set view model instance
     * */
    abstract fun getViewModel(): V

    /**
     *  Override below method for set binding variable
     * */
    abstract fun getBindingVariable(): Int

    /**
     * Override below method for set layout id
     * */
    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun setupUI()
    abstract fun setupObserver()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        rootView = viewDataBinding?.root
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //(requireActivity() as BaseActivity).hideNavigationIcon()
        setupObserver()
        setupUI()
        mViewModel = getViewModel()
        viewDataBinding?.setVariable(getBindingVariable(), mViewModel)
        viewDataBinding?.lifecycleOwner = this;
        viewDataBinding?.executePendingBindings()

        setupToolBar()
    }

}

interface FragmentListener {
    fun setupToolBar()
}