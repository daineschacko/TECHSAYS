package com.sgcreatives.a0003;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {
    private DatePicker datePicker;

    private TextView dateView;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    ImageView top_curve,techsays;
    EditText name, email, dob,address;
    TextView nametxt, emailtxt, dobtxt,addresstxt, login_title;
    TextView logo;
    String ph;
    LinearLayout already_have_account_layout;
    CardView register_card;
Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        i=getIntent();
        ph=i.getStringExtra("phonevo");
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        dob = findViewById(R.id.dob);
       dob.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               datePickerDialog = new DatePickerDialog(Registration.this,
                       new DatePickerDialog.OnDateSetListener() {
                           @Override
                           public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                               dob.setText(day + "/" + (month + 0) + "/" + year);
                           }
                       }, year, month, dayOfMonth);
              // datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
               datePickerDialog.show();
           }
       });

        top_curve = findViewById(R.id.top_curve);
        name = findViewById(R.id.name);
        nametxt = findViewById(R.id.nametxt);
        email = findViewById(R.id.email);
        emailtxt = findViewById(R.id.emailtxt);

        dobtxt = findViewById(R.id.dobtxt);
        address = findViewById(R.id.address);
        addresstxt= findViewById(R.id.addresstxt);
//        logo = findViewById(R.id.logo);
        techsays = findViewById(R.id.techsays);
        already_have_account_layout = findViewById(R.id.already_have_account_text);
        register_card = findViewById(R.id.register_card);
        Animation top_curve_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.top_down);
        top_curve.startAnimation(top_curve_anim);

        Animation editText_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.edittext_anim);
        name.startAnimation(editText_anim);
        email.startAnimation(editText_anim);
        dob.startAnimation(editText_anim);
        address.startAnimation(editText_anim);

        Animation field_name_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.field_name_anim);
        nametxt.startAnimation(field_name_anim);
        emailtxt.startAnimation(field_name_anim);
        dobtxt.startAnimation(field_name_anim);
        techsays.startAnimation(field_name_anim);
        addresstxt.startAnimation(field_name_anim);

        Animation center_reveal_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.center_reveal_anim);
        register_card.startAnimation(center_reveal_anim);

        Animation new_user_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down_top);
        already_have_account_layout.startAnimation(new_user_anim);

    }
//    String emailPattern = "@gmail.com";

    public void registerButton(View view) {
        if (name.getText().toString().isEmpty()||email.getText().toString().isEmpty()||dob.getText().toString().isEmpty()||address.getText().toString().isEmpty()){
          name.setError("Empty Field");
        }
//        else if (email.getText().toString().trim().matches("@gmail.com")){
//            Toast.makeText(this,"Enter Valid Email",Toast.LENGTH_SHORT).show();
//
//
//        }
        else
            {
                Intent i=new Intent(getApplicationContext(),regtwo.class);
                i.putExtra("name",name.getText().toString());
                i.putExtra("email",email.getText().toString());
                i.putExtra("dob",dob.getText().toString());
                i.putExtra("address",address.getText().toString());
                i.putExtra("phone",ph);
            startActivity(i);
            }

    }


}
//




