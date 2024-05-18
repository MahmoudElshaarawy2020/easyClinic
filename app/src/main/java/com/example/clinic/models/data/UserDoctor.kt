package com.example.clinic.models.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class UserDoctor ():Parcelable{
    companion object{
        var id : String? = ""
    }
}