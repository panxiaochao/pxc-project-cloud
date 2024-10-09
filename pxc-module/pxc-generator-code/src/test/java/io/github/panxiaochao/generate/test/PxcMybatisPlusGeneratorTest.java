package io.github.panxiaochao.generate.test;

import io.github.panxiaochao.generate.enums.GenerateDbType;
import io.github.panxiaochao.generate.tool.PxcMybatisPlusGeneratorTools;

/**
 * {@code PxcMybatisPlusGeneratorTest}
 * <p>
 * description:
 *
 * @author Lypxc
 * @since 2023-02-15
 */
public class PxcMybatisPlusGeneratorTest {

	public static void main(String[] args) {
		PxcMybatisPlusGeneratorTools.builder()
			.jdbcUrl(
					"jdbc:mysql://134.98.6.21:9200/kids?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai")
			.username("kids")
			.password("kids@2024")
			.dbType(GenerateDbType.MYSQL)
			// .outputDir("E:/work_2023/test")
			.outputDir("/Users/Lypxc/Documents/project/generate_pxc")
			.parent("com.telecom.boot")
			.moduleName("mysql")
			.entityName("po")
			// .logicDeleteColumnName("deleted")
			.insertFields("create_time")
			.updateFields("update_time")
			.includes("kids_resource")
			.build();
	}

}
