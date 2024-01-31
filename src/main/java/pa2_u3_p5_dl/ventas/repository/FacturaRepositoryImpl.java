package pa2_u3_p5_dl.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import pa2_u3_p5_dl.ventas.repository.modelo.Factura;
import pa2_u3_p5_dl.ventas.repository.modelo.dto.FacturaDTO;

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
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> seleccionarFacturasInnerJoin() {
		// TODO Auto-generated method stub
		// SQL: SELECT * FROM factura f INNER JOIN detalle_factura d on
		// f..fact_id=d.defa_id_factura
		// select f1_0.fact_id,f1_0.fact_cedula,f1_0.fact_fecha,f1_0.fact_numero from
		// factura f1_0 join detalle_factura df1_0 on f1_0.fact_id=df1_0.defa_id_factura

		// JPQL: select f from Factura f inner join f.detalleFacturas d
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("select f from Factura f  join f.detalleFacturas d", Factura.class);
		// carga peresoza
		List<Factura> lista = myQuery.getResultList();
//		for (Factura f : lista) {
//			f.getDetalleFacturas().size();
//		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasRightJoin(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"select f from Factura f right join f.detalleFacturas where f.cedula=: cedula", Factura.class);
		// LAZY: carga peresoza
		myQuery.setParameter("cedula", cedula);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasLeftJoin(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"select f from Factura f left join f.detalleFacturas where f.numero =: numero", Factura.class);
		// LAZY: carga peresoza
		myQuery.setParameter("numero", numero);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFullJoin(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"select f from Factura f full join f.detalleFacturas  where f.numero =: numero", Factura.class);
		// LAZY: carga peresoza
		myQuery.setParameter("numero", numero);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasWhereJoin() {
		// TODO Auto-generated method stub
		// SQL: select f.* from factura f, detalle_factura d WHERE f.fact_id=
		// d_defa_id_factura
		// JPQL: select f from Factura f, DetalleFactura d where f=d.factura
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("select f from Factura f, DetalleFactura d where f=d.factura", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFacturas().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		// JPQL: select f from Factura f join fetch f.detalleFactura d
		// JPQL INNER JOIN: select f from Factura f inner join f.detalleFacturas d
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("select f from Factura f join fetch f.detalleFacturas d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		return lista;
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		// JPQL: update Factura f set f.fecha =: fechaNueva where f.fecha >=
		// :fechaActual
		Query myQuery = this.entityManager
				.createQuery("UPDATE Factura f SET f.fecha = :fechaNueva WHERE f.fecha > :fechaActual");
		myQuery.setParameter("fechaNueva", fechaNueva);
		myQuery.setParameter("fechaActual", fechaActual);
		// myQuery.executeUpdate(); // La cantidad de registros actualizados
		return myQuery.executeUpdate();
	}

	public Factura buscar(Integer id) {
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public int eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		//JPQL: delete from Factura f where f.numero = :numero
		Query myQuery=this.entityManager.createQuery("delete from Factura f where f.numero = :numero");
		myQuery.setParameter("numero", numero);
		return myQuery.executeUpdate();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub

		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public List<FacturaDTO> seleccionarFacturasDTO() {
		// TODO Auto-generated method stub
		TypedQuery<FacturaDTO> myQuery=this.entityManager.createQuery("select new pa2_u3_p5_dl.ventas.repository.modelo.dto.FacturaDTO(f.numero,f.fecha) from Factura f ", FacturaDTO.class);
		return myQuery.getResultList();
	}

}
