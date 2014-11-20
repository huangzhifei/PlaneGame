package com.example.planegame;
import android.R.integer;
import android.content.Context;
import android.os.Handler;
import android.text.StaticLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class CustomToast {
	
	private static int index;
	private static Toast mToast;
	final static int[] textArry = new int[]{R.string.show_text1, R.string.show_text2, 
			 R.string.show_text3, R.string.show_text4, 
			 R.string.show_text5, R.string.show_text6};
	
	private static Handler mHandler = new Handler();
	private static Runnable mRunnable = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			mToast.cancel();
		}
	};
	
	public CustomToast()
	{		
		
	}
	
	public static void showText(View view)
	{
		TextView mTextView = (TextView)view.findViewById(R.id.message);
		index = index++ % textArry.length;
		mTextView.setText(textArry[index]);
		mHandler.removeCallbacks(mRunnable);
		mToast.setDuration(Toast.LENGTH_SHORT);
		mToast.setView(view);
        mHandler.postDelayed(mRunnable, 500);  
        mToast.show();  
	}
	
	public static void showToast(Context context, String text, int duration)  
    {  
		mHandler.removeCallbacks(mRunnable);  
		text += context.getString(textArry[index++ % textArry.length]);
        if( mToast != null )  
        {  
        	mToast.setText(text);  
        }  
        else  
        {  
        	mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);  
        }  
        mHandler.postDelayed(mRunnable, duration);  
        mToast.show();  
    }
	
    public static void showToast(Context context, int resId, int duration)   
    {  
        showToast(context, context.getResources().getString(resId), duration);  
    }  
};
