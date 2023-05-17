package ejercicio12.pkg5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CasaRural {

    private String codigo;
    private String poblacion;
    private String direccion;
    private int numHabitacion = 0;
    private double precio = 0.0;
    boolean esAlta;

    public CasaRural() {
        this.esAlta = true;
        asigna();
    }

    public void asigna() {
        BufferedReader entrada = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            System.out.print("\n Codigo (10 caracteres): ");
            codigo = entrada.readLine();
            System.out.print("\n Población: ");
            poblacion = entrada.readLine();
            System.out.print("\n Dirección: ");
            direccion = entrada.readLine();
            System.out.print("\n Número de habitaciones: ");
            numHabitacion = Integer.parseInt(entrada.readLine());
            System.out.print("\n Precio por día de estancia: ");
            precio = (new Double(entrada.readLine()));
        } catch (IOException e) {
            System.out.println(" Excepcion en la entrada de datos "
                    + e.getMessage() + " . No se da de alta");
            esAlta = false;
        }
    }

    public String codigo() {
        return codigo;
    }

    //muestra la casa que se acaba de asignar
    public void muestra() {
        System.out.println("");
        System.out.println("  ------------------------------");
        System.out.println("     Casa Rural: " + codigo);
        System.out.println("     Poblacion: " + poblacion);
        System.out.println("     Direccion: " + direccion);
        System.out.println("     Precio por dia: " + precio);
        System.out.println("  ------------------------------");
        System.out.println("");
    }

}
