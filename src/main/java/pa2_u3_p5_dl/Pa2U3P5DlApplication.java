package pa2_u3_p5_dl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import pa2_u3_p5_dl.ventas.repository.modelo.Cliente;
import pa2_u3_p5_dl.ventas.repository.modelo.Factura;
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
	System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
	Factura fact = new Factura();
	fact.setCedula("100235615");
	fact.setFecha(LocalDateTime.now());
	fact.setNumero("001-002");
	
	Cliente cli=new Cliente();
	cli.setNombre("David");
	cli.setApellido(null);
	//this.iFacturaService.guardar(fact,cli);
	
	
	System.out.println("MAIN: " +TransactionSynchronizationManager.isActualTransactionActive());
	this.iFacturaService.prueba();
	
	}
}