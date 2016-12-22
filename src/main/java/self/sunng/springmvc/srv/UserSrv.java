package self.sunng.springmvc.srv;

import org.springframework.stereotype.Service;
import self.sunng.springmvc.common.RestfulParam;
import self.sunng.springmvc.dao.UserDao;
import self.sunng.springmvc.ent.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunxiaodong on 16/7/27.
 */
@Service("userService")
public class UserSrv {

    @Resource
    private UserDao userDao;

    public User create(User user) {
        userDao.insert(user);
        return user;
    }

    public User updateById(User user) {
        userDao.updateById(user);
        return user;
    }

    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    public User queryById(long id) {
        return userDao.selectById(id);
    }

    public List<User> queryByPage(RestfulParam restfulParam) {
        int pageNum = restfulParam.getInteger("pageNum");
        return userDao.selectForPage(restfulParam.getMap(), pageNum);
    }
}
