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
		//name���ŦX����
		Meal result = mealService.addMeal(new Meal(" ","BBQ",180));
		Assert.isTrue(result == null,"addMeal error!!");
		//cooking_style���ŦX����
		result = mealService.addMeal(new Meal("beef"," ",180));
		Assert.isTrue(result == null,"addMeal error!!");
		//price���ŦX ��0
		result = mealService.addMeal(new Meal("beef","BBQ",0));
		Assert.isTrue(result == null,"addMeal error!!");
		//���`�s�W
		result = mealService.addMeal(new Meal("beef","BBQ",180));
		Assert.isTrue(result != null,"addMeal error!!");
		//�A�s�W�w�s�b��meal
		result = mealService.addMeal(new Meal("beef","BBQ",180));
		Assert.isTrue(result == null,"addMeal error!!");
		//�R�����ո��
		mealDao.deleteById(new MealId("beef","BBQ"));
	}
	
	@Test
	public void limitTest(){ //�ϥ�limit���խ���^�ǵ��ƨϥ�findFirst 2������
		List<Meal> res = mealDao.findFirst2ByName("chicken");
		System.out.println(res.size());
		Assert.isTrue(res.size() == 2,"find limit error!!" );		
	}
	
	@Test
	public void limitTest1(){ //�ϥ�limit���խ���^�ǵ��ƨϥ�findTop 2������
		List<Meal> res = mealDao.findTop2ByName("chicken");
		System.out.println(res.size());
		Assert.isTrue(res.size() == 2,"find limit error!!" );		
	}
	
	@Test
	public void orderByTest() {
//		List<Meal> res = mealDao.findByNameOrderByPrice("chicken");//����
//		List<Meal> res = mealDao.findAllByOrderByPrice();//�ƧǤp��j����
		List<Meal> res = mealDao.findAllByOrderByPriceDesc();//�ƭ� �˱�,�j��p
		for(Meal item : res) {
			System.out.println(item.getName()+item.getCooking_style()+" : " +item.getPrice() );
		}
	}
	
	@Test
	public void compareTest() { //����j�p������,compare���
		List<Meal> res = mealDao.findByPriceGreaterThan(200);//����j�p�A������(200),�N�䬰�j��200�~�L�X
		for(Meal item : res) {
			System.out.println(item.getName()+item.getCooking_style()+" : " +item.getPrice() );
		}
	}
	
	@Test
	public void containingTest() { //�]�t
		List<Meal> res= mealDao.findByNameContainingAndCookingStyleContaining("e", "b"); //�L�Xname&cookingStyle�̭����]�te��b��
//		List<Meal> res = mealDao.findByNameContaining("e"); //�L�Xname�]�te��
		for(Meal item : res) {
			System.out.println(item.getName()+item.getCooking_style()+" : " +item.getPrice() );
		}
	}
	
	@Test
	public void betweenTest() {	//between�s��϶�,����ӼƦr�ҥH�ݭn���L�@�Ӱ϶��h�M��,���]�t�̤j�γ̤p�϶�
		List<Meal> res = mealDao.findByPriceBetween(120, 260);
		for(Meal item : res) {
			System.out.println(item.getName()+item.getCooking_style()+" : " +item.getPrice() );
		}
	}
	
	@Test
	public void inTest() { //in�Φb�z��o�Ǫ���d�򤺪����B&notIn�Φb�z�ﰣ�F�o�ǽd��H�~�����B
		List<Meal> res = mealDao.findByPriceIn(new ArrayList<>(List.of(100,120,150,180,200)));
//		List<Meal> res = mealDao.findByPriceNotIn(new ArrayList<>(List.of(100,120,150,180,200)));
		for(Meal item : res) {
			System.out.println(item.getName()+item.getCooking_style()+" : " +item.getPrice() );
		}
	}
}
