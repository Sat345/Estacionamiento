package proyecto;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

class Tickets{

    Calendar calendario;

    Coche coche;

    int precio;

    public void ingresarDatos() {
        this.calendario = new GregorianCalendar();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el color del coche:");
        String color = scanner.nextLine();

        System.out.println("Ingrese el tamaño del coche:");
        String tamaño = scanner.nextLine();

        System.out.println("Ingrese la marca del coche:");
        String marca = scanner.nextLine();

        System.out.println("Ingrese la placa del coche:");
        String placas = scanner.nextLine();

        System.out.println("Ingrese el modelo del coche:");
        String modelo = scanner.nextLine();

        coche = new Coche(color, tamaño, placas, marca, modelo);

    }

    public int calcularCostos(){

        if(coche.tamaño.equalsIgnoreCase("Chico")) {
            precio = 25;
        }
        else {
            if(coche.tamaño.equalsIgnoreCase("Grande")) {
                precio=50;

            }
            else {
                System.out.println("\nEl valor es diferente a Chico o Grande.");

            }
        }

        return precio;
    }

    public int obtenerHoraActual() {
        return calendario.get(Calendar.HOUR_OF_DAY);
    }

    public int obtenerMinutoActual() {
        return calendario.get(Calendar.MINUTE);
    }

    public int registrarEntrada() {
        int horaEntrada = obtenerHoraActual();
        return horaEntrada;
    }

    public void obtenerDiaMesAño() {

        int year = calendario.get(Calendar.YEAR);
        int month = calendario.get(Calendar.MONTH) + 1;
        int day = calendario.get(Calendar.DAY_OF_MONTH);
        System.out.print(" "+day+"/"+month+"/"+year);

    }

    int num=0;
    public int numTicket(){
        i=0;
        do{
            i++;


        }while(numS[i]!=0);

        numS[i]=i;
        //String formatoConCeros = String.format("%05d", num);
        return i;
    }

    int[] numS= new int[20];
    int i=0;

    public int pedirNum(Caja caja, int num) {
        int numP;

        do{
            System.out.println();
            System.out.println("Ingresa tu numero de serie");
            numP = caja.pedirNumero();
            if(numP!=num) {
                System.out.println("El numero de serie es incorrecto");
            }


        }while(numP!=num);

        System.out.println("Tu numero de estacionamiento es: "+(num));
        return i;
    }

    public String obtenerDiaActual() {
        int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);

        switch (diaSemana) {
            case Calendar.SUNDAY:
                return "Domingo";
            case Calendar.MONDAY:
                return "Lunes";
            case Calendar.TUESDAY:
                return "Martes";
            case Calendar.WEDNESDAY:
                return "Miércoles";
            case Calendar.THURSDAY:
                return "Jueves";
            case Calendar.FRIDAY:
                return "Viernes";
            case Calendar.SATURDAY:
                return "Sábado";
            default:
                return "Desconocido";
        }
    }

    public void ticked() {
        System.out.println();
        System.out.println("................imprimir ticket................");
        System.out.println("color: "+coche.color);
        System.out.println("tamanio: "+coche.tamaño);
        System.out.println("marca: "+coche.marca);
        System.out.println("placas: "+coche.placas);
        System.out.println("modelo: "+coche.modelo);
        System.out.print("dia: "+obtenerDiaActual()+". ");
        obtenerDiaMesAño();
        System.out.println();
        System.out.println("Hora de entrada: "+registrarEntrada()+":"+obtenerMinutoActual());
        numTicket();
        System.out.println("Numero de serie: "+num);
    }

    public void ticketTexto() {
        System.out.println();
        System.out.println("................imprimir ticket................");

        // Generar texto del ticket
        StringBuilder sb = new StringBuilder();
        sb.append("color: ").append(coche.color).append("\n");
        sb.append("tamanio: ").append(coche.tamaño).append("\n");
        sb.append("placas: ").append(coche.placas).append("\n");
        sb.append("marca: ").append(coche.marca).append("\n");
        sb.append("dia: ").append(obtenerDiaActual()).append(". ");

        int year = calendario.get(Calendar.YEAR);
        int month = calendario.get(Calendar.MONTH) + 1;
        int day = calendario.get(Calendar.DAY_OF_MONTH);
        sb.append(day).append("/").append(month).append("/").append(year).append("\n");

        int hora = registrarEntrada();
        int minuto = obtenerMinutoActual();
        sb.append("Hora de entrada: ").append(hora).append(":").append(minuto).append("\n");

        numTicket();
        sb.append("Numero de serie: ").append(num).append("\n");

        // Imprimir en consola (opcional)
        System.out.print(sb.toString());

        // Guardar en archivo
        try (PrintWriter writer = new PrintWriter(new FileWriter("ticket.txt"))) {
            writer.print(sb.toString());
            System.out.println("✅ Ticket guardado como 'ticket.txt'");
        } catch (IOException e) {
            System.out.println("❌ Error al guardar el ticket: " + e.getMessage());
        }
    }

    public void borrarTicket() {
        File archivo = new File("ticket.txt");

        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("✅ El archivo 'ticket.txt' fue eliminado correctamente.");
            } else {
                System.out.println("❌ No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("ℹ️ El archivo 'ticket.txt' no existe.");
        }
    }


}