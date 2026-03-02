package tema6.PracticaObjetosIII.servicios;

import tema6.PracticaObjetosIII.modelos.*;
import tema6.PracticaObjetosIII.modelos.enums.TipoCoche;
import tema6.PracticaObjetosIII.modelos.enums.TipoCombustible;

import java.time.LocalDate;
import java.util.Scanner;

public class PrincipalServicio {

    private Agencia agencia;

    public PrincipalServicio() {
        agencia = new Agencia();

        this.iniPrincipal();
    }

    private void iniPrincipal() {

        int matricula = 1;
        int modelo = 1;

        CocheEstandar cocheEstandar1 = new CocheEstandar("Dacia", "modelo" + modelo++, "ES100" + matricula++,
                2019, TipoCombustible.GASOLINA, 25.7, true, false);
        CocheEstandar cocheEstandar2 = new CocheEstandar("Dacia", "modelo" + modelo++, "ES100" + matricula++,
                2020, TipoCombustible.GASOLINA, 50.0, false, false);
        CocheEstandar cocheEstandar3 = new CocheEstandar("Dacia", "modelo" + modelo++, "ES100" + matricula++,
                2023, TipoCombustible.GASOLINA, 35.0, true, true);
        CocheEstandar cocheEstandar4 = new CocheEstandar("Dacia", "modelo" + modelo++, "ES100" + matricula++,
                2026, TipoCombustible.GASOLINA, 25.0, true, false);
        CocheEstandar cocheEstandar5 = new CocheEstandar("Dacia", "modelo" + modelo++, "ES100" + matricula++,
                2026, TipoCombustible.GASOLINA, 20.0, false, true);

        CocheEstandar cocheEstandar6 = new CocheEstandar("Audi", "modelo" + modelo++, "ES100" + matricula++,
                2019, TipoCombustible.GASOLINA, 30.0, true, false);
        CocheEstandar cocheEstandar7 = new CocheEstandar("Audi", "modelo" + modelo++, "ES100" + matricula++,
                2020, TipoCombustible.GASOLINA, 50.0, false, false);
        CocheEstandar cocheEstandar8 = new CocheEstandar("Audi", "modelo" + modelo++, "ES100" + matricula++,
                2023, TipoCombustible.GASOLINA, 35.0, true, true);
        CocheEstandar cocheEstandar9 = new CocheEstandar("Audi", "modelo" + modelo++, "ES100" + matricula++,
                2026, TipoCombustible.GASOLINA, 25.0, true, false);
        CocheEstandar cocheEstandar10 = new CocheEstandar("Audi", "modelo" + modelo++, "ES100" + matricula++,
                2026, TipoCombustible.GASOLINA, 20.0, false, true);


        CochePremium cochePremium1 = new CochePremium("Volvo", "modelo" + modelo++, "ES100" + matricula++,
                2025, TipoCombustible.DIESEL, 55.0, true, true, true);
        CochePremium cochePremium2 = new CochePremium("Volvo", "modelo" + modelo++, "ES100" + matricula++,
                2026, TipoCombustible.DIESEL, 30.0, true, true, true);
        CochePremium cochePremium3 = new CochePremium("Volvo", "modelo" + modelo++, "ES100" + matricula++,
                2023, TipoCombustible.DIESEL, 50.0, true, true, true);
        CochePremium cochePremium4 = new CochePremium("Volvo", "modelo" + modelo++, "ES100" + matricula++,
                2019, TipoCombustible.DIESEL, 40.0, true, true, true);
        CochePremium cochePremium5 = new CochePremium("Volvo", "modelo" + modelo++, "ES100" + matricula++,
                2020, TipoCombustible.DIESEL, 50.0, true, true, true);


        CochePremium cochePremium6 = new CochePremium("Toyota", "modelo" + modelo++, "ES100" + matricula++,
                2019, TipoCombustible.HIBRIDO, 60.0, true, true, true);
        CochePremium cochePremium7 = new CochePremium("Toyota", "modelo" + modelo++, "ES100" + matricula++,
                2021, TipoCombustible.HIBRIDO, 70.0, true, true, true);
        CochePremium cochePremium8 = new CochePremium("Toyota", "modelo" + modelo++, "ES100" + matricula++,
                2020, TipoCombustible.HIBRIDO, 40.0, true, true, true);
        CochePremium cochePremium9 = new CochePremium("Toyota", "modelo" + modelo++, "ES100" + matricula++,
                2025, TipoCombustible.HIBRIDO, 50.0, true, true, true);
        CochePremium cochePremium10 = new CochePremium("Toyota", "modelo" + modelo++, "ES100" + matricula++,
                2026, TipoCombustible.HIBRIDO, 30.0, true, true, true);


        this.agencia.addCoche(cocheEstandar1);
        this.agencia.addCoche(cocheEstandar2);
        this.agencia.addCoche(cocheEstandar3);
        this.agencia.addCoche(cocheEstandar4);
        this.agencia.addCoche(cocheEstandar5);
        this.agencia.addCoche(cocheEstandar6);
        this.agencia.addCoche(cocheEstandar7);
        this.agencia.addCoche(cocheEstandar8);
        this.agencia.addCoche(cocheEstandar9);
        this.agencia.addCoche(cocheEstandar10);
        this.agencia.addCoche(cochePremium1);
        this.agencia.addCoche(cochePremium2);
        this.agencia.addCoche(cochePremium3);
        this.agencia.addCoche(cochePremium4);
        this.agencia.addCoche(cochePremium5);
        this.agencia.addCoche(cochePremium6);
        this.agencia.addCoche(cochePremium7);
        this.agencia.addCoche(cochePremium8);
        this.agencia.addCoche(cochePremium9);
        this.agencia.addCoche(cochePremium10);

    }


