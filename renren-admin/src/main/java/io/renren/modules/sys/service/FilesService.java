package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.FilesEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-05-13 10:11:05
 */
public interface FilesService extends IService<FilesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

