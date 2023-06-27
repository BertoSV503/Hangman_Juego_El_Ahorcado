import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PalabrasEscondidas {

    private HashMap<String, ArrayList<String>> categorias;
    private Random rand;

    public PalabrasEscondidas(){
        categorias = new HashMap<String, ArrayList<String>>();
        rand = new Random();
    }

    public void agregarCategoria(String nombreCategoria){
        categorias.put(nombreCategoria, new ArrayList<String>());
    }

    public void agregarPalabra(String nombreCategoria, String palabra){
        ArrayList<String> palabras = categorias.get(nombreCategoria);
        if (palabras != null) {
            palabras.add(palabra);
        }
    }

    public void eliminarPalabra(String nombreCategoria, String palabra){
        ArrayList<String> palabras = categorias.get(nombreCategoria);
        if (palabras != null) {
            palabras.remove(palabra);
        }
    }

    public String obtenerPalabraAleatoria(String nombreCategoria, String dificultad) {
        ArrayList<String> palabras = categorias.get(nombreCategoria);
        if (palabras != null && !palabras.isEmpty()) {
            ArrayList<String> palabrasFiltradas = new ArrayList<String>();
            for (String palabra : palabras) {
                if (dificultad.equals("Facil") && palabra.length() >= 4 && palabra.length() <= 6) {
                    palabrasFiltradas.add(palabra);
                } else if (dificultad.equals("Intermedia") && palabra.length() >= 5 && palabra.length() <= 8) {
                    palabrasFiltradas.add(palabra);
                } else if (dificultad.equals("Dificil") && palabra.length() >= 8 && palabra.length() <= 12) {
                    palabrasFiltradas.add(palabra);
                }
            }
            if (!palabrasFiltradas.isEmpty()) {
                int index = rand.nextInt(palabrasFiltradas.size());
                return palabrasFiltradas.get(index);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
