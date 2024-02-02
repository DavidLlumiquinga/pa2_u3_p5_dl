package pa2_u3_p5_dl.ventas.service;

import java.util.List;

import pa2_u3_p5_dl.ventas.repository.modelo.Factura;

public interface IFacturaService {

	public Factura buscarPorNumero(String numero);
	public void guardar(Factura factura);
	public List<Factura> buscarFacturasInnerJoin(String cedula);
	public List<Factura> buscarFacturasRightJoin(String cedula);
	public List<Factura> buscarFacturasLeftJoin(String numero);
	public List<Factura> buscarFacturasFullJoin(String numero);
	public List<Factura> buscarFacturasFetchJoin();
}
