package action;

import com.opensymphony.xwork2.ActionSupport;
import org.omg.PortableInterceptor.SUCCESSFUL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.UserService;

import javax.xml.ws.soap.Addressing;

@Component
public class LoginAction extends ActionSupport {
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Autowired
    UserService userService;
    String userId;
    String password;

    public String execute() {
        int status =  userService.login(userId, password);
        if(status == 0) {
            return SUCCESS;
        }
        else if(status == -1) {
            return "UserNotExist";
        }
        else {
            return "WrongPassword";
        }
    }
}