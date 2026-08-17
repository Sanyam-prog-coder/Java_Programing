import java.security.SecureRandom;
import java.util.Scanner;

public class OTPGenerator 
{

    public static String generateOTP() 
    {
        // Generate a random 6-digit OTP
        SecureRandom random = new SecureRandom();
        return String.format("%06d", random.nextInt(1_000_000));
    }

    public static boolean verifyOTP(String generatedOTP, String enteredOTP) 
    {
        // Compare the generated OTP with the entered OTP
        return generatedOTP.equals(enteredOTP);
    }

    public static void main(String[] args) 
    {   
        Scanner scanner = new Scanner(System.in);

        // OTP Generation
        String generatedOTP = generateOTP();

        // OTP Reciever
        System.out.println("One Time Password is Valid for 2 minutes: " + generatedOTP);
        System.out.println("OTP sent Successfully ");

        // Checking OTP
        System.out.print("Enter the OTP: ");
        String enteredOTP = scanner.nextLine();

        // Answering the OTP verification
        if(generatedOTP.equals(enteredOTP))
        {
            System.out.println("OTP verified successfully!");
        } 
        else 
        {
            System.out.println("Invalid OTP. Please try again.");
        }

        scanner.close();
    }
}