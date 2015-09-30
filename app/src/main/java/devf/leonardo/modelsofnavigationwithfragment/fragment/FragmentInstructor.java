package devf.leonardo.modelsofnavigationwithfragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import devf.leonardo.modelsofnavigationwithfragment.io.adapter.MyAdapterRecyclerInstructor;
import devf.leonardo.modelsofnavigationwithfragment.io.adapter.MyOnItemClickListener;
import devf.leonardo.modelsofnavigationwithfragment.io.model.ShowInstructorResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by LEONARDO on 24/09/2015.
 */
public class FragmentInstructor extends Fragment implements AdapterView.OnClickListener, MyOnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout refreshLayout;
    ListView myListView;
    private ArrayList<Udacity> myListArtist;
    MyAdapterRecyclerInstructor adapterRecyclerInstructor;
    RecyclerView recyclerView;
    FragmentInstructor fragmentInstructor;
    Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_instructor, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout_instructor);
        recyclerView = (RecyclerView) view.findViewById(R.id.myRecyclerView_instructor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterRecyclerInstructor = new MyAdapterRecyclerInstructor(getContext(), createInstructor());
        recyclerView.setAdapter(adapterRecyclerInstructor);
        refreshLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                refreshLayout.setRefreshing(true);
                refreshLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        refreshLayout.setOnRefreshListener(this);

    }

    private List<Udacity> createInstructor() {
        myListArtist = new ArrayList<>();
        myListArtist.add(new Udacity());
        return myListArtist;
    }

    @Override
    public void onResume() {
        super.onResume();
        executeWithRetrofit();
    }

    public void executeWithRetrofit() {
        ApiClient.showInstructor(new Callback<ShowInstructorResponse>() {
            @Override
            public void success(ShowInstructorResponse showInstructorResponse, Response response) {
                List<Udacity> instructor = showInstructorResponse.getInstructor();
                adapterRecyclerInstructor.setData(instructor);
                refreshLayout.setRefreshing(false);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


    @Override
    public void onItemClick(int position) {
        Toast.makeText(context, myListArtist.get(position).getTitle().toString(), Toast.LENGTH_SHORT).show();
    }

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
