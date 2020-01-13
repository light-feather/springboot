package com.charis.springboot.web;

import com.charis.springboot.dao.CategoryDAO;
import com.charis.springboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired //JPA
    CategoryDAO categoryDAO;
    @RequestMapping("/listCategory")
    public String listCategory(Model m, @RequestParam(value = "start",
            defaultValue = "0")int start,@RequestParam(value = "size",
            defaultValue = "5")int size) throws Exception{
//        start = start<0?0:start;//前端配置了start的值，此处不再配置
        //下一页的按钮点击会不断地增加start的数值
        Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort  orders = Sort.by(order);
//        PageRequest pageRequest = PageRequest.of(start, size, orders);
        Pageable pageRequest = PageRequest.of(start, size, orders);
        Page<Category> page = categoryDAO.findAll(pageRequest);
        m.addAttribute("page",page);
        return "listCategory";
    }
    @RequestMapping("/addCategory")
    public String addCategory(Category category)throws Exception{
        categoryDAO.save(category);
        return "redirect:listCategory";
    }
    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category category)throws Exception{
        categoryDAO.delete(category);
        return "redirect:listCategory";
    }
    @RequestMapping("/updateCategory")
    public String updateCategory(Category category)throws Exception{
        categoryDAO.save(category);
        return "redirect:listCategory";
    }
    @RequestMapping("/editCategory")
    public String editCategory(int id, Model model){
        Category category = categoryDAO.getOne(id);
        model.addAttribute("category",category);
        return "editCategory";
    }
}
