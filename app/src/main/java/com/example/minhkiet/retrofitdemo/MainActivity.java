package com.example.minhkiet.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.minhkiet.retrofitdemo.model.Contact;
import com.example.minhkiet.retrofitdemo.model.ContactResponse;
import com.example.minhkiet.retrofitdemo.service.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Button btnGetData;

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetData = (Button) findViewById(R.id.btn_get_data);
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("");
                getData();
            }
        });

        tvResult = (TextView) findViewById(R.id.tv_result);
    }

    private void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.androidhive.info/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        Call<ContactResponse> call = service.getContactList();

        call.enqueue(new Callback<ContactResponse>() {
            @Override
            public void onResponse(Call<ContactResponse> call, Response<ContactResponse> response) {
                ContactResponse contactResponse= response.body();

                showResult((ArrayList<Contact>) contactResponse.getContacts());
            }

            @Override
            public void onFailure(Call<ContactResponse> call, Throwable t) {
                Log.d(getClass().getSimpleName(), "fail");
            }
        });
    }

    private void showResult(ArrayList<Contact> contacts) {
        String result = "";
        for (Contact contact : contacts) {
            result += contact.getName() + "\n";
        }
        tvResult.setText(result);
    }
}
