package com.example.planegame;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


public class MainActivity extends Activity {

	private int speed = 10;
	
	private CustomToast m_toast = null;
	
	private View mView = null;
	
	public void showToast()
	{
		m_toast.showToast(this, "", 1000);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		m_toast = new CustomToast();
		
		mView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.mytoast, null);
		
		//去掉窗口标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		//全屏显示
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
							 WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		final PlaneView planeView = new PlaneView(this);
		//这里设置了，上面就不需要了
		setContentView(planeView);
		
		//设置背景，名字就是图片的名字，所以不能有中文
		planeView.setBackgroundResource(R.drawable.back);
		
		//获取窗口管理器
		WindowManager wManager = getWindowManager();
		Display display = wManager.getDefaultDisplay();
		DisplayMetrics dMetrics = new DisplayMetrics();
		
		//获取屏幕宽和高
		display.getMetrics(dMetrics);
		
		//设置飞机位置
		planeView.setPlaneX((float)(dMetrics.widthPixels * 0.5));
		planeView.setPlaneY(dMetrics.heightPixels - 120);
		
		planeView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				// TODO Auto-generated method stub
				
				float cx = event.getX();
				float cy = event.getY();
				
				planeView.setPlaneX(cx);
				planeView.setPlaneY(cy);
				
				//要通知planeView去刷新
				planeView.invalidate();
				
				showToast();
				
				return true;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
