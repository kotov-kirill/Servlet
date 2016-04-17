package kurs;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Rakov Kirill
 */

@Entity
@Table(name="Leader")
public class Leader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private Long id;
    
    @Column(name="Rank")
    private String rank;
    
    @Column(name="Surname", nullable = false)
    private String Surname;
    
    @Column(name="First_name", nullable = false)
    private String First_name;
    
    @Column(name="Sec_name", nullable = false)
    private String Sec_name;
    
    @Column(name="Phone", nullable = false)
    private String Phone;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leader")
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    private List<Command> commands;
    {
        commands = new LinkedList<Command>();
    }

    public Leader() {}
    public Leader(String rank, String Surname, String First_name, String Sec_name, String Phone) {
        this.rank = rank;
        this.Surname = Surname;
        this.First_name = First_name;
        this.Sec_name = Sec_name;
        this.Phone = Phone;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSurname() {
        return Surname;
    }
    public void setSurname(String Surname) {
        this.Surname = Surname;
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

    public String getPhone() {
        return Phone;
    }
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    
    public List<Command> getCommands() {
        return commands;
    }
    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }
}