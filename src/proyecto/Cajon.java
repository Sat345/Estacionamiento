package proyecto;


import java.util.Scanner;

class Cajon {

    private Scanner lee;
    boolean[] espacios= new boolean[20];
    int cajon=0;

    public void mostrarTodosLosLugares() {
        System.out.println("****************mostrar lugares****************");
        System.out.println();

        for(int i=0; i<13; i++) {
            if(i<=6) {
                System.out.println();
                System.out.println(" A"+(i+1)+"="+espacios[i]+"                                                    C"+(i+14)+"="+espacios[i+13]);
                if(i==6) {
                    System.out.println();
                }

            }
            else {
                if(i==7) {
                    System.out.print("   ");
                }
                System.out.print(" B"+(i+1)+"="+espacios[i]);
            }
        }

    }

    public int acomodarCoches() {
        mostrarTodosLosLugares();

        System.out.println();
        lee = new Scanner(System.in);
        System.out.println("Selecciona el cajon en el q t quieres estacionar: ");
        cajon = lee.nextInt();
        cajon-=1;

        if((0>cajon)||(cajon>19)){
            System.out.println();
            System.out.println("Escoje un numero del 1 al 20");
            System.out.println();
            acomodarCoches();
        }

        if(espacios[cajon]==false){
            espacios[cajon]=true;
            System.out.println("Lugar estacionado: "+(cajon+1)+"="+espacios[cajon]);
            mostrarTodosLosLugares();

        }
        else {
            System.out.println("Seleccione un cajon q este desocupado.");
            acomodarCoches();
        }
        return cajon;
    }

    public int quitarCoche(int cajon) {
        espacios[cajon]=false;
        System.out.println("Coche retirado: "+(cajon+1)+"="+espacios[cajon]);

        return cajon;
    }
}

//////////////////////////////////////////////////////////////////////////////////
