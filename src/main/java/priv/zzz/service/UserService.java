package priv.zzz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import priv.zzz.dao.UserDao;

@Component
public class UserService {

    @Autowired
    UserDao userDao;

    public void query(){
        for(Object o:userDao.query()){
            System.out.println(o);
        }
    }
}
