package net.schattenkind.androidLove;

import java.io.IOException;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;

public class LoveAndroid extends ActivitiyWithExitMenu {
	private static final String TAG = "LoveAndroid";
	private static final long updateDelayMillis = 1000 / 30;
	private static final String kGamePath = "/mnt/sdcard/love/test/";
	
	private static LoveVM vm = null;

	private GLSurfaceView mGLView;
	private LoveAndroidRenderer renderer;


	@SuppressWarnings("unused")
	private MouseHandler mouseHandler;

	private class UpdateHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {
			LoveAndroid.this._update();
		}

		public void start() {
			sendMessageDelayed(obtainMessage(0), updateDelayMillis);
		}

		public void sleep(long delayMillis) {
			this.removeMessages(0);
			sendMessageDelayed(obtainMessage(0), delayMillis);
		}
	};

	private UpdateHandler mUpdateHandler = new UpdateHandler();

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (vm != null) {
			return vm.feedKey(keyCode, true);
		} else {
			return false;
		}
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (vm != null) {
			return vm.feedKey(keyCode, false);
		} else {
			return false;
		}
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	public void _update() {
		if (vm != null) {
			vm.notifyUpdateTimerMainThread(updateDelayMillis / 1000.0f);
		}
		mUpdateHandler.sleep(updateDelayMillis);
	}

	private static LoveVM createVM(String gamePath) {
		assert (vm == null);

		LoveStorage storage = null;
		try {
			storage = new LoveStorage(gamePath);
		} catch (IOException e) {
			// failed to load .zip/.love or similar, exit
			LoveVM.LoveLog(TAG, "failed to load storage:" + gamePath);
			System.exit(0);
		}
		
		return new LoveVM(storage);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String path = kGamePath;

		if (Launcher.launchMeGamePath != null) {
			path = Launcher.launchMeGamePath;
		}

		if (vm == null) {
			vm = createVM(path);
		}
		vm.assignActivity(this);

		// Create a GLSurfaceView instance and set it
		// as the ContentView for this Activity.
		renderer = new LoveAndroidRenderer(vm);
		mGLView = new GLSurfaceView(this);
		mGLView.setRenderer(renderer);
		
		// TODO: setPreserveEGLContextOnPause undefined in android 2.1 for
		// GLSurfaceView
		// ~ try {
		// ~ mGLView.setPreserveEGLContextOnPause(true);
		// ~ } catch (IOException e) {
		// ~ LoveVM.LoveLog(TAG,"mGLView.setPreserveEGLContextOnPause failed");
		// // just a warning, not fatal
		// ~ }

		setContentView(mGLView);

		vm.notifyOnCreateDone();

		mUpdateHandler.start();

		mouseHandler = new MouseHandler(mGLView, vm);
	}

	@Override
	protected void onPause() {
		super.onPause();
		// The following call pauses the rendering thread.
		// If your OpenGL application is memory intensive,
		// you should consider de-allocating objects that
		// consume significant memory here.
		mGLView.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		// The following call resumes a paused rendering thread.
		// If you de-allocated graphic objects for onPause()
		// this is a good place to re-allocate them.
		mGLView.onResume();
	}

	// ***** ***** ***** ***** ***** 4 main buttons

	public boolean bBlockMainKey_Back = false; // return
	public boolean bBlockMainKey_Menu = false; // Context,options
	public boolean bBlockMainKey_Search = false;

	// ~ public boolean bBlockMainKey_Home = false; // home cannot be blocked or
	// directly detected, only activity:onUserLeaveHint(),
	// home block prevented by os :
	// http://groups.google.com/group/android-developers/browse_thread/thread/6ad5d53f5e8c8013

	public void setBlockMainKey_Back(boolean bBlocked) {
		bBlockMainKey_Back = bBlocked;
	}

	public void setBlockMainKey_Menu(boolean bBlocked) {
		bBlockMainKey_Menu = bBlocked;
	}

	public void setBlockMainKey_Search(boolean bBlocked) {
		bBlockMainKey_Search = bBlocked;
	}

	@Override
	public void onBackPressed() {
		vm.getLuanPhone().notifyMainKey_Back();
		if (bBlockMainKey_Back)
			return;
		super.onBackPressed();
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		vm.getLuanPhone().notifyMainKey_Menu();
		if (bBlockMainKey_Menu)
			return false;
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onSearchRequested() {
		vm.getLuanPhone().notifyMainKey_Search();
		if (bBlockMainKey_Search)
			return false;
		return super.onSearchRequested();
	}

	// / home ? or other form of termination, cannot be prevented
	@Override
	public void onUserLeaveHint() {
		vm.getLuanPhone().notifyUserLeaveHint();
		super.onUserLeaveHint();
	}

	public android.view.View getView() {
		return mGLView;
	}
	
	public static void shutdownRunningVM()
	{
		if (vm != null)
		{
			vm.shutdown();
			vm = null;
		}
	}
}
