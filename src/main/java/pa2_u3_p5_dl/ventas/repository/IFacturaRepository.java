package pa2_u3_p5_dl.ventas.repository;

import java.util.List;

import pa2_u3_p5_dl.ventas.repository.modelo.Factura;

public interface IFacturaRepository {

	public Factura seleccionarPorNumero(String numero);
	public void insertar(Factura factura);
	public List<Factura> seleccionarFacturasInnerJoin();
	public List<Factura> seleccionarFacturasRightJoin(String cedula);
	public List<Factura> seleccionarFacturasLeftJoin(String numero);
	public List<Factura> seleccionarFacturasFullJoin(String numero);
	public List<Factura> seleccionarFacturasWhereJoin();
	public List<Factura> seleccionarFacturasFetchJoin();
}
