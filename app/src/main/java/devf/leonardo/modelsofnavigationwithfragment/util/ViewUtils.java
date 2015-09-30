package devf.leonardo.modelsofnavigationwithfragment.util;

import android.widget.EditText;

/**
 * Created by LEONARDO on 29/09/2015.
 */
public class ViewUtils {
    public static String extractText(EditText editText){
        return editText.getText().toString().trim();
    }
}
