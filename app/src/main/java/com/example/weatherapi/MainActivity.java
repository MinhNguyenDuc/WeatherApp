package com.example.weatherapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHour;
    private TextView tvTem;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTem = (TextView)findViewById(R.id.tvTem);
        tvStatus = (TextView)findViewById(R.id.tvStatus);

        getHours();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rvHour = (RecyclerView)findViewById(R.id.rvHour);
        rvHour.setLayoutManager(layoutManager);
    }

    private void getHours() {
        Retrofit retrofit = new Retrofit().newBuilder()
                            .baseUrl(ApiManager.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create()).build();

        ApiManager service = retrofit.create(ApiManager.class);

        service.getHour().enqueue(new Callback<List<Weather>>() {
            @Override
            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {
                if(response.body() == null){
                    return;
                }

                List<Weather> listWeather = response.body();
                HourAdapter adapter = new HourAdapter(MainActivity.this, listWeather);
                rvHour.setAdapter(adapter);

                Weather weather = listWeather.get(0);
                tvTem.setText(weather.getTemperature().getValue().intValue()+"");
                tvStatus.setText(weather.getIconPhase());
            }

            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t) {

            }
        });
    }
}
