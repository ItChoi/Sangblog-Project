package org.mybatis.spring.mapper;

import org.apache.ibatis.annotations.Mapper;

public class MapperConfigurer extends MapperScannerConfigurer {
	public MapperConfigurer() {
		super.setAnnotationClass(Mapper.class);
		super.setSqlSessionFactoryBeanName("sqlSessionFactory");
	}

}
