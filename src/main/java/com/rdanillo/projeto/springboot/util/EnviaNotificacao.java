package com.rdanillo.projeto.springboot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rdanillo.projeto.springboot.domain.Usuario;
import com.rdanillo.projeto.springboot.dto.Notificacao;

@Component
public class EnviaNotificacao {

    @Autowired
    Notificacao  notificacao;
    
	public void enviaEmail(Usuario usuario) {
		
		System.out.println("Enviar notificacao para "+usuario.getNomeUsuario() + " - senha $"+usuario.getSenha());
		
		if (notificacao.envioAtivo()) {
			
			/*
			     codigo de envio
			 */
			
			System.out.println("Notificacao enviada!");
			
		} else {
			
			System.out.println("Notificacao desligada!");
		
		}
	}
	
	
}
