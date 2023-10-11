package pl.movieweb.movieweb.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CategoryRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

public List<Category> getAllCategory(){
    List<Category> categoryList;
    categoryList=jdbcTemplate.query("SELECT DISTINCT * FROM movieweb.category ORDER BY categoryName", BeanPropertyRowMapper.newInstance(Category.class));
    return categoryList;
}

public String findCategoryName(int idCategory){
    Category category;
    category = jdbcTemplate.queryForObject("SELECT categoryName FROM movieweb.category WHERE idCategory=?", BeanPropertyRowMapper.newInstance(Category.class), idCategory);
    return category.getCategoryName();
}

}
