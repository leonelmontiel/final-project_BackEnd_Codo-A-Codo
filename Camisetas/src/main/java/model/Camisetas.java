package model;

public class Camisetas {
    private int idcamiseta;
    private String equipo;
    private int numero;
    private String jugador;
    private String talle;
    private double precio;
    private int stock;

    public Camisetas(int idcamiseta, String equipo, int numero, String jugador, String talle, double precio, int stock) {
        this.idcamiseta = idcamiseta;
        this.equipo = equipo;
        this.numero = numero;
        this.jugador = jugador;
        this.talle = talle;
        this.precio = precio;
        this.stock = stock;
    }

    public Camisetas(String equipo, int numero, String jugador, String talle, double precio, int stock) {
        this.equipo = equipo;
        this.numero = numero;
        this.jugador = jugador;
        this.talle = talle;
        this.precio = precio;
        this.stock = stock;
    }

    public int getIdcamiseta() {
        return idcamiseta;
    }

    public void setIdcamiseta(int idcamiseta) {
        this.idcamiseta = idcamiseta;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }
    
    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Camiseta{" + "equipo=" + equipo + ", numero=" + numero + ", jugador=" + jugador + ", talle=" + talle + ", precio=" + precio + ", stock=" + stock + '}';
    }
}
