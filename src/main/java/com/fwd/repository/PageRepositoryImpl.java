package com.fwd.repository;

import com.fwd.domain.Pages;

public abstract class PageRepositoryImpl implements PageRepository {
	@Override
	public <S extends Pages> S save(S entity) {
		
		System.out.println("work to here");
		return null;
	}
}
