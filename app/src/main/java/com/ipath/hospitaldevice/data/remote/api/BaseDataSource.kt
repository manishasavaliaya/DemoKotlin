package com.ipath.hospitaldevice.data.remote.api


import com.feedup.data.remote.api.Resource

abstract class BaseDataSource {

    /**
     *  Below method used to convert response of api into model directly no need for manual parsing
     * */


    private fun <T> error(message: String): Resource<T> {
        return Resource.error(message)
    }

}