package cn.edu.bjtu.jzlj.vo;

import cn.edu.bjtu.jzlj.domain.User;
import lombok.Data;

/**
 * @author: LiuYi
 * @date: 2019/4/20 13:41
 */
@Data

public class LoginVo {

    String token;

    String userName;

    String userId;

    String role;

    public LoginVo(String token, User user) {
        this.token = token;
        this.userName = user.getUserName();
        this.userId = user.getUserId();
        this.role = user.getRole();
    }
}
