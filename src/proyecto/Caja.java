package proyecto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Caja {

    private ArrayList<Coche> coches;
    Calendar calendario;
    private Scanner leerString = new Scanner(System.in);
    private Scanner leerInt = new Scanner(System.in);
    Coche coche;
    Cajon cajon = new Cajon();
    int numserie;
    int precio;
    int precioTotal2;
    int cambio_o_cobro;

    public Caja() {
        this.calendario = new GregorianCalendar();
        coches = new ArrayList<>();
    }

    public int obtenerMinutoActual() {
        return calendario.get(Calendar.MINUTE);
    }

    public int obtenerHoraActual() {
        return calendario.get(Calendar.HOUR_OF_DAY);
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

    public void obtenerDiaMesAño() {

        int year = calendario.get(Calendar.YEAR);
        int month = calendario.get(Calendar.MONTH) + 1;
        int day = calendario.get(Calendar.DAY_OF_MONTH);
        System.out.print(" "+day+"/"+month+"/"+year);
    }


    public void ingresarDatos() {

        System.out.println("Ingrese el color del coche:");
        String color = leerString.nextLine();

        String tamanio;
        do{
            System.out.println("Ingrese el tamanio del coche:                  chico/grande");
            tamanio = leerString.nextLine();
        }while (!(tamanio.equalsIgnoreCase("Chico")||tamanio.equalsIgnoreCase("Grande")));

        System.out.println("Ingrese la marca del coche:");
        String marca = leerString.nextLine();

        System.out.println("Ingrese la placa del coche:");
        String placas = leerString.nextLine();

        System.out.println("Ingrese el modelo del coche:");
        String modelo = leerString.nextLine();

        Coche coche = new Coche(color, tamanio, placas, marca, modelo, cajon.acomodarCoches());

        coches.add(coche);
        numserie++;
    }

    public int serieVehiculo(){
        System.out.println(numserie-1);
        return numserie-1;
    }

    // Consultar coche por índice
    public Coche consultarCoche(int indice) {
        if (indice >= 0 && indice < coches.size()) {
            return coches.get(indice);
        } else {
            System.out.println("❌ Índice no válido");
            return null;
        }
    }

    public void ticketTexto(int ns) {
        coche = coches.get(ns);
        System.out.println();
        System.out.println("................imprimir ticket................");

        // Generar texto del ticket
        StringBuilder sb = new StringBuilder();
        sb.append("color: ").append(coche.getColor()).append("\n");
        sb.append("tamanio: ").append(coche.getTamaño()).append("\n");
        sb.append("marca: ").append(coche.marca).append("\n");
        sb.append("placas: ").append(coche.placas).append("\n");
        sb.append("modelo: ").append(coche.modelo).append("\n");
        String formato = String.format("%08d", ns);                            //Formato 00000001
        sb.append("numero de serie: ").append(formato).append("\n");
        sb.append("lugar estacionado: ").append(coche.cajon+1).append("\n");
        sb.append("dia: ").append(obtenerDiaActual()).append(". ");

        int year = calendario.get(Calendar.YEAR);
        int month = calendario.get(Calendar.MONTH) + 1;
        int day = calendario.get(Calendar.DAY_OF_MONTH);
        sb.append(day).append("/").append(month).append("/").append(year).append("\n");

        int hora = registrarEntrada();
        int minuto = obtenerMinutoActual();
        sb.append("Hora de entrada: ").append(hora).append(":").append(minuto).append("\n");

        // Imprimir en consola
        System.out.print(sb.toString());

        // Guardar en archivo
        try (PrintWriter writer = new PrintWriter(new FileWriter("ticket_"+ns+".txt"))) {
            writer.print(sb.toString());
            System.out.println("Ticket guardado como 'ticket_"+ns+".txt'");
        } catch (IOException e) {
            System.out.println("Error al guardar el ticket_"+ns+" " + e.getMessage());
        }
    }


    public void leerTicket(int ns) {
        try {
            File archivo = new File("ticket_" + ns + ".txt");
            Scanner lector = new Scanner(archivo);

            System.out.println("📄 Contenido del ticket_" + ns + ".txt:");
            System.out.println("==========================================");

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                System.out.println(linea);
            }

            System.out.println("==========================================");
            lector.close();

        } catch (FileNotFoundException e) {
            System.out.println("❌ El archivo 'ticket_" + ns + ".txt' no existe");
        }
    }

    public void borrarTicketTexto(int ns) {
        File archivo = new File("ticket_"+ns+".txt");

        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("✅ El archivo 'ticket_"+ns+".txt' fue eliminado correctamente");
            } else {
                System.out.println("❌ No se pudo eliminar el archivo");
            }
        } else {
            System.out.println("ℹ️ El archivo 'ticket_"+ns+".txt' no existe");
        }
    }

    public boolean vereficarLista(){
        return !coches.isEmpty();
    }

    public int pedirNum() {
        int numP;

        System.out.println();
        numP = leerInt.nextInt();

        try {
            Coche coche = coches.get(numP);
            System.out.println("Tu coche tiene las placas: " + coche.getPlacas());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("El coche que ingresaste no existe, intentalo otra vez");
            pedirNum();
        }
        return numP;
    }

    public int registrarEntrada() {
        int horaEntrada = obtenerHoraActual();
        return horaEntrada;
    }

    public int registrarSalida() {
        int horaSalida = obtenerHoraActual();
        return horaSalida;
    }

    public int precioTotal(int ns) {
        int cobro;
        int precio= precio(ns);
        if(registrarSalida()==registrarEntrada()) {

            cobro=precio;
        }
        else {
            int horasTotales =registrarSalida()-registrarEntrada();
            cobro=precio*horasTotales;
        }
        return cobro;
    }

    public int precio(int ns){
        coche = coches.get(ns);

        if(coche.tamaño.equalsIgnoreCase("Chico")) {
            precio = 25;
        }
        else {
            if(coche.tamaño.equalsIgnoreCase("Grande")) {
                precio=50;

            }
        }
        return precio;
    }

    public int leerTarifa() {
       int pago;

        System.out.println("Monto resivido: ");
        pago = leerInt.nextInt();

        return pago;
    }

    public void cobrar(int ns) {
        coche = coches.get(ns);

        if(precioTotal2==0){
            cambio_o_cobro = leerTarifa() - precioTotal(ns);
        }else {
            cambio_o_cobro = leerTarifa() - precioTotal2;
        }

        //cambio_o_cobro=0
        if(cambio_o_cobro==0) {

            System.out.println("El monto resivido es correcto ");
        }
        else {
            //cambio_o_cobro>0
            if(cambio_o_cobro>0) {

                System.out.println("El cambio es: " + cambio_o_cobro);
                cambio_o_cobro=0;
            }
            //cambio_o_cobro<0
            else {
                cambio_o_cobro*=-1;

                System.out.println("para completar el pago faltan: " + cambio_o_cobro);
                precioTotal2=cambio_o_cobro;
                cobrar(ns);
            }
        }
        precioTotal2=0;
        cajon.quitarCoche(coche.getCajon());
        System.out.println("cajon de c = "+coche.getCajon());
        cajon.mostrarTodosLosLugares();
        coches.remove(ns);
        numserie--;
    }

    public void mostarLista(){

        for(Coche n : coches){
            System.out.println(n);
        }
    }
}
