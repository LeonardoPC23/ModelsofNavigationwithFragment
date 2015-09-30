package devf.leonardo.modelsofnavigationwithfragment.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

import butterknife.OnClick;
import devf.leonardo.modelsofnavigationwithfragment.MainActivity;
import devf.leonardo.modelsofnavigationwithfragment.R;
import devf.leonardo.modelsofnavigationwithfragment.util.ViewUtils;

/**
 * Created by LEONARDO on 29/09/2015.
 */
public class Login extends AppCompatActivity {
    @Bind(R.id.email)
    EditText mEmail;

    @Bind(R.id.password)
    EditText mPassword;

    @Bind(R.id.main_container)
    RelativeLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);
        if (isUserDataIsSaved()) {
            mainMenu();
            finish();
        }


    }

    @OnClick(R.id.login)
    protected void login() {
        if (formFilled()) {
            if (isUserDataIsSaved()) {

                saveUserData(ViewUtils.extractText(mEmail), ViewUtils.extractText(mPassword));
                showMessage(R.string.hello_world);
                mainMenu();

                Toast.makeText(this, "Los datos fieron almacenados", Toast.LENGTH_LONG);
            } else {
                Toast.makeText(this, "Ya habia datos alamacenados", Toast.LENGTH_LONG);
            }

        } else if (isPasswordEmpty()) {
            mEmail.setError("Ingresa tu e-mail");
        } else if (isMailEmpty()) {

            mPassword.setError("Ingresa tu password");
        }

    }

    private void saveUserData(String username, String pass) {
        SharedPreferences sharedpreferences = getSharedPreferences("LoginPrefers", MODE_PRIVATE);
        sharedpreferences.edit()
                .putString("username", username)
                .putString("pass", pass)
                .apply();
    }

    private void showMessage(int stringId) {
        String message = getString(stringId);
        Snackbar.make(mContainer, message, Snackbar.LENGTH_SHORT).show();
    }

    private boolean isUserDataIsSaved() {
        SharedPreferences preferences = getSharedPreferences("Save", MODE_PRIVATE);
        return preferences.contains("username") && preferences.contains("pass");
    }

    private boolean formFilled() {
        return !(isPasswordEmpty() || isMailEmpty());
    }

    public boolean isPasswordEmpty() {
        return mPassword.getText().toString().isEmpty();
    }

    public boolean isMailEmpty() {
        return mEmail.getText().toString().isEmpty();
    }


    protected void mainMenu() {
        Intent mainMenu = new Intent(this, MainActivity.class);
        startActivity(mainMenu);
    }

    protected void setupLogin() {
        Intent login = new Intent(this, Login.class);
        startActivity(login);

    }
}
