package  org.onedayday.admincenter.repository.po;


import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.onedayday.framework.base.BaseEntity;

import java.io.Serializable;

import java.sql.Timestamp;
/**
 * @Title:  User
 * @Description: 系统用户
 * @author generator
 * @date 2022-02-14 14:47:00
 * @version 1.0
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class  User extends BaseEntity {


	/**
	* 用户名
	*/
    private String userName;
	/**
	* 昵称
	*/
    private String nickName;
	/**
	* 手机号码
	*/
    private String phone;
	/**
	* 邮箱
	*/
    private String email;
	/**
	* 微信openId
	*/
    private String openId;
	/**
	* 微信unionId
	*/
    private String unionId;
	/**
	* 头像地址
	*/
    private String icon;
	/**
	* 密码
	*/
    private String password;
	/**
	* 性别
	*/
    private String gender;
	/**
	* 出生日期
	*/
    private Timestamp birthday;
	/**
	* 盐
	*/
    private String salt;
	/**
	* 状态：1启用、0禁用
	*/
    private Boolean status;
	
}
