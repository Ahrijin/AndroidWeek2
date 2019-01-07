package jinyuanyuan.bw.com.androidprojects.connector;

/* 管理接口 */
public class Contacts {
    //总接口前缀
    public static final String BASE_URL = "http://172.17.8.100/";
    // 用户相关接口  http://172.17.8.100/small/user/v1/register
    //http://172.17.8.100/small/commodity/v1/bannerShow
    //1.注册
    public static final String REGISTER = "small/user/v1/register";

    //2.登录
    public static final String LOGIN = "small/user/v1/login";

    //12.banner展示列表
    public static final String XBANNER = "small/commodity/v1/bannerShow";

    //13.首页商品信息列表
    public static final String COMMODITYLIST_URL = "small/commodity/v1/commodityList";

    //14.圈子列表
    public static final String FINDCIRCLELIST_URL = "small/circle/v1/findCircleList";

    //15.圈子点赞
    public static final String ADDCICLEGREAT = "small/circle/verify/v1/addCircleGreat";

    //16.取消点赞
    public static final String CACELCIRCLEGREAT = "small/circle/verify/v1/cancelCircleGreat";

    //17.根据关键词查询商品信息
    public static final String FINDCOMMODITYBYKEYWORD = "small/commodity/v1/findCommodityByKeyword";
}
