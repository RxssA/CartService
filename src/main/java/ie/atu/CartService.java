package ie.atu;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private Map<String, List<CartItem>> userCarts = new HashMap<>();
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public interface CartClient {
        @PostMapping("/confirm")
        String someDetails(@RequestBody CartItem cartItem);
    }
    public List<CartItem> getCartItems(String userId){
        return userCarts.getOrDefault(userId, new ArrayList<>());
    }

    public void addItemToCart(String userId,CartItem cartItem) {
        userCarts.computeIfAbsent(userId, k -> new ArrayList<>()).add(cartItem);
    }
    public void removeItemFromCart(String userId, String itemId) {
        userCarts.computeIfPresent(userId, (k, v) -> {
            v.removeIf(item -> item.getItemId().equals(itemId));
            return v;
        });
    }

    public void removeItemToCart(String userId, String itemId) {
    }
}
