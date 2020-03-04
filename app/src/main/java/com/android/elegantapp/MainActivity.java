package com.android.elegantapp;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.elegantapp.adapter.HotelAdapter;
import com.android.elegantapp.api.ApiClient;
import com.android.elegantapp.api.ApiInterface;
import com.android.elegantapp.modal.Hotel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity  {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView listView;
    private ArrayList<Hotel> hotelList;
    private HotelAdapter hotelAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
       // hotelList = new ArrayList<>();
        getJSONResponse();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", hotelList.get(position).getLatitude(), hotelList.get(position).getLongitude());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
    }

    /**
     * fetches json
     */
    private void getJSONResponse(){

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        String content_type = "application/json";

        Call<String> call = apiInterface.getJsonString( content_type);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i(">>>Responsestring", ">>>"+response.body().toString());

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();
                        writeListView(jsonresponse);

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");
                        //Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }

    private void writeListView(String response){

        try {
            //getting the whole json object from the response
            JSONObject obj = new JSONObject(response);
            if(obj.optInt("status")== 200){

                hotelList = new ArrayList<>();
                JSONArray dataArray  = obj.getJSONArray("data");

                for (int i = 0; i < dataArray.length(); i++) {

                    Hotel hotel = new Hotel();
                    JSONObject dataobj = dataArray.getJSONObject(i);

                    hotel.setTitle(dataobj.getString("title"));
                    hotel.setAddress(dataobj.getString("address"));
                    hotel.setLatitude(dataobj.getString("latitude"));
                    hotel.setLongitude(dataobj.getString("longitude"));

                    JSONObject imgObj = dataobj.getJSONObject("image");

                    hotel.setImgURLsmall(imgObj.getString("small"));
                    hotel.setImgURLmedium(imgObj.getString("medium"));
                    hotel.setImgURLlarge(imgObj.getString("large"));

                    hotelList.add(hotel);

                }

                hotelAdapter = new HotelAdapter(this, hotelList);
                listView.setAdapter(hotelAdapter);

            }else {
                Toast.makeText(MainActivity.this, obj.optString("message")+"", Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}

