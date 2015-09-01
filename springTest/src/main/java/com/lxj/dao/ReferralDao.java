package com.lxj.dao;

import java.util.List;

import com.lxj.entity.Referral;

public interface ReferralDao
{
   public void addReferral(Referral referral);
   public void updateReferral(Referral referral);
   public void deleteReferral(Referral referral);
   public List<Referral> getReferralList(int pageNo,int pageSize,String conditionStr);
   public int countReferral(String conditionStr);
}
