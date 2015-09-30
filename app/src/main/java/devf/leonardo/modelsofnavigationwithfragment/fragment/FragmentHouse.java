package devf.leonardo.modelsofnavigationwithfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import devf.leonardo.modelsofnavigationwithfragment.io.adapter.ModelFramentPager;
import devf.leonardo.modelsofnavigationwithfragment.io.adapter.MyAdapterViewPager;
import devf.leonardo.modelsofnavigationwithfragment.R;

/**
 * Created by LEONARDO on 24/09/2015.
 */
public class FragmentHouse extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = (TabLayout) view.findViewById(R.id.myTabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.myViewPager);

        MyAdapterViewPager myAdapterViewPager = new MyAdapterViewPager(getChildFragmentManager(), createPager());
        viewPager.setAdapter(myAdapterViewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupIcon();

    }

    private void setupIcon() {
        int[] tabIcon = {R.drawable.ic_home_white_24dp,
                R.drawable.ic_code_white_24dp,
                R.drawable.ic_face_white_24dp,
                R.drawable.ic_http_white_24dp};

    tabLayout.getTabAt(0).setIcon(tabIcon[0]);
    tabLayout.getTabAt(1).setIcon(tabIcon[1]);
    tabLayout.getTabAt(2).setIcon(tabIcon[2]);
    tabLayout.getTabAt(3).setIcon(tabIcon[3]);
    }



    public List<ModelFramentPager> createPager() {
        List<ModelFramentPager> modelFramentPagers = new ArrayList<>();

        modelFramentPagers.add(new ModelFramentPager(new FragmentWelcome(), ""));
        modelFramentPagers.add(new ModelFramentPager(new FragmentCourse(), ""));
        modelFramentPagers.add(new ModelFramentPager(new FragmentInstructor(), ""));
        modelFramentPagers.add(new ModelFramentPager(new FragmentHomePage(), ""));


        return modelFramentPagers;
    }
}
