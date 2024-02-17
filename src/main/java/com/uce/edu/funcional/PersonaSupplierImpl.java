package com.uce.edu.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String> {

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		String cedula = "17258614";
		cedula = cedula + " provincia";
		return cedula;
	}

}
