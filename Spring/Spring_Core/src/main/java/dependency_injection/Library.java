package dependency_injection;

import lombok.Data;

@Data
public class Library {
    private int id;
    private String name;
    private Book book;
}