    private void realizaralquiler() throws Exception {
        Scanner sc = new Scanner(System.in);
        TipoCoche tipo = null;
        Coche coche = null;


        while (true) {
            try {
                IO.println("Tipo de coches deseado(SEDAN, SUV, FURGONETA, DEPORTIVO): ");
                tipo = TipoCoche.valueOf(sc.nextLine().toUpperCase());
                IO.println(tipo);
                if (tipo != null) {
                    break;
                }
            } catch (Exception e) {
                IO.println("Error");
                tipo = null;
                continue;
            }

        }





        IO.println("Escribe fecha Inicio:");
        LocalDate fechaInicio = LocalDate.parse(sc.nextLine());

        IO.println("Escribe fecha Fin:");
        LocalDate fechaFin = LocalDate.parse(sc.nextLine());

        IO.println("cliente:");

        IO.println("Escribe el nombre del cliente");
        String nombre = sc.nextLine();

        IO.println("Escribe el apellido del cliente");
        String apellido = sc.nextLine();

        IO.println("Escribe el DNI del cliente");
        String dni = sc.nextLine();

        IO.println("Escribe el telefono del cliente");
        String telefono = sc.nextLine();

        IO.println("Escribe el email del cliente");
        String email = sc.nextLine();

        IO.println("Escribe la direccion del cliente");
        String direccion = sc.nextLine();


        IO.println("Escribe Licencia de conducir: ");
        String licenciaConducir = sc.nextLine();

        IO.println("Escribe fecha obtención licencia: ");
        LocalDate fechaObtencionLicencia = LocalDate.parse(sc.nextLine());


        Cliente cliente = new Cliente(nombre, apellido, dni, email, direccion, telefono, licenciaConducir, fechaObtencionLicencia);

        boolean realizarAlquiler = this.agencia.realizarAlquiler(cliente, tipo, fechaInicio, fechaFin);

        if (realizarAlquiler) {
            IO.println("El proceso de alquiler se completó con éxito");
        } else {
            IO.println("El proceso de alquiler no se ha completado");
        }
    }


    private void ingresosTotales() {

        double ingresoTotal = 0.0;
        LocalDate hoy = LocalDate.now();

        for (Alquiler alquiler : this.agencia.getAlquileres()) {

            if (alquiler.getFechaFin().isBefore(hoy)) {
                ingresoTotal += alquiler.getPrecioTotal();
            }

        }

        IO.println("hoy: " + hoy.toString());
        IO.println("El ingreso total es: " + ingresoTotal);


    }


    public void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int menu = -1;


        do {
            try {
                IO.println("*****************************************");
                IO.println("1. Listar Coches disponibles");
                IO.println("2. Listar Alquileres activos ");
                IO.println("3. Realizar alquiler");
                IO.println("4. Mostrar ingresos totales ");
                IO.println("5. Salir");
                IO.println("*****************************************");

                IO.println("Escribe el número de lista:");
                menu = Integer.parseInt(sc.nextLine());

                switch (menu) {
                    case 1:
                        IO.println("1. Listar Coches disponibles");
                        this.agencia.listarCochesDisponibles();
                        break;
                    case 2:
                        IO.println("2. Listar Alquileres activos ");
                        this.agencia.listarAlquileresActivos();
                        break;
                    case 3:
                        IO.println("3. Realizar alquiler");
                        this.realizaralquiler();
                        break;
                    case 4:
                        IO.println("4. Mostrar ingresos totales ");
                        this.ingresosTotales();
                        break;
                    case 5:
                        IO.println("gracias .. salir.....");
                        break;
                    default:
                        IO.println("error: escribe el número de lista");
                }


            } catch (Exception e) {
                IO.println("Error");
                menu = -1;
                continue;
            }

        } while (menu != 5);


    }
}
