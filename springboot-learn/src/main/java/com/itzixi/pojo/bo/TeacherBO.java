package com.itzixi.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.List;

// bo business object 业务层使用的对象,前端传入,在Controller业务层实现处理

@Data
@ToString
@AllArgsConstructor
public class TeacherBO {
    private String id;

    // 字符串不能为null 不能为空格 等空字符串
    @NotBlank
    private String name;

    // 不能为null
    @NotNull
    private Integer age;

    // 校验字符串 集合 数组 不为null也不能为空
    @NotNull
    private String sex;

    // 校验数值的范围区间
    @Min(value = 1, message = "老师任职年级最小为1年级")
    @Max(value = 6, message = "老师任职年级最大为6年级")
    private Integer grade;

    // 数字大小区间范围
    @Range(min = 1, max = 18, message = "老师班级区间为1~18班")
    private Integer classroom;

    // 字符串 集合 数组 长度区间
    @Size(min = 2, max = 5, message = "每个老师需要有2~5个技能")
    private List<String> skill;

    // 字符串长度
    @Length(min = 3, max = 12, message = "每个老师英文名字长度的区间在3~12位之间")
    private String englishName;

    // 字符串必须是邮件格式
    @Email(message = "老师的邮箱格式不正确")
    private String email;

}