package pa2_u3_p5_dl.ventas.service;

import pa2_u3_p5_dl.ventas.repository.modelo.Cliente;
import pa2_u3_p5_dl.ventas.repository.modelo.Factura;

public interface IFacturaService {

	public Factura buscarPorNumero(String numero);
	public void guardar(Factura factura,Cliente cliente);
	public void prueba();
	public void borrar(Integer id);
	public void pruebaSupports();
	public void pruebaNever();
}
