package pa2_u3_p5_dl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pa2_u3_p5_dl.ventas.repository.modelo.DetalleFactura;
import pa2_u3_p5_dl.ventas.repository.modelo.Factura;
import pa2_u3_p5_dl.ventas.repository.modelo.dto.FacturaDTO;
import pa2_u3_p5_dl.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5DlApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService iFacturaService;
	
	/*Join Types en Jakarta Persistence
	1. JOIN 
		1.1 INNER JOIN
		1.2 OUTER JOIN
			1.2.1  RIGHT
			1.2.2  LEFT
			1.2.3  FULL
	2. JOIN WHERE
	3. FETCH JOIN: solo existe a nivel JPA
	*/

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5DlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		System.out.println("UPDATE");
		int cantidad=this.iFacturaService.actualizarFechas(LocalDateTime.of(2020, 1, 15, 12, 50), LocalDateTime.of(2024	, 1, 23, 11, 12));
		System.out.println("Cantidad de registros actualizados: "+cantidad);
		
		System.out.println("DELETE");
		int cantidad2=this.iFacturaService.borrarPorNumero("0001-0856");
		System.out.println("Cantidad de registros actualizados: "+cantidad2);
		
		//this.iFacturaService.borrar(2);
		
		//DTO: Data Transfer Object - Patron de diseño
		System.out.println("DTO");
		List<FacturaDTO> listaDTO=this.iFacturaService.buscarFacturasDTO();
		
		for(FacturaDTO fDto: listaDTO) {
			System.out.println(fDto);
		}
		
	}
}