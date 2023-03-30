package sc_internal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.util.*;
public class Sha256_sc {
	public static String getmd(String s)
	{
		try
		{
		MessageDigest md=MessageDigest.getInstance("SHA-256");
		byte[] msd=md.digest(s.getBytes());
		BigInteger no=new BigInteger(1,msd);
		String ht=no.toString(16);
		while(ht.length()<32)
		{
			ht="0"+ht;
		}
		return ht;
		}
		catch(NoSuchAlgorithmException e)
		{
		 throw new RuntimeException(e);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the text:");
		String h=sc.next();
		System.out.println("md5 generated hashcode is:"+getmd(h));
	}

}
