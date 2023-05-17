package ejercicio12.pkg5;

public class Tabla {
    
     private CasaRural[] casa;
    private int numElementos;
    private double factorCarga;

    public Tabla() {
        casa = new CasaRural[101];
        for (int i = 0; i < 101; i++) {
            casa[i] = null;
            numElementos = 0;
            factorCarga = 0.0;
        }
    }

    public int direccion(String clave) {
        int i = 0, p;
        long d;
        d = transformaCadena(clave);

        // aplica aritmética modular para obtener dirección base
        p = (int) (d % 101);

        // bucle de exploración cuadratica
        while (casa[p] != null && !casa[p].codigo().equals(clave)) {
            i++;
            p = p + i * i;
            p = p % 101; // considera el array como circular
        }
        return p;
    }

    long transformaCadena(String clave) {
        long d;
        d = 0;
        for (int j = 0; j < Math.min(10, clave.length()); j++) {
            d = d * 27 + (int) clave.charAt(j);
        }
        if (d < 0) {
            d = -d;
        }
        return d;
    }

    public void insertar(CasaRural c) {
        int posicion;

        posicion = direccion(c.codigo());
        casa[posicion] = c;
        numElementos++;
        factorCarga = (double) (numElementos) / 101;

        if (factorCarga > 0.5) {
            System.out.println("\n!! Factor de carga supera el 50%.!!" + " Conviene aumentar el tamaño.");
        }
    }

    public CasaRural buscar(String clave) {

        CasaRural c;
        int posicion;
        posicion = direccion(clave);
        c = casa[posicion];
        if (c != null) {
            if (!c.esAlta) {
                c = null;
            }
        }
        return c;
    }

    public void eliminar(String clave) {
        
        int posicion;
        posicion = direccion(clave);
        if (casa[posicion] != null) {
            casa[posicion].esAlta = false;
        }
    }
}
