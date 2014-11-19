package com.example.planegame;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 
 */

/**
 * @author SDT12726
 *
 */
public class PlaneView extends View {
	
	private float currentX;
	private float currentY;
	private Bitmap planeBitmap;
	
	public final float getPlaneX() 
	{
		return currentX;
	}
	public void setPlaneX(float cx)
	{
		currentX = cx;
	}
	public final float getPlaneY()
	{
		return currentY;
	}
	public void setPlaneY(float cy)
	{
		currentY = cy;
	}
	/**
	 * @param context
	 */
	public PlaneView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		// 定义飞机图像
		planeBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane);
		
		setFocusable(true);
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public PlaneView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public PlaneView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		//创建画笔
		Paint p = new Paint();
		//绘制灰机
		canvas.drawBitmap(planeBitmap, currentX, currentY, p);
	}

	
}
