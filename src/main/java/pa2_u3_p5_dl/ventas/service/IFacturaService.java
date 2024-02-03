package pa2_u3_p5_dl.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import pa2_u3_p5_dl.ventas.repository.modelo.Cliente;
import pa2_u3_p5_dl.ventas.repository.modelo.Factura;
import pa2_u3_p5_dl.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaService {

	public Factura buscarPorNumero(String numero);
	public void guardar(Factura factura,Cliente cliente);
	public List<Factura> buscarFacturasInnerJoin();
	public List<Factura> buscarFacturasRightJoin(String cedula);
	public List<Factura> buscarFacturasLeftJoin(String numero);
	public List<Factura> buscarFacturasFullJoin(String numero);
	public List<Factura> buscarFacturasWhereJoin();
	public List<Factura> buscarFacturasFetchJoin();
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);
	public int borrarPorNumero(String numero);
	public void borrar(Integer id);
	public List<FacturaDTO> buscarFacturasDTO();
}
