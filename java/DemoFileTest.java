package org.codegaucho.pidley.Base64Codec;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream ;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class DemoFileTest
{
  public static void main(String[] args) {
    File inFile = new File("C:\\Users\\B\\Documents\\Encryption\\motorcycle.jpg");
    File outFile = new File("C:\\Users\\B\\Documents\\Encryption\\newMotorcycle.jpg");
    File encodedFile = new File("C:\\Users\\B\\Documents\\Encryption\\newMotorcycle_jpg.B64");
    File decodedFile = new File("C:\\Users\\B\\Documents\\Encryption\\decodedMotorcycle.jpg");

    byte[] bytes = null ;
    byte[] decodedBytes = null ;
    String encodedBytes = null ;
    FileChannel inChannel = null ;
    FileChannel outChannel = null ;

    FileInputStream inFileStream = null;
    FileOutputStream outFileStream = null ; 
    FileOutputStream encodedFileStream = null ;
    FileOutputStream decodedFileStream = null ;
    
    try {
      inFileStream = new FileInputStream(inFile); 
      outFileStream = new FileOutputStream(outFile) ;
      encodedFileStream = new FileOutputStream(encodedFile) ; 
      decodedFileStream = new FileOutputStream(decodedFile) ;
      bytes = new byte[(int) inFile.length()] ;
      inFileStream.read(bytes) ;
      
      encodedBytes = Base64Codec.encode(bytes) ;
      encodedFileStream.write(encodedBytes.getBytes());
      encodedFileStream.flush();
      encodedFileStream.close() ;
      
      decodedBytes = Base64Codec.decode(encodedBytes) ;
      decodedFileStream.write(decodedBytes) ;
      decodedFileStream.flush() ;
      decodedFileStream.close() ;
             
      outFileStream.write(bytes);
      inFileStream.close() ;
      outFileStream.flush() ;
      outFileStream.close() ;
//      inChannel = inFileStream.getChannel();
  //    outChannel = outFileStream.getChannel() ;
    } catch (FileNotFoundException fnfe) {
      fnfe.printStackTrace(System.err);
    } catch (Exception e) {
      e.printStackTrace(System.err) ;
    }
/*
    final int PRIMECOUNT = 6;
    ByteBuffer buf = ByteBuffer.allocate(8 * PRIMECOUNT);
    long[] primes = new long[PRIMECOUNT];
    try {
      while (inChannel.read(buf) != -1) {
        ((ByteBuffer) (buf.flip())).asLongBuffer().get(primes);
        for (long prime : primes) {
          System.out.printf("%10d", prime);
        }
        buf.clear();
      }
      inFileStream.close();
    } catch (IOException e) {
      e.printStackTrace(System.err);
    }
        */
  }
}






 
