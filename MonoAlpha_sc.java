package sc_internal;
import java.util.*;
public class MonoAlpha_sc {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s;
		System.out.println("enter the plain text:");
		s=sc.next();
		char al[]= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char rl[]= {'q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
		System.out.println("encrypted text is:");
		char e[]=new char[s.length()];
		char d[]=new char[s.length()];
		for(int i=0;i<s.length();i++)
		{
			for(int j=0;j<26;j++)
			{
				if(al[j]==s.charAt(i))
				{
					e[i]=rl[j];
					System.out.print(e[i]);
				}
			}
		}
		System.out.println();
		System.out.println("decrypted text is:");
		for(int i=0;i<s.length();i++)
		{
			for(int j=0;j<26;j++)
			{
				if(e[i]==rl[j])
				{
					d[i]=al[j];
					System.out.print(d[i]);
				}
			}
		}
	}

}
