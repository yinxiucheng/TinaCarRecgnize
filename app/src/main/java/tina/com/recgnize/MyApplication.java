package tina.com.recgnize;

import android.app.Application;

/**
 * @author yxc
 * @date 2018/12/2
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        copyData();
    }

    public void copyData(){
        //拷贝 模型
        Utils.copyAssets2SdCard(getApplicationContext(), "HOG_ANN_DATA2.xml",
                "/sdcard/HOG_ANN_DATA2.xml");
        Utils.copyAssets2SdCard(getApplicationContext(), "HOG_ANN_ZH_DATA2.xml",
                "/sdcard/HOG_ANN_ZH_DATA2.xml");
        Utils.copyAssets2SdCard(getApplicationContext(), "HOG_SVM_DATA2.xml",
                "/sdcard/HOG_SVM_DATA2.xml");
    }


}
