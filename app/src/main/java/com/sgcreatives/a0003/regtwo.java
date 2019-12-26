package com.sgcreatives.a0003;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

import java.util.HashMap;
import java.util.Map;

public class regtwo extends AppCompatActivity {
    ImageView top_curve,techsays;
    EditText projectfield, projectname, collegename,hodph;
    TextView nametxt, emailtxt, dobtxt,addresstxt, login_title;
    TextView logo;
    LinearLayout already_have_account_layout;
    CardView register_card;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regtwo);
        i=getIntent();
        top_curve = findViewById(R.id.top_curve);
        projectfield= findViewById(R.id.projectfield);
        nametxt = findViewById(R.id.nametxt);
        projectname = findViewById(R.id.projectname);
        emailtxt = findViewById(R.id.emailtxt);
        collegename = findViewById(R.id.collegename);
        dobtxt = findViewById(R.id.dobtxt);
        hodph = findViewById(R.id.hodph);
        addresstxt= findViewById(R.id.addresstxt);
//        logo = findViewById(R.id.logo);
        techsays = findViewById(R.id.techsays);
        already_have_account_layout = findViewById(R.id.already_have_account_text);
        register_card = findViewById(R.id.register_card);
        Animation top_curve_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.top_down);
        top_curve.startAnimation(top_curve_anim);
        Animation editText_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.edittext_anim);
        projectfield.startAnimation(editText_anim);
        projectname.startAnimation(editText_anim);
        collegename.startAnimation(editText_anim);
        hodph.startAnimation(editText_anim);
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


    public void registerButtonf(View view) {
        if (projectfield.getText().toString().isEmpty()||projectname.getText().toString().isEmpty()||collegename.getText().toString().isEmpty()||hodph.getText().toString().isEmpty()){
            Toast.makeText(this,"Empty Field",Toast.LENGTH_SHORT).show();
        }
        else
        {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://www.techsays.in/Techsaysofficialapp/Registration1.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
//If we are getting success from server
                            Toast.makeText(regtwo.this,response,Toast.LENGTH_LONG).show();
                            if(response.equals("Registration Successful"))
                            {
                                SharedPreferences sh=getSharedPreferences("reg",MODE_PRIVATE);
                                SharedPreferences.Editor e=sh.edit();
                                e.putBoolean("hi",true);
                                e.apply();
                                Intent in=new Intent(regtwo.this,MainActivity.class);
                                startActivity(in);
                            }

                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject json_obj = jsonArray.getJSONObject(i);
//ba = json_obj.getString("balance");
                                }
//Toast.makeText(Recharge.this, "your new balnce is "+ba, Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },

                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
//You can handle error here if you want
                        }

                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
//Adding parameters to request
params.put("sname",i.getStringExtra("name"));
params.put("semail",i.getStringExtra("email"));
params.put("phone",i.getStringExtra("phone"));
                    params.put("sdob",i.getStringExtra("dob"));
                    params.put("saddress",i.getStringExtra("address"));
                    params.put("pname",projectfield.getText().toString());
                    params.put("project",projectname.getText().toString());
                    params.put("cname",collegename.getText().toString());
                    params.put("hodph",hodph.getText().toString());

// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                    return params;
                }

            };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
            RequestQueue requestQueue = Volley.newRequestQueue(regtwo.this);
            requestQueue.add(stringRequest);
        }



    }
        }

