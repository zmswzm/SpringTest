package com.lxj.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lxj.dao.ReferralDao;
import com.lxj.entity.Referral;
@Repository
public class ReferralDaoImpl extends BaseDaoImpl implements ReferralDao
{

	@Override
	public void addReferral(Referral referral)
	{
		

	}

	@Override
	public void updateReferral(Referral referral)
	{

	}

	@Override
	public void deleteReferral(Referral referral)
	{

	}

	@Override
	public List<Referral> getReferralList(int pageNo, int pageSize,
			String condition)
	{
	    StringBuffer sqlStr = new StringBuffer("select ");
	    sqlStr.append("b.`REFERRAL_CODE`," + " a.`NAME`,");
	    sqlStr.append("a.`ID_NO`," + "a.`AGE`," + "a.`SEX`," + " a.`COST_CODE`,");
	    sqlStr.append("b.`IN_MEDICAL`," + "b.`EXPECT_DATE`," + "b.`APPLY_STATUS`,");
	    sqlStr.append("b.`CREATE_DATE`,"+"b.`REFERRAL_STATUS`," + "b.`RECORD_STATUS`");
	    sqlStr.append(" from ");
	    sqlStr.append("rec_patient a join rec_referral b");
	    sqlStr.append(" on a.`PATIENT_CODE`=b.`PATIENT_CODE` where 1=1 ");
	    sqlStr.append(condition);//拼接查询条件
	    sqlStr.append("limit ?,?");
		pageNo = (pageNo-1)*pageSize;
		Integer[] params = {pageNo,pageSize};
		return (List<Referral>) getpageList(sqlStr.toString(), params);
	}

	@Override
	public int countReferral(String condition)
	{
		StringBuffer sqlStr = new StringBuffer("select count(b.id) from rec_patient a join rec_referral b"
				+ " on a.`PATIENT_CODE`=b.`PATIENT_CODE`  where 1=1");
		sqlStr.append(condition);
		return getCount(sqlStr.toString());
	}

}
