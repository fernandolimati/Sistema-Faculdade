package persistencia;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Encriptador {
	
	//3DES (Triplo DES), sigla para Triple Data Encryption Standard
    private static final String UNICODE_FORMAT = "UTF8";
    private static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private Cipher cipher;
    private byte[] arrayBytes;
    private String chaveDeEncriptacao;
    private String schemeDeEncriptacao;
    private SecretKey chave;

    public Encriptador() throws Exception {
    	chaveDeEncriptacao = "TrabalhoDeADS2GrupoFodaa";
    	schemeDeEncriptacao = DESEDE_ENCRYPTION_SCHEME;
        arrayBytes = chaveDeEncriptacao.getBytes(UNICODE_FORMAT);
        ks = new DESedeKeySpec(arrayBytes);
        skf = SecretKeyFactory.getInstance(schemeDeEncriptacao);
        cipher = Cipher.getInstance(schemeDeEncriptacao);
        chave = skf.generateSecret(ks);
    }
    public String encriptarString(String textoParaEncriptar) throws Exception{
        String textoEncriptado = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, chave);
            byte[] finalTexto = textoParaEncriptar.getBytes(UNICODE_FORMAT);
            byte[] textoEncriptadoByte = cipher.doFinal(finalTexto);
            textoEncriptado = new String(Base64.encodeBase64(textoEncriptadoByte));
        } catch (Exception e) {
            System.out.println("ERRO NA ENCRIPTACAO!");
        }
        return textoEncriptado;
    }
    public String desencriptarString(String textoEncriptado) throws Exception{
        String textoDecriptado=null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, chave);
            byte[] textoEncriptadoByte = Base64.decodeBase64(textoEncriptado);
            byte[] finalTexto = cipher.doFinal(textoEncriptadoByte);
            textoDecriptado = new String(finalTexto);
        } catch (Exception e) {
        	System.out.println("ERRO NA DESENCRIPTACAO! AARQUIVO PODE NAO ESTAR ENCRYPTADO");
        }
        return textoDecriptado;
    }
    
    public static void main(String args []) throws Exception{
    	String textEntrada = "02fKvyajk53ZoQyDBnDoOVXcmFIv9Sh5";
    	String textEntradaDesencript = "";
    	String textEntradaEncript = "";
    	Encriptador encrypt = new Encriptador();
    	try {
    		textEntradaDesencript = encrypt.desencriptarString(textEntrada);
    		textEntradaEncript = encrypt.encriptarString(textEntrada);
    		System.out.println("Texto Encriptado     : "+ textEntradaEncript);
    		System.out.println("Texto Desencriptado  : "+ textEntradaDesencript);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    }

}