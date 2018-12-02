package tina.com.recgnize;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import tina.com.camera.CameraActivity2;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    static {
        System.loadLibrary("native-lib");
    }

    TextView tv;
    TextView imgPathView;

    private String imgData = "/sdcard/test11.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.sample_text);
        imgPathView = findViewById(R.id.imgPath);

    }

    public native String recgnizeCar(String hogSvmData, String hogAnnZHData, String hogAnnData, String imgStr);

    public void carRecgnize(View view) {

        String carNum = recgnizeCar("/sdcard/HOG_SVM_DATA2.xml",
                "/sdcard/HOG_ANN_ZH_DATA2.xml",
                "/sdcard/HOG_ANN_DATA2.xml",
                imgData);

        if (TextUtils.isEmpty(carNum)) {
            tv.setText("检测失败！");
        } else {
            tv.setText(carNum);
        }

    }


    public void imageLoader(View view) {
        Intent intent = new Intent(this, CameraActivity2.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (null != data) {
            imgData = data.getStringExtra("img");
            imgPathView.setText(imgData);
        }
    }

}
