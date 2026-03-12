package map_dependency_injection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class Kit {
    private String name;
    private Map<String, Integer> items;
}
