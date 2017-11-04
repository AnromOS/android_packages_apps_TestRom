package com.example.rom.testrom;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class MainActivity extends AppCompatActivity {
    static String TAG="PHONESTATE";
    String myNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TelephonyManager telephony = (TelephonyManager)getSystemService(
                Context.TELEPHONY_SERVICE);
//        telephony.listen(new OnePhoneStateListener(),
//                PhoneStateListener.LISTEN_CALL_STATE);
        telephony.listen(new OnePhoneStateListener(),
                PhoneStateListener.LISTEN_REAL_CALL_STATE);
        myNum = telephony.getLine1Number();
    }

    class OnePhoneStateListener extends PhoneStateListener{
//        @Override
//        public void onCallStateChanged(int state, String incomingNumber) {
//            super.onCallStateChanged(state, incomingNumber);
//            Log.d(TAG,"[Listener]mynum:"+myNum);
//            Log.i(TAG, "[Listener]电话号码:"+incomingNumber);
//            switch(state){
//                case TelephonyManager.CALL_STATE_RINGING:
//                    Log.i(TAG, "[Listener]等待接电话:"+incomingNumber);
//                    break;
//                case TelephonyManager.CALL_STATE_IDLE:
//                    Log.i(TAG, "[Listener]电话挂断:"+incomingNumber);
//                    break;
//                case TelephonyManager.CALL_STATE_OFFHOOK:
//                    Log.i(TAG, "[Listener]通话中:"+incomingNumber);
//                    break;
//            }
//        }

        @Override
        public void onRealCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            Log.d(TAG,"REAL [Listener]mynum:"+myNum);
            Log.i(TAG, "Real[Listener]电话号码:"+incomingNumber);
            Log.d(TAG, "REAL PHONE STATE:" + state);
//            public static final int REAL_CALL_STATE_IDLE = 0;
//            public static final int REAL_CALL_STATE_ACTIVE = 1;
//            public static final int REAL_CALL_STATE_HOLDING = 3;
//            public static final int REAL_CALL_STATE_RINGING = 4;
//            public static final int REAL_CALL_STATE_DIALING = 5;
//            //~ public static final int REAL_CALL_STATE_ALERTING = 5;
//            //~ public static final int REAL_CALL_STATE_INCOMING = 6;
//            //~ public static final int REAL_CALL_STATE_WAITING = 7;
//            public static final int REAL_CALL_STATE_DISCONNECTED = 6;
//            public static final int REAL_CALL_STATE_DISCONNECTING = 7;

            switch(state){
                case 0:
                    Log.i(TAG, "Real[Listener]REAL_CALL_STATE_IDLE:"+incomingNumber);
                    break;
                case 1:
                    Log.i(TAG, "Real[Listener]REAL_CALL_STATE_ACTIVE:"+incomingNumber);
                    break;
                case 2:
                    Log.i(TAG, "Real[Listener]REAL_CALL_STATE_HOLDING:"+incomingNumber);
                    break;
                case 3:
                    Log.i(TAG, "Real[Listener]REAL_CALL_STATE_HOLDING:"+incomingNumber);
                    break;
                case 4:
                    Log.i(TAG, "Real[Listener]REAL_CALL_STATE_RINGING:"+incomingNumber);
                    break;
                case 5:
                    Log.i(TAG, "Real[Listener]REAL_CALL_STATE_DIALING:"+incomingNumber);
                    break;
                case 6:
                    Log.i(TAG, "Real[Listener]REAL_CALL_STATE_DISCONNECTED:"+incomingNumber);
                    break;
                case 7:
                    Log.i(TAG, "Real[Listener]REAL_CALL_STATE_DISCONNECTING:"+incomingNumber);
                    break;
            }
        }
    }

    public static class RomReceiver extends BroadcastReceiver {
  
        @Override  
        public void onReceive(Context context, Intent intent) {  

            String action = intent.getAction();
            String fileName = intent.getExtras().getString("filename");  
            Log.d("RomRecevier", "接收到action:" + action + "\nfileName:" + fileName);  
        }

    }
}
