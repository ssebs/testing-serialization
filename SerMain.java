
import java.io.Serializable;
import java.io.*;
import java.net.*;

class SerMain
{
    
    
    
    public static void main(String[] args)
    { 
        //Heres the string to try and downlaod
        // https://github.com/ssebs/testing-serialization/raw/master/temp2.txt
        
        try{
           // String datums = URLDataHelper.getStringDataAsString("https://raw.githubusercontent.com/ssebs/ssebsEngine/master/ssebs%20Engine/Misc/serverTestFile.txt");
         //   System.out.println(datums);
            
        //    FileInputStream fin = new FileInputStream("temp2.out"); LOCAL FILE
            InputStream fin = new URL("https://github.com/ssebs/testing-serialization/raw/master/temp2.txt").openStream(); // URL
            ObjectInputStream ois = new ObjectInputStream(fin);
            Dog dawg =  (Dog)ois.readObject();
            ois.close();
            System.out.println(dawg.toString());
    
        }catch(Exception e)
        {
            e.printStackTrace();
        }
     
 
    }
 
/**
 * returns a Dog object from a URL from the internet 
 */
 private Dog readObject(String url)
 {
     Dog dawg;
     try {
          InputStream fin = new URL(url).openStream(); // URL
            ObjectInputStream ois = new ObjectInputStream(fin);
             dawg = (Dog) ois.readObject();
            ois.close();
     } catch(Exception e) {
     }
     return dawg;
 }
 
 /**
 * returns a Dog object from a local file
 */
 private Dog readObject(String path)
 {
     Dog dawg;
     try {
          InputStream fin = new FileInputStream(path); //local file
            ObjectInputStream ois = new ObjectInputStream(fin);
             dawg = (Dog) ois.readObject();
            ois.close();
     } catch(Exception e) {
     }
     return dawg;
 }
 /**
  * saves a Dog object to a path
  */
 private void saveObject(Dog d, String path)
 {
    try {
        FileOutputStream fos = new FileOutputStream(path);
    	ObjectOutputStream oos = new ObjectOutputStream(fos);
    	oos.writeObject(d);
    	oos.flush();
    	oos.close();
    } catch(Exception e) {
    }
 }
 
 
    
}
class Dog implements Serializable{
    
    int age;
    int height;
    String name;
    public Dog(String name, int age, int height)
    {
        this.age = age;
        this.height = height;
        this.name = name;
    }
    
    public String toString(){
        return "Dog: " + name + " is " + age + " old and is " + height + "tall";
    }
    
}