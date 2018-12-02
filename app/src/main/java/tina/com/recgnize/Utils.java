package tina.com.recgnize;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author yxc
 * @date 2018/12/2
 */
public class Utils {

    public static void copyAssets2SdCard(Context context, String src, String dst) {
        try {
            File file = new File(dst);
            if (!file.exists()) {
                InputStream is = context.getAssets().open(src);
                FileOutputStream fos = new FileOutputStream(file);
                int len;
                byte[] buffer = new byte[2048];
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                is.close();
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
