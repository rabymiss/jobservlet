package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.FilesDao;
import io.renren.modules.sys.entity.FilesEntity;
import io.renren.modules.sys.service.FilesService;


@Service("filesService")
public class FilesServiceImpl extends ServiceImpl<FilesDao, FilesEntity> implements FilesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FilesEntity> page = this.page(
                new Query<FilesEntity>().getPage(params),
                new QueryWrapper<FilesEntity>()
        );

        return new PageUtils(page);
    }

}
