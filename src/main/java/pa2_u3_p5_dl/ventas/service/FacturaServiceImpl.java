package pa2_u3_p5_dl.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pa2_u3_p5_dl.ventas.repository.IFacturaRepository;
import pa2_u3_p5_dl.ventas.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Override
	public Factura buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarPorNumero(numero);
	}

	@Override
	public void guardar(Factura factura) {
		// TODO Auto-generated method stub
		this.iFacturaRepository.insertar(factura);
	}

	@Override
	public List<Factura> buscarFacturasInnerJoin(String cedula) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturasInnerJoin(cedula);
	}

	@Override
	public List<Factura> buscarFacturasRightJoin(String cedula) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturasRightJoin(cedula);
	}

	@Override
	public List<Factura> buscarFacturasLeftJoin(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturasLeftJoin(numero);
	}

	@Override
	public List<Factura> buscarFacturasFullJoin(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturasFullJoin(numero);
	}
	
}
