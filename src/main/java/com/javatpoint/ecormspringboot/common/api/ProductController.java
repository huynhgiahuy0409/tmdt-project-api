package com.javatpoint.ecormspringboot.common.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.javatpoint.ecormspringboot.common.dto.ProductDTO;
import com.javatpoint.ecormspringboot.common.entity.ImageEntity;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import com.javatpoint.ecormspringboot.common.model.Pagination;
import com.javatpoint.ecormspringboot.common.request.ProductRequest;
import com.javatpoint.ecormspringboot.common.service.*;
import com.javatpoint.ecormspringboot.common.util.CustomException;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import com.javatpoint.ecormspringboot.response.ResponseMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    private ObjectMapperUtils mp;
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
    private Gson gson;
    @GetMapping("/product/all")
    public ResponseEntity<List<ProductDTO>> getProducts(@RequestBody Pagination pagination){
        Pageable pageable = new PageRequest(pagination.getPageIndex(), pagination.getPageSize());
        List<ProductDTO> result = this.productService.findAll(pageable);
        return ResponseEntity.ok(result);
    }
    @PostMapping(value = "/product/add", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<ProductDTO> addProduct(@RequestPart String product,@RequestPart MultipartFile[] files) throws IOException {
        ProductDTO productDTO = this.gson.fromJson(product, ProductDTO.class);
//        List<String> filenames = this.fileStorageService.storeFiles(files);
//        Set<ImageEntity> images = new HashSet<ImageEntity>();
//        filenames.forEach(filename -> {
//            ImageEntity imageEntity = new ImageEntity();
//            imageEntity.setUrl(filename);
//            images.add(imageEntity);
//        });
        ProductEntity productEntity = this.mp.map(productDTO, ProductEntity.class);
        productEntity.setCategory(this.categoryService.findByCode(productDTO.getCategoryCode()));
        productEntity.setMaterial(this.materialService.findByCode(productDTO.getMaterialCode()));
        productEntity.setRecommend(this.recommendService.findByCode(productDTO.getRecommendAgeCode()));
        productEntity.setBrand(this.brandService.findByCode(productDTO.getBrandCode()));
        productEntity.setStatus(this.statusService.findByCode(productDTO.getStatusCode()));
//        productEntity.setImages(images);
        System.out.println(productEntity);
        ProductEntity p = this.productService.save(productEntity);

        return null;
    }

}
