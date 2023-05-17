package ejercicio12.pkg5;

import java.util.Scanner;


public class Ejercicio125 {

    
    public static void main(String[] args) {
        
        int op;
        Tabla TablaDispersa = new Tabla();
        Scanner leer = new Scanner(System.in);
        String codigo;

        do{
            menu();
            op = controlOpcionMenu();
            
            switch(op){
                case 1:
                    CasaRural casa = new CasaRural();
                    TablaDispersa.insertar(casa);
                    pause();
                    break;
                case 2:
                    try{
                        System.out.println("Ingrese el codigo de la casa a buscar: ");
                        codigo = leer.nextLine();
                        casa = TablaDispersa.buscar(codigo);
                        casa.muestra();
                    }
                    catch(Exception e){
                        System.out.println("Codigo incorrecto o la casa ha sido eliminada...");
                    }
                    pause();
                    break;
                case 3:
                    try{
                        System.out.println("Ingrese el codigo de la casa a eliminar: ");
                        codigo = leer.nextLine();
                        TablaDispersa.eliminar(codigo);
                        System.out.println("Casa eliminada con exito...");
                    }
                    catch(Exception e){
                        System.out.println("Codigo incorrecto...");
                    }
                    pause();
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("SALIENDO DEL SISTEMA...");
                    System.out.println("");
                    pause();
                    break;
            }
        }
        while( op != 4);
    }
    
    
    public static void menu(){
        
        System.out.println("************************");
        System.out.println("1) Ingresar una casa.");
        System.out.println("2) Buscar una casa");
        System.out.println("3) Dar de baja una casa");
        System.out.println("4) Salir del sistema");
        System.out.println("************************");
    }
    
    public static void pause(){
        
        Scanner leer = new Scanner(System.in);
        System.out.println("");
        System.out.println("Presiones una tecla para continuar...");
        System.out.println("");
        leer.nextLine();
    }
    
    public static int controlOpcionMenu(){
        
        Scanner leer = new Scanner (System.in);
        int op = 0;
        
      try{
          System.out.println("Elija una opcion del menu");
          op = leer.nextInt();
          
          while (op<1 || op>4){
              System.out.println("Opcion no valida!, vuelva a elejir");
              op = leer.nextInt();
          }
          return op;
          
      }catch(Exception e){
          System.out.println("");
          System.out.println("Ingreso una opcion no valida, vuelva a intentarlo");
          System.out.println("");
      }
        return op;
    } 
    
    
}
