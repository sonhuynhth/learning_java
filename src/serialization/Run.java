package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Run {
    public static void main(String[] args) {
        Employee employee =new Employee("Le Tan Tai","Sai Gon",12);
        try {

            // Serializing object
            FileOutputStream fileOutputStream = new FileOutputStream("data_out/employee.data");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee);
            objectOutputStream.close();
            fileOutputStream.close();

            // Deserializing object
            Employee deserializeEmp= null;
            FileInputStream fileInputStream =new FileInputStream("data_out/employee.data");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            deserializeEmp= (Employee) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            if(deserializeEmp!=null)
            System.out.println(deserializeEmp.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
