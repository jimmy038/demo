package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Menu;

//�ާ@��k�q�`�٬�DAOring����Me
@Repository //@Repository�]���L�S����@,�ҥH�L��U�޼g�binterface(������)
//��������@Repository,Dao����Ʀs������,��menu��class��ƦW��,�إ�ID����ƫ��AString
public interface MenuDao extends JpaRepository<Menu, String>{//��Stnu���������ݩʦ��UID��
//					   ���~��JPA	 ��Jpa(�ާ@��Ʈw����k)�i�H�F�����ڭ̤��μg��Ʈw���y�k�N�i�H�ާ@��Ʈw

//	public List<Menu> findAll(); //�w�qfindByAll����k
	
	public List<Menu> findByNameAndPrice(String name,int price);

}
