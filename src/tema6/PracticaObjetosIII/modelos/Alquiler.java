package tema6.PracticaObjetosIII.modelos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler implements Enviable {

    //Atributos
    protected static Long contador = 1L;

    private Long id;
    private Cliente cliente;
    private Coche coche;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double precioTotal;

    public Alquiler(Cliente cliente, Coche coche, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {

        if (coche.getDisponible()) {
            this.id = contador++;

            this.cliente = cliente;
            this.coche = coche;
            this.fechaInicio = fechaInicio;
            this.fechaFin = fechaFin;

            int dias = (int) ChronoUnit.DAYS.between(fechaInicio, fechaFin);

            this.precioTotal = coche.calcularPrecioAlquiler(dias);

            coche.setDisponible(false);

        } else {
            throw new NoHayCochesDisponiblesException();
        }
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }


    public void cancelarAlquiler() {
        this.coche.setDisponible(true);
    }


    @Override
    public String crearEmail() {

        StringBuffer sb = new StringBuffer("cliente:");
        sb.append("\n");

        sb.append("nombre y apellidos: ").append(this.cliente.getNombre() + " " + this.cliente.getApellidos()).append("\n");
        sb.append("marca: ").append(this.coche.getMarca()).append("\n");
        sb.append("modelo: ").append(this.coche.getModelo()).append("\n");
        sb.append("matricula: ").append(this.coche.getMatricula()).append("\n");
        sb.append("fecha inicio: ").append(this.fechaInicio).append("\n");
        sb.append("fecha fin: ").append(this.fechaFin).append("\n");
        sb.append("precio total: ").append(this.precioTotal).append("\n");

        return sb.toString();
    }
}
