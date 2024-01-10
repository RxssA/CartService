package ie.atu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public List<CartItem> getCartItems(@PathVariable String userId) {
        return cartService.getCartItems(userId);
    }

    @PostMapping("/{userId}/add")
    public void addItemToCart(@PathVariable String userId, @RequestBody CartItem cartItem) {
        cartService.addItemToCart(userId, cartItem);
    }

    @DeleteMapping("/{userId}/remove/{itemId}")
    public void removeItemToCart(@PathVariable String userId, @PathVariable String itemId) {
        cartService.removeItemToCart(userId, itemId);

    }
}
