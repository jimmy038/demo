package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuService;

//實作類別為class。方法就為Service類。impl為對介面裡面的物件做實作(類別實作物件)。
@Service 
//↑@Service即為spring boot方法托管,最終進入實作所以要讓spring boot託管在實作(MenuServiceImpl)。Service內寫的邏輯就是為了操作資料庫
public class MenuServiceImpl implements MenuService{
			//↑對介面實作的方法↑    			↑定義介面↑
	
	//@稱為annotation,被spring boot托管的物件拿出來使用
	@Autowired
	private MenuDao menuDao; //被spring boot托管DAO拿來使用
	
	@Override
	public Menu addMenu(Menu menu) {
		if(!StringUtils.hasText(menu.getName()) || menu.getPrice() <= 0) { //判斷字串是否為空StringUtils.hasText指向menu表格內的name
			return null;
		}
		if(menuDao.existsById(menu.getName())) { //如果那筆相同的資料已存在資料必須回傳null,因為這個方法就是單純add新增而非update,要讓save新增而非修改同一筆資料
			return null;
		}
		return menuDao.save(menu);
	}

	
	@Override
	public List<Menu> addMenus(List<Menu> menus) {
		for(Menu item : menus) {
			if(!StringUtils.hasText(item.getName()) || item.getPrice() <=0) {
				return null;
			}
		}
		return menuDao.saveAll(menus); //跳出迴圈後return saveAll資料
	}

	
	@Override
	public Menu updateMenu(Menu menu) {
		if (!StringUtils.hasText(menu.getName()) || menu.getPrice() <= 0) { //判斷字串是否為空StringUtils.hasText								// StringUtils.hasText指向menu表格內的name
			return null;
		}
		if (menuDao.existsById(menu.getName())) {
			return null;
		}
		return menuDao.save(menu);
	}
	
	
	@Override
	public Menu findByName(String name) {
		Optional<Menu> op = menuDao.findById(name);
//		原本if的寫法
		if (op.isEmpty()) { // isEmpty判斷是否為空,為空的話return null
			return null; 	// 若執行進來就return回去了,若沒進來就會執行下面那行
		}
		return op.get();
		//三元運算式寫法,等號後面條件判斷式
//		Menu menu = op.isEmpty()? null : op.get();
//		return menu;
		//三元運算式寫法,返回結果
//		return op.isEmpty()? null : op.get();
		
	}

	
	@Override
	public List<Menu> findAll() {
		return menuDao.findAll(); //直接回傳findAll		
	}
}
