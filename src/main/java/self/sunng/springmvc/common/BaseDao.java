package self.sunng.springmvc.common;

import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;


public class BaseDao {

	protected final static int DEFAULT_PAGE_SIZE = 15;

	@Resource(name = "sqlSessionTemplate")
	protected SqlSessionTemplate sqlSessionReader;

	@Resource(name = "sqlSessionTemplate")
	protected SqlSessionTemplate sqlSessionWriter;

	protected int getStartIndex(int pageNum, int pageSize) {
		return (pageNum - 1) * pageSize;
	}

}
