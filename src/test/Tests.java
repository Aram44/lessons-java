package test;

import java.util.List;

public class Tests {

    private static UserRepository userRepository;
    private static SaleServiceImpl saleService;

    public static void main(String[] args) {
        userRepository = new UserRepository();
        saleService = new SaleServiceImpl(userRepository);
        testBasketProductsDiscountCalculation();
        testBasketProductsWoDiscountCalculation();
    }

    private static void testBasketProductsDiscountCalculation() {
        final int discountPercent = 10;
        final var testUser = new User("user");
        userRepository.addUser(testUser);
        userRepository.addDiscount(testUser.getId(), discountPercent);

        final var testProd1 = new Products(100);
        final var testProd2 = new Products(70);
        final var testProd3 = new Products(40);
        Basket basket = new Basket(List.of(testProd1, testProd2, testProd3));
        basket = saleService.calculateDiscount(testUser.getId(), basket);

        for (Products product : basket.getProducts()) {
            final var discountedAmount = product.getPrice() * discountPercent / 100;
            if (product.getPrice() - discountedAmount != product.getFinalPrice()) {
                throw new RuntimeException("The test is failed");
            } else {
                System.out.println("All good! price is " + product.getPrice() + " and discounted " + product.getFinalPrice());
            }
        }
    }

    private static void testBasketProductsWoDiscountCalculation() {
        final var testUser = new User("user");
        userRepository.addUser(testUser);

        final var testProd1 = new Products(100);
        final var testProd2 = new Products(70);
        final var testProd3 = new Products(40);
        Basket basket = new Basket(List.of(testProd1, testProd2, testProd3));
        basket = saleService.calculateDiscount(testUser.getId(), basket);

        for (Products product : basket.getProducts()) {
            if (product.getPrice() != product.getFinalPrice()) {
                throw new RuntimeException("The test is failed");
            } else {
                System.out.println("All good! price is " + product.getPrice() + " and discounted " + product.getFinalPrice());
            }
        }
    }
}
