package org.rigelos.discuss.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.rigelos.discuss.dao.UserDAO;
import org.rigelos.discuss.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl {
    protected final Log LOGGER = LogFactory.getLog(getClass());

    @Autowired
    private UserDAO userDAO;

    public int remove(long userId) {
        return userDAO.remove(userId);
    }
    public List<User> select(User user, int page, int size){
        if(page<=0)
            page = 1;
        int offset = (page-1)*size;
        return userDAO.select(user, offset, size);
    }
    
    public int getCount(User user){
        return userDAO.getCount(user);
    }

    public int add(User user) {
        if(user==null)
            return 0;
        return userDAO.add(user);
    }

    public int update(User user) {
        if(user==null)
            return 0;

        return userDAO.update(user);
    }

    public User getUserById(long userId) {
        User user = userDAO.get(userId);
        if(user == null){
            user = new User();
        }
        return user;
    }
}