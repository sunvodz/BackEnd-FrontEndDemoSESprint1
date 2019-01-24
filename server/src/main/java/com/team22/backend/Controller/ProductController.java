package com.team22.backend.Controller;

import com.team22.backend.Entity.*;
import com.team22.backend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {

    @Autowired
    private DetailRepository detailRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private DescriptionRepository descriptionRepository;

    @GetMapping(path = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Detail> details() {
        return detailRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/type", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Type> types() {
        return typeRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Product> product() {
        return productRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Status> status() {
        return statusRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/description", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Description> description() {
        return descriptionRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/product/add/{productID}/{productName}/{productPrice}/{productQuantity}/{productDate}/{state}/{type}")
    public Product newProduct(@RequestBody Product newProduct, @PathVariable String productID, @PathVariable String productName
            , @PathVariable Integer productPrice, @PathVariable Integer productQuantity, @PathVariable Date productDate, @PathVariable Long state, @PathVariable Long type
    ) {
        Status setStatus = statusRepository.findByStateId(state);
        Type setType = typeRepository.findByTypeIds(type);
        newProduct.setProductIds(productID);
        newProduct.setProductName(productName);
        newProduct.setProductQuantity(productQuantity);
        newProduct.setProductPrice(productPrice);
        newProduct.setProductDate(productDate);
  //      newProduct.setProductImg(productImg);/{productImg},@PathVariable String productImg
        newProduct.setStatus(setStatus);
        newProduct.setType(setType);
        return productRepository.save(newProduct);
    }
    @PostMapping("/description/{prodId}/{detailId}/{data}")
    public Description newDes(@RequestBody Description newDes, @PathVariable Long prodId, @PathVariable Long detailId,@PathVariable String data)
    {
        Detail setDet = detailRepository.findByDetailIds(detailId);
        Product setProd = productRepository.findByProdId(prodId);
        newDes.setDataDescription(data);
        newDes.setDetail(setDet);
        newDes.setProduct(setProd);
        return descriptionRepository.save(newDes);
    }
    @PutMapping("/product/updateproduct/{prodId}/{productID}/{productName}/{productPrice}/{productQuantity}")
    public Product editProduct(@RequestBody Product prod, @PathVariable Long prodId, @PathVariable String productID, @PathVariable String productName, @PathVariable Integer productPrice
            , @PathVariable Integer productQuantity) {
        return productRepository.findById(prodId).map(prodEdit -> {
                    prodEdit.setProductIds(productID);
                    prodEdit.setProductName(productName);
                    prodEdit.setProductPrice(productPrice);
                    prodEdit.setProductQuantity(productQuantity);
                    return productRepository.save(prodEdit);
                }
        ).orElseGet(() -> {
            return productRepository.save(prod);
        });
    }
    @PutMapping("/description/updatedetail/{prodId}/{detailId}/{data}")
    public Description editDetail(@RequestBody Description des, @PathVariable Long prodId, @PathVariable long detailId, @PathVariable String data) {
        Detail setDet = detailRepository.findByDetailIds(detailId);
        return descriptionRepository.findById(prodId).map(detEdit -> {
                    detEdit.setDetail(setDet);
                    detEdit.setDataDescription(data);
                    return descriptionRepository.save(detEdit);
                }
        ).orElseGet(() -> {
            return descriptionRepository.save(des);
        });
    }
    @DeleteMapping("/product/delete/{prodId}")
    public void deleteProduct(@PathVariable Long prodId) {
         productRepository.deleteById(prodId);
    }
}