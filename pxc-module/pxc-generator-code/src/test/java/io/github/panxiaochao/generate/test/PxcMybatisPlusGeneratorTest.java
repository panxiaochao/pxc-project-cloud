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
			// .jdbcUrl("jdbc:mysql://134.98.6.21:9200/kids?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai")
			.jdbcUrl("jdbc:mysql://127.0.0.1:3306/pxc-system?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai")
			.username("root")
			.password("root123456")
			.dbType(GenerateDbType.MYSQL)
			// .outputDir("E:/work_2023/test")
			.outputDir("/Users/Lypxc/Documents/project/generate_pxc")
			.parent("io.github.panxiaochao.system")
			.moduleName("development")
			.entityName("po")
			// .logicDeleteColumnName("deleted")
			.insertFields("create_time","create_id")
			.updateFields("update_time","update_id")
			.includes("gen_group")
			.build();
	}

}
