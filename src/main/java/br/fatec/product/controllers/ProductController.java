package br.fatec.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.product.Services.ProductService;
import br.fatec.product.entities.Product;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getProducts(){
        return service.getAllProducts();
    }

    @GetMapping("{id}")
    public Product geProduct(@PathVariable long id){
        return service.getProductById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateproduct(@PathVariable long id, @RequestBody Product product){
        service.update(product, id);
        return ResponseEntity.ok().build();
    }
    
    @PostMapping()
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product newProduct = service.save(product);
        return ResponseEntity.created(null).body(newProduct);
    
    }

}
