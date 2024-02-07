package ardents.in.retrofitviewmodel.Repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import ardents.in.retrofitviewmodel.Network.RetrofitClient;
import ardents.in.retrofitviewmodel.models.Employee;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class employeeRepo {

    MutableLiveData<List<Employee>> Allemployeelist;
    List<Employee> employeeslist;

    public employeeRepo(Application application) {
        employeeslist=new ArrayList<>();
        Allemployeelist=new MutableLiveData<>();
    }

    public MutableLiveData<List<Employee>> getEmployeeApi() {
        RetrofitClient.getClient().getEmployee().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try{
                    if (response.isSuccessful()){
                        Log.d("getEmployeeApi","successfule"+response.body());
                        JsonObject jsonObject=response.body();
                        JsonArray data=jsonObject.getAsJsonArray("data");
                        for (int i=0;i<data.size();i++){
                            JsonObject jsonObject1=data.get(i).getAsJsonObject();
                            Employee employee=new Employee(
                                    jsonObject1.get("employee_name").getAsString(),
                                    jsonObject1.get("employee_salary").getAsString(),
                                    jsonObject1.get("id").getAsString(),
                                    jsonObject1.get("employee_age").getAsString()
                                    );
                            employeeslist.add(employee);

                        }
                    }

                }catch(Exception e){
                    Log.d("getEmployeeApi","Failed"+e.getMessage());
                }
                Allemployeelist.postValue(employeeslist);
                Log.d("getEmployeeApi","Allemployeelist"+Allemployeelist);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("getEmployeeApi","Failed"+t.getMessage());
            }
        });

        return Allemployeelist;
    }


}
