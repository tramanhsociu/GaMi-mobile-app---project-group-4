package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ProfileSettingActivity extends AppCompatActivity {
    //private Spinner spinnerGioiTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting2);

//            this.spinnerGioiTinh = (Spinner) findViewById(R.id.spinner_gioitinh);
//
//            GioiTinh[] employees = GioiTinhDataUtils.getEmployees();
//
//            // (@resource) android.R.layout.simple_spinner_item:
//            //   The resource ID for a layout file containing a TextView to use when instantiating views.
//            //    (Layout for one ROW of Spinner)
//            ArrayAdapter<GioiTinh> adapter = new ArrayAdapter<GioiTinh>(this,
//                    android.R.layout.simple_spinner_item,
//                    employees);
//
//            // Layout for All ROWs of Spinner.  (Optional for ArrayAdapter).
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//            this.spinnerGioiTinh.setAdapter(adapter);
//
//            // When user select a List-Item.
//            this.spinnerGioiTinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//                @Override
//                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                    onItemSelectedHandler(parent, view, position, id);
//                }
//
//                @Override
//                public void onNothingSelected(AdapterView<?> parent) {
//
//                }
//            });
//        }
//
//
//        private void onItemSelectedHandler(AdapterView<?> adapterView, View view, int position, long id) {
//            Adapter adapter = adapterView.getAdapter();
//            GioiTinh employee = (GioiTinh) adapter.getItem(position);
//
//            Toast.makeText(getApplicationContext(), "Selected Employee: " + employee.getFullName() ,Toast.LENGTH_SHORT).show();
    }
}