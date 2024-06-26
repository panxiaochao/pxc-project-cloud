package ${application}.api.request.${entity?lower_case};

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
    private <#if field.propertyType="Long">String<#elseif field.propertyType="Integer">String<#else>${field.propertyType}</#if> ${field.propertyName};
    </#if>
</#list>

}
