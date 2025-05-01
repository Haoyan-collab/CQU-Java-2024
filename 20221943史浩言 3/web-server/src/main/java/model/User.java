package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String cname;
    private String pin;
    private Integer times;
    public User() {

    }
}
