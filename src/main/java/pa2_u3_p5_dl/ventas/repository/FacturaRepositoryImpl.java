package pa2_u3_p5_dl.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
import pa2_u3_p5_dl.ventas.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("select f from Factura f where f.numero=: numero",
				Factura.class);
		myQuery.setParameter("numero", numero);
		Factura fact = myQuery.getSingleResult();
		fact.getDetalleFacturas().size(); // le digo que cargue el detalle bajo demanda
		return fact;
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);

		/*
		 * INSERT SI (MANDATORY)  Asegura que sea llamado desde una transaccion
		 * UPDATE SI (MANDATORY)  Asegura que sea llamado desde una transaccion
		 * DELETE SI (MANDATORY)  Asegura que sea llamado desde una transaccion
		 * SELECT NO (NOT_SUPPORTED)   Un select no necesita una transaccion 
		 */
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Transactional(value = TxType.NOT_SUPPORTED)
	public Factura buscar(Integer id) {
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Factura> seleccionarTodos() {
		// TODO Auto-generated method 
		TypedQuery<Factura> myQuery=this.entityManager.createQuery("select f from Factura f",Factura.class);
		return myQuery.getResultList();
	}

}
