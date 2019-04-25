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
public class ConstructionWasteInfo extends Model<ConstructionWasteInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 建筑垃圾序号
     */
    @TableId(value = "CONSTRUCTION_WASTE_ID", type = IdType.AUTO)
    private String constructionWasteId;
    /**
     * 产生源序号
     */
    private String sourceId;
    /**
     * 建筑垃圾重量
     */
    private String constructionWasteWeight;
    /**
     * 建筑垃圾重量单位
     */
    private String constructionWasteUnit;
    /**
     * 备注
     */
    private String content;


    @Override
    protected Serializable pkVal() {
        return this.constructionWasteId;
    }

}
