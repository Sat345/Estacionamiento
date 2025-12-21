package proyecto;

import java.util.Scanner;


//public class mainEstacionamiento {  package proyecto;

public class MainEstacionamiento {
	public static void main(String[] args) { 

		Scanner opcion = new Scanner(System.in);
		Caja caja = new Caja();
        Cajon cajones = new Cajon();
		Estacionamiento espacio = new Estacionamiento();
		Coche coche = new Coche("","","","","",0);

		byte menu;
		do {
			espacio.Opciones();
			try{
                menu = opcion.nextByte();
                opcion.nextLine();
            } catch (Exception e) {
                opcion.nextLine();
                menu=0;
            }

			switch(menu) {
			case 1:

				espacio.ingresarCoche(cajones, caja, coche);
				break;
			case 2:

				espacio.retirarCoche(caja);
				break;
			case 3:
                espacio.leerTxt(caja);
				break;
			case 4:
                caja.mostarLista();
				break;
            case 5:
				cajones.mostrarTodosLosLugares();
                break;
			default:
                System.out.println("Ingresa un numero del 1 al 6");
                break;
			}
		}while(menu!=6);
		
		System.out.println("Fin del menu");
	}
	
	Cajon n = new Cajon();
	
	
}
