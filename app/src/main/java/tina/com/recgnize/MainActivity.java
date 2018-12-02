package tina.com.recgnize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.sample_text);
    }

    public native String stringFromJNI();

    public native String recgnizeCar(String hogSvmData, String hogAnnZHData, String hogAnnData, String imgStr);

    public void carRecgnize(View view) {

        String carNum = recgnizeCar("/sdcard/HOG_SVM_DATA2.xml",
                "/sdcard/HOG_ANN_ZH_DATA2.xml",
                "/sdcard/HOG_ANN_DATA2.xml",
                "/sdcard/test11.jpg");

        tv.setText(carNum);
    }
}
