
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Clinica {

    /* Listado de personas registradas en el sistema */
    public static ArrayList<Persona> personas = new ArrayList<>();

    /* Listado de pacientes confinados*/
    private static ArrayList<Paciente> confinados = new ArrayList<>();

    /* Listado de pacientes vacunados*/
    private static ArrayList<Paciente> vacunados = new ArrayList<>();

    /* Listado de pacientes mayores de 65*/
    private static ArrayList<Paciente> prioritarios = new ArrayList<>();

    /* Listado de pacientes menores de 65*/
    private static ArrayList<Paciente> no_prioritarios = new ArrayList<>();

    public static void main(String[] args) throws ParseException {

        int opcion = 0;
        boolean salir = false;

        /* Vacunas (Control de Stock)*/
        Moderna moderna = null;
        Jhonson jhonson = null;
        Pfizer pfizer = null;

        while (!salir) {

            System.out.println(" ******** Menú Principal ******** ");
            System.out.println(" 1- Gestión de Usuarios ");
            System.out.println(" 2- Realizar prueba");
            System.out.println(" 3- Gestión pacientes confinados");
            System.out.println(" 4- Comunicación con pacientes confinados");
            System.out.println(" 5- Gestión stock vacunas");
            System.out.println(" 6- Gestión vacunación");
            System.out.println(" 7- Visualizar pacientes asignados a cada enfermero");
            System.out.println(" 8- Visualizar pacientes asignados a cada técnico");
            System.out.println(" 9- Visualizar pacientes y su lista de vacunación");
            System.out.println(" 10- Salir ");

            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    int opcionGestionUsuario = 0;
                    boolean irAtrasOpcion1 = false;

                    while (!irAtrasOpcion1) {

                        System.out.println(" Seleccione la acción a realizar ");
                        System.out.println(" 1- Alta ");
                        System.out.println(" 2- Modificar ");
                        System.out.println(" 3- Baja ");
                        System.out.println(" 4- Listado de usuarios ");
                        System.out.println(" 5- Ir al menú principal ");

                        opcionGestionUsuario = sc.nextInt();

                        switch (opcionGestionUsuario) {

                            case 1:

                                System.out.println("Introduzca el dni del usuario");
                                String dniUsuario = sc.next();

                                boolean existeUsuario = verificarUsuario(dniUsuario);

                                if (existeUsuario == false) {
                                    System.out.println("Introduzca la edad del usuario");
                                    int edadUsuario = sc.nextInt();

                                    System.out.println("Seleccione tipo de usuario");
                                    System.out.println("Paciente (P)");
                                    System.out.println("Enfermero (E)");
                                    System.out.println("Técnico (T)");

                                    String tipoUsuarioSeleccionado = sc.next();

                                    String tipoUsuario = tipoUsuario(tipoUsuarioSeleccionado);

                                    Persona p = altaPersona(tipoUsuario, dniUsuario, edadUsuario);

                                    personas.add(p);

                                    System.out.println(tipoUsuario + "  con DNI " + p.getDni() + " fue añadida/o con éxito");

                                } else {
                                    System.out.println("Ya existe un uuario con ese dni !!!");
                                }

                                break;

                            case 2:
                                System.out.println("Introduzca el dni del usuario a modificar");
                                String dniU = sc.next();

                                boolean existeUsuarioBuscado = verificarUsuario(dniU);

                                if (existeUsuarioBuscado == true) {

                                    Persona p = buscarPersonaDNI(dniU);

                                    System.out.println("Introduzca el nuevo dni del Usuario");
                                    p.setDni(sc.next());

                                    System.out.println("Introduzca la nueva edad del Usuario");
                                    p.setEdad(sc.nextInt());

                                    System.out.println("El usuario ha sido modificado correctamente");

                                } else {
                                    System.out.println("No existe el usuario buscado con el dni " + sc.next());
                                }

                                break;

                            case 3:
                                System.out.println("Introduzca el dni del Usuario a eliminar");

                                String dniUsuarioEliminar = sc.next();

                                boolean buscarUsuario = verificarUsuario(dniUsuarioEliminar);

                                if (buscarUsuario == true) {

                                    Persona p = buscarPersonaDNI(dniUsuarioEliminar);

                                    eliminarUsuario(p);

                                } else {
                                    System.out.println("No existe el usuario buscado con ese dni " + dniUsuarioEliminar);
                                }

                                break;

                            case 4:

                                listarUsuariosRegistrados();

                                break;
                            case 5:
                                irAtrasOpcion1 = true;
                                break;
                        }

                    }

                    break;

                case 2:
                    System.out.println("");
                    System.out.println("Realización de pruebas");

                    System.out.println("");
                    System.out.println("Entre el DNI del paciente para realizar prueba diagnostico: ");
                    String dniUsuario = sc.next();

                    boolean existeUsuario = verificarUsuario(dniUsuario);

                    if (existeUsuario == true) {

                        Persona personaBuscada = buscarPersonaDNI(dniUsuario);

                        if (personaBuscada instanceof Paciente) {

                            Paciente pac = (Paciente) personaBuscada; // casting a Paciente

                            System.out.println("Entre la fecha de la prueba con formato (yyyy/mm/dd): ");
                            String fecha_prueba = sc.next();

                            System.out.println("Seleccionar tipo de prueba: ");
                            System.out.println("1- Antígenos");
                            System.out.println("2- PCR");
                            System.out.println("3- Serológico");

                            int test = sc.nextInt();
                            String resultado = "";

                            /* Buscar enfermero disponible */
                            Enfermero enfermero = asignar_enfermero();

                            if (enfermero != null) {

                                /* Asigna el paciente a la lista de pacientes del enfermero*/
                                enfermero.asignarPaciente(pac);

                                /* Asignar técnico disponible a un paciente y su diagnóstico */
                                Tecnico tecnico = asignar_tecnico();

                                if (tecnico != null) {

                                    /* Asigna el paciente a la lista de pacientes del técnico */
                                    tecnico.asignarPaciente(pac);

                                    Prueba prueba = null;

                                    switch (test) {
                                        case 1:
                                            prueba = new Antigeno(1);
                                            resultado = tecnico.resultado_antigenos_pcr();
                                            break;
                                        case 2: {
                                            boolean plazo_prueba = verificar_plazos_prueba(pac, fecha_prueba);
                                            if (plazo_prueba == true) {

                                                resultado = tecnico.resultado_antigenos_pcr();
                                                prueba = new PCR(2);

                                            } else {
                                                System.out.println("La fecha del último PCR con la fecha actual es inferior a 15 días. Debe superar el plazo de 15 días");
                                            }
                                            break;
                                        }
                                        case 3: {
                                            boolean plazo_prueba = verificar_plazos_prueba(pac, fecha_prueba);
                                            if (plazo_prueba == true) {
                                                resultado = tecnico.resultado_serologico();
                                                prueba = new Serologia(3);
                                            } else {
                                                System.out.println("La fecha de la última prueba Serológica con la fecha actual es inferior a 15. Debe superar el plazo de 6 meses (180 días)");
                                            }
                                            break;
                                        }
                                        default:
                                            break;
                                    }

                                    Diagnostico diagnostico = new Diagnostico(fecha_prueba, resultado, enfermero, tecnico, prueba);

                                    /* Método para asignar a laista de diagnóstico del paciente dado*/
                                    pac.anadirDiagnostico(diagnostico);
                                    System.out.println("Diagnóstico añadido a la lista del paciente: " + pac.toString());

                                    /* Verificar si el paciente ha dado POSITIVO, por tanto, tiene COVID y hay que confinarlo*/
                                    if (diagnostico.getResultado().equalsIgnoreCase("Positivo")) {
                                        System.out.println("El paciente " + pac.toString() + " ha dado POSITIVO AL COVID");
                                        confinados.add(pac);
                                        System.out.println("Paciente " + pac.toString() + " ha sido añadido a la lista de confinados. Darle seguimiento !!!");
                                        System.out.println("");
                                    }

                                } else {
                                    System.out.println("No existe técnico disponible en este momento");
                                }

                            } else {
                                System.out.println("No existe enfermero disponible en este momento");
                            }

                        } else {
                            System.out.println("Las pruebas sólo se realizan a usuarios de tipo Paciente !!!");
                        }

                    } else {
                        System.out.println("No está registrado el usuario " + dniUsuario + " en el sistema.");
                    }

                    System.out.println("");

                    break;

                case 4:
                    System.out.println("");
                    System.out.println("Listado de pacientes confinados:");

                    int totalConfinados = confinados.size();

                    if (totalConfinados > 0) {
                        for (int i = 0; i < confinados.size(); i++) {

                            int ultimo = confinados.get(i).getDiagnosticos().size() - 1;
                            Diagnostico d = confinados.get(i).getDiagnosticos().get(ultimo);
                            System.out.println(confinados.get(i).toString() + " con fecha de confinación: " + d.getFecha());

                        }
                    } else {
                        System.out.println("No existen pacientes confinados hasta el momento");
                        System.out.println("");
                    }
                    break;

                case 5:
                    System.out.println("");

                    System.out.println("Gestión del Stock de Vacunas");
                    System.out.println("Introduzca cantidad de dosis de vacunas Moderna");
                    int dosisModerna = sc.nextInt();
                    moderna = new Moderna(dosisModerna);

                    System.out.println("Introduzca cantidad de dosis de vacunas Pfizer");
                    int dosisPfizer = sc.nextInt();
                    pfizer = new Pfizer(dosisPfizer);

                    System.out.println("Introduzca cantidad de dosis de vacunas Johnson");
                    int dosisJohnson = sc.nextInt();
                    jhonson = new Jhonson(dosisJohnson);

                    System.out.println("Stock recibido: ");
                    System.out.println(moderna.getStock() + " vacunas de tipo Moderna");
                    System.out.println(pfizer.getStock() + " vacunas de tipo Pfizer");
                    System.out.println(jhonson.getStock() + " vacunas de tipo Jhonson");

                    int totalvacunas = moderna.getStock() + jhonson.getStock() + pfizer.getStock();

                    System.out.println("Total de vacunas recibidas: " + totalvacunas);

                    System.out.println("");
                    break;

                case 6:
                    System.out.println("");
                    System.out.println(" Gestión de la vacunación ");

                    int totalPacientes = personas.size();

                    if (totalPacientes > 0) {

                        for (int i = 0; i < personas.size(); i++) {
                            if (personas.get(i) instanceof Paciente) {

                                Paciente pacienteVacuna = (Paciente) personas.get(i);

                                int totalVacunasPacienteInicial = pacienteVacuna.getVacunacion().size();

                                if (totalVacunasPacienteInicial == 0) {
                                    /* Verificar los pacientes por edad para dar PRIORIDAD de VACUNACIÓN*/
                                    int ultimo = pacienteVacuna.getDiagnosticos().size() - 1;

                                    if (ultimo >= 0) {
                                        Diagnostico ultimoDiagnostico = pacienteVacuna.getDiagnosticos().get(ultimo);

                                        if (pacienteVacuna.getEdad() > 65 && ultimoDiagnostico.getResultado().equalsIgnoreCase("Negativo")) {
                                            prioritarios.add(pacienteVacuna);
                                        } else if (pacienteVacuna.getEdad() < 65 && ultimoDiagnostico.getResultado().equalsIgnoreCase("Negativo")) {
                                            no_prioritarios.add(pacienteVacuna);
                                        }
                                    } else {
                                        System.out.println("Al paciente. " + pacienteVacuna.toString() + ", no se le ha realizado ninguna prueba !!!");
                                    }
                                }

                            }
                        }

                        /* Plan de VACUNACIÓN de pacientes de más de 65*/
                        if (prioritarios.size() > 0) {

                            for (int i = 0; i < prioritarios.size(); i++) {

                                int vacunaPaciente = (int) aleatorio_vacuna();
                                Vacuna v = null;
                                String vacunaHoy = "";

                                switch (vacunaPaciente) {
                                    case 1:
                                        v = moderna;
                                        vacunaHoy = "Moderna";
                                        break;
                                    case 2:
                                        v = pfizer;
                                        vacunaHoy = "Pfizer";
                                        break;
                                    case 3:
                                        v = jhonson;
                                        vacunaHoy = "Jhonson";
                                        break;
                                }

                                if (v.getStock() > 0) {

                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    String fechaHoy = sdf.format(new Date());

                                    Vacunacion vacunacion = new Vacunacion(v, fechaHoy);

                                    prioritarios.get(i).anadirVacunacion(vacunacion);

                                    v.setStock(v.getStock() - 1);

                                    vacunados.add(prioritarios.get(i));

                                    System.out.println("Paciente " + prioritarios.get(i).toString() + ", vacunado con " + vacunaHoy + ", el día: " + vacunacion.getFecha());

                                    prioritarios.remove(i);

                                    System.out.println("");
                                }

                            }
                        }

                        /* Plan de VACUNACIÓN de pacientes de menos de 65*/
                        if (no_prioritarios.size() > 0) {
                            for (int i = 0; i < no_prioritarios.size(); i++) {

                                int vacunaPaciente = (int) aleatorio_vacuna();
                                Vacuna v = null;
                                String vacunaHoy = "";

                                switch (vacunaPaciente) {
                                    case 1:
                                        v = moderna;
                                        vacunaHoy = "Moderna";
                                        break;
                                    case 2:
                                        v = pfizer;
                                        vacunaHoy = "Pfizer";
                                        break;
                                    case 3:
                                        v = jhonson;
                                        vacunaHoy = "Jhonson";
                                        break;
                                }

                                if (v.getStock() > 0) {

                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    String fechaHoy = sdf.format(new Date());

                                    Vacunacion vacunacion = new Vacunacion(v, fechaHoy);

                                    no_prioritarios.get(i).anadirVacunacion(vacunacion);

                                    v.setStock(v.getStock() - 1);

                                    vacunados.add(no_prioritarios.get(i));

                                    System.out.println("Paciente " + no_prioritarios.get(i).toString() + ", vacunado con " + vacunaHoy + ", el día: " + vacunacion.getFecha());

                                    no_prioritarios.remove(i);

                                    System.out.println("");

                                }
                            }
                        }

                        System.out.println("");
                        System.out.println("Actualización del stock de vacunas: ");
                        System.out.println("Moderna: " + moderna.getStock());
                        System.out.println("Pfizer: " + pfizer.getStock());
                        System.out.println("Jhonson: " + jhonson.getStock());

                        System.out.println("");

                    } else {
                        System.out.println("Para vacunar a este paciente, primero hay que darle de alta y luego la prueba COVID");
                    }

                    System.out.println("");
                    break;

                case 7:
                    System.out.println("");
                    System.out.println("Listado de pacientes para cada Enfermero");

                    for (int i = 0; i < personas.size(); i++) {
                        if (personas.get(i) instanceof Enfermero) {
                            Enfermero e = (Enfermero) personas.get(i);

                            System.out.println("Enfermero: " + e.toString());
                            System.out.println("Lista de pacientes: ");
                            e.visualizar_pacientes_asignados();
                        }
                    }

                    System.out.println("");
                    break;

                case 8:

                    System.out.println("");
                    System.out.println("Listado de pacientes para cada Técnico");

                    for (int i = 0; i < personas.size(); i++) {
                        if (personas.get(i) instanceof Tecnico) {
                            Tecnico t = (Tecnico) personas.get(i);

                            System.out.println("Técnico: " + t.toString());
                            System.out.println("Lista de pacientes: ");
                            t.visualizar_pacientes_asignados();
                        }
                    }

                    System.out.println("");
                    break;

                case 9:
                    listarUsuariosVacunados();

                    System.out.println("");
                    System.out.println("Actualización del stock de vacunas: ");
                    System.out.println("Moderna: " + moderna.getStock());
                    System.out.println("Pfizer: " + pfizer.getStock());
                    System.out.println("Jhonson: " + jhonson.getStock());

                    System.out.println("");
                    break;

                case 10:

                    salir = true;
                    break;

                default:
                    System.out.println("Seleccione una opción válida");
                    break;

            }
        }

    }

    public static boolean verificarUsuario(String dni) {

        boolean existe = false;

        if (personas.size() > 0) {

            for (int i = 0; i < personas.size(); i++) {
                Persona persona = personas.get(i);

                if (persona.getDni().equalsIgnoreCase(dni)) {
                    existe = true;
                }
            }
        }

        return existe;
    }

    public static String tipoUsuario(String letra) {

        String tipo = "";
        String letraUsuario = letra.toUpperCase();

        if (letraUsuario.equalsIgnoreCase("P")) {
            tipo = "Paciente";
        } else if (letraUsuario.equalsIgnoreCase("E")) {
            tipo = "Enfermero";
        } else if (letraUsuario.equalsIgnoreCase("T")) {
            tipo = "Tecnico";
        }

        return tipo;
    }

    public static Persona altaPersona(String tipo, String dni, int edad) {
        Persona p = null;

        if (tipo.equalsIgnoreCase("Paciente")) {
            p = new Paciente(dni, edad);
        } else if (tipo.equalsIgnoreCase("Enfermero")) {
            p = new Enfermero(dni, edad);
        } else if (tipo.equalsIgnoreCase("Tecnico")) {
            p = new Tecnico(dni, edad);
        }

        return p;
    }

    public static Persona buscarPersonaDNI(String dni) {
        Persona p = null;

        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getDni().equalsIgnoreCase(dni)) {
                p = personas.get(i);
            }
        }
        return p;
    }

    public static void eliminarUsuario(Persona p) {
        personas.remove(p);
        System.out.println("Usuario eliminado correctamente !!!");
    }

    public static void listarUsuariosRegistrados() {

        System.out.println(" ******* Listado de Usuarios Registrados ******* ");

        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i) instanceof Paciente) {
                System.out.println("Paciente con " + personas.get(i).toString());
            } else if (personas.get(i) instanceof Enfermero) {
                System.out.println("Enfermero con " + personas.get(i).toString());
            } else if (personas.get(i) instanceof Tecnico) {
                System.out.println("Técnico con " + personas.get(i).toString());
            }
        }

        System.out.println("");

    }

    /* Método para buscar un enfermero disponible */
    public static Enfermero asignar_enfermero() {

        Enfermero e = null;

        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i) instanceof Enfermero) {
                e = (Enfermero) personas.get(i);
                if (e.comprobar_disponibilidad() == true) {
                    e.incrementar_total_test();
                }
            }
        }

        return e;
    }

    /* Método para buscar un técnico disponible */
    public static Tecnico asignar_tecnico() {
        Tecnico t = null;

        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i) instanceof Tecnico) {
                t = (Tecnico) personas.get(i);
                if (t.comprobar_disponibilidad() == true) {
                    t.incrementar_total_test();
                }
            }
        }

        return t;
    }

    /* Método que verifica los plazos de tiempo entre un examen y otro */
    public static boolean verificar_plazos_prueba(Paciente p, String fecha) throws ParseException {
        boolean testOK = false;

        int tamListaDiagnostico = p.getDiagnosticos().size();

        if (tamListaDiagnostico > 0) {
            int ultimo = p.getDiagnosticos().size() - 1;
            Diagnostico d = p.getDiagnosticos().get(ultimo);

            if (d.getPrueba() instanceof PCR) {
                String fechaUltimoDiagnosticoString = d.getFecha();
                java.util.Date fechaUltimoDiagnostico = new SimpleDateFormat("yyyy/MM/dd")
                        .parse(fechaUltimoDiagnosticoString);

                java.util.Date fechaActual = new SimpleDateFormat("yyyy/MM/dd").parse(fecha);

                long diff = fechaActual.getTime() - fechaUltimoDiagnostico.getTime();

                TimeUnit time = TimeUnit.DAYS;
                long diferenciaDias = time.convert(diff, TimeUnit.MILLISECONDS);

                if (diferenciaDias > 15) {
                    testOK = true;
                }
            } else if (d.getPrueba() instanceof Serologia) {
                String fechaUltimoDiagnosticoString = d.getFecha();
                java.util.Date fechaUltimoDiagnostico = new SimpleDateFormat("yyyy/MM/dd")
                        .parse(fechaUltimoDiagnosticoString);

                java.util.Date fechaActual = new SimpleDateFormat("yyyy/MM/dd").parse(fecha);

                long diff = fechaActual.getTime() - fechaUltimoDiagnostico.getTime();

                TimeUnit time = TimeUnit.DAYS;
                long diferenciaDias = time.convert(diff, TimeUnit.MILLISECONDS);

                if (diferenciaDias > 180) {
                    testOK = true;
                }
            }
        } else {
            testOK = true;
        }

        return testOK;
    }

    /* Método para crear aleatorio y seleccionar el tipo de vacuna*/
    public static double aleatorio_vacuna() {
        double valor = Math.random() * (4 - (1)) + (1);
        return valor;
    }

    /* Método para listar los pacientes vacunados y su plan de Vacunación*/
    public static void listarUsuariosVacunados() {

        System.out.println(" ******* Listado de Usuarios Vacunados ******* ");

        int totalVacunados = vacunados.size();

        if (totalVacunados > 0) {

            for (int i = 0; i < vacunados.size(); i++) {
                if (vacunados.get(i) instanceof Paciente) {

                    System.out.println("Paciente: " + vacunados.get(i).toString() + " y su plan de VACUNACIÓN: ");

                    Paciente pacienteV = vacunados.get(i);

                    for (int j = 0; j < pacienteV.getVacunacion().size(); j++) {
                        System.out.println(pacienteV.getVacunacion().get(j).toString());
                    }

                }
            }
        } else {
            System.out.println("No existen pacientes vacunados hasta el momento");
        }

        System.out.println("");

    }
    
}

