package com.javatpoint.ecormspringboot.common.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.javatpoint.ecormspringboot.common.dto.ProductDTO;
import com.javatpoint.ecormspringboot.common.entity.ImageEntity;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import com.javatpoint.ecormspringboot.common.repository.specification.builder.ProductSpecificationBuilder;
import com.javatpoint.ecormspringboot.common.request.ProductRequest;
import com.javatpoint.ecormspringboot.common.service.*;
import com.javatpoint.ecormspringboot.common.service.imp.OriginService;
import com.javatpoint.ecormspringboot.common.service.imp.UserService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/api")
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private ObjectMapperUtils om;
    @Autowired
    private ModelMapper mp;
    @Autowired
    ObjectMapper objectmapper;
    @Autowired
    private IFileStorageService fileStorageService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IImageService imageService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IRecommendAgeService recommendService;
    @Autowired
    private IMaterialService materialService;
    @Autowired
    private IBrandService brandService;
    @Autowired
    private IStatusService statusService;
    @Autowired
    private ISizeService sizeService;
    @Autowired
    private UserService userService;
    @Autowired
    private OriginService originService;
    @Autowired
    private Gson gson;

    @GetMapping("/product/all")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<ProductDTO> result = this.om.mapAll(this.productService.findAll(), ProductDTO.class);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDTO> findOne(@PathVariable Long productId) {
        ProductEntity productEntity = this.productService.findOne(productId);
        return ResponseEntity.ok(this.mp.map(productEntity, ProductDTO.class));
    }


    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getProducts(@RequestParam int pageIndex, @RequestParam int pageSize,
                                                        @RequestParam(required = false) String dirSort, @RequestParam(required = false) String orderSort,
                                                        @RequestParam(required = false) String nameFilter, @RequestParam(required = false) Long categoryIdFilter,
                                                        @RequestParam(required = false) Long brandIdFilter, @RequestParam(required = false) Long ageIdFilter,
                                                        @RequestParam(required = false) Long[] priceFilter) {
        Pageable initPageable = new PageRequest(pageIndex, pageSize);
        ProductSpecificationBuilder productSpecificationBuilder = new ProductSpecificationBuilder();
        List<ProductEntity> initProductEntities = this.productService.findAll(initPageable);
        /* Filter */
        if (!StringUtils.isEmpty(dirSort)) {
            if (dirSort.equals("asc")) {
                initPageable = new PageRequest(pageIndex, pageSize, new Sort(Sort.Direction.ASC, orderSort));
            } else if (dirSort.equals("desc")) {
                initPageable = new PageRequest(pageIndex, pageSize, new Sort(Sort.Direction.DESC, orderSort));
            }

        }
        if (!StringUtils.isEmpty(nameFilter)) {
            productSpecificationBuilder.with("name", nameFilter, "like");
        }
        if (!StringUtils.isEmpty(categoryIdFilter)) {
            productSpecificationBuilder.with("category", categoryIdFilter, "in-equals");
        }
        if (!StringUtils.isEmpty(brandIdFilter)) {
            productSpecificationBuilder.with("brand", brandIdFilter, "in-equals");
        }
        if (!StringUtils.isEmpty(ageIdFilter)) {
            productSpecificationBuilder.with("recommend", ageIdFilter, "in-equals");
        }
        if (!StringUtils.isEmpty(priceFilter)) {
            productSpecificationBuilder.with("buyPrice", priceFilter, "between");
        }
        initProductEntities = this.productService.findAll(productSpecificationBuilder.build(), initPageable);
        List<ProductDTO> result = this.om.mapAll(initProductEntities, ProductDTO.class);
        System.out.println(result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/product/name-search")
    public ResponseEntity<List<ProductDTO>> searchProductByName(@RequestParam(value = "result") String productName, @RequestParam int pageIndex, @RequestParam int pageSize) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        List<ProductEntity> foundProducts = this.productService.findByNameContaining(productName, pageable);
        return ResponseEntity.ok(this.om.mapAll(foundProducts, ProductDTO.class));
    }

    @PostMapping("/product/add")
    public ResponseEntity addProduct(@RequestBody ProductRequest productRequest, @RequestParam long userId) throws IOException {
        this.mp.getConfiguration().setPreferNestedProperties(false);
        UserEntity foundUser = this.userService.findById(userId);
        ShopEntity shopEntity = foundUser.getShop();
        Set<ProductEntity> shopOfProducts = shopEntity.getProducts();
        ProductEntity productEntity = this.mp.map(productRequest, ProductEntity.class);
        productEntity.setOrigin(this.originService.findByCode(productRequest.getOriginCode()));
        productEntity.setCategory(this.categoryService.findByCode(productRequest.getCategoryCode()));
        productEntity.setMaterial(this.materialService.findByCode(productRequest.getMaterialCode()));
        productEntity.setRecommend(this.recommendService.findByCode(productRequest.getRecommendAgeCode()));
        productEntity.setBrand(this.brandService.findByCode(productRequest.getBrandCode()));
        productEntity.setStatus(this.statusService.findByCode(productRequest.getStatusCode()));
        productEntity.setBuyPrice(productEntity.getSourcePrice() * (100 - productEntity.getDiscountPercent()) / 100);
        productEntity.setShop(shopEntity);
        ProductEntity p = this.productService.save(productEntity);
        shopOfProducts.add(p);
        return ResponseEntity.ok(productEntity.getId());
    }

    @PostMapping(value = "/product/upload-image/{postId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductDTO> uploadProductImages(@PathVariable long postId, @RequestPart MultipartFile[] files) {
        ProductEntity foundPost = this.productService.findById(postId);
        ProductDTO result = null;
        if (foundPost != null) {
            foundPost.setSKU(String.valueOf(foundPost.getId()));
            List<String> filenames = this.fileStorageService.storeFiles(files);
            filenames.forEach(filename -> {
                ImageEntity imageEntity = new ImageEntity();
                imageEntity.setUrl(filename);
                imageEntity.setProduct(foundPost);
                this.imageService.save(imageEntity);
            });
            System.out.println(foundPost);
            this.productService.save(foundPost);
            result = this.om.map(foundPost, ProductDTO.class);
        }
        return ResponseEntity.ok(result);
    }
}
