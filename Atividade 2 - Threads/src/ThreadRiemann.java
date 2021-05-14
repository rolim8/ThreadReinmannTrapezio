
public class ThreadRiemann extends Thread {
	
	
	public double f(double x){ 

	    return  2.971 * Math.exp(0.138 * x); 

	}
	
	public double regraRiemann(double start, double end, int n){
	
	double h = 0;
	double xi = 0;
	double areaAprox = 0;
	int i = 0;
		
	h = (end - start) / n;

	for (i = 0; i < n; i++){
		
		xi = start + i * h;
		areaAprox += h * f(xi);
	}
	
	return  areaAprox;
   }
	
	public void run () {
		System.out.println("Iniciando a thread " + Thread.currentThread().getId() + " - Método Riemann");
		try {
			double inicio = System.currentTimeMillis();
			double area = this.regraRiemann(70, 190, 900000000);
			double fim = System.currentTimeMillis();
			System.out.println(String.format("Área total pela regra do Riemann: %.1f - Duração: %.3f ms", area, (fim - inicio)));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
}