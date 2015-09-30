package devf.leonardo.modelsofnavigationwithfragment.domain;

import java.util.ArrayList;

/**
 * Created by LEONARDO on 21/09/2015.
 */
public class Udacity {

    String title;
    //
    String project_name;
    String level;
    String image;
    String banner_image;
    String expected_duration_unit;
    String expected_duration;
    String homepage;


    ArrayList<Image> images;

    public String getTitle() {
        return title;
    }

    public String getProject_name() {
        return project_name;
    }

    public String getLevel() {
        return level;
    }

    public String getImage() {
        return image;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getBanner_image() {
        return banner_image;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public String getExpected_duration_unit() {
        return expected_duration_unit;
    }

    public String getExpected_duration() {
        return expected_duration;
    }
}
