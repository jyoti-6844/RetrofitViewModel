package ardents.in.retrofitviewmodel.ViewModels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import ardents.in.retrofitviewmodel.Network.RetrofitClient;
import ardents.in.retrofitviewmodel.Repository.employeeRepo;
import ardents.in.retrofitviewmodel.models.Employee;
import retrofit2.Call;
import retrofit2.Callback;

public class EmployeeViewModel extends AndroidViewModel {
   private final employeeRepo repository;

    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        repository=new employeeRepo(application);
    }
    public MutableLiveData<List<Employee>> loadData(){
        return repository.getEmployeeApi();
    }
}
