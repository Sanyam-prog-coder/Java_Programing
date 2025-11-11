import java.io.*;
import java.net.*;

class ChatClient
{
    public static void main(String a[]) throws Exception
    {



        Socket sobj = new Socket("localhost",5100);
        System.out.println("Clients gets Connected with Server succefully");

        PrintStream pobj = new PrintStream(sobj.getOutputStream());
        BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
        BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in));




        System.out.println("Enter Message for Server ");
        String str = bobj2.readLine();
        pobj.println(str);



        str = bobj1.readLine();
        System.out.println("Server says " +str);
    }
}