package models;

import java.awt.desktop.PreferencesEvent;
import java.util.Date;

public class CompraRealizadaEjemplo implements Comparable<CompraRealizadaEjemplo> {
    private Date fecha;
    private String id;
    private String producto;
    private double precioPagado;
    private double costoProducto;

    public CompraRealizadaEjemplo(Date fecha, String id, String producto, double precioPagado) {
        this.fecha = fecha;
        this.id = id;
        this.producto = producto;
        this.precioPagado = precioPagado;
        this.costoProducto = costoProducto;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public double getPrecioPagado() {
        return precioPagado;
    }

    public double getCostoProducto() {
        return costoProducto;
    }

    public double calcularSobrante() {
        return precioPagado - costoProducto;
    }

    @Override
    public int compareTo(CompraRealizadaEjemplo otraCompra) {
        // Comparamos las fechas para ordenar en orden ascendente
        return this.fecha.compareTo(otraCompra.fecha);
    }

    @Override
    public String toString() {
        return "CompraRealizadaEjemplo{" +
                "fecha=" + fecha +
                ", id='" + id + '\'' +
                ", producto='" + producto + '\'' +
                ", precioPagado=" + precioPagado +
                ", costoProducto=" + costoProducto +
                '}';
    }

    public double getPrecio() {
        return 0;
    }

    public double getMontoPagado() {
        return 0;
    }
}
