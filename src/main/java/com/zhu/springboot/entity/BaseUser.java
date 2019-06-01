package com.zhu.springboot.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class BaseUser {
    @NotBlank(message = "姓名不能为空！")
    private String name;

    @NotNull(message = "年龄不能为空！")
    @Min(value = 1, message = "最小值为1")
    @Max(value = 120, message = "最大值为120")
    private Long age;

    @NotBlank(message = "性别不能为空！")
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseUser baseUser = (BaseUser) o;
        return Objects.equals(name, baseUser.name) &&
                Objects.equals(age, baseUser.age) &&
                Objects.equals(gender, baseUser.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }

    @Override
    public String toString() {
        return "BaseUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
