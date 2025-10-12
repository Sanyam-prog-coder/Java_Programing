class Demo extends Thread
{
    public void run()
    {
        System.out.println("Inside run Method of :"+Thread.currentThread().getName());
    }
}

class ThreadUserDefinedJoinXX
{
    public static void main(String A[])
    {
        System.out.println("Inside main Thread");

        Demo dobj1 = new Demo();
        Demo dobj2 = new Demo();

        dobj1.setName("Fist");
        dobj2.setName("Second");
        
        dobj1.start();
        dobj2.start();
        
        // checked Exception
        try
        {
            dobj1.join();
            dobj2.join();
        }
        catch(InterruptedException iobj)
        {}

        System.out.println("End of main Thread");
    }
}