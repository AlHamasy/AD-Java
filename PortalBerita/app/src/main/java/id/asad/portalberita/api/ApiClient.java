package id.asad.portalberita.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static String BASE_URL = "http://192.168.43.117:8888/portal_berita/";
    public static String URL_IMAGE = BASE_URL + "image/";

    private static Retrofit retrofit = new Retrofit.Builder()
                                    .baseUrl(BASE_URL)
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();

    public static ApiService service = retrofit.create(ApiService.class);

}