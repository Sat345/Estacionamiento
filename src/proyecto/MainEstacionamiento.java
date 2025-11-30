package proyecto;

import java.util.Scanner;
/*Nuevo mensaje de prueva
* ver
* este
* mensaje*/

//public class mainEstacionamiento {  package proyecto;

public class MainEstacionamiento {
	public static void main(String[] args) { 
		
		
		Scanner Opcion1 = new Scanner(System.in);
		
		
        Tickets tickets = new Tickets();
		Caja caja = new Caja();
		Cajones cajones = new Cajones();
		Estacionamiento espacio[] = new Estacionamiento[300];
		Coche coche = new Coche("","","","","");
		
						//color, tamaño, marca, placas, modelo
		int Opcion;
		int i=0;
		do {
			espacio[i] = new Estacionamiento();
			espacio[0].pedirDatos();
			
			Opcion = Opcion1.nextInt();
			switch(Opcion) {
			case 1:
				espacio[i++].ingresarCoche(cajones, caja, tickets, i);
                System.out.println("espacio i = " + i);
				break;
			case 2:
				//i=Espacio que quieras retirar
				espacio[i].retirarCoche(cajones, caja, tickets, i);
				break;
			case 3:
				System.out.println();
				//tickets.borrarTicket();
				tickets.ticketTexto();
				System.out.println("Creo que ya guarda :|");

				break;
			case 4:
				System.out.println(coche);
				break;
				case 5:
					cajones.mostrarTodosLosLugares();
			default:
			}
			
		}while(Opcion!=6);
		
		System.out.println("Fin del menu");
	}
	
	Cajones n = new Cajones();
	
	
}
