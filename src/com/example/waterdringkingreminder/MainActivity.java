package com.example.waterdringkingreminder;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Timer t;
	private Vibrator v;
	private int dot = 200;      // Length of a Morse Code "dot" in milliseconds
	private int dash = 500;     // Length of a Morse Code "dash" in milliseconds
	private int short_gap = 200;    // Length of Gap Between dots/dashes
	private long[] pattern =  {
		    0,  // Start immediately
		    dash, short_gap, dot, short_gap, dot,   
		    short_gap, dot, short_gap, dot,
		    short_gap, dot, short_gap, dot,
		    short_gap, dot, short_gap, dot
		};
	
	class TimeTask extends TimerTask {
		@Override
		public void run() {
			Log.d("[timer running]", "oops! 10s, time out.");
			Log.d("[timer running]", "to vibrate here!");
			v.vibrate(pattern, -1);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button timerButton = (Button) findViewById(R.id.timer);
		timerButton.setOnClickListener(this.timerButtonListener);
		Button vibrateButton = (Button) findViewById(R.id.vibrate);
		vibrateButton.setOnClickListener(this.vibrateButtonListener);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	}

	private OnClickListener vibrateButtonListener = new OnClickListener() {
		
		@Override
		public void onClick(View view) {
			v.cancel();
		}
	};

	private OnClickListener timerButtonListener = new OnClickListener() {

		@Override
		public void onClick(View view) {
			Button b = (Button) view;
			if (!b.getText().equals("Stop")) {
				b.setText("Stop");
				t = new Timer();
				Log.d("[timer running]", "timer starts.");
				t.schedule(new TimeTask(), 20000, 1000 * 20);
			} else {
				b.setText("Timer");
				t.cancel();
				t.purge();
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
