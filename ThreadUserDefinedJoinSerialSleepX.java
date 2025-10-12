// Code to Demonstrate thread Sheduling

class Demo extends Thread
{
    public void run() 
    {
        int i = 0;
        try
        {
            for(i = 1; i <= 5; i++)
            {
                Thread.sleep(1000);
                System.out.println("Inside run Method of :"+Thread.currentThread().getName());
            }
        }
        catch(InterruptedException iobj)
        {}
    }
}

class ThreadUserDefinedJoinSerialSleepX
{
    public static void main(String A[])
    {
        System.out.println("Inside main Thread");

        Demo dobj1 = new Demo();
        Demo dobj2 = new Demo();

        dobj1.setName("Fist");
        dobj2.setName("Second");
        
        try
        {
            dobj1.start();
            dobj1.join();
          
            dobj2.start();
            dobj2.join();
        }
        
        catch(InterruptedException iobj)
        {}

        System.out.println("End of main Thread");
    }
}