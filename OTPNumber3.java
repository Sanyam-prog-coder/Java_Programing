import java.security.SecureRandom;
import java.util.Scanner;

class OTPNumber3 
{

    public static String generateOTP() 
    {
        SecureRandom random = new SecureRandom();
        return String.format("%06d", random.nextInt(1_000_000));
    }

    // Simulate sending OTP to the user
    public static void sendOTP(String number, String otp) 
    {
        System.out.println("OTP sent successfully to: " + number);
        System.out.println("Your OTP is: " + otp);
        System.out.println("OTP is valid for 10 seconds.");
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

        // OTP validity time = 10 seconds for testing
        long otpValidityTime = 10 * 1000;

        // Generate first OTP
        String generatedOTP = generateOTP();

        // Store OTP generation time
        long otpGenerationTime = System.currentTimeMillis();

        // Send first OTP
        sendOTP(Num, generatedOTP);

        // OTP verification loop
        while (true) 
        {

            System.out.print("\nEnter the OTP: ");
            String enteredOTP = sc.next();

            // Calculate current time
            long currentTime = System.currentTimeMillis();

            // Calculate elapsed time
            long elapsedTime = currentTime - otpGenerationTime;

            // Check whether OTP expired
            if (elapsedTime > otpValidityTime) 
            {

                System.out.println("\nOTP has expired.");

                // Generate new OTP
                generatedOTP = generateOTP();

                // Reset OTP generation time
                otpGenerationTime = System.currentTimeMillis();

                // Send new OTP
                sendOTP(Num, generatedOTP);

                // Start verification again
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