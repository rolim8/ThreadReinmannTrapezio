public class ThreadTrapezio extends Thread {
	
	public double f(double x){ 

	    return  2.971 * Math.exp(0.138 * x); 

	}
	
	public double regraTrapezio(double start, double end, int n){

		double h = 0; 
		double xi = 0;
		double areaAprox = 0;
		int i = 0;
			
		h = (end - start) / n;
		
		areaAprox = f(start) + f(end);


		for (i = 1; i < n; i++){
			
			xi = start + i * h;
			
			areaAprox = areaAprox + 2 * f(xi);
		}
		
		return  (h / 2) * areaAprox;
	}    

	public void run () {
		System.out.println("Iniciando a thread " + Thread.currentThread().getId() + " - Método Trapezio");
		try {
			double inicio = System.currentTimeMillis();
			double area = this.regraTrapezio(70, 190, 900000000);
			double fim = System.currentTimeMillis();
			System.out.println(String.format("Área total pela regra do Trapezio: %.1f - Duração: %.3f ms", area, (fim - inicio)));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	

}
