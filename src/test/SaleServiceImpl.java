package test;

import java.util.NoSuchElementException;
import java.util.UUID;

public class SaleServiceImpl implements SaleService {

    private final UserRepository userRepository;

    public SaleServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Basket calculateDiscount(UUID userId, Basket basket) {
        userRepository.findUserById(userId)
                .orElseThrow(() -> new NoSuchElementException("user.not.found"));
        final var findDiscount = userRepository.getUserDiscount(userId);
        if (findDiscount.isPresent()) {
            final var discount = findDiscount.get();
            System.out.println("Discount is " + discount);
            for (Products product : basket.getProducts()) {
                final var discountedAmount = product.getPrice() * discount / 100;
                product.setFinalPrice(product.getPrice() - discountedAmount);
                System.out.println("Check discount for product " + product.getId() + " calculated " + discountedAmount);
            }
        }
        return basket;
    }
}