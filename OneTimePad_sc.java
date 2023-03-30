package sc_internal;
import java.util.*;
public class OneTimePad_sc {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s,k;
		StringBuffer key,en=new StringBuffer(""),de=new StringBuffer("");
		System.out.println("enter the plain text:");
		s=sc.next();
		System.out.println("enter the key:");
		k=sc.next();
		s=s.toUpperCase();
		k=k.toUpperCase();
		key=new StringBuffer(k);
		int j=0;
		if(k.length()==s.length())
			key=new StringBuffer(k);
		else
		{
			for(int i=k.length()-1;i<=s.length();i++)
			{
			    key.append(Character.toString(k.charAt(j)));
				j=(j+1)%(k.length());
			}
		}
		
		for(int i=0;i<s.length();i++)
		{
			int x=(int)s.charAt(i)-65;
			int y=(int)key.charAt(i)-65;
			int z=x^y;
			en.append(Character.toString((char)(z+65)));
		}
		System.out.println("encrypted text is:"+en);
		System.out.println();
		for(int i=0;i<en.length();i++)
		{
			int x=(int)en.charAt(i)-65;
			int y=(int)key.charAt(i)-65;
			int z=x^y;
			de.append(Character.toString((char)(z+65)));
		}
		System.out.println("decrypted text is:"+de);
		

	}

}
