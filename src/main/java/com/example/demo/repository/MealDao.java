package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;

@Repository
public interface MealDao extends JpaRepository<Meal, MealId>{

//  findTop筆數By:限制搜尋結果的回傳筆數(筆數皆為數字)
	public List<Meal>  findTop2ByName(String name); //回傳限制筆數都為2筆
//	findFirst筆數By:限制搜尋結果的回傳筆數(筆數皆為數字)
	public List<Meal> findFirst2ByName(String name); //回傳限制筆數都為2筆
//	以上兩者概念相同↑ 皆為自定義方法
	
//	排序:OrderBy為排序:預設排序為ASC  ASC為:由小到大 DESC為:由大到小 ,使用OrderBy
	public List<Meal> findByNameOrderByPrice(String name); //
	
//	OrderBy為排序:預設排序為ASC  ASC為:由小到大 DESC為:由大到小 ,使用OrderBy
//	public List<Meal> findAllByOrderByPriceAsc();
	public List<Meal> findAllByOrderByPrice(); //排序價格的方法,不用參數,因為只是從原本撈出的欄位結果去做排序
//	預設排序ASC所以不用寫ASC	↑Jpa規定格式	的關鍵字OrderBy,語法規則在findAllBy
	
	public List<Meal> findAllByOrderByPriceDesc(); //倒序方法
//						↑倒敘的Desc只能D大寫開頭,從大到小排序
	
	
//	比較大小:
/*	1.大於:GreaterThan 2.大於等於:GreaterThanEqual 
	3.小於:LessThan	  4.小於等於LessThanEqual 	*/
	public List<Meal> findByPriceGreaterThan(int price);
	
	//多個欄位+比較大小 兩個欄位
	public List<Meal> findByNameAndPriceGreaterThan(String name,int price); //兩個條件的串接And及or
	
	//containing包含,模糊搜尋的包含只要當中有含一個英文字就會印車
	public List<Meal> findByNameContaining(String name);
	
	public List<Meal> findByNameContainingAndCookingStyleContaining(String name, String cookingStyle);
	
	//between介於兩個數字之間,為連續字,有包含最大及最小上下限的值,()所以括號內有兩個欄位需帶入值,讓他有區間價格
	public List<Meal> findByPriceBetween(int price1,int price2);
	
	public List<Meal> findByPriceBetweenOrderByPrice(int price1,int price2);
//	對上面的結果做價格排序
	
	
	//in							List內只能放類別不能放int
	public List<Meal> findByPriceIn(List<Integer> priceList);
	
	//notIn
	public List<Meal> findByPriceNotIn(List<Integer> priceList);
	
	
}
