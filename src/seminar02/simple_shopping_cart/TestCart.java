package seminar02.simple_shopping_cart;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static seminar02.simple_shopping_cart.Main.getStoreItems;

public class TestCart {
    private Shop shop;
    private Cart cart;

    @BeforeEach
    public void SetUp(){
        shop = new Shop(getStoreItems());
        cart = new Cart(shop);
    }

    @Test
    void testCartPriсe(){
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(2);
        cart.addProductToCartByID(3);
        assertThat(cart.getTotalPrice()).isEqualTo(620.00d);
    }

    @Test
    void testMultiCartPriсe(){
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        assertThat(cart.getTotalPrice()).isEqualTo(510.00d);
    }

    @Test
    void testCartPriceAfterRemove(){
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(2);
        cart.addProductToCartByID(3);
        cart.removeProductByID(1);
        assertThat(cart.getTotalPrice()).isEqualTo(450.00d);
    }


    @Test
    void testCartChangeProductQuantity(){
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(7);
    }

    @Test
    void testAddProductToCartWithZeroStock(){
        Product product = shop.getProductsShop().get(0);
        product.setQuantity(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(0);
        assertThat(cart.cartItems.get(0).getQuantity()).isEqualTo(1);
    }

    @Test
    void testRemoveProductFromCart(){
        cart.addProductToCartByID(1);
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(9);
        cart.removeProductByID(1);
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(10);

    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 5000})
    void testInvalidProductID(int id){
        assertThatThrownBy(() -> cart.addProductToCartByID(id)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void testRemoveFromEmptyCart() {
        assertThatThrownBy(()-> cart.removeProductByID(1)).isInstanceOf(RuntimeException.class);
    }
}
