package me.chlorcl.spacefacility.checkouts;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/checkouts")
@RequiredArgsConstructor
public class CheckoutController {
    private final CheckoutService checkoutService;

    @GetMapping
    public ResponseEntity<List<Checkout>> getAllCheckouts() {
        return ResponseEntity.ok(checkoutService.getAllCheckouts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Checkout> getCheckoutById(@PathVariable String id) {
        return ResponseEntity.ok(checkoutService.getCheckoutById(Integer.valueOf(id)));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Checkout> createCheckout(@RequestBody Checkout checkout) {
        return ResponseEntity.ok(checkoutService.createCheckout(checkout));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public ResponseEntity<Checkout> updateCheckout(@RequestBody Checkout checkout) {
        return ResponseEntity.ok(checkoutService.updateCheckout(checkout));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping
    public ResponseEntity<Void> deleteCheckout(@RequestBody Integer id) {
        checkoutService.deleteCheckout(id);
        return ResponseEntity.ok().build();
    }
}
