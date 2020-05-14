package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.UserMassageEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-05-13 10:11:06
 */
public interface UserMassageService extends IService<UserMassageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

