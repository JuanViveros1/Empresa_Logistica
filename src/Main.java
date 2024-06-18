import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventarioAlmacen inventario = new InventarioAlmacen();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenú de Gestión de Inventario");
            System.out.println("1. Agregar/Actualizar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Consultar Cantidad de Producto");
            System.out.println("4. Mostrar Inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el código del producto: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Ingrese la cantidad del producto: ");
                    int cantidad = scanner.nextInt();
                    inventario.agregarActualizarProducto(codigo, cantidad);
                    System.out.println("Producto agregado/actualizado.");
                    break;
                case 2:
                    System.out.print("Ingrese el código del producto a eliminar: ");
                    codigo = scanner.nextLine();
                    inventario.eliminarProducto(codigo);
                    System.out.println("Producto eliminado.");
                    break;
                case 3:
                    System.out.print("Ingrese el código del producto: ");
                    codigo = scanner.nextLine();
                    cantidad = inventario.obtenerCantidadProducto(codigo);
                    System.out.println("Cantidad de " + codigo + ": " + cantidad);
                    break;
                case 4:
                    inventario.mostrarInventario();
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}
