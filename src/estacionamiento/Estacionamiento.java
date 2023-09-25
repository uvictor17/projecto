/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionamiento;

import java.util.Scanner;

/**
 *
 * @author travi
 */
public class Estacionamiento {

    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        
        int opcion;
        
        // Menú de opciones
        do {
            System.out.println("------- Estacionamiento con Ventanillas -------");
            System.out.println("1. Ingresar vehículo");
            System.out.println("2. Retirar vehículo");
            System.out.println("3. Ver estado del estacionamiento");
            System.out.println("4. Salir");
            System.out.println("-----------------------------------------------");
            System.out.print("Ingrese su opción: ");
            opcion = sc.nextInt();
            
            switch(opcion) {
                case 1 -> ingresarVehiculo();
                case 2 -> retirarVehiculo();
                case 3 -> verEstado();
                case 4 -> System.out.println("¡Hasta pronto!");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while(opcion != 4);
    }
    
    // Método para ingresar un vehículo al estacionamiento
    public static void ingresarVehiculo() {
        Scanner sc = new Scanner(System.in);
        int[] estacionamiento = null;
        
        for(int i = 0; i < estacionamiento.length; i++) {
            if(estacionamiento[i] == 0) { // Si el espacio está vacío
                estacionamiento[i] = 1; // 1 = espacio ocupado
                System.out.println("¡Vehículo ingresado!");
                System.out.println("Número de espacio: " + (i+1));
                
                // Asignar tiempo de ingreso
                System.out.print("Ingrese la hora de ingreso (en formato HH): ");
                int horaIngreso = sc.nextInt();
                System.out.print("Ingrese los minutos de ingreso (en formato MM): ");
                int minutosIngreso = sc.nextInt();
                int tiempoIngreso = (horaIngreso * 60) + minutosIngreso;
                estacionamiento[i] = tiempoIngreso;
                
                break; // Salir del ciclo for
            } else if(i == estacionamiento.length - 1) { // Si todos los espacios están ocupados
                System.out.println("Lo siento, el estacionamiento está lleno.");
            }
        }
    }
    
    // Método para retirar un vehículo del estacionamiento
    public static void retirarVehiculo() {
        Scanner sc = new Scanner(System.in);
        
        // Verificar si el vehículo está en el estacionamiento
        System.out.print("Ingrese el número de espacio: ");
        int espacio = sc.nextInt();
        int[] estacionamiento = null;
        if(estacionamiento[espacio - 1] == 0) { // Si el espacio está vacío
            System.out.println("Lo siento, ese espacio está vacío.");
        } else { // Si el espacio está ocupado
            // Calcular tiempo de uso
            System.out.print("Ingrese la hora de salida (en formato HH): ");
            int horaSalida = sc.nextInt();
            System.out.print("Ingrese los minutos de salida (en formato MM): ");
            int minutosSalida = sc.nextInt();
            int tiempoSalida = (horaSalida * 60) + minutosSalida;
            int tiempoUso = tiempoSalida - estacionamiento[espacio - 1];
            int precioHora = 0;
            
            // Calcular costo de uso
            int costo = (int) Math.ceil(tiempoUso / 60.0) * precioHora;
            System.out.println("El costo de uso es de $" + costo);
            
            // Liberar espacio
            estacionamiento[espacio - 1] = 0;
            System.out.println("¡Vehículo retirado!");
        }
    }
    
    // Método para mostrar el estado del estacionamiento
    public static void verEstado() {
        System.out.println("Estado del estacionamiento:");
        
        for(int i = 0; i < estacionamiento.length; i++) {
            if(estacionamiento[i] == 0) {
                System.out.println("Espacio " + (i+1) + ": Vacío");
            } else {
                System.out.println("Espacio " + (i+1) + ": Ocupado (desde las " + estacionamiento[i] + " horas)");
            }
        }
    }
    
}
