package gr.aueb.cf.starter_data.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor                                                                       //lombok
@Getter                                                                                  //lombok
@Setter                                                                                  //lombok
@Entity                                                                                  //JPA Annotation
@Table(name = "teachers")                                                                //JPA Annotation
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private UUID uuid =  UUID.randomUUID();

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)                                             //Στους Booleans ΠΟΤΕ δεν κραταμε nulls! Αν το κανουμε πρεπει να δηλωσουμε ρηγτα οτι το null σημαινει false.
    private Boolean active;

    @Override
    public String toString() {
        return String.format("id=%d, uuid=%s, firstname=%s, lastname=%s, active=%s", id, uuid, firstname, lastname, active);
    }
}
