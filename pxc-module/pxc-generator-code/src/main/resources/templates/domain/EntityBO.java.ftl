package ${domain}.entity.${entity?lower_case};

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>${table.comment!} BO实体类.</p>
 *
 * @author ${author}
 * @since ${date}
 */
@Getter
@Setter
@ToString
public class ${entity}BO {
<#list table.fields as field>

    <#if field.keyFlag>
    /**
    * ${field.comment}
    */
    private String ${field.propertyName};
    <#-- 普通字段 -->
    <#else>
    /**
     * ${field.comment}
     */
    private <#if field.propertyType="Long">String<#elseif field.propertyType="Integer">String<#else>${field.propertyType}</#if> ${field.propertyName};
    </#if>
</#list>
}
