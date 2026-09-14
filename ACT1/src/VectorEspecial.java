import java.util.Scanner;

public class VectorEspecial {
    private int[] data;
    private int size;

    public VectorEspecial(int capacidadInicial) {
        this.data = new int[capacidadInicial];
        this.size = 0;
    }

    // 1. Obtener posición inicio
    public int posInicio() {
        return (size > 0) ? 0 : -1;
    }

    // 2. Obtener posición fin
    public int posFin() {
        return (size > 0) ? size - 1 : -1;
    }

    // 3. Obtener cantidad elementos
    public int obtenerCantidad() {
        return size;
    }

    // 4. Mostrar todos los elementos
    public void mostrar() {
        if (size == 0) {
            System.out.println("Vector vacío.");
            return;
        }
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("]");
    }

    // 5. Mostrar elemento del inicio
    public void mostrarInicio() {
        if (size > 0) System.out.println("Inicio: " + data[0]);
        else System.out.println("Vector vacío.");
    }

    // 6. Mostrar elemento del final
    public void mostrarFinal() {
        if (size > 0) System.out.println("Final: " + data[size - 1]);
        else System.out.println("Vector vacío.");
    }

    // 7 y 8. Aumentar y Disminuir tamaño (Redimensionar capacidad)
    public void redimensionar(int nuevaCapacidad) {
        if (nuevaCapacidad < size) {
            size = nuevaCapacidad;
        }
        int[] nuevoData = new int[nuevaCapacidad];
        System.arraycopy(data, 0, nuevoData, 0, size);
        data = nuevoData;
        System.out.println("-> Nueva capacidad asignada: " + data.length);
    }

    // 9. Insertar elemento en posición específica
    public void insertarEnPosicion(int pos, int valor) {
        if (pos < 0 || pos > size) {
            System.out.println("Posición inválida.");
            return;
        }
        if (size == data.length) {
            redimensionar(data.length * 2);
        }
        for (int i = size; i > pos; i--) {
            data[i] = data[i - 1];
        }
        data[pos] = valor;
        size++;
    }

    // 9 (variaciones). Insertar al inicio y al final
    public void insertarInicio(int valor) { insertarEnPosicion(0, valor); }
    public void insertarFinal(int valor) { insertarEnPosicion(size, valor); }

    // 10. Eliminar de posición específica
    public void eliminarDePosicion(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Posición inválida.");
            return;
        }
        for (int i = pos; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    // 11 y 12. Eliminar inicio y final
    public void eliminarInicio() { eliminarDePosicion(0); }
    public void eliminarFinal() { if (size > 0) size--; }

    // 13. Invertir el vector
    public void invertir() {
        int izq = 0, der = size - 1;
        while (izq < der) {
            int temp = data[izq];
            data[izq] = data[der];
            data[der] = temp;
            izq++;
            der--;
        }
        System.out.println("-> Vector invertido correctamente.");
    }

    // 14. Buscar elemento
    public int buscar(int valor) {
        for (int i = 0; i < size; i++) {
            if (data[i] == valor) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VectorEspecial vec = new VectorEspecial(5);
        int opcion, val, pos;

        do {
            System.out.println("\n--- MENU VECTORES ---");
            System.out.println("1. Posicion inicio      2. Posicion fin          3. Cantidad elementos");
            System.out.println("4. Mostrar todo         5. Elemento inicio       6. Elemento final");
            System.out.println("7. Aumentar tamano      8. Disminuir tamano      9. Insertar en posicion");
            System.out.println("10. Insertar inicio     11. Insertar final       12. Eliminar en posicion");
            System.out.println("13. Eliminar inicio     14. Eliminar final       15. Invertir vector");
            System.out.println("16. Buscar elemento     0. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> System.out.println("Posicion Inicio: " + vec.posInicio());
                case 2 -> System.out.println("Posicion Fin: " + vec.posFin());
                case 3 -> System.out.println("Cantidad: " + vec.obtenerCantidad());
                case 4 -> vec.mostrar();
                case 5 -> vec.mostrarInicio();
                case 6 -> vec.mostrarFinal();
                case 7, 8 -> {
                    System.out.print("Nueva capacidad: ");
                    val = scanner.nextInt();
                    vec.redimensionar(val);
                }
                case 9 -> {
                    System.out.print("Posicion: "); pos = scanner.nextInt();
                    System.out.print("Valor: "); val = scanner.nextInt();
                    vec.insertarEnPosicion(pos, val);
                }
                case 10 -> { System.out.print("Valor: "); val = scanner.nextInt(); vec.insertarInicio(val); }
                case 11 -> { System.out.print("Valor: "); val = scanner.nextInt(); vec.insertarFinal(val); }
                case 12 -> { System.out.print("Posicion a eliminar: "); pos = scanner.nextInt(); vec.eliminarDePosicion(pos); }
                case 13 -> vec.eliminarInicio();
                case 14 -> vec.eliminarFinal();
                case 15 -> vec.invertir();
                case 16 -> {
                    System.out.print("Valor a buscar: "); val = scanner.nextInt();
                    pos = vec.buscar(val);
                    if (pos != -1) System.out.println("-> Elemento en indice: " + pos);
                    else System.out.println("-> Elemento no encontrado.");
                }
            }
        } while (opcion != 0);

        scanner.close();
    }
}