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
	
	@Autowired //@Autowired��W�������O���ݩʴN����new�F
	private MenuService menuService;
	
	@Autowired
	private MenuDao menuDao;
	
	@Test	//�������N�Τ������^��,�p�S�������N��class���^��
	public void addMenuText() {	//�@�ӷs�W�ݧP�_�H�U4�ӱ���
		//name ���ŦX���� name���o���Ŧr��
		Menu result = menuService.addMenu(new Menu(" ",120));
		Assert.isTrue(result == null,"addMenu error!!"); 
		//price = 0 ���椣�o��0
		result = menuService.addMenu(new Menu("chicken", 0)); 
		Assert.isTrue(result == null,"addMenu error!!"); 
		//���`�s�W�@�����
		result = menuService.addMenu(new Menu("fish1", 120)); 
		Assert.isTrue(result != null,"addMenu error!!"); 
		//�s�W�w�s�b��Menu
		result = menuService.addMenu(new Menu("fish1", 150)); 
		Assert.isTrue(result == null,"addMenu error!!"); 
		//�R�����ո��(�R��fish1�ۦP���)
		menuDao.deleteById("fish1");
	}

		
	@Test
	public void addMenusText() {	//�s�W�h�����
		List<Menu> list = new ArrayList<>();
		list.add(new Menu("chicken", 150));
		list.add(new Menu("beef", 300));
		list.add(new Menu("mutton", 250));
		menuService.addMenus(list);
	}
	
	
	@Test
	public void updateMenu() {
		//name���ŦX����
		Menu result = menuService.updateMenu(new Menu("",120));
		Assert.isTrue(result == null,"updateMenu error!!");
		//price=0
		result = menuService.updateMenu(new Menu("chicken",0));
		Assert.isTrue(result == null,"updateMenu error!!");
		//��s���s�b��Menu
		result = menuService.updateMenu(new Menu("fish1",120));
		Assert.isTrue(result == null,"updateMenu error!!");
		//���`�s�W��A��s
		result = menuService.addMenu(new Menu("fish1",120));
		result = menuService.updateMenu(new Menu("fish1",120));
		Assert.isTrue(result != null,"updateMenu error!!");
		Assert.isTrue(result.getPrice() == 150,"updateMenu error!!");
		//�R�����ո��
		menuDao.deleteById("fish1");
	}
	
	
	@Test
	public void findByName() {
		//name���ŦX����
		Menu result = menuService.findByName("");
		Assert.isTrue(result == null, "findByName error!!");
		//name���s�b
		result = menuService.findByName("fish1");
		Assert.isTrue(result == null, "findByName error!!");
		//�s�W���ո��
		result = menuService.addMenu(new Menu("fish1",120));
		result = menuService.findByName("fish1");
		Assert.isTrue(result != null, "findByName error!!");
		//�R�����ո��
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
