package model

import android.os.Parcel
import android.os.Parcelable
import java.util.jar.Attributes

class person (
    val Name: String? = null,
    val Address: String? = null,
    val Number: String? = null,
    val Gender: String? = null
    ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Name)
        parcel.writeString(Address)
        parcel.writeString(Number)
        parcel.writeString(Gender)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<person> {
        override fun createFromParcel(parcel: Parcel): person {
            return person(parcel)
        }

        override fun newArray(size: Int): Array<person?> {
            return arrayOfNulls(size)
        }
    }
    override fun toString(): String {
        return Name!!;
    }
}


