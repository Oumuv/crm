package com.oumuv.core.info;

import java.io.Serializable;
import java.util.List;
/**
 * 菜单info
 * @author Administrator
 *
 */
public class MenuInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2357855834195447237L;
	private Long id;
	private String name;
	private String url;
	private String tip;
	private List<MenuInfo> menus;
	
	
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
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<MenuInfo> getMenus() {
		return menus;
	}
	public void setMenus(List<MenuInfo> menus) {
		this.menus = menus;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	
}
