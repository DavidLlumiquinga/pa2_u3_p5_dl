package pa2_u3_p5_dl.ventas.service;

import pa2_u3_p5_dl.ventas.repository.modelo.Factura;

public interface IFacturaService {

	public Factura buscarPorNumero(String numero);
	public void guardar(Factura factura);
}
