package ie.wit.ufopedia.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UfoModel(var id: Long = 0,
                          var title: String = "",
                          var description: String = "") : Parcelable