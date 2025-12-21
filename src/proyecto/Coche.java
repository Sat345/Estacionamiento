package proyecto;

class Coche{

    String color;
    String tamaño;
    String placas;
    String marca;
    String modelo;
    int cajon;

    public Coche(String color, String tamaño, String placas, String marca, String modelo, int cajon) {
        this.color = color;
        this.tamaño = tamaño;
        this.placas = placas;
        this.marca = marca;
        this.modelo = modelo;
        this.cajon = cajon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCajon() {
        return cajon;
    }

    public void setCajon(int cajon) {
        this.cajon = cajon;
    }

    public String mostrarInfo() {
        return color + " " + tamaño + " " + placas + " " + marca + " " + modelo + " " + cajon;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "color='" + color + '\'' +
                ", tamaño='" + tamaño + '\'' +
                ", placas='" + placas + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cajon=" + (cajon+1) +
                '}';
    }
}