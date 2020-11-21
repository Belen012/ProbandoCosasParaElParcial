package probando.cosas.manejo.datos;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Plato implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private Long id;



    public  Plato(){  }

    public Plato(Long id){ this.id= id; }

    public Long getId() {return id; }

    public void setId(Long id) {this.id = id; }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
    }

    protected Plato(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
    }

    public static final Creator<Plato> CREATOR = new Creator<Plato>() {
        @Override
        public Plato createFromParcel(Parcel in) { return new Plato(in);}

        @Override
        public Plato[] newArray(int size) { return new Plato[size]; }
    };
}
