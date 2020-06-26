
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Arrays;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;







public class AES_Lab {

	private static final String ALGO = "AES";
	private static final Key ScKrtKey = null;
	private byte[] KeyVal;
	
	public AES_Lab(String key) {
				KeyVal = key.getBytes();
	}
	
	
	public String encypt(String Data) throws Exception{
			Key key = generateKey();
			Cipher ciph = Cipher.getInstance(ALGO);
			ciph.init(Cipher.ENCRYPT_MODE, key);
			byte[] encV = ciph.doFinal(Data.getBytes());
			//String encryptV = Base64.getEncoder().encode(encV);
			String encryptV = java.util.Base64.getEncoder().encodeToString(encV);
			return encryptV;
	}
	
	
	public String decypt(String encryptedData) throws Exception{
		Key key = generateKey();
		Cipher ciph = Cipher.getInstance(ALGO);
		ciph.init(Cipher.DECRYPT_MODE, key);
		//byte[] decodVal = new Base64.Decoder().decode(encryptedData);
		byte[] decodVal = java.util.Base64.getDecoder().decode(encryptedData);
		byte[] DVAL = ciph.doFinal(decodVal);
		String decryptV = new String(DVAL);
		return decryptV;
		
	}
	
	
	private Key generateKey() throws Exception{
		Key key = new SecretKeySpec(KeyVal, ALGO);
		return key;
		
		
		
	}
	
	public static void main(String[] args) {
		try {
						AES_Lab aes = new AES_Lab("jhktlyipabvtymde");
			String encrypteddata = aes.encypt("Hazematt");
			System.out.println("Encrption Example test 1 = " + encrypteddata);
			String decrypteddata = aes.decypt(encrypteddata);
			System.out.println("Decryption Example Test 2 =" + decrypteddata);
			

		}catch (Exception ex) {
			
			
		}
			 
			
			
		
		
		

		
	}

}
