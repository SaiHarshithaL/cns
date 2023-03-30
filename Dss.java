package sc_internal;
import java.security.*;
import java.util.Base64;

public class Dss{

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keypairgen=KeyPairGenerator.getInstance("DSA");
        keypairgen.initialize(1024);
        KeyPair kp=keypairgen.generateKeyPair();
        PublicKey pk=kp.getPublic();
        PrivateKey prk=kp.getPrivate();
        String msg="hello";
        byte[] msgbytes=msg.getBytes();
        Signature sign=Signature.getInstance("SHA256withDSA");
        sign.initSign(prk);
        sign.update(msgbytes);
        byte[] ds=sign.sign();
        String b64=Base64.getEncoder().encodeToString(ds);
        System.out.println("digital signature is:"+b64);
        sign.initVerify(pk);
        sign.update(msgbytes);
        boolean v=sign.verify(ds);
        System.out.println("signature verified:"+v);
    }
}