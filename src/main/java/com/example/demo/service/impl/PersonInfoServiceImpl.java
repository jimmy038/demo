package com.example.demo.service.impl; //����@�g�޿�Τ�k���a��impl

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

//����spring boot�U�ޤS�ٱ������(IOC) 
@Service	/*PersonInfoServiceImpl  ���h��@    PersonInfoService*/
public class PersonInfoServiceImpl implements PersonInfoService{
	
	@Autowired //��U�޵�spring boot,PersonInfoDao�̿�`�J(DI)�q�`�S��DI��{IOC,(DI)����r:@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public void addPersonInfo(PersonInfo personInfo) {
		//�ϥ�if else�Υ��W��F���P�_id�榡�O�_���T,�ϥ�pattern�ܼƱ����W��F�����榡
		String id = personInfo.getId(); //���Xid,getid����k
		//pattern��id�һݨD������,�]�w�b�j�g�pA��Z,�ư�ABDEFHabdefh,�᭱��X1��2,�᭱8�X
		String pattern = "[A-Za-z][1,2]\\d{8}"; 
		if (id.matches(pattern)) {	//id���pattern���榡�O�_���T,(����)�I(��k)
			System.out.println("�ŦX�榡!!");
			personInfoDao.save(personInfo); //�s��ƶi���Ʈw��,jpa����save�{�o�OPK,save�s�����,�s����Ʈɻ{�o�OID
		}else {								//�YPK(�ߤ@��)�s�b�ɷ|�ק�@�����,���s�b�ɷs�W�@�����,PK�P�ɥi�H����W�ר��
			System.out.println( "���ŦX�榡!!");
		}
	}
	
//=================================���j�u====================================//	
	@Override // ���s�w�q�s�W��k
	public PersonInfo addInfo(PersonInfo personInfo) {
		if (!StringUtils.hasText(personInfo.getId()) || !StringUtils.hasText(personInfo.getName())
				|| personInfo.getAge() <= 0 || !StringUtils.hasText(personInfo.getCity())) {
			return null;
		}
		if (personInfoDao.existsById(personInfo.getId())) {
			return null;
		}
		return personInfoDao.save(personInfo);
	}
	
	
	@Override //���s�w�qfindAll��k
	public List<PersonInfo> findAll() {
		return personInfoDao.findAll();
	}
	
	@Override //���s�w�qfindById��k
	public PersonInfo findById(String name) {
		Optional<PersonInfo> op = personInfoDao.findById(name);
		if(op.isEmpty()) {
			return null;
		}
		return op.get();
	}
	
//========================���j�u====================================//
	@Override
	public void deleteAll() {	//���s�w�q�R����ƪ���k
		personInfoDao.deleteAll();
	}

	@Override	//�o������save��saveAll,������ˬd�浧��h��
	public void addInfoList(List<PersonInfo> infoList) { //���]infoList��10�����
		String pattern = "[a-zA-Z][1,2]\\d{8}";	
		for (PersonInfo item : infoList ) { //�ϥ�foreach�M���v���ˬd
			String id = item.getId();
			//StringUtils.hasText(id)�ˬd�O�_���Ť��O�Ŭ�true,�_�hfalse
			//�H�U�g�k��:���p�GID��null �B ID���ŦXpattern�ɪ����G�O�ۤϮ�(!),��ӱ���P�_�����G�ۤ�
//			if(!(StringUtils.hasText(id) && id.matches(pattern))) { //���g�k���쥻�P�_����ӥ��V���G���ϦV�ܧ�
//				System.out.println("id error!!");
//				return; //return���X��k������void
//			}
			//���p�G�P�_����false���ܩΪ� ID���pattern���G���ŦX��,�N�L�X"id error!!"�̫���X
			if(!StringUtils.hasText(id) || !id.matches(pattern)) { /*hasText�P�_����false�ɩ�pattern��ﵲ�G��false��
				System.out.println("id error!!");					���˱��󺡨��䤤�@�Ӯɧi�D�Lid���~*/
				return; //return���X��k������void
			}
		}	//for�j�鰵�ˬd�P�_����A�s�J���
		personInfoDao.saveAll(infoList); //�qsave�ܦ�saveAll��ֻP��Ʈw�ާ@������,�@���s�h�����
	}



}
