package com.feedup.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("mobile_number", alternate = ["phone_number"]) var mobileNumber: String = "",
    @SerializedName("profile") var profile: String = "",
    @SerializedName("address") var address: String = "",
    @SerializedName("email") var email: String = "",
    @SerializedName("name") var name: String = "",
    @SerializedName("token") var token: String = "",
    @SerializedName("about_us_url") var about_us_url: String = "",
    @SerializedName("terms_condition_url") var terms_condition_url: String = "",
    @SerializedName("mail_verify_otp") var mailVerifyOtp: String = ""
) : Parcelable

@Parcelize
data class User(
    @SerializedName("user") var user: UserModel = UserModel(),
) : Parcelable