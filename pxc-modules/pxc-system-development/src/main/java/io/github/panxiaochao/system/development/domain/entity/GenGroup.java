package io.github.panxiaochao.system.development.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>模板分组 实体. </p>
 *
 * @author Lypxc
 * @since 2025-03-28
 */
@Getter
@Setter
@ToString
public class GenGroup {

    /**
    * 主键
    */
    private String id;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 分组描述
     */
    private String groupDesc;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private String createId;

    /**
     * 修改人
     */
    private String updateId;
}
