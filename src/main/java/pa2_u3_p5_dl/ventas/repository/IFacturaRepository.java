package pa2_u3_p5_dl.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import pa2_u3_p5_dl.ventas.repository.modelo.Factura;
import pa2_u3_p5_dl.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaRepository {

	public Factura seleccionarPorNumero(String numero);
	public void insertar(Factura factura);
	public void actualizar(Factura factura);
	public int actualizarFechas(LocalDateTime fechaNueva,LocalDateTime fechaActual);
	public int eliminarPorNumero(String numero);
	public void eliminar(Integer id);
	public List<Factura> seleccionarFacturasInnerJoin();
	public List<Factura> seleccionarFacturasRightJoin(String cedula);
	public List<Factura> seleccionarFacturasLeftJoin(String numero);
	public List<Factura> seleccionarFacturasFullJoin(String numero);
	public List<Factura> seleccionarFacturasWhereJoin();
	public List<Factura> seleccionarFacturasFetchJoin();
	public List<FacturaDTO> seleccionarFacturasDTO();
}
