package pa2_u3_p5_dl.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
import pa2_u3_p5_dl.ventas.repository.IClienteRepository;
import pa2_u3_p5_dl.ventas.repository.modelo.Cliente;

@Service

public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository iClienteRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		
			this.iClienteRepository.insertar(cliente);
		
	}
}