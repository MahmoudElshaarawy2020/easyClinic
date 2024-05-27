package views.patientViews.doctor_data

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.clinic.api.ApiManager
import com.example.clinic.api.models.patient_doctor_data.DoctorItem
import com.example.clinic.api.models.patient_doctor_data.PatientDoctorDataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DoctorDataViewModel : ViewModel() {

    var listOfDoctors = mutableListOf<DoctorItem>()

    fun getDoctorsData(){
        ApiManager.getService()
            .getAllDoctorAvaliable("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY2NTFjNzBkODA4ZTJhNTk5NzJjY2JhZCIsInJvbGUiOiJQYXRpZW50IiwiaWF0IjoxNzE2NjM1NDI5fQ.mFYPgBco_0ZiHqJCOIULHcyXjvrEO7I_-6pnhlCJh5I")
            .enqueue(object : Callback<PatientDoctorDataResponse> {
                override fun onResponse(
                    call: Call<PatientDoctorDataResponse>,
                    response: Response<PatientDoctorDataResponse>
                ) {
                    if (response.isSuccessful && response.body()!!.doctor!!.isNotEmpty()) {
                        val NullList = response.body()?.doctor!!
                        val nonNullList = NullList.filterNotNull()
                        listOfDoctors.addAll(nonNullList)
                    }
                }

                override fun onFailure(call: Call<PatientDoctorDataResponse>, t: Throwable) {
                    Log.e("TAG", "onFailure: $t")
                }

            })
    }
}