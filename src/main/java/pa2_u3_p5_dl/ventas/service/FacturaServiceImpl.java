package pa2_u3_p5_dl.ventas.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
import pa2_u3_p5_dl.ventas.repository.IFacturaRepository;
import pa2_u3_p5_dl.ventas.repository.modelo.Cliente;
import pa2_u3_p5_dl.ventas.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Autowired
	private IClienteService iClienteService;

	@Override
	public Factura buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarPorNumero(numero);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Factura factura, Cliente cliente) {
		// TODO Auto-generated method
		//solo se utiliza el atributo de un valor transitorio 
		BigDecimal valor=new BigDecimal(100);
		valor=valor.multiply(new BigDecimal(0.12));
		factura.setValorIVA(valor);
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Paso el insert de factura");
		this.iFacturaRepository.insertar(factura);
		System.out.println("Paso el insert de cliente");
		this.iClienteService.guardar(cliente);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iFacturaRepository.eliminar(id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY) // obliga que desde donde se lo llama tenga una transaccion
	public void prueba() {
		// TODO Auto-generated method stub
		System.out.println("Este metodo es de prueba");
		System.out.println("Prueba: " + TransactionSynchronizationManager.isActualTransactionActive());
	}

	@Override
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println("Prueba Factura Supports: " + TransactionSynchronizationManager.isActualTransactionActive());
		this.iClienteService.pruebaSupports();
	}

	@Override
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("Prueba Factura Never: " + TransactionSynchronizationManager.isActualTransactionActive());
		this.iClienteService.pruebaNever();
	}
}
