package com.example.ocr;

import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;

/** 
 * ��ΪBitmapû��ʵ�����л������Բ���ֱ�������л���(MyBitmap)��ʹ�� 
 * BytesBitmap����ʵ��Bitmap��byte[]����໥ת�� 
 * @author joran 
 *  
 */  
class BytesBitmap {  
    public static Bitmap getBitmap(byte[] data) {  
        return BitmapFactory.decodeByteArray(data, 0, data.length);  
    }  
  
    public static byte[] getBytes(Bitmap bitmap) {  
        ByteArrayOutputStream baops = new ByteArrayOutputStream();  
        bitmap.compress(CompressFormat.PNG, 0, baops);  
        return baops.toByteArray();  
    }  
}  
