import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestHangman {

    public static void main(String[] args) {

        //  Leer el contenido del archivo de texto
        String fileName = "src/banner.txt";
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch(IOException e){
            e.printStackTrace();
        }

        // Agregar más información a la pantalla de presentación
        content += "\n\nCreado por: Mas Bytes, S.A. de C.V. (+Bytes)";
        content += "\nProgramador: Berto SV";
        content += "\nSan Salvador, Junio 2023";

        // Agregar texto de bienvenida
        content += "\n\n¡Bienvenido al juego Hangman!\n\n";
        content += "En este juego, tu objetivo es adivinar una palabra secreta eligiendo letras una por una. Si adivinas una letra que está en la palabra secreta, se revelará en su posición correcta. Pero ten cuidado, solo tienes un número limitado de intentos fallidos antes de perder el juego.\n\n";
        content += "Para comenzar, elige una categoría y una dificultad. Luego, comienza a adivinar letras hasta que adivines la palabra secreta o te quedes sin intentos fallidos.\n\n";
        content += "¡Buena suerte y diviértete!";

        //  Mostrar el contenido en la consola
        System.out.println(content);

        System.out.println();

        PalabrasEscondidas palabrasEscondidas = new PalabrasEscondidas();
        palabrasEscondidas.agregarCategoria("Paises");
        palabrasEscondidas.agregarCategoria("Animales");
        palabrasEscondidas.agregarCategoria("Ciudades");
        palabrasEscondidas.agregarCategoria("Nombres de Personas");

        palabrasEscondidas.agregarPalabra("Paises", "Chile");
        palabrasEscondidas.agregarPalabra("Paises", "Peru");
        palabrasEscondidas.agregarPalabra("Paises", "Dinamarca");
        palabrasEscondidas.agregarPalabra("Paises", "Alemania");
        palabrasEscondidas.agregarPalabra("Paises", "Argentina");
        palabrasEscondidas.agregarPalabra("Paises", "Australia");
        palabrasEscondidas.agregarPalabra("Paises", "Brasil");
        palabrasEscondidas.agregarPalabra("Paises", "Colombia");
        palabrasEscondidas.agregarPalabra("Paises", "Egipto");
        palabrasEscondidas.agregarPalabra("Paises", "Francia");



        palabrasEscondidas.agregarPalabra("Animales", "Perro");
        palabrasEscondidas.agregarPalabra("Animales", "Gato");
        palabrasEscondidas.agregarPalabra("Animales", "Serpiente");
        palabrasEscondidas.agregarPalabra("Animales", "Canguro");
        palabrasEscondidas.agregarPalabra("Animales", "Chimpance");
        palabrasEscondidas.agregarPalabra("Animales", "Flamenco");
        palabrasEscondidas.agregarPalabra("Animales", "Koala");
        palabrasEscondidas.agregarPalabra("Animales", "Leopardo");
        palabrasEscondidas.agregarPalabra("Animales", "Pinguino");
        palabrasEscondidas.agregarPalabra("Animales", "Elefante");


        palabrasEscondidas.agregarPalabra("Ciudades", "Lima");
        palabrasEscondidas.agregarPalabra("Ciudades", "Bogota");
        palabrasEscondidas.agregarPalabra("Ciudades", "Washington");
        palabrasEscondidas.agregarPalabra("Ciudades", "Bangkok");
        palabrasEscondidas.agregarPalabra("Ciudades", "Barcelona");
        palabrasEscondidas.agregarPalabra("Ciudades", "Chicago");
        palabrasEscondidas.agregarPalabra("Ciudades", "Estambul");
        palabrasEscondidas.agregarPalabra("Ciudades", "Londres");
        palabrasEscondidas.agregarPalabra("Ciudades", "Berlin");
        palabrasEscondidas.agregarPalabra("Ciudades", "Venezia");


        palabrasEscondidas.agregarPalabra("Nombres de Personas", "Juan");
        palabrasEscondidas.agregarPalabra("Nombres de Personas", "Maria");
        palabrasEscondidas.agregarPalabra("Nombres de Personas", "Mauricio");
        palabrasEscondidas.agregarPalabra("Nombres de Personas", "Adriana");
        palabrasEscondidas.agregarPalabra("Nombres de Personas", "Camila");
        palabrasEscondidas.agregarPalabra("Nombres de Personas", "Diego");
        palabrasEscondidas.agregarPalabra("Nombres de Personas", "Fernando");
        palabrasEscondidas.agregarPalabra("Nombres de Personas", "Javier");
        palabrasEscondidas.agregarPalabra("Nombres de Personas", "Mateo");
        palabrasEscondidas.agregarPalabra("Nombres de Personas", "Luciana");


        Scanner entrada = new Scanner(System.in);
        String jugarDeNuevo = "s";
        while (jugarDeNuevo.equals("s")) {
            System.out.println("Elige una categoria: 1) Paises 2) Animales 3) Ciudades 4) Nombres de Personas: ");
            int categoriaElegida = entrada.nextInt();
            entrada.nextLine();
            String nombreCategoria = "";
            switch(categoriaElegida){
                case 1 :
                    nombreCategoria = "Paises";
                    break;

                case 2 :
                    nombreCategoria = "Animales";
                    break;

                case 3 :
                    nombreCategoria = "Ciudades";
                    break;

                case 4 :
                    nombreCategoria = "Nombres de Personas";
                    break;
            }

            System.out.println("Elige una dificultad: 1) Facil 2) Intermedia 3) Dificil: ");
            int dificultadElegida = entrada.nextInt();
            entrada.nextLine();
            String dificultad = "";
            switch (dificultadElegida) {
                case 1:
                    dificultad = "Facil";
                    break;
                case 2:
                    dificultad = "Intermedia";
                    break;
                case 3:
                    dificultad = "Dificil";
                    break;
            }

            String palabraSecreta = palabrasEscondidas.obtenerPalabraAleatoria(nombreCategoria, dificultad);

            Hangman juego = new Hangman(palabraSecreta, 6);

            while (!juego.juegoFinalizado()) {
                System.out.println("Ingresa una letra : ");
                String input = entrada.nextLine();
                char letra = input.charAt(0);
                if(!Character.isLetter(letra) || !Character.isAlphabetic(letra)){
                    System.out.println("Por favor ingresa una letra valida. Sin tildes.");
                } else {
                juego.adivinandoLetras(letra);
                juego.mostrarEstado();
                if (juego.juegoGanado()) {
                    System.out.println("Felicidades has ganado !!");
                    agregarPalabraSecreta(palabrasEscondidas, nombreCategoria);
                    break;
                }

                }

            }

            if (juego.juegoFinalizado()) {
                juego.calcularPuntuacionFinal();
                juego.mostrarEstado();
                if (!juego.juegoGanado()) {
                    System.out.println("Game Over. Fallaste!");
                }
            }

            System.out.println("Quieres jugar de nuevo? (s/n): ");
            jugarDeNuevo = entrada.nextLine();

        }

    }

    public static void agregarPalabraSecreta(PalabrasEscondidas palabrasEscondidas, String nombreCategoria) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Has ganado. Como premio agrega una palabra secreta al juego : ");
        String nuevaPalabra = entrada.nextLine();
        while (nuevaPalabra.length() < 4 || nuevaPalabra.length() > 10) {
            System.out.println("La palabra debe de tener entre 4 y 10 letras. Sin acentos y sin mayusculas." +
                    " Intenta de nuevo.");
            nuevaPalabra = entrada.nextLine();
        }

        palabrasEscondidas.agregarPalabra(nombreCategoria, nuevaPalabra);
        System.out.println("Palabra agregada exitosamente!");

    }

}
