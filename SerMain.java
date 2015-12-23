
import java.io.Serializable;
import java.io.*;
import java.net.*;
import java.util.*;

class SerMain
{
    private static String myUrl;
    private static boolean isLocal;
    
    public static void main(String[] args)
    { 
        // myUrl = "https://github.com/ssebs/testing-serialization/raw/master/temp2.txt"; // Online place
        // myUrl = "temp.out"; // local place
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a path or url to a Dog object.");
        myUrl = scan.nextLine();
        if(myUrl.startsWith("http"))
        {
            isLocal = false;
        } else 
        {
            isLocal = true;    
        }
        
        System.out.println(readObject(isLocal, myUrl));
        scan.close();
    }
 
/**
 * returns a Dog object from a URL from the internet 
 */
 private static Dog readObject(boolean isLocal, String path)
 {
    Dog dawg = null;
    try 
    {
        if(isLocal)
        {
            InputStream fin = new FileInputStream(path); //local file
            ObjectInputStream ois = new ObjectInputStream(fin);
            dawg = (Dog) ois.readObject();
            ois.close();
        }else 
        {
            InputStream fin = new URL(path).openStream(); // URL
            ObjectInputStream ois = new ObjectInputStream(fin);
            dawg = (Dog) ois.readObject();
            ois.close();
        }
    } catch(Exception e) 
    {
        e.printStackTrace();
    }
    return dawg;
 }
 
 /**
  * saves a Dog object to a path
  */
 private static void saveObject(Dog d, String path)
 {
    try
    {
        FileOutputStream fos = new FileOutputStream(path);
    	ObjectOutputStream oos = new ObjectOutputStream(fos);
    	oos.writeObject(d);
    	oos.flush();
    	oos.close();
    } catch(Exception e) 
    {
        e.printStackTrace();
    }
 }
 
 
    
}
class Dog implements Serializable
{
    int age;
    int height;
    String name;
    
    public Dog(String name, int age, int height)
    {
        this.age = age;
        this.height = height;
        this.name = name;
    }
    
    public String toString()
    {
        return "Dog: " + name + " is " + age + " old and is " + height + "tall";
    }
    
}