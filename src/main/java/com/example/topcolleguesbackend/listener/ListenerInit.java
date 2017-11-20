package com.example.topcolleguesbackend.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.topcolleguesbackend.init.Initialiseur;

@Component
public class ListenerInit {

	/** init : Initialiseur */
	@Autowired
	private Initialiseur init;
	
	/**
	 * Listener de fin d'instanciation de context
	 */
	@EventListener({ ContextRefreshedEvent.class })
	void contextRefreshedEvent() {
		init.init();
	}
}