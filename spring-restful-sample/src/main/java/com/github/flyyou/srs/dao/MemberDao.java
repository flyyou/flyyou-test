package com.github.flyyou.srs.dao;

import java.util.List;

import com.github.flyyou.srs.domain.Member;

public interface MemberDao {

	public void create(Member member);

	public int update(Member member);

	public int delete(String id);

	public Member get(String id);

	public List<Member> getAllList();

}
