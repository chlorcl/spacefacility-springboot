package me.chlorcl.spacefacility.checkouts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckoutService {
    private final CheckoutRepository checkoutRepository;

    public Checkout createCheckout(Checkout checkout) {
        return checkoutRepository.save(checkout);
    }

    public Checkout getCheckoutById(Integer id) {
        return checkoutRepository.findById(id).orElseThrow();
    }

    public Checkout updateCheckout(Checkout checkout) {
        return checkoutRepository.save(checkout);
    }

    public void deleteCheckout(Integer id) {
        checkoutRepository.deleteById(id);
    }

    public List<Checkout> getAllCheckouts() {
        return checkoutRepository.findAll();
    }
}
