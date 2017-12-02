package com.zhaogui.biyesheji.bean;

import java.util.List;

/**
 * Created by gui on 2017/8/18.
 */

public class ScenicBean {

    /**
     * error_code : 0
     * reason : 成功
     * result : [{"title":"黄山","grade":"AAAAA","price_min":"230","comm_cnt":null,"cityId":"45","address":"安徽省黄山市黄山风景区","sid":"5305","url":"http://www.ly.com/scenery/BookSceneryTicket_5305.html","imgurl":"http://pic4.40017.cn/scenery/destination/2016/12/09/15/6A3FLk_240x135_00.jpg"},{"title":"安徽宏村","grade":"AAAAA","price_min":"94","comm_cnt":null,"cityId":"45","address":"安徽省黄山市黟县宏村镇","sid":"999","url":"http://www.ly.com/scenery/BookSceneryTicket_999.html","imgurl":"http://pic3.40017.cn/scenery/destination/2015/10/21/14/H3q91Y_240x135_00.jpg"},{"title":"翡翠谷","grade":"AAAA","price_min":"60","comm_cnt":null,"cityId":"45","address":"安徽省黄山市黄山风景区翡翠谷","sid":"178","url":"http://www.ly.com/scenery/BookSceneryTicket_178.html","imgurl":"http://pic4.40017.cn/scenery/destination/2016/07/31/17/Tahj0I_240x135_00.jpg"},{"title":"西递","grade":"AAAAA","price_min":"90","comm_cnt":null,"cityId":"45","address":"安徽省黄山市黟县西递镇西递村","sid":"29001","url":"http://www.ly.com/scenery/BookSceneryTicket_29001.html","imgurl":"http://pic4.40017.cn/scenery/destination/2016/07/30/17/xcF88L_240x135_00.jpg"},{"title":"齐云山（四大道教名山）","grade":"AAAA","price_min":"60","comm_cnt":null,"cityId":"45","address":"安徽省黄山市休宁县齐云山镇","sid":"1021","url":"http://www.ly.com/scenery/BookSceneryTicket_1021.html","imgurl":"http://pic4.40017.cn/scenery/destination/2016/07/30/10/sPbd0B_240x135_00.jpg"},{"title":"棠樾牌坊群鲍家花园","grade":"AAAAA","price_min":"90","comm_cnt":null,"cityId":"45","address":"安徽黄山歙县棠樾村","sid":"24610","url":"http://www.ly.com/scenery/BookSceneryTicket_24610.html","imgurl":"http://pic4.40017.cn/scenery/destination/2016/08/02/15/tk2gQq_240x135_00.jpg"},{"title":"黄山醉温泉度假城","grade":"AAAA","price_min":"59","comm_cnt":null,"cityId":"45","address":"安徽省黄山市屯溪区花山路黄山醉温泉度假城","sid":"24351","url":"http://www.ly.com/scenery/BookSceneryTicket_24351.html","imgurl":"http://pic4.40017.cn/scenery/destination/2016/08/03/20/bzyXE6_240x135_00.jpg"},{"title":"祁门牯牛降风景区","grade":"AAAA","price_min":"60","comm_cnt":null,"cityId":"45","address":"安徽省黄山市祁门县历口镇观音堂牯牛降风景区","sid":"4087","url":"http://www.ly.com/scenery/BookSceneryTicket_4087.html","imgurl":"http://pic4.40017.cn/scenery/destination/2016/07/31/23/2Rylvi_240x135_00.jpg"},{"title":"呈坎","grade":"AAAAA","price_min":"95","comm_cnt":null,"cityId":"45","address":"安徽黄山市歙县（黄山南面40公里处在灵山和丰山之间）","sid":"1510","url":"http://www.ly.com/scenery/BookSceneryTicket_1510.html","imgurl":"http://pic4.40017.cn/scenery/destination/2016/10/10/13/aDm7sL_240x135_00.jpg"},{"title":"花山谜窟","grade":"AAAA","price_min":"80","comm_cnt":null,"cityId":"45","address":"安徽省黄山市屯溪区屯光镇","sid":"761","url":"http://www.ly.com/scenery/BookSceneryTicket_761.html","imgurl":"http://pic4.40017.cn/scenery/destination/2016/10/27/14/rCD4tp_240x135_00.jpg"}]
     */

    private int error_code;
    private String reason;
    private List<ResultBean> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * title : 黄山
         * grade : AAAAA
         * price_min : 230
         * comm_cnt : null
         * cityId : 45
         * address : 安徽省黄山市黄山风景区
         * sid : 5305
         * url : http://www.ly.com/scenery/BookSceneryTicket_5305.html
         * imgurl : http://pic4.40017.cn/scenery/destination/2016/12/09/15/6A3FLk_240x135_00.jpg
         */

        private String title;
        private String grade;
        private String price_min;
        private Object comm_cnt;
        private String cityId;
        private String address;
        private String sid;
        private String url;
        private String imgurl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getPrice_min() {
            return price_min;
        }

        public void setPrice_min(String price_min) {
            this.price_min = price_min;
        }

        public Object getComm_cnt() {
            return comm_cnt;
        }

        public void setComm_cnt(Object comm_cnt) {
            this.comm_cnt = comm_cnt;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }
    }
}
