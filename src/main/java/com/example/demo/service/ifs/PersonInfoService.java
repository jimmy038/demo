package com.example.demo.service.ifs; //service.ifs�N�ݨD�g����k���a��
import java.util.List;


/*@Service�~���޿�h */
import com.example.demo.entity.PersonInfo;

public interface PersonInfoService { //�إߤ@�Ӥ����~����@����k
//				�쥻addPersonInfo�s�W��T����k
	public void addPersonInfo(PersonInfo presonInfo); 

	public void deleteAll(); //�R����줺��ƪ���k
	
	public void addInfoList(List<PersonInfo> infoList); //addInfoList,�s�W�h����ƪ���k

//=======================================���j�u===================================//
//	�m��
//	�s�W��k�אּ�^�ǳQ�Ыت���T�T��
	public PersonInfo addInfo(PersonInfo presonInfo);//�^�����O

	public List<PersonInfo>  findAll();//���o�Ҧ��ӤH��T �h���n��List�h��

	public PersonInfo findById(String Id); //�M��ID������T

	
	
}
