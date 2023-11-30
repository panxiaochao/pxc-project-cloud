package ${infrastructure}.mapper;

import ${superMapperClassPackage};
import ${infrastructure}.po.${entity}PO;
<#if mapperAnnotationClass??>
import ${mapperAnnotationClass.name};
</#if>

/**
 * <p> ${table.comment!} 持久化接口. </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if mapperAnnotationClass??>
@${mapperAnnotationClass.simpleName}
</#if>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}PO> {

}
