package Homework01.Shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {
    private Shop shop;

    @BeforeEach
    public void setUp() {
        shop = new Shop();
    }


//   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
    @Test
    public void testShopCorrectProducts() {
        Product product1 = new Product("Product A", 100);
        Product product2 = new Product("Product B", 50);
        shop.setProducts(Arrays.asList(product1, product2));

        assertThat(shop.getProducts()).hasSize(2)
                .contains(product1, product2);
    }


//   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
    @Test
    public void testGetMostExpensiveProduct() {
        // сразу проверяем исключение на пустом списке
        assertThatThrownBy(() -> shop.getMostExpensiveProduct()).isInstanceOf(NoSuchElementException.class);

        List<Product> products = Arrays.asList(
                new Product("Product A", 50),
                new Product("Product B", 200),
                new Product("Product C", 100)
        );
        shop.setProducts(products);

        assertThat(shop.getMostExpensiveProduct()).isEqualTo(products.get(1));
    }


//   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
    @Test
    public void testSortProductsByPrice() {
        shop.setProducts(Arrays.asList(
                new Product("Product A", 100),
                new Product("Product B", 50),
                new Product("Product C", 200)
        ));
        List<Product> sortedProducts = shop.sortProductsByPrice();

        assertThat(sortedProducts).isNotNull()
                .hasSize(3)
                .isSorted();
    }
}