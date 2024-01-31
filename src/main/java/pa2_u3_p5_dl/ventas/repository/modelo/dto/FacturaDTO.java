package pa2_u3_p5_dl.ventas.repository.modelo.dto;

import java.time.LocalDateTime;

public class FacturaDTO {

	private String numero;
	private LocalDateTime fecha;
	
	public FacturaDTO() {
		
	}
	
	public FacturaDTO(String numero, LocalDateTime fecha) {
		super();
		this.numero = numero;
		this.fecha = fecha;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "FacturaDTO [numero=" + numero + ", fecha=" + fecha + "]";
	}
	
}
