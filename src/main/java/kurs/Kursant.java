package kurs;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Rakov Kirill
 */

@Entity
@Table(name="Kursant")
public class Kursant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private Long id;
    
    @Column(name="Num_gr", nullable = false)
    private Integer Num_gr;
    
    @Column(name="Sirname", nullable = false)
    private String Sirname;
    
    @Column(name="First_name", nullable = false)
    private String First_name;
    
    @Column(name="Sec_name")
    private String Sec_name;
    
    @Column(name="ID_kursant", unique = true)
    private Integer ID_kursant;
    
    @ManyToOne
    @JoinColumn(name="ID_Command")
    private Command command;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Kursant")
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    private List<Address> addresses;
    {
        addresses = new LinkedList<Address>();
    }

    public Kursant() {}
    public Kursant(Integer Num_gr, String Sirname, String First_name, String Sec_name, Integer ID_kursant, Command command) {
        this.Num_gr = Num_gr;
        this.Sirname = Sirname;
        this.First_name = First_name;
        this.Sec_name = Sec_name;
        this.ID_kursant = ID_kursant;
        this.command = command;
    }
    public Kursant(Integer Num_gr, String Sirname, String First_name, String Sec_name, Integer ID_kursant) {
        this.Num_gr = Num_gr;
        this.Sirname = Sirname;
        this.First_name = First_name;
        this.Sec_name = Sec_name;
        this.ID_kursant = ID_kursant;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum_gr() {
        return Num_gr;
    }
    public void setNum_gr(Integer Num_gr) {
        this.Num_gr = Num_gr;
    }

    public String getSirname() {
        return Sirname;
    }
    public void setSirname(String Sirname) {
        this.Sirname = Sirname;
    }

    public String getFirst_name() {
        return First_name;
    }
    public void setFirst_name(String First_name) {
        this.First_name = First_name;
    }

    public String getSec_name() {
        return Sec_name;
    }
    public void setSec_name(String Sec_name) {
        this.Sec_name = Sec_name;
    }

    public Integer getID_kursant() {
        return ID_kursant;
    }
    public void setID_kursant(Integer ID_kursant) {
        this.ID_kursant = ID_kursant;
    }

    public Command getCommand() {
        return command;
    }
    public void setCommand(Command command) {
        this.command = command;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}