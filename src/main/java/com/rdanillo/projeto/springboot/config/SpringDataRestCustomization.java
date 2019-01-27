package com.rdanillo.projeto.springboot.config;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

import com.rdanillo.projeto.springboot.Repository.UsuarioRepository;

@Component
public class SpringDataRestCustomization 
extends RepositoryRestConfigurerAdapter 
{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Item.class,UsuarioRepository.class);
	}
}
