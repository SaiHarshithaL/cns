package sc_internal;
import javax.crypto.KeyGenerator;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.util.*;
class De{
		Cipher ec;
		Cipher dc;
		public De(SecretKey key)throws Exception
		{
			ec=Cipher.getInstance("DES");
			dc=Cipher.getInstance("DES");
			ec.init(Cipher.ENCRYPT_MODE,key);
			dc.init(Cipher.DECRYPT_MODE,key);	
		}
		public String enc(String s)throws Exception
		{
			byte[] utf=s.getBytes();
			byte[] encr=ec.doFinal(utf);
			return Base64.getEncoder().encodeToString(encr);
		}
		public String dec(String s)throws Exception
		{
			byte[] dcr=Base64.getDecoder().decode(s);
			byte[] utf=dc.doFinal(dcr);
			return new String(utf,"UTF8");
		}
}
public class Des_sc {

	public static void main(String[] args)throws Exception {
		SecretKey sk=KeyGenerator.getInstance("DES").generateKey();
		De em=new De(sk);
		System.out.println("enter a message");
		Scanner sc=new Scanner(System.in);
		String h=sc.next();
		String en=em.enc(h);
		System.out.println("encrypted message:"+en);
		String dn=em.dec(en);
		System.out.println("dec msg is:"+dn);
	}

}
