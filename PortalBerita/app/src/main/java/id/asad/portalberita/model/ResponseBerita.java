package id.asad.portalberita.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseBerita{

	@SerializedName("data_berita")
	private List<DataBeritaItem> dataBerita;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setDataBerita(List<DataBeritaItem> dataBerita){
		this.dataBerita = dataBerita;
	}

	public List<DataBeritaItem> getDataBerita(){
		return dataBerita;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}