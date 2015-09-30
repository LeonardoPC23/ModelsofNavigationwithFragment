package devf.leonardo.modelsofnavigationwithfragment.io;

import devf.leonardo.modelsofnavigationwithfragment.constant.Constant;
import devf.leonardo.modelsofnavigationwithfragment.io.model.ShowCourseResponse;
import devf.leonardo.modelsofnavigationwithfragment.io.model.ShowInstructorResponse;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by LEONARDO on 22/09/2015.
 */
public interface ApiService {
    @GET(Constant.PATH_COURSE
    )
    void showCourse(Callback<ShowCourseResponse> serviceResponse);
    void showInstructor(Callback<ShowInstructorResponse>serviceResponseInstructor);

}
