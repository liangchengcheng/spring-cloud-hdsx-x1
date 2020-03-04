package com.hdsx.webservice.common.config.bean;

public class GlobalConstants {

    /** 登陆用户对象 */
    public final static String LOGINUSEROBJECT                                  = "userobject";
    /**
     * 分页最小条数
     */
    public final static Integer MINLIMIT 										=1;
    /**
     * 分页最大条数
     */
    public final static Integer MAXLIMIT 										=100;

    public final static String PREFIX_TOKEN 									="DRINKWATER";

    /**
     * 响应体返回信息
     */
    public static final String KEY_RESPONSE_DATA                                = "data";

    /**
     * 返回总数
     */
    public static final String KEY_TOTAL_DATA                                   = "total";

    /**
     * 需要批复审核的总数
     */
    public static final String KEY_NEED_PF_CHECK_TOTAL_DATA                     = "need_pf_check_total";

    /**
     * 需要批复审核不通过的总数
     */
    public static final String KEY_PF_CHECK_FAIL_TOTAL_DATA                     = "need_pf_check_fail_total";

    /**
     * 需要批复审核不通过的总数
     */
    public static final String KEY_BOUNDARY_CHECK_FAIL_TOTAL_DATA               = "need_boundary_check_fail_total";

    /**
     * 用户信息
     */
    public static final String KEY_USER_INFO                                    = "userinfo";

    /**
     * token
     */
    public static final String KEY_TOKEN                                        = "token";

    /**
     * 单位信息
     */
    public static final String KEY_UNIT_INFO                                    = "unitinfo";

    /**
     * 角色信息
     */
    public static final String KEY_ROLE_INFO                                    = "roleinfo";


    /**
     * 菜单信息
     */
    public static final String KEY_MENUS_INFO                                   = "menusinfo";

    /**
     * 单位层级：全国
     */
    public static final String UNIT_TYPE_COUNTRY                                = "0";

    /**
     * 单位层级：部分省权限单位
     */
    public static final String UNIT_TYPE_M_PROVINCE                             = "1";

    /**
     * 单位层级：省级单位
     */
    public static final String UNIT_TYPE_PROVINCE                               = "2";

    /**
     * 单位层级：市级单位
     */
    public static final String UNIT_TYPE_CITY                                   = "3";

    /**
     * 单位层级：县级单位
     */
    public static final String UNIT_TYPE_COUNTY                                  = "4";

}
