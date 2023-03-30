package sc_internal;
import java.util.*;
public class BreakShift_sc {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s;
		int key;
		System.out.println("enter the plain text:");
		s=sc.next();
		s=s.toUpperCase();
		char[] c=new char[s.length()];
		c=s.toCharArray();
		char[] h=new char[c.length];
		char[] l=new char[c.length];
		System.out.println("enter the key:");
		key=sc.nextInt();
		System.out.println("encrypted text is:");
		for(int i=0;i<c.length;i++)
		{
			h[i]=(char)(((int)c[i]+key-65)%26+65);
			System.out.print(h[i]);
		}
		System.out.println();
		System.out.println("decrypted text is:");
		for(int i=0;i<c.length;i++)
		{
			l[i]=(char)(((int)h[i]+(26-key)-65)%26+65);
			System.out.print(l[i]);
		}
	}

}
