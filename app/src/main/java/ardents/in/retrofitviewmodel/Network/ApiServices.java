package ardents.in.retrofitviewmodel.Network;

import com.google.gson.JsonObject;

import java.util.List;

import ardents.in.retrofitviewmodel.models.Employee;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("employees")
    Call<JsonObject> getEmployee();
}
