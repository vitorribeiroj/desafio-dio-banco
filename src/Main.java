
public class Main {

	public static void main(String[] args) {
		
		Cliente vitor = new Cliente("Vitor Jardim");
		Cliente mari = new Cliente("Mariana Mendes");
		
		Conta cc = new ContaCorrente(vitor);
		Conta cp = new ContaPoupanca(mari);
		
		cc.depositar(500);
		
		cc.transferir(200, cp);
		cc.imprimirExtrato();
		cp.imprimirExtrato();
	}

}
