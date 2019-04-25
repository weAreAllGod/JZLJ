package cn.edu.bjtu.jzlj.service;

import cn.edu.bjtu.jzlj.domain.User;

/**
 * @author: LiuYi
 * @date: 2019/4/20 1:10
 */
public interface UserService {

    User getUserByName(String userName);
}
