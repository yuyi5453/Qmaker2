package action;

import org.omg.PortableInterceptor.SUCCESSFUL;

import service.UserService;

public class LoginAction extends ActionSupport{
    
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