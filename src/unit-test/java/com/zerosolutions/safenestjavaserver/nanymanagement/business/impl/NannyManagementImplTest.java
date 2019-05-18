package com.zerosolutions.safenestjavaserver.nanymanagement.business.impl;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zerosolutions.safenestjavaserver.nanymanagement.business.api.NannyManagement;
import com.zerosolutions.safenestjavaserver.nanymanagement.common.api.to.NannyTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NannyManagementImplTest {

	@Autowired
	NannyManagement nannyManagement;
	
	@Test
	public void testGetAllNannies() {
		List<NannyTO> nannyTOList = nannyManagement.getAllNannies();
		assertNotNull(nannyTOList);
	}
}
