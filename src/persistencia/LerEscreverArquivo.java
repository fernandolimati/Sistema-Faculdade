package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LerEscreverArquivo {
		
	private String gerarCaminhoArquivo(String nomeArquivo) {
		String diretorio  = new java.io.File(".").toURI().toString();
		diretorio = diretorio.substring(6,diretorio.length()-2);
		diretorio = diretorio.replaceAll("%20"," ");
		diretorio = diretorio + "src/arquivosDados/" + nomeArquivo;		
		return diretorio;
	}
	private String gerarCaminhoPasta() {
		String diretorio  = new java.io.File(".").toURI().toString();
		diretorio = diretorio.substring(6,diretorio.length()-2);
		diretorio = diretorio.replaceAll("%20"," ");
		diretorio = diretorio + "src/arquivosDados/";		
		return diretorio;
	}
	
	public ArrayList<String> lerArquivo(String nomeArquivo) throws Exception{
		String caminhoTotal = gerarCaminhoArquivo(nomeArquivo);
		BufferedReader fileReader = null;
		ArrayList<String> listaSaida = new ArrayList<String>();
        try {
        	String linha = "";          
            fileReader = new BufferedReader(new FileReader(caminhoTotal));     
			while ((linha = fileReader.readLine()) != null) listaSaida.add(linha);               
			
		} catch (FileNotFoundException e) {
			throw new Exception("Arquivo não Encontrado!");
		} catch (IOException ex) {
			
		}
		
		return listaSaida;
	}
	public ArrayList<String> lerArquivoEncriptado(String nomeArquivo) throws Exception{
		String caminhoTotal = gerarCaminhoArquivo(nomeArquivo);
		BufferedReader fileReader = null;
		ArrayList<String> listaSaida = new ArrayList<String>();
        Encriptador chave = new Encriptador();
        String linha = "";          
        fileReader = new BufferedReader(new FileReader(caminhoTotal));     
        while((linha = fileReader.readLine()) != null) {
			listaSaida.add(chave.desencriptarString(linha));
		}
        fileReader.close();
		return listaSaida;
	}
	
	public void escreverArquivo(ArrayList<String> listaLinha,String nomeArquivo) throws IOException {
		File dir = new File(gerarCaminhoPasta());
        File arq = new File(dir,nomeArquivo);
        try {
            arq.createNewFile();
            FileWriter fileWriter = new FileWriter(arq, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (String linha : listaLinha) printWriter.println(linha);
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void escreverArquivoEncriptado(ArrayList<String> listaLinha,String nomeArquivo) throws IOException {
		File dir = new File(gerarCaminhoPasta());
        File arq = new File(dir,nomeArquivo);
        try {
            arq.createNewFile();
            FileWriter fileWriter = new FileWriter(arq, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            Encriptador key = new Encriptador();
            for (String linha : listaLinha) printWriter.println(key.encriptarString(linha));
            printWriter.flush();
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public void escreverArquivoEncriptadoFinal(String nomeArquivo,String linha) throws Exception {
		File dir = new File(gerarCaminhoPasta());
        File arq = new File(dir,nomeArquivo);
        try {
            FileWriter fileWriter = new FileWriter(arq, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            Encriptador key = new Encriptador();
            printWriter.println(key.encriptarString(linha));
            printWriter.flush();
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
