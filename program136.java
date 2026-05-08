import java.util.Scanner;

class Logic
{
    void Pattern(int Row, int Col)
    {
        int i = 0, j = 0;
        
        for(i = 0; i < Row; i++)
        {
            char ch = 'A';
            for(j = 0; j < Col; j++)
            {
                System.err.print(ch + "\t");
                ch++;
            }
            System.out.println();
        }
    }
}

class program136
{
    public static void main(String A[])
    {
        int Value1 = 0, Value2 = 0;

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Row: ");
        Value1 = sc.nextInt();

        System.out.print("Enter Column: ");
        Value2 = sc.nextInt();

        Logic lobj = new Logic();

        lobj.Pattern(Value1, Value2);

        sc.close();
    }
}