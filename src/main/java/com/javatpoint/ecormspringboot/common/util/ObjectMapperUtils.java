package com.javatpoint.ecormspringboot.common.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "ObjectMapperUtils")
public class ObjectMapperUtils {
	@Autowired
	private ModelMapper modelMapper;

	public <D, T> List<D> mapAll(final Collection<T> sourceCollection, Class<D> desClass) {
		return sourceCollection.stream().map(entity -> this.modelMapper.map(entity, desClass))
				.collect(Collectors.toList());
	}

	public <D, T> D map(T entity, Class<D> desClass) {
		return this.modelMapper.map(entity, desClass);
	}
}
