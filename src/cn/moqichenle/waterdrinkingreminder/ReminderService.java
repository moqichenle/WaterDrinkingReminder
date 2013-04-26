package cn.moqichenle.waterdrinkingreminder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ReminderService extends Service {
	public static final String ACTION = "com.example.waterdrin";

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
