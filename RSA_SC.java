package sc_internal;
import java.math.BigInteger;
import java.security.SecureRandom;
public class RSA_SC {
	private static final BigInteger one=new BigInteger("1");
	private static final SecureRandom random=new SecureRandom();
	private BigInteger publickey;
	private BigInteger privatekey;
	private BigInteger modulus;
	RSA_SC(int N)
	{
		BigInteger p=BigInteger.probablePrime(N/2,random);
		BigInteger q=BigInteger.probablePrime(N/2,random);
		BigInteger phi=(p.subtract(one)).multiply(q.subtract(one));
		System.out.println("prime p:"+p);
		System.out.println("prime q:"+q);
		System.out.println("phi="+phi);
		modulus=p.multiply(q);
		publickey=new BigInteger("65537");
		privatekey=publickey.modInverse(phi);
		System.out.println("pk="+publickey);
		System.out.println("prk="+privatekey);
		System.out.println("mod="+modulus);
	}
	BigInteger enc(BigInteger m)
	{
		return m.modPow(publickey, modulus);
	}
	BigInteger dec(BigInteger e)
	{
		return e.modPow(privatekey,modulus);
	}
	public static void main(String[] args) {
		int N=10;
		RSA_SC k=new RSA_SC(N);
		BigInteger m=new BigInteger("2");
		BigInteger en=k.enc(m);
		BigInteger de=k.dec(en);
		System.out.println("message="+m);
		System.out.println("encrypted message:"+en);
		System.out.println("decrypted message="+de);

	}

}
