package com.uce.edu.funcional;

public class MetodosReferenciados {

	// SUPPLIER
	public String obtenerId() {
		// TODO Auto-generated method stub
		String cedula = "10025681";
		cedula = cedula + " referenciado";
		return cedula;
	}

	// CONSUMER
	public void procesar(String cadena) {
		System.out.println(cadena);
		System.out.println("Se proceso la cadena");
	}

	// PREDICATE
	public boolean evaluar(String cadena) {
		return "David".contains(cadena);
	}

	public boolean procesar(Integer numero) {
		return 8 == numero;
	}

	public Ciudadano cambiar(Empleado empl) {
		Ciudadano ciud = new Ciudadano();
		ciud.setApellido(empl.getNombreCompleto().split(" ")[0]);
		ciud.setNombre(empl.getNombreCompleto().split(" ")[1]);
		ciud.setProvincia("Manabi");
		return ciud;
	}

	public Empleado procesar(Empleado empl) {
		empl.setNombreCompleto(empl.getNombreCompleto() + " " + empl.getPais());
		empl.setPais(empl.getPais() + " de nacimiento");
		return empl;
	}
}
