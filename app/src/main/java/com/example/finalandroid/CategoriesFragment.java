package com.example.finalandroid;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriesFragment extends Fragment {
    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private List<Category> categoryList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categories_fragment, container, false);
        recyclerView = view.findViewById(R.id.img_view_category);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        categoryAdapter = new CategoryAdapter(categoryList);
        loadList();
        Log.i("ee" ,"work");

        recyclerView.setAdapter(categoryAdapter);
        return view;
    }

    private void loadList() {
        String url = "https://my-json-server.typicode.com/Insaovisal123/image-api/categories";
        //creating a string request to send request to the url
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Refresh Data
                        recyclerView.setAdapter( new CategoryAdapter(Arrays.asList(new Gson().fromJson(response, Category[].class))));
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
