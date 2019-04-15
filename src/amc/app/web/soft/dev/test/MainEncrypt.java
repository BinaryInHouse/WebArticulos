package amc.app.web.soft.dev.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import amc.app.web.soft.dev.util.Encrypt;



public class MainEncrypt {
	
	public static void main(String args[]) throws GeneralSecurityException, IOException{
	
		String clave="abc";
		Encrypt.init("G4l4XYTR41N1NG");
		System.out.println(Encrypt.encrypt(clave));
		
		System.out.println(Encrypt.decrypt("xdlOnb5Nv0M="));
		// +MJMXqhhBQK8yFZpwbVE7A==
		// uElq0poo45U2DhmzuWsTgQ==
		
	}

}
