package dwood253.uw.tacoma.edu.webserviceslab.authenticate;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dwood253.uw.tacoma.edu.webserviceslab.CourseActivity;
import dwood253.uw.tacoma.edu.webserviceslab.CourseDetailFragment;
import dwood253.uw.tacoma.edu.webserviceslab.R;
import layout.LoginFragment;

public class SignInActivity extends AppCompatActivity implements LoginFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new LoginFragment() )
                .commit();
    }

    public void login(String userId, String pwd) {
        Intent i = new Intent(this, CourseActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
