import java.security.SecureRandom;
import java.util.Scanner;

class OTPNumber
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
    public static void main(String A[])
    {
        Scanner sc = new Scanner(System.in);
        
        // Number for which OTP is to be generated
        System.out.println("Enter the Number: ");
        String Num = sc.next();

        // Fillter for invalid number
        if(Num.length() != 10)
        {
            System.out.println("Invalid Number");
            sc.close();
            return;
        }

        // OTP Generation
        String generatedOTP = generateOTP();

        // Store OTP generation time
        long otpGenerationTime = System.currentTimeMillis();

        // OTP valid for 2 minutes (120000 milliseconds)
        long otpValidityTime = 2 * 60 * 1000;

        // OTP Reciever
        System.out.println("One Time Password is Valid for 2 minutes: " + generatedOTP);
        System.out.println("OTP sent Successfully ");

        // Checking OTP
        System.out.print("Enter the OTP: ");
        String enteredOTP = sc.next();

        // calculate the time elapsed since OTP generation
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - otpGenerationTime;

        // Check time limit first
        if(elapsedTime > otpValidityTime)
        {
            System.out.println("OTP has expired. Please request a new OTP.");
        }
        else if(verifyOTP(generatedOTP, enteredOTP))
        {
            System.out.println("OTP verified successfully!");
        } 
        else 
        {
            System.out.println("Invalid OTP. Please try again.");
        }

        sc.close();
    }
}