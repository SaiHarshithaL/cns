package sc_internal;
import java.io.*;
import java.net.*;
public class Ds {

	public static void main(String[] args)throws IOException{
		try
		{
			double cp,cg,ca,bdash,B;
			String bstr;
			int port=8088;
			int b=3;
			ServerSocket ss=new ServerSocket(port);
			System.out.println("waiting to conenect"+ss.getLocalPort());
			Socket s=ss.accept();
			System.out.println("connected to client at port:"+s.getRemoteSocketAddress());
			System.out.println("from server private key:"+b);
			DataInputStream in=new DataInputStream(s.getInputStream());
			cp=Integer.parseInt(in.readUTF());
			System.out.println("from client p:"+cp);
			cg=Integer.parseInt(in.readUTF());
			System.out.println("from client g:"+cg);
			ca=Double.parseDouble(in.readUTF());
			System.out.println("from client public key:"+ca);
			B=(Math.pow(cg,b)%cp);
			bstr=Double.toString(B);
			OutputStream os=s.getOutputStream();
			DataOutputStream o=new DataOutputStream(os);
			o.writeUTF(bstr);
			bdash=(Math.pow(ca, b)%cp);
			System.out.println("secret key to perform encryption:"+bdash);
			
			
		}
		catch(SocketTimeoutException s)
		{
			System.out.println("socket time out");
		}
		catch(IOException e)
		{
			
		}

	}

}
