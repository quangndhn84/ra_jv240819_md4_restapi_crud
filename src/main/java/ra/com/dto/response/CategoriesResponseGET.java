package ra.com.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriesResponseGET {
    private int id;
    private String name;
    private LocalDate created;
    private boolean status;
}
