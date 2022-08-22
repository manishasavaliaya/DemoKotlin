package com.feedup.data.remote.api

data class Resource<out T>(val status: Status, val data: T?, val message: String?,var accessToken:String="") {
    companion object {
        fun <T> success(data: T, msg: String = "",accessToken:String=""): Resource<T> {
            return Resource(Status.SUCCESS, data, msg,accessToken)
        }

        fun <T> error(msg: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }

}
enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}