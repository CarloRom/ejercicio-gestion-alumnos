package org.example.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.example.model.Alumno;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlumnoAction extends ActionSupport {
    private Alumno alumno;
    private String dni;
    private String fechaNacimiento; // Agrega un String para recibir la fecha desde el formulario
    private List<Alumno> listaAlumnos = new ArrayList<>();
    private static final String ALUMNOS_SESSION_KEY = "listaAlumnos";

    public String showForm() {
        alumno = new Alumno(); // Inicializa un nuevo objeto Alumno
        return SUCCESS;
    }

    public String guardar() {
        // Verifica si la lista de alumnos está en la sesión
        Map<String, Object> session = ActionContext.getContext().getSession();
        listaAlumnos = (List<Alumno>) session.get(ALUMNOS_SESSION_KEY);
        if (listaAlumnos == null) {
            listaAlumnos = new ArrayList<>(); // Inicializa si no existe
        }


        // Validaciones
        if (alumno.getDni() == null || alumno.getDni().isEmpty()) {
            addFieldError("alumno.dni", "El DNI es obligatorio.");
        } else if (!alumno.getDni().matches("\\d{8}[A-Z]")) { // Asumiendo un formato de DNI español
            addFieldError("alumno.dni", "El DNI debe tener 8 dígitos seguidos de una letra.");
        }

        if (alumno.getNombre() == null || alumno.getNombre().isEmpty()) {
            addFieldError("alumno.nombre", "El nombre es obligatorio.");
        } else if (alumno.getNombre().length() < 2) {
            addFieldError("alumno.nombre", "El nombre debe tener al menos 2 caracteres.");
        }

        if (alumno.getApellido() == null || alumno.getApellido().isEmpty()) {
            addFieldError("alumno.apellido", "El apellido es obligatorio.");
        } else if (alumno.getApellido().length() < 2) {
            addFieldError("alumno.apellido", "El apellido debe tener al menos 2 caracteres.");
        }

        if (alumno.getEmail() != null && !alumno.getEmail().isEmpty()) {
            if (!alumno.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                addFieldError("alumno.email", "El email no es válido.");
            }
        }

        if (alumno.getTelefono() != null && !alumno.getTelefono().isEmpty()) {
            if (!alumno.getTelefono().matches("^\\+?[0-9]{7,15}$")) { // Número de teléfono válido
                addFieldError("alumno.telefono", "El teléfono no es válido.");
            }
        }

        if (alumno.getDireccion() != null && !alumno.getDireccion().isEmpty()) {
            if (alumno.getDireccion().length() < 5) {
                addFieldError("alumno.direccion", "La dirección debe tener al menos 5 caracteres.");
            }
        }

        if (alumno.getCiudad() != null && !alumno.getCiudad().isEmpty()) {
            if (alumno.getCiudad().length() < 2) {
                addFieldError("alumno.ciudad", "La ciudad debe tener al menos 2 caracteres.");
            }
        }

        if (alumno.getProvincia() != null && !alumno.getProvincia().isEmpty()) {
            if (alumno.getProvincia().length() < 2) {
                addFieldError("alumno.provincia", "La provincia debe tener al menos 2 caracteres.");
            }
        }

        if (alumno.getCodigoPostal() != null && !alumno.getCodigoPostal().isEmpty()) {
            if (!alumno.getCodigoPostal().matches("^[0-9]{5}$")) { // Formato de código postal
                addFieldError("alumno.codigoPostal", "El código postal debe tener 5 dígitos.");
            }
        }

        if (fechaNacimiento == null || fechaNacimiento.isEmpty()) {
            addFieldError("alumno.fechaNacimiento", "La fecha de nacimiento es obligatoria.");
        } else {
            try {
                // Definir el formato esperado
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate fecha = LocalDate.parse(fechaNacimiento, formatter);

                // Verificar que la fecha no sea en el futuro
                if (fecha.isAfter(LocalDate.now())) {
                    addFieldError("alumno.fechaNacimiento", "No has podido nacer en el futuro.");
                } else {
                    alumno.setFechaNacimiento(fecha); // Asignar la fecha válida
                }
            } catch (DateTimeParseException e) {
                addFieldError("alumno.fechaNacimiento", "La fecha de nacimiento debe estar en el formato DD-MM-YYYY y ser una fecha válida.");
            }
        }

        // Verifica si hay errores antes de guardar
        if (hasFieldErrors()) {
            return INPUT; // Regresar al formulario si hay errores
        }

        if (alumno != null) {
            // Guarda el alumno en la lista
            listaAlumnos.add(alumno);
            session.put(ALUMNOS_SESSION_KEY, listaAlumnos); // Almacena la lista de vuelta en la sesión
        }

        return SUCCESS;
    }

    public String buscar() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        listaAlumnos = (List<Alumno>) session.get(ALUMNOS_SESSION_KEY);
        if (listaAlumnos != null && !listaAlumnos.isEmpty()) {
           for(Alumno a : listaAlumnos) {
               if (a.getDni().equals(dni)) {
                   alumno = a;
                   return SUCCESS;
               }
           }
            // Si recorres toda la lista y no encuentras el DNI
            addActionError("El alumno con DNI " + dni + " no fue encontrado.");
        } else {
            addActionError("No hay alumnos registrados");

        }
        return INPUT;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }
}
