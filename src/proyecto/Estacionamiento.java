package proyecto;

class Estacionamiento{


    Coche coche;

    public void pedirDatos() {
        System.out.println();
        System.out.println("Opcion 1: ingresar coche");
        System.out.println("Opcion 2: retirar coche");
        System.out.println("Opcion 3: imprimir ticket");
        System.out.println("Opcion 4: mostrar coches");
        System.out.println("Opcion 5: Mostrar lugares");
        System.out.println("Opcion 5: salir");
        System.out.println();
        System.out.println("Introduce un numero: ");

    }

    public void ingresarCoche(Cajones cajones, Caja caja, Tickets tickets, int num) {

        System.out.println( cajones.cajon());
        tickets.ingresarDatos();
        cajones.mostrarTodosLosLugares();
        cajones.acomodarCoches();
        tickets.ticked();
        tickets.pedirNum(caja, num);
        System.out.println("i = "+num);
    }

    public void retirarCoche(Cajones cajones, Caja caja, Tickets tickets, int num ) {
        tickets.pedirNum(caja, num);
        System.out.println("Buscando coche...");
        System.out.println("Total a pagar "+caja.tarifa(tickets));
        caja.cobrarTarifa();
        caja.cambio(tickets);
        cajones.quitarCoche();
        System.out.println("ir = "+num);
    }
    public void guardarEstacionamiento() {

    }
}