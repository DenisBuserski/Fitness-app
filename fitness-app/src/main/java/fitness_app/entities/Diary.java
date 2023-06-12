package fitness_app.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "diaries")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private List<Workout> workout;

    public Diary(){}
    public Diary(String name, User user) {
        this.name = name;
        this.user = user;
        this.workout = new ArrayList<>();

    }
}
