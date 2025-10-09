class Demo
{
    public int i;
    public static int j;

    static
    {
        j = 21;
    }

    public Demo()
    {
        System.out.println("Inside Default");
        this.i = 11;        // First Use
    }

    public Demo(int A)
    {
        this();     // Second Use
        System.out.println("Inside parametries");
    }

    public void Display()
    {
        System.out.println("Inside Display"+this.i);        // Third Use
    }
}

class ThisDemo
{
    public static void main(String A[])
    {
        Demo dobj = new Demo(51);
        dobj.Display();

    }
}