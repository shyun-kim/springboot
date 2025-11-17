package com.springboot.shoppy_fullstack_app.service;

import com.springboot.shoppy_fullstack_app.dto.ProductDto;
import com.springboot.shoppy_fullstack_app.dto.ProductDetailinfoDto;
import com.springboot.shoppy_fullstack_app.dto.ProductQnaDto;
import com.springboot.shoppy_fullstack_app.dto.ProductReturnDto;
import com.springboot.shoppy_fullstack_app.entity.Product;
import com.springboot.shoppy_fullstack_app.entity.ProductDetailinfo;
import com.springboot.shoppy_fullstack_app.entity.ProductQna;
import com.springboot.shoppy_fullstack_app.jpa_repository.JpaProductRepository;
import com.springboot.shoppy_fullstack_app.jpa_repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final JpaProductRepository jpaProductRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, JpaProductRepository jpaProductRepository) {
        this.productRepository = productRepository;
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public ProductReturnDto findReturn() {

        return new ProductReturnDto(jpaProductRepository.findReturn());
    }

    @Override
    public List<ProductQnaDto> findQna(int pid) {
        List<ProductQnaDto> list = new ArrayList<>();
        List<ProductQna> entityList = jpaProductRepository.findQna(pid);
        entityList.forEach(entity -> list.add(new ProductQnaDto(entity)));
        return list;
    }

    /**
     * 상품 상세 - 디테일 탭
     */
    @Override
    public ProductDetailinfoDto findDetailinfo(int pid) {
        Optional<Product> entity = productRepository.findProductWithDetail(pid);
        ProductDetailinfo detailinfo = null; //OnetoOne이 아니라 OneToMany 면 List<> 로 감싸야함
        if(!entity.isEmpty()) {
            detailinfo = entity.get().getDetailinfo();
        }
        return new ProductDetailinfoDto(detailinfo);
    }

    /**
     * 상품 상세조회
     */
    @Override
    public ProductDto findByPid(int pid) {
        Product entity = productRepository.findByPid(pid);
        return new ProductDto(entity);
    }

    /**
     * 상품 전체 조회
     */
    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> dlist = new ArrayList<>();
        List<Product> list = productRepository.findAll();
        list.forEach((product) -> dlist.add(new ProductDto(product)));
        return dlist;
    }
}
