# pxc-project-cloud
一款基于系统管理的微服务，采用Spring Boot 2.7.X版本，致力做一款通用的系统管理。

# 技术栈
- springboot 2.7.X
- JDK 1.8

# 常规标准字段
```sql
`sort` int NULL COMMENT '排序',
`status` char(1) NULL DEFAULT '1' COMMENT '状态：0关闭 1启用',
`is_delete` char(1) NULL COMMENT '删除：0删除 1正常',
`created_at` datetime NULL COMMENT '创建时间',
`updated_at` datetime NULL COMMENT '更新时间',
`deleted_at` datetime NULL COMMENT '删除时间',
`created_by` bigint NULL COMMENT '创建人ID',
`updated_by` bigint NULL COMMENT '更新人ID',
`tentant_id` bigint NULL COMMENT '租户ID',
`expire_at` datetime NULL COMMENT '过期时间',
`version` int NULL COMMENT '版本号',
`remark` varchar(255) NULL COMMENT '备注',
```
