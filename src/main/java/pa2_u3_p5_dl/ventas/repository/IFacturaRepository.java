package pa2_u3_p5_dl.ventas.repository;

import pa2_u3_p5_dl.ventas.repository.modelo.Factura;

public interface IFacturaRepository {

	public Factura seleccionarPorNumero(String numero);
	public void insertar(Factura factura);
}
