package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;
import com.example.demo.repository.MealDao;
import com.example.demo.service.ifs.MealService;

@SpringBootTest(classes = DemoApplication.class)
public class MealServiceTest {

	@Autowired
	private MealService mealService;
	
	@Autowired
	private MealDao mealDao;
	
	@Test
	public void addMeal() {
//		mealService.addMeal(new Meal("beef","BBQ",180));
//		mealService.addMeal(new Meal("beef","fry",150));
//		mealService.addMeal(new Meal("pork","friend",220));
//		mealService.addMeal(new Meal("chicken","stew",260));
//		mealService.addMeal(new Meal("chicken","BBQ",120));
//		mealService.addMeal(new Meal("chicken","steam",520));
		mealService.addMeal(new Meal("Apple","sugar",1520));
	}
	
	
	@Test
	public void addMealTest() {
		//name不符合條件
		Meal result = mealService.addMeal(new Meal(" ","BBQ",180));
		Assert.isTrue(result == null,"addMeal error!!");
		//cooking_style不符合條件
		result = mealService.addMeal(new Meal("beef"," ",180));
		Assert.isTrue(result == null,"addMeal error!!");
		//price不符合 為0
		result = mealService.addMeal(new Meal("beef","BBQ",0));
		Assert.isTrue(result == null,"addMeal error!!");
		//正常新增
		result = mealService.addMeal(new Meal("beef","BBQ",180));
		Assert.isTrue(result != null,"addMeal error!!");
		//再新增已存在的meal
		result = mealService.addMeal(new Meal("beef","BBQ",180));
		Assert.isTrue(result == null,"addMeal error!!");
		//刪除測試資料
		mealDao.deleteById(new MealId("beef","BBQ"));
	}
	
	@Test
	public void limitTest(){ //使用limit測試限制回傳筆數使用findFirst 2為筆數
		List<Meal> res = mealDao.findFirst2ByName("chicken");
		System.out.println(res.size());
		Assert.isTrue(res.size() == 2,"find limit error!!" );		
	}
	
	@Test
	public void limitTest1(){ //使用limit測試限制回傳筆數使用findTop 2為筆數
		List<Meal> res = mealDao.findTop2ByName("chicken");
		System.out.println(res.size());
		Assert.isTrue(res.size() == 2,"find limit error!!" );		
	}
	
	@Test
	public void orderByTest() {
//		List<Meal> res = mealDao.findByNameOrderByPrice("chicken");//測試
//		List<Meal> res = mealDao.findAllByOrderByPrice();//排序小到大順序
		List<Meal> res = mealDao.findAllByOrderByPriceDesc();//排倒 倒敘,大到小
		for(Meal item : res) {
			System.out.println(item.getName()+item.getCooking_style()+" : " +item.getPrice() );
		}
	}
	
	@Test
	public void compareTest() { //比較大小的測試,compare比較
		List<Meal> res = mealDao.findByPriceGreaterThan(200);//比較大小括號內為(200),意思為大於200才印出
		for(Meal item : res) {
			System.out.println(item.getName()+item.getCooking_style()+" : " +item.getPrice() );
		}
	}
	
	@Test
	public void containingTest() { //包含
		List<Meal> res= mealDao.findByNameContainingAndCookingStyleContaining("e", "b"); //印出name&cookingStyle裡面的包含e及b的
//		List<Meal> res = mealDao.findByNameContaining("e"); //印出name包含e的
		for(Meal item : res) {
			System.out.println(item.getName()+item.getCooking_style()+" : " +item.getPrice() );
		}
	}
	
	@Test
	public void betweenTest() {	//between連續區間,有兩個數字所以需要給他一個區間去尋找,有包含最大及最小區間
		List<Meal> res = mealDao.findByPriceBetween(120, 260);
		for(Meal item : res) {
			System.out.println(item.getName()+item.getCooking_style()+" : " +item.getPrice() );
		}
	}
	
	@Test
	public void inTest() { //in用在篩選這些物件範圍內的金額&notIn用在篩選除了這些範圍以外的金額
		List<Meal> res = mealDao.findByPriceIn(new ArrayList<>(List.of(100,120,150,180,200)));
//		List<Meal> res = mealDao.findByPriceNotIn(new ArrayList<>(List.of(100,120,150,180,200)));
		for(Meal item : res) {
			System.out.println(item.getName()+item.getCooking_style()+" : " +item.getPrice() );
		}
	}
}
