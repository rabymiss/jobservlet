package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-05-13 10:11:06
 */
@Data
@TableName("user_massage")
public class UserMassageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private String nickname;
	/**
	 * 
	 */
	private String burthday;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String phonenumber;
	/**
	 * 
	 */
	private String addressp;
	/**
	 * 
	 */
	private String workin;
	/**
	 * 
	 */
	private String showyou;
	/**
	 * 
	 */
	private String icon;

}
