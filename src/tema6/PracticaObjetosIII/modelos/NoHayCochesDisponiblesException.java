package tema6.PracticaObjetosIII.modelos;

public class NoHayCochesDisponiblesException extends Exception {

    public NoHayCochesDisponiblesException() {
        IO.println("No hay coches disponibles");
    }
}
