package murkoto.belajarbikin.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.androidannotations.annotations.EActivity;

import murkoto.belajarbikin.R;

@EActivity
public class MainActivity extends AppCompatActivity {

    private final static String API_KEY = "b44a69512c4249b591bf886f5f1973d3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    
    }
}
