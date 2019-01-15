/**
 *  Version: 1.0
 * 	Class: EncryptionHandler
 * 	Description: Handles Password Encryption
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */


package naartjie;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionHandler 
{
	//Properties
	String generatedPassword = null;
	
	//Encrypts Password
	public String encrypt(String password) 
	{
	     
	        try 
	        {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            md.update(password.getBytes());
	            byte[] bytes = md.digest();
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            return generatedPassword= sb.toString();
	        }
	        catch (NoSuchAlgorithmException e)
	        {
	            e.printStackTrace();
	        }
			return generatedPassword;
	}
	


}
