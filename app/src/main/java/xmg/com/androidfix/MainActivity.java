package xmg.com.androidfix;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText edit_username, edit_password;
    private Button btn_login, btn_loadPatch;
    private String username = null, password = null;

    private static final String APATCH_PATH = "out.apatch";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_username = (EditText) findViewById(R.id.edit_username);
        edit_password = (EditText) findViewById(R.id.edit_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_loadPatch = (Button) findViewById(R.id.btn_loadPatch);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*********修复bug的代码**********************************/
                Toast.makeText(MainActivity.this, AddNewClass.toastTxt, Toast.LENGTH_SHORT).show();
                username = edit_username.getText().toString().trim();
                password = edit_password.getText().toString().trim();

                if (username.equals("") || password.equals("")) {
                    Toast.makeText(MainActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                /********************以上为修复bug的代码，还有ReadMe.txt中的注意*************************************/


                if (password.equals("456") && username.equals("123"))
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(MainActivity.this, "用户名与密码出错", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btn_loadPatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String patchFileString = Environment.getExternalStorageDirectory() + "/data/andfix/" + APATCH_PATH;
                    MainApplication.getInstance().mPatchManager.addPatch(patchFileString);
                    Log.d(TAG, "apatch:" + patchFileString + " added.");
                } catch (IOException e) {
                    Log.e(TAG, "", e);
                }

                Toast.makeText(MainActivity.this, "加载补丁文件成功", Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //为了应用重新启动，再次执行MainApplication中onCreate方法中的代码
        android.os.Process.killProcess(android.os.Process.myPid());
    }

}
