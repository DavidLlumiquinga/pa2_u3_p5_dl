package pa2_u3_p5_dl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pa2_u3_p5_dl.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5DlApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService iFacturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5DlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//this.iFacturaService.pruebaSupports();
		//this.iFacturaService.pruebaNever();
		
	}
}