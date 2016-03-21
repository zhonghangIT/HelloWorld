package com.bwie.test.imagelayout.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageLoad {

	private String murl;
	private ImageView mimg;
	private Handler hand=new Handler(){
		public void handleMessage(Message msg) {

			Bitmap bm=(Bitmap) msg.obj;
			mimg.setImageBitmap(bm);
		};
	};

	public void showImageByThread(final String url2,ImageView img2){
		murl=url2;
		mimg=img2;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				//得到bitmap
				Bitmap bm=getImage(url2);
				//发送消息
				Message msg=Message.obtain();
				msg.obj=bm;
				hand.sendMessage(msg);
			}
		}).start();
	}

	public static Bitmap getImage(String url){

		InputStream input=null;		
		try {
			//打开连接
			HttpURLConnection connection=(HttpURLConnection) new URL(url).openConnection();
			//得到输入流
			input=connection.getInputStream();
			//把输入流转为bitmap
			Bitmap bm=BitmapFactory.decodeStream(input);
			//关闭连接
			connection.disconnect();
			//返回bitmap
			return bm;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}






//public class ImageLoad {
//
//	private String murl;
//	private ImageView mimg;
//	private Handler hand=new Handler(){
//		public void handleMessage(Message msg) {
//
//			Bitmap bm=(Bitmap) msg.obj;
//			mimg.setImageBitmap(bm);
//		};
//	};
//
//	public void showImageByThread(final String url2,ImageView img2){
//		murl=url2;
//		mimg=img2;
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				//得到bitmap
//				Bitmap bm=getImage(url2);
//				//发送消息
//				Message msg=Message.obtain();
//				msg.obj=bm;
//				hand.sendMessage(msg);
//			}
//		}).start();
//	}
//
//	public static Bitmap getImage(String url){
//
//		InputStream input=null;
//		try {
//			//打开连接
//			HttpURLConnection connection=(HttpURLConnection) new URL(url).openConnection();
//			//得到输入流
//			input=connection.getInputStream();
//			//把输入流转为bitmap
//			Bitmap bm=BitmapFactory.decodeStream(input);
//			//关闭连接
//			connection.disconnect();
//			//返回bitmap
//			return bm;
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//}
//
//
////		package com.tang.utils;
////		import com.nostra13.universalimageloader.core.DisplayImageOptions;
////		import com.nostra13.universalimageloader.core.ImageLoader;
////		import com.nostra13.universalimageloader.core.assist.ImageSize;
////		import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
////		import com.tang.android_today.R;
////
////		import android.graphics.Bitmap;
////		import android.view.View;
////		import android.widget.ImageView;
//////图片加载
////public class ImageUtils {
////
////	public void imageUrl(final ImageView imageView,String path) {
////		DisplayImageOptions options = new DisplayImageOptions.Builder()
////				.showImageForEmptyUri(R.drawable.aab)
////				.showImageOnFail(R.drawable.aab)
////				.showImageOnLoading(R.drawable.aab)
////				.cacheInMemory(true)
////				.cacheOnDisk(true)
////				.build();
////		ImageSize imageSize = new ImageSize(100, 100);
////		ImageLoader.getInstance().loadImage(path, imageSize, options, new SimpleImageLoadingListener(){
////			@Override
////			public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
////				super.onLoadingComplete(imageUri, view, loadedImage);
////				imageView.setImageBitmap(loadedImage);
////			}
////		}) ;
////	}
////}

