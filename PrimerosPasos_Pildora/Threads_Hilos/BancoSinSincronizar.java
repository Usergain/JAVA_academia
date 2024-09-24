import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSinSincronizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco b = new Banco();

		for (int i = 0; i < 100; i++) {
			EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);
			Thread t = new Thread(r);
			t.start();
		}
	}
}

class Banco {

	private final double[] cuentas;
	//private Lock cierreBanco = new ReentrantLock();
	//private Condition saldoSuficiente;

	public Banco() {

		cuentas = new double[100];

		for (int i = 0; i < cuentas.length; i++) {
			cuentas[i] = 2000;
		}

		//saldoSuficiente = cierreBanco.newCondition();
	}

	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {
		//cierreBanco.lock();
		//try {
			// if (cuentas[cuentaOrigen] < cantidad) { // Evalua que el saldo no es inferior
			// a la transferencia
			while (cuentas[cuentaOrigen] < cantidad) {
				// System.out.println("------------- CANTIDAD INSUFICIENTE: " + cuentaOrigen +
				// "......SALDO: " + cuentas[cuentaOrigen] + "....." + cantidad);
				// return;// Vuelve al principio sin hacer nada
				/*try {
					saldoSuficiente.await(); // Para dejar la transferencia a la espera hasta que tenga saldo.
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				try {
					wait(); //Al ser solo una unica condicion valdría Synchornizer y wait (cierre implicito). Si habria muchas condiciones 
					// tendriamos que tirar de Lock y Condition (cierre explicito).
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			// }else {
			System.out.println(" ---------- CANTIDAD OK -----------------" + cuentaOrigen);
			// }
			System.out.println(Thread.currentThread());
			cuentas[cuentaOrigen] -= cantidad; // dinero que sale de la cuenta origen
			// printeado customizado:
			System.out.printf("%10.2f de %d para %d ", cantidad, cuentaOrigen, cuentaDestino);
			cuentas[cuentaDestino] += cantidad;
			System.out.printf("Saldo total: %10.2f%n", getSaldoTotal());
			//saldoSuficiente.signalAll(); //despertar los hilos
			notifyAll(); //despertar los hilos con Synchronizer
		}// finally {
			//cierreBanco.unlock();
		//}
	//}

	public double getSaldoTotal() {
		double suma_cuentas = 0;

		for (double d : cuentas) {
			suma_cuentas += d;
		}
		return suma_cuentas;
	}

}

class EjecucionTransferencias implements Runnable {

	private Banco banco;
	private int deLaCuenta;
	private double cantidadMax;

	public EjecucionTransferencias(Banco b, int de, double max) {
		banco = b;
		deLaCuenta = de;
		cantidadMax = max;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			int paraLaCuenta = (int) (100 * Math.random()); // numero aleatorio 0-100(*100)
			double cantidad = cantidadMax * Math.random(); // 2000 x numero(0-1)=cantidad de dinero a transf.
			banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
			try {
				Thread.sleep((int) (Math.random() * 10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}


