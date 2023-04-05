package com.productManagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import com.productManagement.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	private final MessageSource messageSource;

	@Autowired
	public MessageServiceImpl(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public String getMessage(String messageKey) {
		return messageSource.getMessage(messageKey, null, LocaleContextHolder.getLocale());
	}

}
