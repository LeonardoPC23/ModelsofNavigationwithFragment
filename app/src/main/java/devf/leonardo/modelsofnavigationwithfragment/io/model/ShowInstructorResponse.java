package devf.leonardo.modelsofnavigationwithfragment.io.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import devf.leonardo.modelsofnavigationwithfragment.domain.Udacity;

/**
 * Created by LEONARDO on 24/09/2015.
 */
public class ShowInstructorResponse {
    @SerializedName("courses")
    InstructorMain main;

    public ArrayList<Udacity> getInstructor() {
        return main.instructors;
    }

    public class InstructorMain {
        @SerializedName("instructors")
        ArrayList<Udacity> instructors;

    }
}
