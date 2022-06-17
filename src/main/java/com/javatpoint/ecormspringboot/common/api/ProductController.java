package com.javatpoint.ecormspringboot.common.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.javatpoint.ecormspringboot.common.dto.ProductDTO;
import com.javatpoint.ecormspringboot.common.entity.ImageEntity;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import com.javatpoint.ecormspringboot.common.entity.SizeEntity;
import com.javatpoint.ecormspringboot.common.model.Pagination;
import com.javatpoint.ecormspringboot.common.request.ProductRequest;
import com.javatpoint.ecormspringboot.common.service.*;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/api")
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
    private Gson gson;

    @GetMapping("/product/all")
    public ResponseEntity<List<ProductDTO>> getProducts(@RequestBody Pagination pagination) {
        Pageable pageable = new PageRequest(pagination.getPageIndex(), pagination.getPageSize());
        List<ProductDTO> result = this.productService.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/product/add")
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) throws IOException {
        this.mp.getConfiguration().setPreferNestedProperties(false);
        ProductEntity productEntity = this.mp.map(productRequest, ProductEntity.class);
        productEntity.setCategory(this.categoryService.findByCode(productRequest.getCategoryCode()));
        productEntity.setMaterial(this.materialService.findByCode(productRequest.getMaterialCode()));
        productEntity.setRecommend(this.recommendService.findByCode(productRequest.getRecommendAgeCode()));
        productEntity.setBrand(this.brandService.findByCode(productRequest.getBrandCode()));
        productEntity.setStatus(this.statusService.findByCode(productRequest.getStatusCode()));
        ProductEntity p = this.productService.save(productEntity);
        return ResponseEntity.ok(p.getId());
    }
    @PostMapping(value = "/product/upload-image/{postId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductDTO> uploadProductImages(@PathVariable long postId, @RequestPart MultipartFile[] files){
        ProductEntity foundPost = this.productService.findById(postId);
        ProductDTO result = null;
        if(foundPost != null){
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
