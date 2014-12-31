package org.rigelos.discuss.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.rigelos.discuss.dao.CategoryDAO;
import org.rigelos.discuss.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryImpl {
    protected final Log LOGGER = LogFactory.getLog(getClass());

    @Autowired
    private CategoryDAO categoryDAO;

    public int remove(long categoryId) {
        return categoryDAO.remove(categoryId);
    }
    public List<Category> select(Category category, int page, int size){
        if(page<=0)
            page = 1;
        int offset = (page-1)*size;
        return categoryDAO.select(category, offset, size);
    }
    
    public int getCount(Category category){
        return categoryDAO.getCount(category);
    }

    public int add(Category category) {
        if(category==null)
            return 0;
        return categoryDAO.add(category);
    }

    public int update(Category category) {
        if(category==null)
            return 0;

        return categoryDAO.update(category);
    }

    public Category getCategoryById(long categoryId) {
        Category category = categoryDAO.get(categoryId);
        if(category == null){
            category = new Category();
        }
        return category;
    }
}