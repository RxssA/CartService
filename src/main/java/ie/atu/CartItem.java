package ie.atu;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Data
public class CartItem {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private  Long id;

    private String itemId;
    private String itemName;
    private double price;

}
