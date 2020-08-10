package sequencia;

import java.util.Scanner;
import java.util.Stack;

public class Sequencia {
	Scanner sc = new Scanner(System.in);
	
	private String mostrarMenu() {
		System.out.println("Digite a sequência para verificação "
				+ "ou digite sair para encerrar:");
		return sc.nextLine();
	}
		
	public void iniciar() {		
		String sequencia = mostrarMenu();
		while(!sequencia.equals("sair")) {
			boolean isSequenciaOk = true;
			Stack<String> stack = new Stack<String>();			
			
			for(int i = 0; i < sequencia.length(); i++) {
				if(!isSequenciaOk) {
					break;
				}
				
				char c = sequencia.charAt(i);
				
				switch (c) {
				
				case ')':
					
					if (stack.isEmpty()) {
						System.out.println("Sequência inválida");
						sequencia = mostrarMenu();
						isSequenciaOk = false;
					} else {
						String elemento = stack.pop();
						if (!elemento.equals("(")) {
							System.out.println("Sequência inválida");
							sequencia = mostrarMenu();
							isSequenciaOk = false;	
						}
					}
					break;
					
					case ']':
						if (stack.isEmpty()) {
							System.out.println("Sequência inválida");
							sequencia = mostrarMenu();
							isSequenciaOk = false;
						} else {
							String elemento = stack.pop();
							if (!elemento.equals("[")) {
								System.out.println("Sequência inválida");
								sequencia = mostrarMenu();
								isSequenciaOk = false;	
							}
						 }
					break;	
				
				default:
					stack.push(String.valueOf(c));
				}
				
			}
			if (stack.isEmpty()) {
				System.out.println("A sequência esta correta!");
			}else {
				System.out.println("Sequência inválida!");
			}
			sequencia = mostrarMenu();
		}
		
	}

}
