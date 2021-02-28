package Controller;

import Model.Product;
import Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/test")
    public List<Product> getProducts(){
        List<Product> p = new ArrayList<>();
        Product product = new Product();
        product.setDescription("wow");
        p.add(product);
        return p;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    @PostMapping("/products")
    public List<Product> saveProduct(@RequestBody Product product){
        productRepository.save(product);
        return (List<Product>) productRepository.findAll();
    }

}
