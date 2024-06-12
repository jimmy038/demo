package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuService;

//��@���O��class�C��k�N��Service���Cimpl���虜���̭������󰵹�@(���O��@����)�C
@Service 
//��@Service�Y��spring boot��k����,�̲׶i�J��@�ҥH�n��spring boot�U�ަb��@(MenuServiceImpl)�CService���g���޿�N�O���F�ާ@��Ʈw
public class MenuServiceImpl implements MenuService{
			//���虜����@����k��    			���w�q������
		
	//@�٬�annotation,�Qspring boot���ު����󮳥X�Өϥ�
	@Autowired
	private MenuDao menuDao; //�Qspring boot����DAO���Өϥ�
	
	@Override
	public Menu addMenu(Menu menu) {
		if(!StringUtils.hasText(menu.getName()) || menu.getPrice() <= 0) { //�P�_�r��O�_����StringUtils.hasText���Vmenu��椺��name
			return null;
		}
		if(menuDao.existsById(menu.getName())) { //�p�G�����ۦP����Ƥw�s�b��ƥ����^��null,�]���o�Ӥ�k�N�O���add�s�W�ӫDupdate,�n��save�s�W�ӫD�ק�P�@�����
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
		return menuDao.saveAll(menus); //���X�j���return saveAll���
	}

	
	@Override
	public Menu updateMenu(Menu menu) {
		if (!StringUtils.hasText(menu.getName()) || menu.getPrice() <= 0) { //�P�_�r��O�_����StringUtils.hasText								// StringUtils.hasText���Vmenu��椺��name
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
//		�쥻if���g�k
		if (op.isEmpty()) { // isEmpty�P�_�O�_����,���Ū���return null
			return null; 	// �Y����i�ӴNreturn�^�h�F,�Y�S�i�ӴN�|����U������
		}
		return op.get();
		//�T���B�⦡�g�k,�����᭱����P�_��
//		Menu menu = op.isEmpty()? null : op.get();
//		return menu;
		//�T���B�⦡�g�k,��^���G
//		return op.isEmpty()? null : op.get();
		
	}

	
	@Override
	public List<Menu> findAll() {
		return menuDao.findAll(); //�����^��findAll		
	}
}
