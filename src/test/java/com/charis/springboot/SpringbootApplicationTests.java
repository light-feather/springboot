package com.charis.springboot;

import com.charis.springboot.dao.CategoryDAO;
import com.charis.springboot.pojo.Category;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
class SpringbootApplicationTests {
    @Autowired
    CategoryDAO categoryDAO;
    //@Before Junit5中@Before被@BeforeEach代替了
    @BeforeEach
    public void before(){
        List<Category> categoryList = categoryDAO.findAll();
        for (Category category :
                categoryList) {
            categoryDAO.delete(category);
        }
        for (int i = 0; i < 20; i++) {
            Category category = new Category();
            category.setName("category"+(i+1));
            categoryDAO.save(category);
        }
    }
    @Test
    void contextLoads() {
    }
    @Test
    void test1(){
        List<Category> categoryList = categoryDAO.findAll();
        System.out.println("所有的分类信息：");
        for (Category category :
                categoryList) {
            System.out.println(category.getName());
        }
        System.out.println();
    }
    @Test
    void test2(){
        System.out.println("查询名称是\"category 1\"的分类:");
        List<Category> cs = categoryDAO.findByName("category 1");
        for (Category category :
                cs) {
            System.out.println("category.getName():" + category.getName());
        }
        System.out.println();
    }
    @Test
    void test3(){
        System.out.println("根据名称模糊查询，id大于5，并且名称正排序查询");
        List<Category> categoryList =
                categoryDAO.findByNameLikeAndIdGreaterThanOrderByNameAsc("%3" +
                        "%",5);
        for (Category category :
                categoryList) {
            System.out.println(category);
        }
        System.out.println();
    }
}
