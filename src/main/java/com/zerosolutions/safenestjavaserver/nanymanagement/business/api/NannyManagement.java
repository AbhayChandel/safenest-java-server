package com.zerosolutions.safenestjavaserver.nanymanagement.business.api;

import java.util.List;

import com.zerosolutions.safenestjavaserver.nanymanagement.common.api.to.NannyTO;

public interface NannyManagement {

	public List<NannyTO> getAllNannies();
}
