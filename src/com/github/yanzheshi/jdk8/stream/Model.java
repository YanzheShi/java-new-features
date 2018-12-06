package com.github.yanzheshi.jdk8.stream;

/**
 * @author shiyanzhe
 * @date 2018/10/10
 */
public class Model {
    /**
     * id
     */
    public Integer id;

    /**
     * name
     */
    public String name;

    public Model(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Model{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
