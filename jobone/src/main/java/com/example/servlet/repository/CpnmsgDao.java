package com.example.servlet.repository;

import com.example.servlet.entity.CpnMsgEn;

public interface CpnmsgDao {
    public int save(CpnMsgEn cpnMsgEn);
    public CpnMsgEn findcpn();
    public Long update(CpnMsgEn cpnMsgEn);
}
