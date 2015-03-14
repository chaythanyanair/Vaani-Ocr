package com.example.helloworld;

import java.io.File;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class LanguageActivity extends ActionBarActivity {

		public static File imgFile;
		Button camera,gallery;
		public Uri fileUri;
		ImageView showImg;
		public static File fileName;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_lang);
			String myRef = this.getIntent().getStringExtra("name");
		    imgFile = new  File(myRef);
		    /*Display Image*/
	        if(imgFile.exists()){
	        	Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
	        	BitmapFactory.Options options = new BitmapFactory.Options();
	        	options.inSampleSize = 4;
	       		ImageView showImg = (ImageView) findViewById(R.id.view_photo);
	        	showImg.setImageBitmap(myBitmap);
	        	}
			
		}
}
