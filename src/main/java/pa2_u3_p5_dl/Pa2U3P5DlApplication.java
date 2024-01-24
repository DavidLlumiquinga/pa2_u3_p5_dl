package pa2_u3_p5_dl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.net.SyslogOutputStream;
import pa2_u3_p5_dl.ventas.repository.modelo.DetalleFactura;
import pa2_u3_p5_dl.ventas.repository.modelo.Factura;
import pa2_u3_p5_dl.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5DlApplication implements CommandLineRunner{

	@Autowired
	private IFacturaService iFacturaService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5DlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		Factura fac=new Factura();
		fac.setCedula("1725896110");
		fac.setFecha(LocalDateTime.now());
		fac.setNumero("0001-0856");
	
		DetalleFactura det1=new DetalleFactura();
		det1.setCantidad(4);
		det1.setCodigoBarras("123456");
		det1.setFactura(fac);
		det1.setNombreProducto("Coca-Cola");
		
		
		DetalleFactura det2=new DetalleFactura();
		det2.setCantidad(2);
		det2.setCodigoBarras("654321");
		det2.setFactura(fac);
		det2.setNombreProducto("Leche Vita");
		
		List<DetalleFactura> detalle=new ArrayList<DetalleFactura>();
		detalle.add(det1);
		detalle.add(det2);
		
		fac.setDetalleFacturas(detalle);
		
		this.iFacturaService.guardar(fac);*/
		
		Factura fact1=this.iFacturaService.buscarPorNumero("0001-0856");
	/*	for(DetalleFactura det: fact1.getDetalleFacturas()) {
			System.out.println(det.getCodigoBarras());
		}*/
		System.out.println(fact1);
	}

}
