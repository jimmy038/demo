package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Menu;

//操作方法通常稱為DAOring為看Me
@Repository //@Repository因為他沒有實作,所以他把託管寫在interface(介面內)
//托管類型@Repository,Dao指資料存取物件,↓menu為class資料名稱,建立ID的資料型態String
public interface MenuDao extends JpaRepository<Menu, String>{//←Stnu內的哪個屬性有下ID的
//					   ↑繼承JPA	 ↑Jpa(操作資料庫的方法)可以達到讓我們不用寫資料庫的語法就可以操作資料庫

//	public List<Menu> findAll(); //定義findByAll的方法
	
	public List<Menu> findByNameAndPrice(String name,int price);

}
