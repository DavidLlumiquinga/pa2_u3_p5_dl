package pa2_u3_p5_dl.ventas.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
import pa2_u3_p5_dl.ventas.repository.IClienteRepository;
import pa2_u3_p5_dl.ventas.repository.modelo.Cliente;

@Service

public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository iClienteRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(Cliente cliente) {
        try {
            this.iClienteRepository.insertar(cliente);
            //simulando demora por diferentes consultas
            TimeUnit.SECONDS.sleep(1);
        } catch (RuntimeException e) {
            // TODO: handle exception
            System.out.println(e.getClass());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }//commit
	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println("Este es un metodo supports");
		System.out.println("Prueba Supports: " + TransactionSynchronizationManager.isActualTransactionActive());

	}

	@Override
	@Transactional(value = TxType.NEVER)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("Este es un metodo Never");
		System.out.println("Prueba Never: " + TransactionSynchronizationManager.isActualTransactionActive());

	}
}
