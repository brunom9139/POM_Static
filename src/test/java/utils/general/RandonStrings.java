package utils.general;

import java.util.Random;


public class RandonStrings {
    public static String generarCadenaAleatoria(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder cadena = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            cadena.append(caracteres.charAt(index));
        }
        return cadena.toString();
    }

    public static String generarNombre() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder cadena = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 7; i++) {
            int index = random.nextInt(caracteres.length());
            cadena.append(caracteres.charAt(index));
        }
        return cadena.toString();
    }

    public static String generarPassword() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder cadena = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 7; i++) {
            int index = random.nextInt(caracteres.length());
            cadena.append(caracteres.charAt(index));
        }
        return cadena.toString();
    }

    public static String generarPasswordDebil() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder cadena = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(caracteres.length());
            cadena.append(caracteres.charAt(index));
        }
        return cadena.toString();
    }

}
