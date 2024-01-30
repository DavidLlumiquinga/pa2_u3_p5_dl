package pa2_u3_p5_dl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pa2_u3_p5_dl.ventas.repository.modelo.DetalleFactura;
import pa2_u3_p5_dl.ventas.repository.modelo.Factura;
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
		
		System.out.println("INNER JOIN");

		List<Factura> lista=this.iFacturaService.buscarFacturasInnerJoin();
		for(Factura f:lista) {
			System.out.println(f.getNumero());
//			for(DetalleFactura d: f.getDetalleFacturas()) {
//				System.out.println(d.getNombreProducto());
//			}
		}

		System.out.println("WHERE JOIN");

		List<Factura> lista2=this.iFacturaService.buscarFacturasWhereJoin();
		for(Factura f:lista2) {
			System.out.println(f.getNumero());
			for(DetalleFactura d: f.getDetalleFacturas()) {
				System.out.println(d.getNombreProducto());
			}
			
			
		}
		//FETCH eficiente en terminos de numero de consultas
		//Native Query es mas rapido SQL puro (hibernate)
		System.out.println("FETCH JOIN");

		List<Factura> lista3=this.iFacturaService.buscarFacturasFetchJoin();
		for(Factura f:lista3) {
			System.out.println(f.getNumero());
			for(DetalleFactura d: f.getDetalleFacturas()) {
				System.out.println(d.getNombreProducto());
			}
		}
	}
}