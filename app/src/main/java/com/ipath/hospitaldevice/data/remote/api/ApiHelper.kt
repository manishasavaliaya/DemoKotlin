package com.ipath.hospitaldevice.data.remote.api


import com.ipath.hospitaldevice.data.remote.api.ApiService
import com.ipath.hospitaldevice.data.remote.api.BaseDataSource
import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiService: ApiService) : BaseDataSource() {


}