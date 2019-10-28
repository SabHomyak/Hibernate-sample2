import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Peoples")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int peopleId;
    private String name;
    @OneToMany(mappedBy = "people", cascade = CascadeType.PERSIST)
    List<Person> persons = new ArrayList<>();

    public People() {
    }

    public People(String name) {
        this.name = name;
    }

    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPerson(Person person) {
        person.setPeople(this);
        persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public String toString() {
        return "People{" +
                "peopleId=" + peopleId +
                ", name='" + name + '\'' +
                '}';
    }
}
