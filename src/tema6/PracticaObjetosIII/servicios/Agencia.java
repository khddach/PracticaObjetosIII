package tema6.PracticaObjetosIII.servicios;

import tema6.PracticaObjetosIII.modelos.Alquiler;
import tema6.PracticaObjetosIII.modelos.Cliente;
import tema6.PracticaObjetosIII.modelos.Coche;
import tema6.PracticaObjetosIII.modelos.NoHayCochesDisponiblesException;
import tema6.PracticaObjetosIII.modelos.enums.TipoCoche;

import java.time.LocalDate;
import java.util.ArrayList;

public class Agencia {

    //atributos
    private ArrayList<Coche> coches;
    private ArrayList<Alquiler> alquileres;

    public Agencia() {
        this.coches = new ArrayList<>();
        this.alquileres = new ArrayList<>();
    }


    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public ArrayList<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void addCoche(Coche c) {
        this.coches.add(c);
    }

    public void removeCoche(Coche c) {
        this.coches.remove(c);
    }


    public void listarCochesDisponibles() {
        for (Coche coche : coches) {
            if (coche.getDisponible()) {
                IO.println(coche.toString());
            }
        }
    }


    public void listarAlquileresActivos() {
        LocalDate hoy = LocalDate.now();

        for (Alquiler alquiler : alquileres) {
            if ( alquiler.getFechaFin().isAfter(hoy) ) {
                IO.println(alquiler.crearEmail());
            }
        }
    }



    public Coche buscarCocheDisponible(TipoCoche tipo) throws Exception {

        Coche cocheBuscar = null;

        for (Coche coche : coches) {
            if (coche.getDisponible() && coche.getTipo().equals(tipo) ) {
                cocheBuscar = coche;
                IO.println(cocheBuscar.toString());
                break;
            }
        }

        if (cocheBuscar == null) {
            throw new NoHayCochesDisponiblesException();
        }

        return cocheBuscar;
    }


    public boolean realizarAlquiler(Cliente cliente, TipoCoche tipo, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {

        try {

            Coche coche = this.buscarCocheDisponible(tipo);


            Alquiler alquiler = new Alquiler(cliente, coche, fechaInicio, fechaFin);
            this.alquileres.add(alquiler);

            return true;
        } catch (NoHayCochesDisponiblesException e) {
            return false;
        }



    }
}
