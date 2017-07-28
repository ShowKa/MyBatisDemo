package com.showka.MyBatisDemo.mapper;

import com.showka.MyBatisDemo.entity.MNyukinKakeInfo;

public interface MNyukinKakeInfoMapper extends IMapper<MNyukinKakeInfo> {

	public MNyukinKakeInfo selectByPK(String kokyaku_id);

}
