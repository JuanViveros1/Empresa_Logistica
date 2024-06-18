import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class InventarioAlmacen {
    private HashMap<String, Producto> inventario;

    public InventarioAlmacen() {
        this.inventario = new HashMap<>();
        cargarInventario("inventario.txt"); 
    }

    public void agregarActualizarProducto(String codigo, int cantidad) {
        Producto producto = inventario.get(codigo);
        if (producto != null) {
            producto.setCantidad(cantidad);
        } else {
            producto = new Producto(codigo, cantidad);
            inventario.put(codigo, producto);
        }
        guardarInventario("inventario.txt"); 
    }

    public void eliminarProducto(String codigo) {
        inventario.remove(codigo);
        guardarInventario("inventario.txt"); 
    }

    public int obtenerCantidadProducto(String codigo) {
        Producto producto = inventario.get(codigo);
        return producto != null ? producto.getCantidad() : 0;
    }

    public void guardarInventario(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            for (Map.Entry<String, Producto> entry : inventario.entrySet()) {
                writer.write(entry.getValue().toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario.");
            e.printStackTrace();
        }
    }

    public void cargarInventario(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String codigo = parts[0].split(": ")[1];
                int cantidad = Integer.parseInt(parts[1].split(": ")[1]);
                inventario.put(codigo, new Producto(codigo, cantidad));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el inventario inicial.");
            e.printStackTrace();
        }
    }

    public void mostrarInventario() {
        for (Map.Entry<String, Producto> entry : inventario.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}
