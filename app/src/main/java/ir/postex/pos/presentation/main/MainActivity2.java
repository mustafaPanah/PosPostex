package ir.postex.pos.presentation.main;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import ir.postex.pos.R;


public class MainActivity2 extends AppCompatActivity {

    private static final int BUY_REQUEST_CODE = 110;
    private static final int SETTINGS_REQUEST_CODE = 120;

    private static final int PRINT_RESULT = 1;

    Messenger requestMessenger, responseMessenger;
    boolean bound;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button buy = findViewById(R.id.btn_buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchPos();
            }
        });

        Button settings = findViewById(R.id.btn_settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSettings();
            }
        });

        Button print = findViewById(R.id.btn_print);

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        if (!bound)
                            return;
                        Message msg = new Message();
                        msg.what = 1;
                        msg.obj = BitmapFactory.decodeResource(getResources(), R.drawable.shaparak_psp);
                        msg.replyTo = responseMessenger;
                        try {
                            requestMessenger.send(msg);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });

    }

    private final ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            requestMessenger = new Messenger(service);
            responseMessenger = new Messenger(new IncomingHandler());
            bound = true;
        }

        public void onServiceDisconnected(ComponentName className) {
            requestMessenger = null;
            responseMessenger = null;
            bound = false;
        }
    };

    class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == PRINT_RESULT) {
                if (msg.arg1 == 1)
                    Toast.makeText(MainActivity2.this, "پرینت موفق", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity2.this, "پرینت ناموفق", Toast.LENGTH_SHORT).show();
            } else {
                super.handleMessage(msg);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        String SERVICE_CLASS_NAME = "com.fanap.androidpos.thirdparty.BitmapPrintService";

        bindService(
                new Intent().setComponent(new ComponentName("com.fanap.androidpos", SERVICE_CLASS_NAME)),
                mConnection,
                Context.BIND_AUTO_CREATE
        );
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (bound) {
            unbindService(mConnection);
            bound = false;
        }
    }

    private void launchPos() {// شروع برنامه پوز جهت انجام فرآیند خرید
        Intent sendIntent = new Intent();
        sendIntent.setAction("com.fanap.androidpos.TpActivity");
        Bundle bundle = new Bundle();
        bundle.putString("AMOUNT", "1001"); // مبلغ خرید
        bundle.putString("GUID", "1234567890");
        sendIntent.putExtra("DATA", bundle);
        sendIntent.setType("text/plain");
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            // بررسی نصب بودن برنامه پوز روی دستگاه
            startActivityForResult(sendIntent, BUY_REQUEST_CODE);
        } else
            Toast.makeText(this, "برنامه پوز روی دستگاه نصب نمی باشد!", Toast.LENGTH_SHORT).show();
    }

    private void launchSettings() {
        Intent sendIntent = new Intent();
        sendIntent.setAction("com.fanap.androidpos.TpSettingsActivity");
        if (sendIntent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(sendIntent, SETTINGS_REQUEST_CODE);
        else
            Toast.makeText(this, "برنامه پوز روی دستگاه نصب نمی باشد!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {// دریافت نتیجه از پوز
        if (requestCode == BUY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Bundle bundle = data.getBundleExtra("DATA");
                boolean status = bundle.getBoolean("STATUS"); // true->تراکنش موفق false->تراکنش ناموفق
                String date = bundle.getString("DATE"); //تاریخ تراکنش
                String time = bundle.getString("TIME"); //زمان تراکنش
                String stan = bundle.getString("STAN"); // شماره پیگیری
                String rrn = bundle.getString("RRN"); // شماره مرجع
                String response = bundle.getString("RESPONSE"); // پاسخ سوئیچ
                String guid = bundle.getString("GUID");
                String amount = bundle.getString("AMOUNT");
                Toast.makeText(this, String.valueOf(status), Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == SETTINGS_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Bundle bundle = data.getBundleExtra("DATA");
                String version = bundle.getString("VERSION"); //ورژن برنامه
                String firmware = bundle.getString("FIRMWARE"); //فرم ویر
                String terminal = bundle.getString("TERMINAL"); // شماره ترمینال
                String merchant = bundle.getString("MERCHANT"); // شماره پذیرنده
                String name = bundle.getString("NAME"); // نام پذیرنده
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}