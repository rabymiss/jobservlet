package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.FilesEntity;
import io.renren.modules.sys.service.FilesService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-05-13 10:11:05
 */
@RestController
@RequestMapping("sys/files")
public class FilesController {
    @Autowired
    private FilesService filesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:files:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = filesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:files:info")
    public R info(@PathVariable("id") Integer id){
        FilesEntity files = filesService.getById(id);

        return R.ok().put("files", files);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:files:save")
    public R save(@RequestBody FilesEntity files){
        filesService.save(files);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:files:update")
    public R update(@RequestBody FilesEntity files){
        ValidatorUtils.validateEntity(files);
        filesService.updateById(files);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:files:delete")
    public R delete(@RequestBody Integer[] ids){
        filesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
