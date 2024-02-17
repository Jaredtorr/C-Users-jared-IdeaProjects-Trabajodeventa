import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class MainEjemplo {
    private static Scanner scanner;
    private static AsignacionEjemplo asignacion;
    private static TrabajadorEjemplo trabajador;

    public static void main(String[] args) {
        inicializar();

        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    darDineroAlTrabajador();
                    break;

                case 2:
                    realizarCompra();
                    break;

                case 3:
                    mostrarHistorialYSalir();
                    break;

                default:
                    System.out.println("Opción inválida ❌. Por favor, seleccione una opción válida \uD83D\uDD18.");
            }

        } while (opcion != 3);
    }

    private static void inicializar() {
        scanner = new Scanner(System.in);
        asignacion = new AsignacionEjemplo();
        trabajador = new TrabajadorEjemplo("Juan");
    }

    private static void mostrarMenu() {
        String azul = "\033[34m";
        System.out.println(azul + "-----------\uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBBMenú\uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBB-----------");
        System.out.println(azul + "------------------------------");
        System.out.println(azul + "--- ✅ 1) Dar dinero al trabajador ---");
        System.out.println(azul + "--- ✅ 2) Realizar compra ---");
        System.out.println(azul + "--- ❌ 3) Salir            ---");
        System.out.println(azul + "------------------------------");
        System.out.println(azul + "---   Ingrese su opción:   ---");
        System.out.println(azul + "------------------------------");
    }

    private static void darDineroAlTrabajador() {
        System.out.println("Ingrese la cantidad de dinero a dar al trabajador: ");
        double monto = scanner.nextDouble();
        asignacion.asignarDinero(monto);
        trabajador.recibirDinero(monto);
    }

    private static void realizarCompra() {
        System.out.println("Ingrese producto \uD83D\uDCD6:");
        String producto = scanner.nextLine();
        System.out.println("Ingrese id \uD83D\uDCB7:");
        String id = scanner.nextLine();
        System.out.println("Ingrese fecha \uD83D\uDCC6:");
        int fecha = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.println("Ingrese precio del producto \uD83D\uDCC4:");
        int precio = scanner.nextInt();

        trabajador.realizarCompra(new CompraRealizadaEjemplo(new Date(), id, producto, precio));
    }

    private static void mostrarHistorialYSalir() {
        // Mostrar historial de compras
        System.out.println("Historial de compras realizadas por " + trabajador.getNombre() + ":");
        for (CompraRealizadaEjemplo compra : trabajador.getHistorialCompras()) {
            System.out.println(compra);
        }

        // Calcular la diferencia entre el dinero inicial y el total gastado
        double diferencia = trabajador.getDineroInicial() - trabajador.getTotalGastado();
        System.out.println("Diferencia entre dinero inicial y total gastado: $" + diferencia);

        // Mostrar las compras realizadas al final
        System.out.println("Compras realizadas:");
        for (CompraRealizadaEjemplo compra : trabajador.getHistorialCompras()) {
            System.out.println(compra);
        }

        // Mostrar el sobrante
        double sobrante = trabajador.calcularSobrante();
        System.out.println("Sobrante después de todas las compras: $" + sobrante);

        System.out.println("Nos vemos pronto \uD83D\uDC4B\uD83C\uDFFB.");
        System.out.println("Saliendo del programa \uD83D\uDCE4...");
    }

    private static class AsignacionEjemplo {
        private double dineroAsignado;

        public void asignarDinero(double monto) {
            dineroAsignado = monto;
        }
    }

    private static class CompraRealizadaEjemplo {
        private Date fecha;
        private String id;
        private String producto;
        private int precio;

        public CompraRealizadaEjemplo(Date fecha, String id, String producto, int precio) {
            this.fecha = fecha;
            this.id = id;
            this.producto = producto;
            this.precio = precio;
        }

        public int getPrecio() {
            return precio;
        }

        @Override
        public String toString() {
            return "Compra realizada el " + fecha + ": " + producto + " (ID: " + id + ") - Precio: $" + precio;
        }
    }

    private static class TrabajadorEjemplo {
        private String nombre;
        private double dineroInicial;
        private List<CompraRealizadaEjemplo> historialCompras;

        public TrabajadorEjemplo(String nombre) {
            this.nombre = nombre;
            this.dineroInicial = 0.0;
            this.historialCompras = new ArrayList<>();
        }

        public void recibirDinero(double monto) {
            dineroInicial += monto;
        }

        public void realizarCompra(CompraRealizadaEjemplo compra) {
            historialCompras.add(compra);
            dineroInicial -= compra.getPrecio();
        }

        public double getDineroInicial() {
            return dineroInicial;
        }

        public double getTotalGastado() {
            double total = 0.0;
            for (CompraRealizadaEjemplo compra : historialCompras) {
                total += compra.getPrecio();
            }
            return total;
        }

        public List<CompraRealizadaEjemplo> getHistorialCompras() {
            return historialCompras;
        }

        public double calcularSobrante() {
            return dineroInicial - getTotalGastado();
        }

        public String getNombre() {
            return null;
        }
    }
}
