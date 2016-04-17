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
@Table(name="Command")
public class Command {
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "command")
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    private List<Kursant> kursants;
    {
        kursants = new LinkedList<Kursant>();
    }
    
    @ManyToOne
    @JoinColumn(name="ID_Leader")
    private Leader leader;

    public Command() {}

    public Command(Long Num_gr, String rank, String Surname, String First_name, String Sec_name, String Phone, Leader leader) {
        this.id = Num_gr;
        this.rank = rank;
        this.Surname = Surname;
        this.First_name = First_name;
        this.Sec_name = Sec_name;
        this.Phone = Phone;
        this.leader = leader;
    }

    public Long getNum_gr() {
        return id;
    }

    public void setNum_gr(Long Num_gr) {
        this.id = Num_gr;
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

    public List<Kursant> getKursants() {
        return kursants;
    }

    public void setKursants(List<Kursant> kursants) {
        this.kursants = kursants;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }
}