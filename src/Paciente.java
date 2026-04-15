public class Paciente {


    private String nombreCompleto;
    private String identificacion;
    private String tipoSeguro;
    private int edad;
    private double costoConsulta;
    private int numeroConsultas;
    private int prioridad;


    public Paciente(String nombreCompleto, String identificacion, String tipoSeguro, int edad, double costoConsulta, int numeroConsultas, int prioridad) {

        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;

        setTipoSeguro(tipoSeguro);
        setEdad(edad);
        setCostoConsulta(costoConsulta);
        setNumeroConsultas(numeroConsultas);
        setPrioridad(prioridad);
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public int getEdad() {
        return edad;
    }

    public double getCostoConsulta() {
        return costoConsulta;
    }

    public int getNumeroConsultas() {
        return numeroConsultas;
    }

    public int getPrioridad() {
        return prioridad;
    }



    public void setTipoSeguro(String tipoSeguro) {
        if (tipoSeguro.equalsIgnoreCase("Basico") ||
                tipoSeguro.equalsIgnoreCase("Premium") ||
                tipoSeguro.equalsIgnoreCase("SinSeguro")) {
            this.tipoSeguro = tipoSeguro;
        } else {
            this.tipoSeguro = "SinSeguro";
        }
    }

    public void setEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        } else {
            System.out.println("Edad inválida");
        }
    }

    public void setCostoConsulta(double costoConsulta) {
        if (costoConsulta > 0) {
            this.costoConsulta = costoConsulta;
        } else {
            System.out.println("Costo inválido");
        }
    }

    public void setNumeroConsultas(int numeroConsultas) {
        if (numeroConsultas >= 0) {
            this.numeroConsultas = numeroConsultas;
        } else {
            System.out.println("Número de consultas inválido");
        }
    }

    public void setPrioridad(int prioridad) {
        if (prioridad >= 1 && prioridad <= 5) {
            this.prioridad = prioridad;
        } else {
            System.out.println("Prioridad inválida");
        }
    }



    public double calcularCostoTotal() {
        return costoConsulta * numeroConsultas;
    }

    public double calcularDescuento() {
        double total = calcularCostoTotal();

        if (tipoSeguro.equalsIgnoreCase("Basico")) {
            return total * 0.10;
        } else if (tipoSeguro.equalsIgnoreCase("Premium")) {
            return total * 0.20;
        } else {
            return 0;
        }
    }

    public double calcularTotalPagar() {
        return calcularCostoTotal() - calcularDescuento();
    }

    public String clasificarPrioridad() {
        if (prioridad >= 4) {
            return "Alta prioridad";
        } else if (prioridad >= 2) {
            return "Prioridad media";
        } else {
            return "Prioridad baja";
        }
    }

    public String mensajeAtencion() {
        if (prioridad >= 4) {
            return "Atención inmediata requerida";
        } else if (prioridad >= 2) {
            return "Seguimiento necesario";
        } else {
            return "Control regular";
        }
    }


    public void mostrarReporte() {
        System.out.println("***************DATOS MEDICOS***********" );
        System.out.println("Nombre: " + getNombreCompleto());
        System.out.println("ID: " + getIdentificacion());
        System.out.println("Seguro: " + getTipoSeguro());
        System.out.println("Edad: " + getEdad());
        System.out.println("Costo total: " + calcularCostoTotal());
        System.out.println("Descuento: " + calcularDescuento());
        System.out.println("Total a pagar: " + calcularTotalPagar());
        System.out.println("Clasificación: " + clasificarPrioridad());
        System.out.println("Mensaje: " + mensajeAtencion());
    }
}

