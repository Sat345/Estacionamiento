package proyecto;

class Estacionamiento{

    public void Opciones() {
        System.out.println();
        System.out.println("Opcion 1: ingresar coche");
        System.out.println("Opcion 2: retirar coche");
        System.out.println("Opcion 3: imprimir ticket");
        System.out.println("Opcion 4: mostrar coches");
        System.out.println("Opcion 5: Mostrar lugares");
        System.out.println("Opcion 6: salir");
        System.out.println();
        System.out.println("Introduce un numero: ");

    }

    public void ingresarCoche(Cajon cajon, Caja caja, Coche coche) {
        caja.ingresarDatos();
        caja.ticketTexto(caja.serieVehiculo());
    }

    public void retirarCoche(Caja caja) {
        if(caja.vereficarLista()){
            int ns = caja.pedirNum();
            System.out.println("Total a pagar "+caja.precioTotal(ns));
            caja.cobrar(ns);
        }else{
            System.out.println("La lista esta vacia, intenta ingresar coches");
        }
    }

    public void leerTxt(Caja caja){
        System.out.println("Ingresa el numero se serie: ");
        caja.leerTicket(caja.pedirNum());

    }
}