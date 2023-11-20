package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;

@Repository
public interface MealDao extends JpaRepository<Meal, MealId>{

//  findTop����By:����j�M���G���^�ǵ���(���ƬҬ��Ʀr)
	public List<Meal>  findTop2ByName(String name); //�^�ǭ���Ƴ���2��
//	findFirst����By:����j�M���G���^�ǵ���(���ƬҬ��Ʀr)
	public List<Meal> findFirst2ByName(String name); //�^�ǭ���Ƴ���2��
//	�H�W��̷����ۦP�� �Ҭ��۩w�q��k
	
//	�Ƨ�:OrderBy���Ƨ�:�w�]�ƧǬ�ASC  ASC��:�Ѥp��j DESC��:�Ѥj��p ,�ϥ�OrderBy
	public List<Meal> findByNameOrderByPrice(String name); //
	
//	OrderBy���Ƨ�:�w�]�ƧǬ�ASC  ASC��:�Ѥp��j DESC��:�Ѥj��p ,�ϥ�OrderBy
//	public List<Meal> findAllByOrderByPriceAsc();
	public List<Meal> findAllByOrderByPrice(); //�Ƨǻ��檺��k,���ΰѼ�,�]���u�O�q�쥻���X����쵲�G�h���Ƨ�
//	�w�]�Ƨ�ASC�ҥH���μgASC	��Jpa�W�w�榡	������rOrderBy,�y�k�W�h�bfindAllBy
	
	public List<Meal> findAllByOrderByPriceDesc(); //�˧Ǥ�k
//						���˱Ԫ�Desc�u��D�j�g�}�Y,�q�j��p�Ƨ�
	
	
//	����j�p:
/*	1.�j��:GreaterThan 2.�j�󵥩�:GreaterThanEqual 
	3.�p��:LessThan	  4.�p�󵥩�LessThanEqual 	*/
	public List<Meal> findByPriceGreaterThan(int price);
	
	//�h�����+����j�p ������
	public List<Meal> findByNameAndPriceGreaterThan(String name,int price); //��ӱ��󪺦걵And��or
	
	//containing�]�t,�ҽk�j�M���]�t�u�n�����t�@�ӭ^��r�N�|�L��
	public List<Meal> findByNameContaining(String name);
	
	public List<Meal> findByNameContainingAndCookingStyleContaining(String name, String cookingStyle);
	
	//between�����ӼƦr����,���s��r,���]�t�̤j�γ̤p�W�U������,()�ҥH�A������������ݱa�J��,���L���϶�����
	public List<Meal> findByPriceBetween(int price1,int price2);
	
	public List<Meal> findByPriceBetweenOrderByPrice(int price1,int price2);
//	��W�������G������Ƨ�
	
	
	//in							List���u������O�����int
	public List<Meal> findByPriceIn(List<Integer> priceList);
	
	//notIn
	public List<Meal> findByPriceNotIn(List<Integer> priceList);
	
	
}
