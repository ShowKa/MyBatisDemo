<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.showka.MyBatisDemo.mapper.${className}Mapper">

	<insert id="insert">
		INSERT
		INTO ${tableName}
		set
		<#list columns as c>
		<#if c_index = 0>
		${c.column} = ${r"#{"}${c.column}${r"}"}
		<#else>
		, ${c.column} = ${r"#{"}${c.column}${r"}"}
		</#if>
	    </#list>
		<include refid="Common.insertSet" />
	</insert>

	<update id="update">
		UPDATE
		${tableName}
		set
		<#list columns as c>
		<#if c_index = 0>
		${c.column} = ${r"#{"}${c.column}${r"}"}
		<#else>
		, ${c.column} = ${r"#{"}${c.column}${r"}"}
		</#if>
	    </#list>
		<include refid="Common.updateSet" />
		WHERE
		<#list keys as c>
		<#if c_index = 0>
		${c.column} = ${r"#{"}${c.column}${r"}"}
		<#else>
		, ${c.column} = ${r"#{"}${c.column}${r"}"}
		</#if>
	    </#list>
		<include refid="Common.updateCriteria" />
	</update>

	<update id="deleteLogically">
		UPDATE
		${tableName}
		set
		<include refid="Common.deleteLogicallySet" />
		WHERE
		<#list keys as c>
		<#if c_index = 0>
		${c.column} = ${r"#{"}${c.column}${r"}"}
		<#else>
		, ${c.column} = ${r"#{"}${c.column}${r"}"}
		</#if>
	    </#list>
		<include refid="Common.deleteLogicallyCriteria" />
	</update>

	<delete id="deletePhysically">
		DELETE
		FROM ${tableName}
		WHERE
		<#list keys as c>
		<#if c_index = 0>
		${c.column} = ${r"#{"}${c.column}${r"}"}
		<#else>
		, ${c.column} = ${r"#{"}${c.column}${r"}"}
		</#if>
	    </#list>
		<include refid="Common.deletePhysicallyCriteria" />
	</delete>

	<select id="selectByPK" resultMap="Entity.${className}">
		SELECT *
		FROM ${tableName}
		WHERE
		<#list keys as c>
		<#if c_index = 0>
		${c.column} = ${r"#{"}${c.column}${r"}"}
		<#else>
		, ${c.column} = ${r"#{"}${c.column}${r"}"}
		</#if>
	    </#list>
		<include refid="Common.selectCriteria" />
	</select>
	
	<select id="selectDeletedByPK" resultMap="Entity.${className}">
		SELECT *
		FROM ${tableName}
		WHERE
		<#list keys as c>
		<#if c_index = 0>
		${c.column} = ${r"#{"}${c.column}${r"}"}
		<#else>
		, ${c.column} = ${r"#{"}${c.column}${r"}"}
		</#if>
	    </#list>
		<include refid="Common.selectDeletedCriteria" />
	</select>

</mapper>