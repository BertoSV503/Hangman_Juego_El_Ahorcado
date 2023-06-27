import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    private String palabraSecreta;

    private int maximoIntentosFallidos;

    private int intentosFallidos;

    private String letrasAcertadas;
    private String letrasIncorrectas;
    private double saldo;
    private double puntuacion;


    public Hangman(String palabraSecreta, int maximoIntentosFallidos) {
        this.palabraSecreta = palabraSecreta.toLowerCase();
        this.maximoIntentosFallidos = maximoIntentosFallidos;
        this.intentosFallidos = 0;
        this.letrasAcertadas = "";
        this.letrasIncorrectas = "";
        this.saldo = 100.0;
        this.puntuacion = 0.0;
    }

    public boolean adivinandoLetras(char letras) {
        letras = Character.toLowerCase(letras);
        if (letrasIncorrectas.indexOf(letras) >= 0) {
            System.out.println("Letra ya ingresada y no fue encontrada. Intenta con otra letra.");
            return false;
        } else {
            if (palabraSecreta.indexOf(letras) >= 0) {
                letrasAcertadas += letras;
                saldo += 50.0;
            } else {
                intentosFallidos++;
                letrasIncorrectas += letras;
                saldo -= 50.0;
            }
            return true;
        }
    }

    public boolean juegoFinalizado() {
        if (intentosFallidos >= maximoIntentosFallidos) {
            return true;
        }
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (letrasAcertadas.indexOf(palabraSecreta.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean juegoGanado() {
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (letrasAcertadas.indexOf(palabraSecreta.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }

    public void mostrarEstado() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < palabraSecreta.length(); i++) {
            char c = palabraSecreta.charAt(i);
            if (letrasAcertadas.indexOf(c) >= 0) {
                sb.append(c);
            } else {
                sb.append("*");
            }
        }

        System.out.println("Palabra Secreta : " + sb.toString());
        System.out.println("Intentos Fallidos : " + intentosFallidos);
        System.out.println("Intentos Restantes : " + (maximoIntentosFallidos - intentosFallidos));
        System.out.println("Saldo $ " + saldo);
        System.out.println("Puntuacion : " + puntuacion);
    }

    public void calcularPuntuacionFinal() {

        if (juegoGanado()) {
            puntuacion = saldo + 1000.0;
        } else {
            puntuacion = saldo;
        }
    }

}

