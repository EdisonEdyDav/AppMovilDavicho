package com.example.avherramientasappmovil.Interface;

import com.example.avherramientasappmovil.Model.Banner;

import java.util.List;

public interface ILookbookLoadListener {

    void onLookbookLoadSucces(List<Banner> banners);
    void onLookbookLoadFailed(String message);
}
