package pl.irybchuk.model;

import java.time.LocalDate;

public class User {
    private Integer Id;
    private String FirstName;
    private String LastName;
    private LocalDate DoB;

    public User(String firstName, String lastName, LocalDate doB) {
        FirstName = firstName;
        LastName = lastName;
        DoB = doB;
    }

    public User(Integer id, String firstName, String lastName, LocalDate doB) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        DoB = doB;
    }


    public LocalDate getDoB() {
        return DoB;
    }

    public void setDoB(LocalDate doB) {
        DoB = doB;
    }

    public Integer getId() {
        return Id;
    }

}
