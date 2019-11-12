package eu.epitech.cashmanager.controller;

import eu.epitech.cashmanager.domain.Product;
import eu.epitech.cashmanager.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product) {
        this.productService.addProduct(product);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public void updateProduct(@RequestBody Product product) {
        this.productService.updateProduct(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable int id) {
        this.productService.deleteProduct(id);
    }
}
