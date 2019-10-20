package com.example.avherramientasappmovil.Interface;

import com.example.avherramientasappmovil.Model.Banner;

import java.util.List;

public interface IBannerLoadListener {
    void onBannerLoadSucces(List<Banner> banners);
    void onBannerLoadFailed(String message);
}
