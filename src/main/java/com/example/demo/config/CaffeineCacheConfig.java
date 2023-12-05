package com.example.demo.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@EnableCaching //spring framework
			   //�e�����ܤ֭n���@��CacheManager��Bean
@Configuration //�t�m���]�w��,@Configuration�N�䬰�t�m��,���spring boot�U��
public class CaffeineCacheConfig {

	@Bean
	public CacheManager cacaheManager() {
		CaffeineCacheManager cacheManager = new CaffeineCacheManager();
		cacheManager.setCaffeine(Caffeine.newBuilder()
			//�]�w�L���ɶ�:1.�̫�@���g�J�� 2.�X�ݹL��N�T�w�@�q�ɶ�
			.expireAfterAccess(600,TimeUnit.SECONDS)
			//��l���w�s�Ŷ��j�p
			.initialCapacity(100)
			//�w�s���̤j����
			.maximumSize(500));
		return cacaheManager();
		
	}
	
}
