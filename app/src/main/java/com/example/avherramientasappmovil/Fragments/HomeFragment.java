package com.example.avherramientasappmovil.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.avherramientasappmovil.Adapter.HomeSliderAdapter;
import com.example.avherramientasappmovil.Adapter.LookbookAdapter;
import com.example.avherramientasappmovil.Common.Common;
import com.example.avherramientasappmovil.HistorialActivity;
import com.example.avherramientasappmovil.Interface.IBannerLoadListener;
import com.example.avherramientasappmovil.Interface.ILookbookLoadListener;
import com.example.avherramientasappmovil.MisHerramientasActivity;
import com.example.avherramientasappmovil.Model.Banner;
import com.example.avherramientasappmovil.PedidosActivity;
import com.example.avherramientasappmovil.R;
import com.example.avherramientasappmovil.ReservaActivity;
import com.example.avherramientasappmovil.Service.PicassoImageLoadingService;
import com.facebook.accountkit.AccountKit;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ss.com.bannerslider.Slider;


public class HomeFragment extends Fragment implements IBannerLoadListener, ILookbookLoadListener {

    private Unbinder unbinder;

    @BindView(R.id.layout_user_information)
    LinearLayout layout_user_information;
    @BindView(R.id.txt_user_name)
    TextView txt_user_name;
    @BindView(R.id.banner_slider)
    Slider banner_slider;
    @BindView(R.id.recycler_look_book)
    RecyclerView recycler_look_book;


    @OnClick(R.id.card_view_pedidos)
        void booking() {

        startActivity(new Intent(getActivity(), PedidosActivity.class));
    }

    @OnClick(R.id.card_view_Historial)
    void nextHistorial() {

        startActivity(new Intent(getActivity(), HistorialActivity.class));
    }














    //Firestoreee

    CollectionReference bannerRef,lookbookRef;

    //Interface

    IBannerLoadListener iBannerLoadListener;
    ILookbookLoadListener iLookbookLoadListener;



    public HomeFragment() {
        bannerRef= FirebaseFirestore.getInstance().collection("Banner");
        lookbookRef= FirebaseFirestore.getInstance().collection("Lookbook");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        unbinder= ButterKnife.bind(this,view);

        //Init

        Slider.init(new PicassoImageLoadingService());
        iBannerLoadListener=this;
        iLookbookLoadListener=this;


        //Check is logged

        if(AccountKit.getCurrentAccessToken() != null){
            setUserInformation();
            loadBanner();
            loadLookBook();
        }



        return view;

    }

    private void loadLookBook() {

        lookbookRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        List<Banner> lookbooks = new ArrayList<>();
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot bannerSnapShot:task.getResult()){
                                Banner banner= bannerSnapShot.toObject(Banner.class);
                                lookbooks.add(banner);
                            }
                            iLookbookLoadListener.onLookbookLoadSucces(lookbooks);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                iLookbookLoadListener.onLookbookLoadFailed(e.getMessage());

            }
        });

    }

    private void loadBanner() {
        bannerRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        List<Banner> banners = new ArrayList<>();
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot bannerSnapShot:task.getResult()){
                                Banner banner= bannerSnapShot.toObject(Banner.class);
                                banners.add(banner);
                            }
                            iBannerLoadListener.onBannerLoadSucces(banners);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                iBannerLoadListener.onBannerLoadFailed(e.getMessage());

            }
        });

    }

    private void setUserInformation() {
        layout_user_information.setVisibility(View.VISIBLE);
        txt_user_name.setText(Common.currentUser.getNombre());
    }

    @Override
    public void onBannerLoadSucces(List<Banner> banners) {
        banner_slider.setAdapter(new HomeSliderAdapter(banners));

    }

    @Override
    public void onBannerLoadFailed(String message) {
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLookbookLoadSucces(List<Banner> banners) {

        recycler_look_book.setHasFixedSize(true);
        recycler_look_book.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_look_book.setAdapter(new LookbookAdapter(getActivity(),banners));



    }

    @Override
    public void onLookbookLoadFailed(String message) {
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();

    }
}
