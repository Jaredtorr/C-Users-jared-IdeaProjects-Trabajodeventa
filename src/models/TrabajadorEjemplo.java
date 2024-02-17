package models;

import java.util.ArrayList;
import java.util.List;

public class TrabajadorEjemplo {
    private String nombre;
    private double dineroInicial;
    private List<CompraRealizadaEjemplo> historialCompras;

    public TrabajadorEjemplo(String nombre) {
        this.nombre = nombre;
        this.dineroInicial = 0;
        this.historialCompras = new ArrayList<>();
    }

    public void realizarCompra(CompraRealizadaEjemplo compra) {
        historialCompras.add(compra);

        // Calcular y almacenar la diferencia
        double diferencia = dineroInicial - compra.getMontoPagado();
        System.out.println("Diferencia después de la compra: $" + diferencia);
    }

    // Otros métodos y getters...
}
