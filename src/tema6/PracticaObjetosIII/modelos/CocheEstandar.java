package tema6.PracticaObjetosIII.modelos;

import tema6.PracticaObjetosIII.modelos.enums.TipoCoche;
import tema6.PracticaObjetosIII.modelos.enums.TipoCombustible;

public class CocheEstandar extends Coche{

    private Boolean aireAcondicionado;

    public CocheEstandar(String marca, String modelo, String matricula, Integer anio, TipoCombustible combustible, Double precioBase,Boolean aireAcondicionado,Boolean esSEDAN) {

        TipoCoche tipo = esSEDAN ? TipoCoche.SEDAN : TipoCoche.SUV;

        super(marca, modelo, matricula, anio, combustible, tipo, precioBase);
        this.aireAcondicionado = aireAcondicionado;
    }


    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CocheEstandar{");
        sb.append("id=").append(id);
        sb.append(", marca='").append(marca).append('\'');
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append(", matricula='").append(matricula).append('\'');
        sb.append(", anio=").append(anio);
        sb.append(", combustible=").append(combustible);
        sb.append(", tipo=").append(tipo);
        sb.append(", precioBase=").append(precioBase);
        sb.append(", disponible=").append(disponible);
        sb.append(", aireAcondicionado=").append(aireAcondicionado);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Double calcularPrecioAlquiler(int dias) {

        double precio = this.aireAcondicionado ?  5 * dias : 0.0;

        return (this.precioBase * dias) + precio;
    }
}
