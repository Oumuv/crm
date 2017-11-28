package com.oumuv.core.info;

import java.util.List;

import com.oumuv.entity.User;

public class DepartmentInfo {
    private Long id;

    private String name;

    private Long pid;
    
    private List<User> menber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

	public List<User> getMenber() {
		return menber;
	}

	public void setMenber(List<User> menber) {
		this.menber = menber;
	}
    
    
}