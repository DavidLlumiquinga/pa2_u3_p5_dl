package pa2_u3_p5_dl.ventas.repository;

import java.util.List;

import pa2_u3_p5_dl.ventas.repository.modelo.Factura;

public interface IFacturaRepository {

	public Factura seleccionarPorNumero(String numero);
	public void insertar(Factura factura);
	public List<Factura> seleccionarFacturasInnerJoin();
	public List<Factura> seleccionarFacturasRightJoin();
	public List<Factura> seleccionarFacturasLeftJoin();
	public List<Factura> seleccionarFacturasFullJoin();
}
