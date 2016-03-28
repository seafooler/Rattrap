package com.example.ocr;

import java.io.Serializable;

/** 
 * MyBitmap��Ҫ�����л����� 
 * ���а�����ͨ��BytesBitmap��õ���Bitmap�����ݵ����� 
 * ��һ������λͼ�����ֵ��ַ��������ڱ�ʶͼƬ 
 * @author joran 
 * 
 */  
class MyBitmap implements Serializable {  
    /** 
     * serialVersionUID����: 
     * http://www.blogjava.net/invisibletank/archive/2007/11/15/160684.html 
     */  
    private static final long serialVersionUID = 1L;  
    private byte[] bitmapBytes = null;  
    private String name = null;  
  
    public MyBitmap(byte[] bitmapBytes, String name) {  
        // TODO Auto-generated constructor stub  
        this.bitmapBytes = bitmapBytes;  
        this.name = name;  
    }  
  
    public byte[] getBitmapBytes() {  
        return this.bitmapBytes;  
    }  
  
    public String getName() {  
        return this.name;  
    }  
}  

