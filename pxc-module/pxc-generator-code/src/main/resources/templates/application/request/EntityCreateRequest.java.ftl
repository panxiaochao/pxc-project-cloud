package ${application}.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>${table.comment!}创建请求对象</p>
 *
 * @author ${author}
 * @since ${date}
 */
@Getter
@Setter
@ToString
@Schema(description = "${table.comment!}创建请求对象")
public class ${entity}CreateRequest {
<#list table.fields as field>
    <#if field.keyFlag>
    <#-- 普通字段 -->
    <#else>

    /**
     * ${field.comment}
     */
    @Schema(description = "${field.comment}")
    private ${field.propertyType} ${field.propertyName};
    </#if>
</#list>
}
