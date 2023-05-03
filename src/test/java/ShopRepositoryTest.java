import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void testRemoveId() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "хлеб", 40);
        Product product2 = new Product(2, "молоко", 75);
        Product product3 = new Product(3, "масло", 160);
        Product product4 = new Product(4, "сыр", 209);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.remove(2);

        Product[] expected = {product1, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotFound() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "хлеб", 40);
        Product product2 = new Product(2, "молоко", 75);
        Product product3 = new Product(3, "масло", 160);
        Product product4 = new Product(4, "сыр", 209);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(15));
    }
}
