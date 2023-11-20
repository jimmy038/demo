package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuService;

@SpringBootTest(classes = DemoApplication.class)
public class MenuServiceTest {
	
	@Autowired //@Autowired跟上面的類別拿屬性就不用new了
	private MenuService menuService;
	
	@Autowired
	private MenuDao menuDao;
	
	@Test	//有介面就用介面接回來,如沒有介面就用class接回來
	public void addMenuText() {	//一個新增需判斷以下4個條件
		//name 不符合條件 name不得為空字串
		Menu result = menuService.addMenu(new Menu(" ",120));
		Assert.isTrue(result == null,"addMenu error!!"); 
		//price = 0 價格不得為0
		result = menuService.addMenu(new Menu("chicken", 0)); 
		Assert.isTrue(result == null,"addMenu error!!"); 
		//正常新增一筆資料
		result = menuService.addMenu(new Menu("fish1", 120)); 
		Assert.isTrue(result != null,"addMenu error!!"); 
		//新增已存在的Menu
		result = menuService.addMenu(new Menu("fish1", 150)); 
		Assert.isTrue(result == null,"addMenu error!!"); 
		//刪除測試資料(刪除fish1相同資料)
		menuDao.deleteById("fish1");
	}

		
	@Test
	public void addMenusText() {	//新增多筆資料
		List<Menu> list = new ArrayList<>();
		list.add(new Menu("chicken", 150));
		list.add(new Menu("beef", 300));
		list.add(new Menu("mutton", 250));
		menuService.addMenus(list);
	}
	
	
	@Test
	public void updateMenu() {
		//name不符合條件
		Menu result = menuService.updateMenu(new Menu("",120));
		Assert.isTrue(result == null,"updateMenu error!!");
		//price=0
		result = menuService.updateMenu(new Menu("chicken",0));
		Assert.isTrue(result == null,"updateMenu error!!");
		//更新不存在的Menu
		result = menuService.updateMenu(new Menu("fish1",120));
		Assert.isTrue(result == null,"updateMenu error!!");
		//正常新增後再更新
		result = menuService.addMenu(new Menu("fish1",120));
		result = menuService.updateMenu(new Menu("fish1",120));
		Assert.isTrue(result != null,"updateMenu error!!");
		Assert.isTrue(result.getPrice() == 150,"updateMenu error!!");
		//刪除測試資料
		menuDao.deleteById("fish1");
	}
	
	
	@Test
	public void findByName() {
		//name不符合條件
		Menu result = menuService.findByName("");
		Assert.isTrue(result == null, "findByName error!!");
		//name不存在
		result = menuService.findByName("fish1");
		Assert.isTrue(result == null, "findByName error!!");
		//新增測試資料
		result = menuService.addMenu(new Menu("fish1",120));
		result = menuService.findByName("fish1");
		Assert.isTrue(result != null, "findByName error!!");
		//刪除測試資料
		menuDao.deleteById("fish1");
	}
	
	
	@Test
	public void findAll() {
		List<Menu> list = menuDao.findAll();
		for(Menu item : list) {
			System.out.println("Name:" + item.getName() + " " + "Price:" + item.getPrice());
		}
	}
}
