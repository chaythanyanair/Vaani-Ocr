package com.example.helloworld;

import java.io.*;
import java.text.*;
import java.util.*;
import android.os.*;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.Button;
import android.net.Uri;


public class MainActivity extends ActionBarActivity {
	Button camera,gallery;
	public Uri fileUri;
	ImageView showImg;
	public static File fileName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		showImg = (ImageView)findViewById(R.id.imageView1);
		camera = (Button)findViewById(R.id.button1);
	    camera.setOnClickListener(new OnClickListener() {
	    	@Override
	        public void onClick(View v) { open();}
	    });
	    gallery=(Button)findViewById(R.id.button2);
	    gallery.setOnClickListener(new View.OnClickListener() {

	    	@Override
	    	public void onClick(View v) {
	    	
	    	Intent intent = new Intent();
	    	// call android default gallery
	    	intent.setType("image/*");
	    	intent.setAction(Intent.ACTION_GET_CONTENT);
	    	intent.putExtra("return-data", true);
	    	startActivityForResult(Intent.createChooser(intent,"Complete action using"), 2);
	    	}
	    });
	}
	public void open(){
	      Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
	      fileUri = getOutputImageFileUri(); // create a file to save the image
		  intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, fileUri);
		  if (intent.resolveActivity(getPackageManager()) != null) {
		  	startActivityForResult(intent, 1);
		  }
	}
	private static Uri getOutputImageFileUri(){
		fileName=getOutputImageFile();
		return Uri.fromFile(fileName);
	}
	/** Create a File for saving the image */
	private static File getOutputImageFile(){
	    File imageStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "HelloWorld!");
	   	// Create the storage directory if it does not exist
	    // Create a media file name
	    String imgName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    File imageFile;
	    imageFile = new File(imageStorageDir.getPath() + File.separator + "IMG_"+ imgName +".png");
	    return imageFile;
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	      // TODO Auto-generated method stub
	     super.onActivityResult(requestCode, resultCode, data);
		 if (requestCode==1 && resultCode == RESULT_OK) { 
			 if(null == data) {
				 	//Bitmap bitmap;
				 //	BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
				 //	bitmap = BitmapFactory.decodeFile(fileName.getAbsolutePath(),bitmapOptions); 
                    //showImg.setImageBitmap(bitmap);
				 //	Uri savedImg=Uri.fromFile(fileName);
	               	Intent first = new Intent(this, SecondActivity.class);
	                first.putExtra("name", fileName.toString() );
                    startActivity(first);
                    
              }
		 }
		 else if(requestCode==2 && resultCode == RESULT_OK) {
			 if(null!=data){
				 Intent first = new Intent(this, SecondActivity.class);
				 first.putExtra("name", fileName.toString() );
				 startActivity(first);
			 }
		 }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
}
