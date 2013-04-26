package com.example.waterdringkingreminder;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Timer t;

	class TimeTask extends TimerTask{

		@Override
		public void run() {
			Log.d("[timer running]", "time out.");
		}
		
	}
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button timer= (Button)findViewById(R.id.timer);
        timer.setOnClickListener(this.buttonListener);
        
    }public MainActivity() {
		// TODO Auto-generated constructor stub
	}
	private OnClickListener buttonListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Button b = (Button)v;
			if(!b.getText().equals("Stop")){
				t = new Timer();
				t.schedule(new TimeTask(), 0, 2000);
				b.setText("Stop");
			}
		}
	};
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
