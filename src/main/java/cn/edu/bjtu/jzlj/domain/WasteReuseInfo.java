package cn.edu.bjtu.jzlj.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

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
public class WasteReuseInfo extends Model<WasteReuseInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "WASTE_REUSE_ID", type = IdType.AUTO)
    private String wasteReuseId;
    /**
     * 资源厂序号
     */
    private String resourcePlantId;
    /**
     * 建筑垃圾序号
     */
    private String constructionWasteId;
    /**
     * 垃圾用量
     */
    private String actualWeight;
    /**
     * 垃圾用量单位
     */
    private String actualWeightUnit;
    /**
     * 加工时间
     */
    private Date processingTime;
    /**
     * 说明
     */
    private String explain;
    /**
     * 录入人名称
     */
    private String inputName;
    /**
     * 录入时间
     */
    private Date inputTime;
    /**
     * 备注
     */
    private String content;


    @Override
    protected Serializable pkVal() {
        return this.wasteReuseId;
    }

}
