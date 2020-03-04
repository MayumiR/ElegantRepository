package com.android.elegantapp.modal.apimodal;

import com.android.elegantapp.modal.Hotel;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ReadJson {

    @SerializedName("status")
    private int Status;
    @SerializedName("data")
    private List<Hotel> hotels;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}
