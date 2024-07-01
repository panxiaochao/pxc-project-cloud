package io.github.panxiaochao.system.infrastructure.commpant;

import io.github.panxiaochao.mybatis.plus.handler.IMetaObjectHandler;
import io.github.panxiaochao.system.common.model.LoginUser;
import io.github.panxiaochao.system.common.utils.LoginContextHelper;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 项目自定义元对象填充
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 * @version 1.0
 */
@Component
public class CloudMetaObjectHandlerCustomizer implements IMetaObjectHandler {

	/**
	 * 创建人字段
	 */
	private static final String FIELD_CREATE_ID = "createId";

	/**
	 * 更新人字段
	 */
	private static final String FIELD_UPDATE_ID = "updateId";

	/**
	 * 插入元对象字段填充（用于插入时对公共字段的填充）
	 * @param metaObject 元对象
	 */
	@Override
	public void insertFillCustomize(MetaObject metaObject) {
		LoginUser loginUser = LoginContextHelper.getLoginUser();
		if (fillValIfNullByName(FIELD_CREATE_ID, loginUser, metaObject)) {
			metaObject.setValue(FIELD_CREATE_ID, Integer.valueOf(loginUser.getUserId()));
			metaObject.setValue(FIELD_UPDATE_ID, Integer.valueOf(loginUser.getUserId()));
		}
	}

	/**
	 * 更新元对象字段填充（用于更新时对公共字段的填充）
	 * @param metaObject 元对象
	 */
	@Override
	public void updateFillCustomize(MetaObject metaObject) {
		LoginUser loginUser = LoginContextHelper.getLoginUser();
		if (fillValIfNullByName(FIELD_UPDATE_ID, loginUser, metaObject)) {
			metaObject.setValue(FIELD_UPDATE_ID, Integer.valueOf(loginUser.getUserId()));
		}
	}

}
