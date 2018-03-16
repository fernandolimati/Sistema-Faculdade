package classes;

public class CPF {

	private String numeroCPF;
	private String dvCPF;
	private String cpfOriginal;
	
	public CPF(String cpfOriginal) throws Exception {
		this.cpfOriginal = cpfOriginal;
		if(validarEntrada()) {
			separarCPF();
		}else {
			throw new Exception("CPF informado invalido.");
		}
		
	}
	public boolean validarCPF() {
		//CALCULO 1 DIGITO VERIFICAADOR
		int soma = 0;
		for(int i=10;i-1>0;i--)
			soma += (Integer.parseInt(Character.toString(numeroCPF.charAt(10-i))))*i;
		
		int dv1 = 11-(soma%11);
		if(dv1 == 10 || dv1 == 11) dv1 = 0;
		
		//CALCULO 2 DIGITO VERIFICAADOR
		soma = 0;
		String numeroCPF2 = numeroCPF+dv1;
		for(int i=11;i-1>0;i--)
			soma += (Integer.parseInt(Character.toString(numeroCPF2.charAt(11-i))))*i;
		
		int dv2 = 11-(soma%11);
		if(dv2 == 10 || dv2 == 11) dv2 = 0;
		
		if(dv1 == Integer.parseInt(Character.toString(dvCPF.charAt(0))) && dv2 == Integer.parseInt(Character.toString(dvCPF.charAt(1)))) {
			return true;
		}else {
			return false;
		}
	}
	private void separarCPF() {
		numeroCPF = cpfOriginal.substring(0, 9);
		dvCPF 	  = cpfOriginal.substring(9, 11);
	}
	private boolean validarEntrada() {
		cpfOriginal = cpfOriginal.replace(".", "");
		cpfOriginal = cpfOriginal.replace("-", "");
		if(cpfOriginal.length() == 11) {
			for(int i=0;i<cpfOriginal.length();i++) {
				if(!caractereValido(cpfOriginal.charAt(i)))
					return false;
			}
			return true;
		}else {
			return false;
		}
		
	}
	private boolean caractereValido(char caractere) {
		String teste = "0123456789";
		for(int i=0;i<teste.length();i++) {
			if(teste.charAt(i) == caractere)
				return true;
		}
		return false;
	}
	public void mostrarDados() {
		System.out.println(cpfOriginal);
		System.out.println(numeroCPF);
		System.out.println(dvCPF);
	}

//	public static void main(String[] args) throws Exception {
//		CPF cpf = new CPF("016.327.251-42");
//		System.out.println(cpf.validarCPF());
//	}

}
