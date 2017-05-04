package xmg.com.androidfix;

import android.app.Application;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;


/**
 * Description :
 * Author : wanggang
 * Email  :
 * Date   : 2016/12/11
 */
public class MainApplication extends Application {
    public PatchManager mPatchManager;
    private static final String TAG = "MainApplication";
    private static final String APATCH_PATH = "out.apatch";
    private static MainApplication appcontext;

    // 单例模式
    public static MainApplication getInstance() {
        return appcontext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appcontext = this;

        // initialize
        mPatchManager = new PatchManager(this);
        mPatchManager.init("1.0");

        // load patch
        mPatchManager.loadPatch();
        Log.d(TAG, "apatch loaded.");

        //加载补丁文件 正式项目中可以直接写在这里
      /*  try {
            String patchFileString = Environment.getExternalStorageDirectory() + "/data/andfix/" + APATCH_PATH;
            mPatchManager.addPatch(patchFileString);
            Log.d(TAG, "apatch:" + patchFileString + " added.");
        } catch (IOException e) {
            Log.e(TAG, "", e);
        }*/
    }
}
