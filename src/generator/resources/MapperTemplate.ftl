<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.showka.MyBatisDemo.mapper.${entityClassName}Mapper">

	<insert id="insert">
		INSERT
		INTO ${tableName}
		set
		<#list columns as c>
		<#if c_index eq 0>
		${c.column} = #{${c.column}}
		<#else>
		, ${c.column} = #{${c.column}}
		</#if>
	    </#list>
		<include refid="Common.insertSet" />
	</insert>

	<update id="update">
		UPDATE
		${tableName}
		set
		<#list columns as c>
		<#if c_index eq 0>
		${c.column} = #{${c.column}}
		<#else>
		, ${c.column} = #{${c.column}}
		</#if>
	    </#list>
		<include refid="Common.updateSet" />
		WHERE
		<#list keys as k>
		<#if k_index eq 0>
		${k.column} = #{${k.column}}
		<#else>
		, ${k.column} = #{${k.column}}
		</#if>}
	    </#list>
		<include refid="Common.updateWhere" />
	</update>

	<update id="deleteLogically">
		UPDATE
		${tableName}
		set
		<include refid="Common.deleteLogicallySet" />
		WHERE
		<#list keys as k>
		<#if k_index eq 0>
		${k.column} = #{${k.column}}
		<#else>
		, ${k.column} = #{${k.column}}
		</#if>}
	    </#list>
		<include refid="Common.deleteLogicallyWhere" />
	</update>

	<delete id="deletePhysically">
		DELETE
		FROM ${tableName}
		WHERE
		<#list keys as k>
		<#if k_index eq 0>
		${k.column} = #{${k.column}}
		<#else>
		, ${k.column} = #{${k.column}}
		</#if>}
	    </#list>
		<include refid="Common.deletePhysicallyWhere" />
	</delete>

	<select id="select" resultMap="Entity.${entityClassName}">
		SELECT *
		FROM ${tableName}
		WHERE
		<#list keys as k>
		<#if k_index eq 0>
		${k.column} = #{${k.column}}
		<#else>
		, ${k.column} = #{${k.column}}
		</#if>}
	    </#list>
		<include refid="Common.select" />
	</select>

</mapper>