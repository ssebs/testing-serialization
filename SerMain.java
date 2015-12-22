
import java.io.Serializable;
import java.io.*;

class SerMain
{
    
    
    
    public static void main(String[] args)
    { 
        try{
              String datums = URLDataHelper.getStringDataAsString("https://raw.githubusercontent.com/ssebs/ssebsEngine/master/ssebs%20Engine/Misc/serverTestFile.txt");
      System.out.println(datums);
      FileOutputStream fos = new FileOutputStream("temp2.txt");
    	ObjectOutputStream oos = new ObjectOutputStream(fos);
    	Dog d = new Dog("Dog2", 36, 4);
    	oos.writeObject(d);
    	oos.flush();
    	oos.close();
    
        }catch(Exception e)
        {
            e.printStackTrace();
        }
     
    }
    
}
class Dog  implements Serializable{
    
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