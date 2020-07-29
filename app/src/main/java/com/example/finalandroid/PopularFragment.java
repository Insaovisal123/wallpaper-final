package com.example.finalandroid;

import android.app.MediaRouteButton;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PopularFragment extends Fragment {
    private RecyclerView recyclerView;
    private ImageAdapter imageAdapter;
    private List<Image> imageList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popular_fragment, container, false);
        recyclerView = view.findViewById(R.id.img_view_popular);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        imageAdapter = new ImageAdapter(imageList);
        loadList();
        Log.i("ee" ,"work");

        recyclerView.setAdapter(imageAdapter);
        return view;
    }

    private void loadList() {
        String url = "https://my-json-server.typicode.com/Insaovisal123/image-api/images";
        //creating a string request to send request to the url
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Log.e("kk", response);
                        // Refresh Data
                        recyclerView.setAdapter( new ImageAdapter (Arrays.asList(new Gson().fromJson(response, Image[].class))));
//                        MediaRouteButton recyclerView = null;
                        recyclerView.setVisibility(View.VISIBLE);
                    }
                    //Initialize
                    private Object findViewById(int recyclerView) {
                        return recyclerView;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("kk", "" + error.toString());
                        //displaying the error in toast if occurred
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        //adding the string request to request queue
        MyApplication.getInstance().addToRequestQueue(request);
    }
}
