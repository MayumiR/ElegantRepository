package com.android.elegantapp.modal;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rashmi on 04/03/20.
 */

public class Hotel {
    private String title, address, latitude, longitude, imgURLsmall, imgURLmedium, imgURLlarge;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getImgURLsmall() {
        return imgURLsmall;
    }

    public void setImgURLsmall(String imgURLsmall) {
        this.imgURLsmall = imgURLsmall;
    }

    public String getImgURLmedium() {
        return imgURLmedium;
    }

    public void setImgURLmedium(String imgURLmedium) {
        this.imgURLmedium = imgURLmedium;
    }

    public String getImgURLlarge() {
        return imgURLlarge;
    }

    public void setImgURLlarge(String imgURLlarge) {
        this.imgURLlarge = imgURLlarge;
    }
}
