package com.uce.edu.funcional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Supplier

		System.out.println(">>>>>>>>>>> SUPPLIER <<<<<<<<<<<<");
		// Clases
		System.out.println("CLASES");
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		System.out.println(supplierClase.getId());
		// Lambdas
		System.out.println("LAMBDAS");
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "17258614";
			cedula = cedula + " canton";
			return cedula;
		};
		System.out.println(supplierLambda.getId());

		IPersonaSupplier<String> supplierLambda2 = () -> "17258614" + " pais";
		System.out.println(supplierLambda2.getId());

		IPersonaSupplier<Integer> supplierLambda3 = () -> {
			Integer valor1 = Integer.valueOf(100);
			valor1 = valor1 * Integer.valueOf(50) / Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLambda3.getId());
		// METODOS REFERENCIADOS SUPPLIER
		System.out.println("METODOS REFERENCIADOS SUPPLIER");
		MetodosReferenciados met = new MetodosReferenciados();
		IPersonaSupplier<String> supplierLambda4 = met::obtenerId;
		System.out.println(supplierLambda4.getId());

		// 2. CONSUMER
		System.out.println(">>>>>>>>>>> CONSUMER <<<<<<<<<<<<");
		// Clases
		System.out.println("CLASES");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");
		// LAMBDAS
		System.out.println("LAMBDAS");
		IPersonaConsumer<String> consumerLambda = (cadena) -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerClase.accept("Profesor LAMBDA");

		// METODOS REFERENCIADOS CONSUMER
		System.out.println("METODOS REFERENCIADOS CONSUMER");
		IPersonaConsumer<String> consumerMetodoRe=met:: procesar;
		consumerMetodoRe.accept("David Referenciado");
		
		// 3. PREDICATE
		System.out.println(">>>>>>>>>>> PREDICATE <<<<<<<<<<<<");
		// Lambda
		System.out.println("LAMBDA");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(7)));

		IPersonaPredicate<String> predicateLambda2 = letra -> "David".contains(letra);
		System.out.println(predicateLambda2.evaluar("h"));

		// METODOS REFERENCIADOS PREDICATE
		System.out.println("METODOS REFERENCIADOS PREDICATE");
		IPersonaPredicate<String> predicateMetodoRe= met::evaluar;
		System.out.println(predicateMetodoRe.evaluar("a"));
		
		IPersonaPredicate<Integer> predicateMetodoRe2=met:: procesar;
		System.out.println(predicateMetodoRe2.evaluar(5));
		
		// 4. FUNCTION
		System.out.println(">>>>>>>>>>> FUNCTION <<<<<<<<<<<<");
		// Lambda
		System.out.println("LAMBDA");
		// El primero retorna un String el siguiente recibe un INteger
		IPersonaFunction<String, Integer> functionLambda = numero -> {
			numero = numero + Integer.valueOf(10);
			String numeroString = numero.toString().concat("- VALOR");
			return numeroString;
		};
		System.out.println(functionLambda.aplicar(7));

		IPersonaFunction<Empleado, Ciudadano> functionLambda1 = ciudadano -> {
			Empleado empl = new Empleado();
			empl.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());
			if (ciudadano.getProvincia().compareTo("Pichincha") == 0) {
				empl.setPais("Ecuador");
			}
			return empl;
		};

		Ciudadano ciud = new Ciudadano();
		ciud.setNombre("David");
		ciud.setApellido("Llumiquinga");
		ciud.setProvincia("Pichincha");

		Empleado empl = functionLambda1.aplicar(ciud);
		System.out.println(empl);
		
		// METODOS REFERENCIADOS FUNCTION
		System.out.println("METODOS REFERENCIADOS FUNCTION");
		IPersonaFunction<Ciudadano, Empleado> functionMetodoRe=met::cambiar;
		Empleado empl2=new Empleado();
		empl2.setNombreCompleto("Manuel Tasiguano");
		empl2.setPais("Ecuador");
		Ciudadano ciud2=functionMetodoRe.aplicar(empl2);
		System.out.println(ciud2);
		
		System.out.println(">>>>>>>>>>> UNARY OPERATOR <<<<<<<<<<<<");
		// Lambda
		System.out.println("LAMBDA");
		IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero + (numero * 2);
		System.out.println(unaryOperatorLambda.aplicar(14));

		// Interface de herencia
		IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda1 = numero -> numero + (numero * 2);
		System.out.println(unaryOperatorLambda1.aplicar(10));
		
		// METODOS REFERENCIADOS UNARY OPERATOR
		System.out.println("METODOS REFERENCIADOS UNARY OPERATOR");
		IPersonaUnaryOperatorFunction<Empleado> unaryOperatorMetodoR= met::procesar;
		Empleado empl3=unaryOperatorMetodoR.aplicar(empl2);
		System.out.println(empl3);
	}

}
