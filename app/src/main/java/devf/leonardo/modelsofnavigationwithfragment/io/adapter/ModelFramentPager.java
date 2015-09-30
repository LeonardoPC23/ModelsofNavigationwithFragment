package devf.leonardo.modelsofnavigationwithfragment.io.adapter;

import android.support.v4.app.Fragment;

/**
 * Created by LEONARDO on 25/09/2015.
 */
public class ModelFramentPager {
    private Fragment pager;
    private String title;

    public ModelFramentPager(Fragment pager, String title) {
        this.pager = pager;
        this.title = title;
    }

    public Fragment getPager() {
        return pager;
    }

    public String getTitle() {
        return title;
    }
}
