package serviceImpl;

import dao.UserDocDao;
import entity.UserDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.UserService;

@Component("userServiceImpl")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDocDao userDocDao;

    @Override
    public int create_New_Account(String userId, String password) {
        // TODO Auto-generated method stub
        if(userDocDao.select_User(userId).size() == 0){
            userDocDao.insert_New_User(userId, password);
        }
        else{
            return -1;
        }
        return 0;
    }

    @Override
    public int login(String userId, String password) {
        // TODO Auto-generated method stub
        UserDoc userdoc = (UserDoc)userDocDao.select_User(userId).get(0);
        if( userdoc == null){
            return -1;
        }
        else if(userdoc.getPassword().equals(password)){
            return 0;
        }
        else{
            return -2;
        }
    }

    
    
}