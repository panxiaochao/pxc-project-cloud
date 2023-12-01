package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

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
@Accessors(chain = true)
@TableName("persistent_logins")
public class PersistentLoginsPO {

	@TableField("username")
	private String username;

	@TableId(value = "series", type = IdType.ASSIGN_UUID)
	private String series;

	@TableField("token")
	private String token;

	@TableField("last_used")
	private LocalDateTime lastUsed;

}
