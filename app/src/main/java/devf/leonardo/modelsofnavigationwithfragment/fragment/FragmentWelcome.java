package devf.leonardo.modelsofnavigationwithfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import devf.leonardo.modelsofnavigationwithfragment.R;

/**
 * Created by LEONARDO on 25/09/2015.
 */
public class FragmentWelcome extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }
}
