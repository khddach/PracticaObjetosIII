package tema6.PracticaObjetosIII.modelos;

import tema6.PracticaObjetosIII.modelos.enums.TipoCoche;
import tema6.PracticaObjetosIII.modelos.enums.TipoCombustible;

public class CochePremium extends Coche{

    //atributos
    private boolean gps;
    private boolean seguroExtra;


    public CochePremium(String marca, String modelo, String matricula, Integer anio, TipoCombustible combustible, Double precioBase, Boolean gps, Boolean seguroExtra,Boolean esDEPORTIVO) {

        TipoCoche tipo = esDEPORTIVO ? TipoCoche.DEPORTIVO : TipoCoche.FURGONETA;

        super(marca, modelo, matricula, anio, combustible, tipo, precioBase);
        this.gps = gps;
        this.seguroExtra = seguroExtra;
    }


    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public boolean isSeguroExtra() {
        return seguroExtra;
    }

    public void setSeguroExtra(boolean seguroExtra) {
        this.seguroExtra = seguroExtra;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CochePremium{");
        sb.append("id=").append(id);
        sb.append(", marca='").append(marca).append('\'');
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append(", matricula='").append(matricula).append('\'');
        sb.append(", anio=").append(anio);
        sb.append(", combustible=").append(combustible);
        sb.append(", tipo=").append(tipo);
        sb.append(", precioBase=").append(precioBase);
        sb.append(", disponible=").append(disponible);
        sb.append(", gps=").append(gps);
        sb.append(", seguroExtra=").append(seguroExtra);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Double calcularPrecioAlquiler(int dias) {

        double precio = this.precioBase * dias ;

        precio = precio + (precio * 20 / 100);

        precio = this.gps ? precio + (precio * 10 / 100) : precio;

        precio = this.seguroExtra ? precio + (precio * 15 / 100) : precio;

        return precio;
    }
}
