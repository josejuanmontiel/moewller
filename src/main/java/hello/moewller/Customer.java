package hello.moewller;

import static org.junit.Assert.assertEquals;

import hello.model.CustomerEntity;
import hello.view.CustomerView;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

public class Customer {

    private MVC layer = MVC.MO;
    public MVC getLayer() { return layer; }
    public void setLayer(MVC layer) { this.layer = layer; }

    public Customer() {
        nombre = firstName;
    }


    private Long id;
    public Long getId() {
        if (layer==MVC.MO) {
            return id;
        } else {
            return null;
        }
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String firstName;
    public String getFirstName() {
        switch (layer) {
            case MO: return firstName;
            case LLER: return nombre; 
        }
        return null;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        this.nombre = this.firstName;
    }

    private String lastName;
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String nombre;
    public String getNombre() {
        return firstName;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String apellido;
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    private CustomerEntity ce;
    private CustomerView cv;

}