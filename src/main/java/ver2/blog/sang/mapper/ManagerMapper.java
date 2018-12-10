package ver2.blog.sang.mapper;


import org.apache.ibatis.annotations.Mapper;

import ver2.blog.sang.domain.ManagerInfo;

@Mapper
public interface ManagerMapper {
	
	public ManagerInfo getManagerInfo();
	
}
