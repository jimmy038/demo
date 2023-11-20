package com.example.demo.repository; //操作資料庫的行為(方法)都放在repository內的Dao
import java.util.List;

/*操作資料庫的行為(方法)分為4種Create(新增),Read(查詢),Update(修改),Delete(刪除)*/
/*對資料庫操作的4個行為,中文簡稱增刪修查,英文簡稱C R U D*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PersonInfo;

//Dao Data-access-object(資料存取對象)
//一張表就會對應到要寫一個DAO
//放在Repository檔案的方法都是操作資料庫的方法而已,PersonInfoDao只對PersonInfo這個只對這張表做操作而已
@Repository  //@Repository請spring boot託管(託付管理)
public interface PersonInfoDao extends JpaRepository<PersonInfo, String> {
	   //建立interface介面 PersonInfoDao繼承Jpa
	
//↓自定義方法,findByCity,City為屬性的名稱,自定義方法的名稱findByCity的City為屬性名稱,findByCity小駝峰式命名關係遇到一個單字的首個字需大寫
	public List<PersonInfo> findByCity(String city); //()內要帶值,要找到City欄位的值,值的資料型態為字串後面一個變數,語法就為findBy
//DAO欄位內要找的值為重複的時使用List<>接回來,因希望回傳的資料是多筆,City可以重複所以使用List集合起來

	public List<PersonInfo> findByNameAndCity(String name,String city);
	
	public List<PersonInfo> findByNameOrCity(String name,String city);
	//↑多個欄位屬性用and串接,條件擇一的話用or串接
	//撈資料findBy 跟 By這兩個方式是固定的
	
//==================================分隔線===============================================//
	//練習
	
//	因這些方法不用實作因此寫在Dao這邊,可以直接使用方法	
	
//	比較大小:
/*	1.大於:GreaterThan 2.大於等於:GreaterThanEqual 
	3.小於:LessThan	  4.小於等於LessThanEqual 	*/
	
	//4.年紀大於條件的方法
	public List<PersonInfo> findByAgeGreaterThan(int age);

	//5.年紀小於等於條件的方法
	public List<PersonInfo> findByAgeLessThanEqualOrderByAge(int age);

	//6.年齡小於條件1或是大於條件2的資訊
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(int age1, int age2);

	//7. 找到年紀介於2個數字之間(有包含) 的資訊	▪ 以年齡由大到小排序	▪ 只取前3筆資料
	public List<PersonInfo> findTop3ByAgeBetweenOrderByAgeDesc(int age1,int age2);
	
	//8.取得 city 包含某個特定字的所有個人資訊
	public List<PersonInfo> findByCityContaining(String keyword);
	
	//9.找出年紀大於輸入條件以及city 包含某個特定字的所有人資訊 ▪ 依照年齡由大到小排序
	public List<PersonInfo> findByAgeGreaterThanAndCityContainingOrderByAgeDesc(int age, String city);
	
	
}
