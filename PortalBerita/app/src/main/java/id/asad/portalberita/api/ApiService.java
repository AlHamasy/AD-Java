package id.asad.portalberita.api;

import id.asad.portalberita.model.ResponseBerita;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("lihat_berita.php")
    Call<ResponseBerita> getDataBerita(@Query("table") String tableName);

}
