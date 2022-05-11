import java.text.DecimalFormat;

public abstract class Conta {
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	private boolean transferencia = false;
	
	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	public void sacar(double valor) {
		if (valor > this.saldo) {
			System.out.println("Saque não realizado por insuficiência de saldo.");
		}
		else {
			saldo -= valor;
			if (transferencia) {
				System.out.println("Transferência realizada com sucesso.");
				System.out.println("Saldo atualizado: " + saldo  + "\n");
				this.transferencia = false;
			}
			else {
				System.out.println("Saque realizado com sucesso.");
				System.out.println("Saldo atualizado: " + saldo + "\n");
			}
			
			
		}
		
	}
	
	public void depositar(double valor) {
		saldo += valor;
	}
	
	public void transferir(double valor, Conta contaDestino) {
		this.transferencia = true;
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	
	public void imprimirInfoComuns() {
		System.out.println("Titular: " + cliente.getNome());
		System.out.println("Agência: " + agencia);
		System.out.println("Número da conta: " + numero);
		System.out.println("Saldo: R$ " + df.format(saldo) + "\n");
	}
	
	public int getAgencia() {
		return agencia;
	}
	public int getNumero() {
		return numero;
	}
	public double getSaldo() {
		return saldo;
	}

	protected abstract void imprimirExtrato();
	
}
