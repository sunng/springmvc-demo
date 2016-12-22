package self.sunng.springmvc.dao;

import org.springframework.stereotype.Repository;
import self.sunng.springmvc.common.BaseDao;
import self.sunng.springmvc.ent.User;

import java.util.List;
import java.util.Map;

/**
 * Created by sunxiaodong on 16/7/27.
 */
@Repository("userDao")
public class UserDao extends BaseDao {
    public void insert(User user) {
        sqlSessionWriter.insert("User.insert", user);
    }

    public void updateById(User user) {
        sqlSessionWriter.update("User.updateById", user);
    }

    public void deleteById(Long id) {
        sqlSessionWriter.delete("User.deleteById", id);
    }

    public User selectById(Long id) {
        return sqlSessionReader.selectOne("User.selectById", id);
    }

    public List<User> selectForPage(Map<String, Object> paramMap, int pageNum) {
        paramMap.put("pageSize", DEFAULT_PAGE_SIZE);
        paramMap.put("startIndex", getStartIndex(pageNum, DEFAULT_PAGE_SIZE));
        List<User> list = sqlSessionReader.selectList("User.selectForPage", paramMap);
        //is return total count
//        int totalCount = sqlSessionReader.selectOne("User.selectForPageTotalCount", paramMap);
//        return new Page<>(pageNum, DEFAULT_PAGE_SIZE, totalCount, list);
        return list;
    }
}
