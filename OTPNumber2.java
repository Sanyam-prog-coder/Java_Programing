import java.security.SecureRandom;
import java.util.Scanner;

class OTPNumber2 
{

    public static String generateOTP() 
    {
        SecureRandom random = new SecureRandom();
        return String.format("%06d", random.nextInt(1_000_000));
    }

    public static boolean verifyOTP(String generatedOTP, String enteredOTP) 
    {
        return generatedOTP.equals(enteredOTP);
    }

    public static void main(String A[]) 
    {

        Scanner sc = new Scanner(System.in);

        // Number for which OTP is to be generated
        System.out.print("Enter the Number: ");
        String Num = sc.next();

        // Filter for invalid number
        if (Num.length() != 10 || !Num.matches("\\d+")) 
        {
            System.out.println("Invalid Number");
            sc.close();
            return;
        }

        // OTP validity time = 2 minutes
        long otpValidityTime = 1 * 10 * 1000;

        // Generate first OTP
        String generatedOTP = generateOTP();

        // Store OTP generation time
        long otpGenerationTime = System.currentTimeMillis();

        System.out.println("OTP sent successfully");
        System.out.println("One Time Password is valid for 2 minutes: " + generatedOTP);

        // OTP verification loop
        while (true) 
        {

            System.out.println("Enter the OTP: ");
            String enteredOTP = sc.next();

            // Calculate current time
            long currentTime = System.currentTimeMillis();

            // Calculate elapsed time
            long elapsedTime = currentTime - otpGenerationTime;

            // Check whether OTP expired
            if (elapsedTime > otpValidityTime) 
            {

                System.out.println("OTP has expired.");

                // Generate new OTP
                generatedOTP = generateOTP();

                // Reset OTP generation time
                otpGenerationTime = System.currentTimeMillis();

                System.out.println("New OTP generated!");
                System.out.println("One Time Password is valid for 2 minutes: " + generatedOTP);

                // Continue the loop
                continue;
            }

            // Verify OTP
            if (verifyOTP(generatedOTP, enteredOTP)) 
            {

                System.out.println("OTP verified successfully!");
                break;

            } 
            else 
            {

                System.out.println("Invalid OTP. Please try again.");
            }
        }

        sc.close();
    }
}