package com.lxj.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxj.dao.ReferralDao;
import com.lxj.entity.Referral;
import com.lxj.entity.User;
import com.lxj.service.ReferralService;
import com.lxj.util.StringUtil;

@Repository
public class ReferralServiceImpl implements ReferralService
{
	@Autowired
	private ReferralDao referralDao;

	@Override
	public int countReferral(Referral referral, User user)
	{
		String condition = setCondition(referral, user);
		return referralDao.countReferral(condition);
	}

	@Override
	public List<Referral> getReferralList(int pageNo, int pageSize,
			Referral referral, User user)
	{
		String condition = setCondition(referral, user);
		return referralDao.getReferralList(pageNo, pageSize, condition);
	}

	private static String setCondition(Referral referral, User user)
	{
		StringBuffer condition = new StringBuffer();
		// 患者姓名
		if (StringUtil.isNotEmpty(referral.getPatient_name()))
		{
			condition.append(" and a.`NAME` like '%" + referral.getPatient_name()
					+ "%'");
		}
		// 转入医疗机构
		if (StringUtil.isNotEmpty(referral.getIn_medical()))
		{
			condition.append(" and b.`IN_MEDICAL` like '%"
					+ referral.getIn_medical() + "'");
		}
		// 转出时间段
		if (StringUtil.isNotEmpty(referral.getStart_time())
				&& StringUtil.isNotEmpty(referral.getEnd_time()))
		{

		}
		if (StringUtil.isNotEmpty(referral.getStart_time())
				&&!StringUtil.isNotEmpty(referral.getEnd_time()))
		{

		}
		if (!StringUtil.isNotEmpty(referral.getStart_time())
				&& StringUtil.isNotEmpty(referral.getEnd_time()))
		{

		}
		// 申请状态
        if(StringUtil.isNotEmpty(referral.getReferral_status())){
        	condition.append(" and b.`REFERRAL_STATUS` = "+referral.getReferral_status());
        }
		return condition.toString();
	}
}
