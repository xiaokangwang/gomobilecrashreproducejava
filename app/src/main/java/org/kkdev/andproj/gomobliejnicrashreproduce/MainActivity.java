package org.kkdev.andproj.gomobliejnicrashreproduce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import golangmobilecrashreproduce.CrashInterface;
import golangmobilecrashreproduce.Golangmobilecrashreproduce;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "Crasher";
    public class Crashimp implements CrashInterface{

        @Override
        public void callMeIfYouCanFunc() {
            Log.d(TAG, "callMeIfYouCanFunc: ");
            throw new RuntimeException("callMeIfYouCanFunc");
        }

        @Override
        public void firstFunc() {
            Log.d(TAG, "firstFunc: ");
        }

        @Override
        public void secondFunc() {
            Log.d(TAG, "secondFunc: ");
            throw new RuntimeException("secondFunc");
        }

        @Override
        public void seeYouAtAnotherWorld() {
            Log.d(TAG, "Will this success? ");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Golangmobilecrashreproduce.crasher(new Crashimp());
    }
}
