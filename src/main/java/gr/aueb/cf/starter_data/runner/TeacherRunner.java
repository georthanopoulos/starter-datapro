package gr.aueb.cf.starter_data.runner;

import gr.aueb.cf.starter_data.model.Teacher;
import gr.aueb.cf.starter_data.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor                                                   // Creates a constructor automatically. As shown in the "muted" part below. Should it be private final only!!!
public class TeacherRunner implements CommandLineRunner {                  // By starting, it runs through Command Line Runner (CLR).

    private final TeacherRepository teacherRepository;

//    @Autowired
//    public TeacherRunner(TeacherRepository teacherRepository) {
//        this.teacherRepository = teacherRepository;
//    }

    @Override
    public void run(String... args) throws Exception {                     // ... -> it means that we can pass parameters into the command on the terminal (for creating the .jar)!

        Teacher teacher1 = new Teacher();
        teacher1.setFirstname("John");
        teacher1.setLastname("Papadopoulos");
        teacher1.setActive(true);
        teacherRepository.save(teacher1);                     // Upsert

        Teacher teacher2 = new Teacher();
        teacher2.setFirstname("Alice");
        teacher2.setLastname("Ioannou");
        teacher2.setActive(true);
        teacherRepository.save(teacher2);                     // Upsert

        Teacher teacher3 = new Teacher();
        teacher3.setFirstname("Bob");
        teacher3.setLastname("Giannoutsos");
        teacher3.setActive(false);
        teacherRepository.save(teacher3);                     // Upsert

    }
}
