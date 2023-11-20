package com.example.demo.service.ifs; //service.ifs將需求寫成方法的地方
import java.util.List;


/*@Service業務邏輯層 */
import com.example.demo.entity.PersonInfo;

public interface PersonInfoService { //建立一個介面才有實作的方法
//				原本addPersonInfo新增資訊的方法
	public void addPersonInfo(PersonInfo presonInfo); 

	public void deleteAll(); //刪除欄位內資料的方法
	
	public void addInfoList(List<PersonInfo> infoList); //addInfoList,新增多筆資料的方法

//=======================================分隔線===================================//
//	練習
//	新增方法改為回傳被創建的資訊訊息
	public PersonInfo addInfo(PersonInfo presonInfo);//回傳類別

	public List<PersonInfo>  findAll();//取得所有個人資訊 多筆要用List去接

	public PersonInfo findById(String Id); //尋找ID對應資訊

	
	
}
