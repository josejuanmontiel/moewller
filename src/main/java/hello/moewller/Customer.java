package hello.moewller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import hello.model.CustomerMo;
import hello.view.CustomerView;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private MVC layer = MVC.MO;
    public MVC getLayer() { 
        return layer; 
    }
    public void setLayer(MVC layer) { 
        this.layer = layer; 
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String firstName;
    private String lastName;

    private String getFirstName() {
        switch (layer) {
            case MO: return firstName;
            case LLER: return ""; 
        }
        return null;
    }
    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNombre() {
        return firstName;
    }
    public String getApellido() {
        return lastName;
    }

}