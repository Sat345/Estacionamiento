package proyecto;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

class Caja {

    Calendar calendario;
    private Scanner d1;

    public Caja() {
        this.calendario = new GregorianCalendar();
    }

    public int registrarSalida() {
        int horaSalida = obtenerHoraActual();
        return horaSalida;
    }

    public int tarifa(Tickets precio) {
        int cobro;
        if(registrarSalida()==precio.registrarEntrada()) {

            cobro=precio.calcularCostos();
        }
        else {
            int horasTotales =registrarSalida()-precio.registrarEntrada();
            cobro=precio.calcularCostos()*horasTotales;
        }
        return cobro;
    }
    int pago =0;
    public int cobrarTarifa() {
        if(pago==0) {
            d1 = new Scanner(System.in);
            System.out.println("Monto resivido: ");
            pago = d1.nextInt();

        }

        return pago;
    }

    public int cambio(Tickets tickets) {
        int cambio=0;
        cambio=cobrarTarifa()-tarifa(tickets);
        int tarifa= tarifa(tickets);

        do {
            //camvio=0
            if(cobrarTarifa()==tarifa) {

                System.out.println("El monto resivido es correcto. ");
                cambio=0;
            }
            else {
                //cambio>0
                if(cobrarTarifa()>tarifa) {

                    System.out.println("El cambio es: "+ cambio);
                    cambio=0;
                }
                //cambio<0
                else {
                    cambio*=-1;

                    System.out.println("para completar el pago faltan: "+cambio);
                    pago=0;
                    tarifa=cambio;
                    cobrarTarifa();
                    cambio=cobrarTarifa()-tarifa;
                    if(cobrarTarifa()==tarifa) {

                        System.out.println("El monto resivido es correcto. ");
                        cambio=0;
                    }
                }
            }
        }while(cambio!=0);

        return cambio;
    }

    public int obtenerHoraActual() {
        return calendario.get(Calendar.HOUR_OF_DAY);
    }

    int P=0;
    public int pedirNumero() {
        d1 = new Scanner(System.in);
        P = d1.nextInt();

        return P;
    }
    /*
    public int pedirboleto(Tickets pedir) {
        int R=0;
        int S=pedir.numTicket();

        do {
            System.out.println();
            System.out.println("Ingrese el numero de serie de su boleto: ");
            System.out.println(S);

            R= pedirNumero();

            if(S!=R) {
                System.out.println();
                System.out.println("Numero icorrecto.");
                if(R==0) {
                    R=0;
                }
            }
            else {
                System.out.println();
                System.out.println("Numero correcto");
                R=0;
            }

        }while(R!=0);

        return R;
        }
        */
}
