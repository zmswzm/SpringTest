package com.lxj.service;

import java.util.List;

import com.lxj.entity.Referral;
import com.lxj.entity.User;

public interface ReferralService
{
   public int countReferral(Referral referral,User user);
   public List<Referral> getReferralList(int pageNo,int pageSize,Referral referral,User user);
}
