package sc_internal;
import java.io.*;
import java.net.*;
public class Dc {

	public static void main(String[] args) throws Exception{
		try
		{
		int p=23;
		int g=9;
		int a=4;
		String se="localhost";
		int port=8088;
		String ps,gs,as;
		double adash,A,sb;
		Socket s=new Socket(se,port);
		System.out.println("connected to :"+s.getRemoteSocketAddress());
		OutputStream os=s.getOutputStream();
		DataOutputStream o=new DataOutputStream(os);
		ps=Integer.toString(p);
		o.writeUTF(ps);
		gs=Integer.toString(g);
		o.writeUTF(gs);
		A=(Math.pow(g, a)%p);
		as=Double.toString(A);
		o.writeUTF(as);
		System.out.println("client private key:"+a);
		DataInputStream i=new DataInputStream(s.getInputStream());
		sb=Double.parseDouble(i.readUTF());
		System.out.println("from server public key:"+sb);
		adash=(Math.pow(sb, a)%p);
		System.out.println("server key to perform symmetric encryption:"+adash);
		s.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
