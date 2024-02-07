package ardents.in.retrofitviewmodel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ardents.in.retrofitviewmodel.databinding.EmployeeLayBinding;
import ardents.in.retrofitviewmodel.models.Employee;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    List<Employee> employeeList;
    Context context;

    public EmployeeAdapter(List<Employee> employeeList, Context context) {
        this.employeeList = employeeList;
        this.context = context;
    }

    public void updateEmployeeList(List<Employee> list){
        this.employeeList =list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        EmployeeLayBinding binding=EmployeeLayBinding.inflate(layoutInflater,parent,false);
        ViewHolder viewHolder=new ViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.id.setText(employeeList.get(position).getId());
        holder.binding.name.setText(employeeList.get(position).getEmployeeName());
        holder.binding.salary.setText(employeeList.get(position).getEmployeeSalary());
        holder.binding.age.setText(employeeList.get(position).getEmployeeAge());

    }

    @Override
    public int getItemCount() {
        if (this.employeeList !=null){
            return this.employeeList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EmployeeLayBinding binding;
        public ViewHolder(@NonNull EmployeeLayBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
