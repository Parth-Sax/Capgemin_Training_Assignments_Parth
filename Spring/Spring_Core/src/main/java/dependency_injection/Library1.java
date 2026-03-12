package dependency_injection;

import lombok.Data;

import java.util.List;

@Data
public class Library1 {
    private int id;
    private String name;
    private List<Book> books;
}
