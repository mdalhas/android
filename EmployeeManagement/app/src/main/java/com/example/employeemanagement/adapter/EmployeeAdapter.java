package com.example.employeemanagement.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeemanagement.R;
import com.example.employeemanagement.model.EmployeeModel;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>{

    private List<EmployeeModel> employeelist;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, email, cellNo, gender, department, joiningDate;
        public Button empBtnEdit, empBtnDelete;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.empName);
            email = view.findViewById(R.id.empEmail);
            cellNo = view.findViewById(R.id.empCell);
            gender = view.findViewById(R.id.empGender);
            department = view.findViewById(R.id.empDepartment);
            joiningDate = view.findViewById(R.id.empJoiningDate);
            empBtnDelete =view.findViewById(R.id.empBtnDelete);
            empBtnEdit = view.findViewById(R.id.empBtnEdit);


        }
    }

    public EmployeeAdapter(List<EmployeeModel> employeeList) {
        this.employeelist = employeeList;
    }


    @NonNull
    @Override
    public EmployeeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.MyViewHolder holder, int position) {

        EmployeeModel employee = employeelist.get(position);
        holder.name.setText(employee.getName());
        holder.email.setText(employee.getEmail());
        holder.cellNo.setText(employee.getCellNo());
        holder.gender.setText(employee.getGender());
        holder.department.setText(employee.getDepartment());
        holder.joiningDate.setText(employee.getJoiningDate());


    }

    @Override
    public int getItemCount() {
        return employeelist.size();
    }
}
