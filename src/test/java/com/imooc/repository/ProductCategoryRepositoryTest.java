package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;


    @Test
    public void findOneTest(){
        ProductCategory productCategory =  repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("时尚",11);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void updataTest(){
        ProductCategory productCategory = repository.findOne(2);
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(7);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<ProductCategory> productCategoryList = repository.findAll();
        //List<Integer> list2 = new ArrayList<>();
        List<Integer> list2 = productCategoryList.stream().map(e ->e.getCategoryType()).collect(Collectors.toList());
        /*for (ProductCategory productCategory: productCategoryList){
            list2.add(productCategory.getCategoryType());
        }*/
        for (Integer num : list2){
            System.out.println(num);
        }
        //List<Integer> list = Arrays.asList(2,3,6);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list2);
        for (ProductCategory productCategory : result){
            System.out.println(productCategory);
        }
        Assert.assertNotEquals(0, result);
    }
}