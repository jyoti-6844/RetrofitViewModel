package ardents.in.retrofitviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import java.util.List;

import ardents.in.retrofitviewmodel.ViewModels.EmployeeViewModel;
import ardents.in.retrofitviewmodel.adapter.EmployeeAdapter;
import ardents.in.retrofitviewmodel.databinding.ActivityMainBinding;
import ardents.in.retrofitviewmodel.models.Employee;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    EmployeeAdapter adapter;
    EmployeeViewModel viewModel;
    List<Employee> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter=new EmployeeAdapter(employeeList,MainActivity.this);
        binding.employeeRecycler.setAdapter(adapter);

        viewModel= ViewModelProviders.of(this).get(EmployeeViewModel.class);
        viewModel.loadData().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                if (employees!=null){
                    employeeList=employees;
                    adapter.updateEmployeeList(employeeList);
                }
            }
        });
    }
}