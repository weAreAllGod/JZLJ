package cn.edu.bjtu.jzlj.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author LiuYi
 * @since 2019-04-17
 */
@Data
@Accessors(chain = true)
public class Sequence extends Model<Sequence> {

    private static final long serialVersionUID = 1L;

    /**
     * 序列的名字
     */
    @TableId(value = "name", type = IdType.AUTO)
    private String name;
    /**
     * 序列的当前值
     */
    private Integer currentValue;
    /**
     * 序列的自增值
     */
    private Integer increment;


    @Override
    protected Serializable pkVal() {
        return this.name;
    }

}
