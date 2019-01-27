package com.rdanillo.projeto.springboot.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.rdanillo.projeto.springboot.dto.Notificacao;

@Component
@Profile("!prod")
public class DevNotificacaoConfig implements Notificacao {

	@Override
	public boolean envioAtivo() {
		return false;
	}

}
