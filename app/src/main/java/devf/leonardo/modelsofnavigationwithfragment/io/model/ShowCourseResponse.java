package devf.leonardo.modelsofnavigationwithfragment.io.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import devf.leonardo.modelsofnavigationwithfragment.domain.Udacity;


/**
 * Created by LEONARDO on 22/09/2015.
 */
public class ShowCourseResponse {
    @SerializedName("courses")
    ArrayList<Udacity> main;

    public ArrayList<Udacity>getUdaCity(){return main;}


}
