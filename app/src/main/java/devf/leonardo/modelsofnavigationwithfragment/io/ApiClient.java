package devf.leonardo.modelsofnavigationwithfragment.io;


import devf.leonardo.modelsofnavigationwithfragment.constant.Constant;
import devf.leonardo.modelsofnavigationwithfragment.io.model.ShowCourseResponse;
import devf.leonardo.modelsofnavigationwithfragment.io.model.ShowInstructorResponse;
import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by LEONARDO on 22/09/2015.
 */
public class ApiClient {
    private static ApiService apiService;
    public static ApiService getApiService(){
        if(apiService==null){
            RestAdapter restAdapter= new RestAdapter.Builder().setEndpoint(Constant.URL_BASE).
                    setLogLevel(RestAdapter.LogLevel.BASIC).build();

            apiService=restAdapter.create(ApiService.class);
        }
        return apiService;
    }

    public static void showCourse(Callback<ShowCourseResponse>serverResponse){
        getApiService().showCourse(serverResponse);
    }

    public static void showInstructor(Callback<ShowInstructorResponse>serInstructorResponse) {
        getApiService().showInstructor(serInstructorResponse);

    }
}
