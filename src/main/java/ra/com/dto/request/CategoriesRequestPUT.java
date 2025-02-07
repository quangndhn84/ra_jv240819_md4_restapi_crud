package ra.com.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriesRequestPUT {
    private String name;
    private int priority;
    private LocalDate created;
    private String description;
    private boolean status;
}
