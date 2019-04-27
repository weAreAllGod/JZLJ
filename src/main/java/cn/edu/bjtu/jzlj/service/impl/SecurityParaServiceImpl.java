package cn.edu.bjtu.jzlj.service.impl;

import cn.edu.bjtu.jzlj.domain.SecurityPara;
import cn.edu.bjtu.jzlj.mapper.SecurityParaMapper;
import cn.edu.bjtu.jzlj.service.SecurityParaService;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LiuYi
 * @since 2019-04-17
 */
@Service
public class SecurityParaServiceImpl extends ServiceImpl<SecurityParaMapper, SecurityPara> implements SecurityParaService {

    @Override
    public SecurityPara selectOne(Wrapper<SecurityPara> wrapper) {
        return super.selectOne(wrapper);
    }

    @Override
    public Object selectObj(Wrapper<SecurityPara> wrapper) {
        return super.selectObj(wrapper);
    }

    @Override
    public Page<Map<String, Object>> selectMapsPage(Page page, Wrapper<SecurityPara> wrapper) {
        return super.selectMapsPage(page, wrapper);
    }
}
