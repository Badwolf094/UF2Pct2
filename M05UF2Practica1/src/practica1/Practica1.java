/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica1 {

    public static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double res = 0;
        String operacion;
        boolean comprobar = false;

        do {

            double n1 = pedirNumero("primer");

            do {
                System.out.println("\n Operació? (Indica el signe)");
                System.out.println("(+) - Sumar \n(-) - Restar\n"
                        + "(x) - Multiplicar\n(/) - Dividir\n(*) - Elevar primer num al segon num."
                        + "\n(%) - Residu");
                operacion = sc.nextLine();
                if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x")
                        || operacion.equals("X") || operacion.equals("/") || operacion.equals("%")
                        || operacion.equals("*")) {
                    comprobar = true;
                } else {
                    comprobar = false;
                }
            } while (comprobar != true);

            double n2 = pedirNumero("segon");

            do {
                comprobar = true;
                switch (operacion) {
                    case "+":
                        res = n1 + n2;
                        break;
                    case "-":
                        res = n1 - n2;
                        break;
                    case "x":
                    case "X":
                        res = n1 * n2;
                        break;
                    case "/":
                        n2 = comprueba(n2, "segon");
                        res = n1 / n2;
                        break;
                    case "*":
                        res = Math.pow(n1, n2);
                        break;
                    case "%":
                        n2 = comprueba(n2, "segon");
                        res = n1 % n2;
                        break;
                }
            } while (comprobar != true);

            System.out.println("(" + n1 + ") " + operacion + " (" + n2 + ")" + " = " + res);
            System.out.println("\n Vols continuar operant? \n");
            System.out.println(" [s/n]");

        } while (salir());
    }

    public static double pedirNumero(String numero) {
        String valor = "";

        do {
            System.out.println("\n Introdueix el " + numero + " numero. ");
            valor = sc.nextLine();
        } while (!valor.matches("[+-]?[\\d]*[.]?[\\d]+"));
        double temp = Double.parseDouble(valor);
        double num = new Double(valor);

        return num;
    }

    public static double comprueba(double numero, String posicion) {

        while (numero == 0) {
            System.err.println(" Al denominador hi ha un zero per a  evitar errors coloca un altre valor.");
            numero = pedirNumero(posicion);

        }
        return numero;
    }

    public static Boolean salir() {
        boolean comprobar = false;

        String salir = sc.nextLine();
        while (!(salir.equals("S") || salir.equals("s") || salir.equals("N") || salir.equals("n"))) {
            System.err.println("\n Error, posa un valor vàlid. \n");
            salir = sc.nextLine();
        }
        switch (salir) {
            case "s":
            case "S":
                comprobar = true;
                break;
            case "n":
            case "N":
                System.err.println("\nFins aviat!");
                break;
            default:
                comprobar = false;
        }

        return comprobar;
    }
}
