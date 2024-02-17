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
		// METODOS REFERENCIADOS
		// CONSUMER
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

		// PREDICATE
		System.out.println(">>>>>>>>>>> PREDICATE <<<<<<<<<<<<");
		// Lambda
		System.out.println("LAMBDA");
		IPersonaPredicate<Integer> predicateLambda= numero-> numero.compareTo(7)==0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(7)));
		
		IPersonaPredicate<String> predicateLambda2= letra-> "David".contains(letra);
		System.out.println(predicateLambda2.evaluar("a"));
	}

}
