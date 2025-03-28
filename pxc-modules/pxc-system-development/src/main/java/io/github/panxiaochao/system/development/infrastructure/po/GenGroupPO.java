package io.github.panxiaochao.system.development.infrastructure.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p> 模板分组 持久化对象. <p>
 *
 * @author Lypxc
 * @since 2025-03-28
 */
@Getter
@Setter
@TableName("gen_group")
public class GenGroupPO {

    /**
    * 主键
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
    * 分组名称
    */
    @TableField("group_name")
    private String groupName;

    /**
    * 分组描述
    */
    @TableField("group_desc")
    private String groupDesc;

    /**
    * 创建时间
    */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
    * 更新时间
    */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
    * 创建人
    */
    @TableField(value = "create_id", fill = FieldFill.INSERT)
    private Integer createId;

    /**
    * 修改人
    */
    @TableField(value = "update_id", fill = FieldFill.INSERT_UPDATE)
    private Integer updateId;
}
