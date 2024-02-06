package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@TableName("oauth2_authorization_consent")
public class Oauth2AuthorizationConsentPO {

	@TableId(value = "registered_client_id", type = IdType.ASSIGN_UUID)
	private String registeredClientId;

	@TableField(value = "principal_name")
	private String principalName;

	@TableField("authorities")
	private String authorities;

}
