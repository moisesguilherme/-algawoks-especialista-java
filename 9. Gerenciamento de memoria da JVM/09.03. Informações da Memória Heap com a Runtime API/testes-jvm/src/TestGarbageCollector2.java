public class TestGarbageCollector2 {

    public static void main(String[] args) {
        imprimirUsoMemoria();

        byte[] x = new byte[500 * 1024 * 1024];
        byte[] y = new byte[500 * 1024 * 1024];

        imprimirUsoMemoria();
        //Garbage Collector o objeto se torna inalcancável
        x = y;

        System.gc(); //Limpou, tirou o valor q estava no x

        imprimirUsoMemoria();
    }

    static void imprimirUsoMemoria() {
        // Memória q a JVM pode usar
        System.out.printf("Máxima: %s%n", emMegabytes(Runtime.getRuntime().maxMemory()));

        // Total de memória reservada
        System.out.printf("Total empenhada: %s%n", emMegabytes(Runtime.getRuntime().totalMemory()));

        // Total de memória disponível
        System.out.printf("Disponível: %s%n", emMegabytes(Runtime.getRuntime().freeMemory()));

        long memoriaUsada = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.printf("Usada: %s%n", emMegabytes(memoriaUsada));

        System.out.println("----");
    }


    static String emMegabytes(long bytes) {
        return String.format("%.2fMB", bytes / 1024d / 1024d);
    }
}
