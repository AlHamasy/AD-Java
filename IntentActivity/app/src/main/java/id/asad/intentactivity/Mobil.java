package id.asad.intentactivity;

import android.os.Parcel;
import android.os.Parcelable;

public class Mobil implements Parcelable {

    String merek;
    int tahun;
    double kilometer;
    char platnomor;
    boolean baru;

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public double getKilometer() {
        return kilometer;
    }

    public void setKilometer(double kilometer) {
        this.kilometer = kilometer;
    }

    public char getPlatnomor() {
        return platnomor;
    }

    public void setPlatnomor(char platnomor) {
        this.platnomor = platnomor;
    }

    public boolean isBaru() {
        return baru;
    }

    public void setBaru(boolean baru) {
        this.baru = baru;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.merek);
        dest.writeInt(this.tahun);
        dest.writeDouble(this.kilometer);
        dest.writeInt(this.platnomor);
        dest.writeByte(this.baru ? (byte) 1 : (byte) 0);
    }

    public Mobil() {
    }

    protected Mobil(Parcel in) {
        this.merek = in.readString();
        this.tahun = in.readInt();
        this.kilometer = in.readDouble();
        this.platnomor = (char) in.readInt();
        this.baru = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Mobil> CREATOR = new Parcelable.Creator<Mobil>() {
        @Override
        public Mobil createFromParcel(Parcel source) {
            return new Mobil(source);
        }

        @Override
        public Mobil[] newArray(int size) {
            return new Mobil[size];
        }
    };
}
