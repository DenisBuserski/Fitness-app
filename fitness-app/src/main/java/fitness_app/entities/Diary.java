package fitness_app.entities;

import javax.persistence.*;

@Entity(name = "diaries")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private Workout workout;

    public Diary(){}
    public Diary(String name) {
        this.name = name;
    }
}
