package com.leyou.item.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class BrandService {

    private final BrandMapper brandMapper;

    @Autowired
    public BrandService(BrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    public PageResult<Brand> queryBrandByPageAndSort(Integer page, Integer rows,
                                                     String sortBy, Boolean desc, String key) {

        //开始分页
        if (rows == -1) {
            rows = this.brandMapper.selectCount(new Brand());
        }
        PageHelper.startPage(page, rows);
        //过滤
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().andLike("name", "%" + key + "%")
                    .orEqualTo("letter", key.toUpperCase());
        }
        if (StringUtils.isNotBlank(sortBy)) {
            // 排序
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        Page<Brand> brands = (Page<Brand>) this.brandMapper.selectByExample(example);
        return new PageResult<>(brands.getTotal(), brands);
    }
}
