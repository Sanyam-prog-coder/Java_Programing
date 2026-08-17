import java.util.Scanner;
import java.security.SecureRandom;


class OTP
{
    public static String generateOTP()
    {
        SecureRandom random = new SecureRandom();

        int otp = 100000 + random.nextInt(900000);

        return String.valueOf(otp);
    }
    public static void main(String A[])
    {
        System.out.println("OTP is Valid for 2 min " + generateOTP());
    }
}