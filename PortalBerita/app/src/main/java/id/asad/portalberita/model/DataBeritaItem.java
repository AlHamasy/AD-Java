package id.asad.portalberita.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DataBeritaItem implements Parcelable {

	@SerializedName("penulis_berita")
	private String penulisBerita;

	@SerializedName("image_berita")
	private String imageBerita;

	@SerializedName("id_berita")
	private String idBerita;

	@SerializedName("judul_berita")
	private String judulBerita;

	@SerializedName("isi_berita")
	private String isiBerita;

	public void setPenulisBerita(String penulisBerita){
		this.penulisBerita = penulisBerita;
	}

	public String getPenulisBerita(){
		return penulisBerita;
	}

	public void setImageBerita(String imageBerita){
		this.imageBerita = imageBerita;
	}

	public String getImageBerita(){
		return imageBerita;
	}

	public void setIdBerita(String idBerita){
		this.idBerita = idBerita;
	}

	public String getIdBerita(){
		return idBerita;
	}

	public void setJudulBerita(String judulBerita){
		this.judulBerita = judulBerita;
	}

	public String getJudulBerita(){
		return judulBerita;
	}

	public void setIsiBerita(String isiBerita){
		this.isiBerita = isiBerita;
	}

	public String getIsiBerita(){
		return isiBerita;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.penulisBerita);
		dest.writeString(this.imageBerita);
		dest.writeString(this.idBerita);
		dest.writeString(this.judulBerita);
		dest.writeString(this.isiBerita);
	}

	public DataBeritaItem() {
	}

	protected DataBeritaItem(Parcel in) {
		this.penulisBerita = in.readString();
		this.imageBerita = in.readString();
		this.idBerita = in.readString();
		this.judulBerita = in.readString();
		this.isiBerita = in.readString();
	}

	public static final Parcelable.Creator<DataBeritaItem> CREATOR = new Parcelable.Creator<DataBeritaItem>() {
		@Override
		public DataBeritaItem createFromParcel(Parcel source) {
			return new DataBeritaItem(source);
		}

		@Override
		public DataBeritaItem[] newArray(int size) {
			return new DataBeritaItem[size];
		}
	};
}