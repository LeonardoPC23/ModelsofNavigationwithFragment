package devf.leonardo.modelsofnavigationwithfragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import devf.leonardo.modelsofnavigationwithfragment.R;
import devf.leonardo.modelsofnavigationwithfragment.domain.Udacity;
import devf.leonardo.modelsofnavigationwithfragment.io.ApiClient;
import devf.leonardo.modelsofnavigationwithfragment.io.adapter.MyAdapterRecycler;
import devf.leonardo.modelsofnavigationwithfragment.io.adapter.MyOnItemClickListener;
import devf.leonardo.modelsofnavigationwithfragment.io.model.ShowCourseResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by LEONARDO on 24/09/2015.
 */
public class FragmentCourse extends Fragment implements AdapterView.OnClickListener, MyOnItemClickListener,SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout refreshLayout;
    ListView myListView;
    private ArrayList<Udacity> myListaArtist;
    MyAdapterRecycler adapterRecyclerView;
    RecyclerView recyclerView;
    FragmentCourse fragmentCourse;
    Context context;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context=context;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_course, container, false);




        return view;
    }

//vista inflada metodo
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        refreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);
        recyclerView=(RecyclerView)view.findViewById(R.id.myRecyclerView);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext() ,LinearLayoutManager.VERTICAL,false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterRecyclerView = new MyAdapterRecycler(getContext(),createCourse());
        recyclerView.setAdapter(adapterRecyclerView);
        refreshLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                refreshLayout.setRefreshing(true);
                refreshLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        refreshLayout.setOnRefreshListener(this);


    }

    @Override
    public void onResume() {
        super.onResume();
        executeWithRetrofit();
    }

    public void executeWithRetrofit() {
        ApiClient.showCourse(new Callback<ShowCourseResponse>() {
            @Override
            public void success(ShowCourseResponse showCourseResponse, Response response) {
                List<Udacity> courses = showCourseResponse.getUdaCity();
                adapterRecyclerView.setData(courses);
                refreshLayout.setRefreshing(false);


            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


    private List<Udacity> createCourse() {
        myListaArtist = new ArrayList<>();
        myListaArtist.add(new Udacity());
        return myListaArtist;
    }


    @Override
    public void onItemClick(int position) {
        Toast.makeText(context,myListaArtist.get(position).getTitle().toString(),Toast.LENGTH_SHORT).show();   }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onRefresh() {


        onItemsLoadComplete();
    }

    private void onItemsLoadComplete() {
       executeWithRetrofit();

    }


}
