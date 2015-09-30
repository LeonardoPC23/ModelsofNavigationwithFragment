package devf.leonardo.modelsofnavigationwithfragment.io.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import devf.leonardo.modelsofnavigationwithfragment.R;

/**
 * Created by LEONARDO on 25/09/2015.
 */
public class MyAdapterViewPager extends FragmentPagerAdapter {

    private List<ModelFramentPager> pagerList = new ArrayList<>();


    private int[] imagesId = {R.drawable.ic_home_black_24dp,
            R.drawable.ic_code_black_24dp,
            R.drawable.ic_face_black_24dp,
            R.drawable.ic_http_black_24dp};
    private Context context;


    public MyAdapterViewPager(FragmentManager fm, List<ModelFramentPager> pagerList) {
        super(fm);
        this.pagerList = pagerList;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return pagerList.get(position).getPager();
    }

    @Override
    public int getCount() {
        return pagerList.size();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public CharSequence getPageTitle(int position) {

        return pagerList.get(position).getTitle();
    }
}
