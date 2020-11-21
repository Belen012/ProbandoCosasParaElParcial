package probando.cosas;

import android.os.Parcel;
import android.os.Parcelable;

public class FlorParcelable implements Parcelable {

    private String nombre;

    public FlorParcelable(){    }

    public FlorParcelable(String nombre){ this.nombre = nombre;  }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    protected FlorParcelable(Parcel in) {
        this.nombre = in.readString();
    }

    public static final Creator<FlorParcelable> CREATOR = new Creator<FlorParcelable>() {
        @Override
        public FlorParcelable createFromParcel(Parcel in) {
            return new FlorParcelable(in);
        }

        @Override
        public FlorParcelable[] newArray(int size) {
            return new FlorParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
    }
}
