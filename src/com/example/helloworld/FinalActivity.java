package com.example.helloworld;

import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import android.content.res.AssetManager;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;

import android.os.Bundle;
//import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
//import android.util.Log;
import android.widget.TextView; 
//import com.googlecode.tesseract.android.TessBaseAPI;
//import android.content.Intent;
public class FinalActivity extends ActionBarActivity {
	TextView recognised;
	public static File imgFile;
	
	 //public static String DATA_PATH = Environment.getExternalStorageDirectory().toString() + "Vaani";
	 //public static final String lang="eng";
	 //private static final String TAG = "FinalActivity.java";
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final);
		String myRef = this.getIntent().getStringExtra("name");
	    imgFile = new  File(myRef);
	    //String choice = this.getIntent().getStringExtra("choice");
	    //String path =imgFile.getAbsolutePath();
	    //Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
	    String recognizedText = "Hello app is working";
	    recognised=(TextView)findViewById(R.id.textView1);
	    recognised.setText(recognizedText);
	   /* String[] paths = new String[] { DATA_PATH, DATA_PATH + "tessdata/" };
		    for (String path : paths) {
		    	File dir = new File(path);
		    	if (!dir.exists()) {
		                dir.mkdirs();// Create the storage directory if it does not exist
		    	}
		    }
		    if (!(new File(DATA_PATH + "tessdata/" + lang + ".traineddata")).exists()) {
		    	try {
		    		AssetManager assetManager = getAssets();
		    		InputStream in = assetManager.open("tessdata/" + lang + ".traineddata");
		    		//GZIPInputStream gin = new GZIPInputStream(in);
		    		OutputStream out = new FileOutputStream(DATA_PATH + "tessdata/" + lang + ".traineddata");
		    		// Transfer bytes from in to out
		    		byte[] buf = new byte[1024];
		    		int len;
		    		
		    		while ((len = in.read(buf)) > 0) {
		    			out.write(buf, 0, len);
		    		}
		    		in.close();
		    		out.close();
		    		Log.v(TAG, "Copied " + lang + " traineddata");
		    	} catch (IOException e) {
		    		Log.e(TAG, "Was unable to copy " + lang + " traineddata " + e.toString());
		    		}
		    }
		    TessBaseAPI baseApi = new TessBaseAPI();
		    DATA_PATH=DATA_PATH + "tessdata/" + lang + ".traineddata";
		    baseApi.init(DATA_PATH,lang);*/
		 // Eg. baseApi.init("/mnt/sdcard/tesseract/tessdata/eng.traineddata", "eng");
		  //  baseApi.setImage(bitmap);
		   // String recognizedText = baseApi.getUTF8Text();
		    
		   // baseApi.end();
	    
	 
}
}
