package classes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class GeradorHash {

	public String gerarHash(String texto) throws NoSuchAlgorithmException {
		
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(texto.getBytes());

        byte byteData[] = md.digest();

        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
		return hexString.toString();
	}	
	
	public boolean compararHash(String hashInicial, String textoValidar) {
		try {
			String hashGerada = gerarHash(textoValidar);
			if(hashInicial.equals(hashGerada)) {
				return true;
			}else {
				return false;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return false;
		
	}

}
