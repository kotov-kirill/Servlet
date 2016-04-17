package kurs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Rakov Kirill
 */

@Entity
@Table(name="Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private Long id;
    
    @Column(name="ind")
    private String ind;
    
    @Column(name="Region", nullable = false)
    private String Region;
    
    @Column(name="City", nullable = false)
    private String City;
    
    @Column(name="Street", nullable = false)
    private String Street;
    
    @Column(name="Place", nullable = false)
    private String Place;
    
    @Column(name="Phone")
    private String Phone;
    
    @ManyToOne
    @JoinColumn(name="ID_Kursnt")
    private Kursant Kursant;

    public Address() {}
    public Address(String ind, String Region, String City, String Street, String Place, String Phone, Kursant Kursant) {
        this.ind = ind;
        this.Region = Region;
        this.City = City;
        this.Street = Street;
        this.Place = Place;
        this.Phone = Phone;
        this.Kursant = Kursant;
    }
    public Address(Long id, String ind, String Region, String City, String Street, String Place, String Phone) {
        this.id = id;
        this.ind = ind;
        this.Region = Region;
        this.City = City;
        this.Street = Street;
        this.Place = Place;
        this.Phone = Phone;
    }
    public Address(String ind, String Region, String City, String Street, String Place, String Phone) {
        this.ind = ind;
        this.Region = Region;
        this.City = City;
        this.Street = Street;
        this.Place = Place;
        this.Phone = Phone;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getInd() {
        return ind;
    }
    public void setInd(String ind) {
        this.ind = ind;
    }
    
    public String getRegion() {
        return Region;
    }
    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getCity() {
        return City;
    }
    public void setCity(String City) {
        this.City = City;
    }

    public String getStreet() {
        return Street;
    }
    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getPlace() {
        return Place;
    }
    public void setPlace(String Place) {
        this.Place = Place;
    }

    public String getPhone() {
        return Phone;
    }
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public Kursant getKursant() {
        return Kursant;
    }
    public void setKursant(Kursant Kursant) {
        this.Kursant = Kursant;
    }
}