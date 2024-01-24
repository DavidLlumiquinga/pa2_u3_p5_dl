package pa2_u3_p5_dl.ventas.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {

	@Id
	@SequenceGenerator(name = "seq_detalle_factura", sequenceName = "seq_detalle_factura", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detalle_factura")

	@Column(name = "defa_id")
	private Integer id;
	@Column(name = "defa_cantidad")
	private Integer cantidad;
	@Column(name = "defa_codigo_barras")
	private String codigoBarras;
	@Column(name = "defa_nombre_producto")
	private String nombreProducto;
	
	@ManyToOne()
	@JoinColumn(name = "defa_id_factura")
	private Factura factura;
	
	//SET y GET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	
	
}
