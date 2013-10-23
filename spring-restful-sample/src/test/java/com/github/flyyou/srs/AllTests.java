package com.github.flyyou.srs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.github.flyyou.srs.controller.MemberControllerTest;
import com.github.flyyou.srs.dao.MemberDaoTest;
import com.github.flyyou.srs.service.MemberServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	AbstractTest.class, 
	MemberDaoTest.class, 
	MemberServiceTest.class, 
	MemberControllerTest.class, 
})
public class AllTests {

}
