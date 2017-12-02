package com.zhaogui.biyesheji.bean;

/**
 * Created by gui on 2017/8/17.
 */

public class HistoryBean {

    /**
     * error_code : 0
     * reason : 成功
     * result : {"id":4680,"day":"1","des":"在92年前的今天，1922年5月1日(农历四月初五)，第一次全国劳动大会召开。1922年5月1日，代表着全国110多个工会和20余万有组织的工人的173位代表，参加了在广州举行的第一次全国劳动大会。在这些代表中有共产党员、国民党员和无政府主义者等。大会由中国劳动组合书记部主任张国焘主持。大会接受中国共产党提出的打倒帝国主义、打倒封建军阀的政治口号，通过《八小时工作》、《罢工援助》、《全国总工会组织原则》等决议案。大会决定，在全国总工会成立以前，中国劳动组织和书记部为全国工人组织的总通讯机关。这次大会的召开，标志着中国工人阶级开始走向团结统一的道路，为中国工运和工会组织的统一奠定了基础，推动了第一次全国工运高潮的深入发展。","lunar":"壬戌年四月初五","month":"5","pic":"","title":"第一次全国劳动大会召开","year":"1922"}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 4680
         * day : 1
         * des : 在92年前的今天，1922年5月1日(农历四月初五)，第一次全国劳动大会召开。1922年5月1日，代表着全国110多个工会和20余万有组织的工人的173位代表，参加了在广州举行的第一次全国劳动大会。在这些代表中有共产党员、国民党员和无政府主义者等。大会由中国劳动组合书记部主任张国焘主持。大会接受中国共产党提出的打倒帝国主义、打倒封建军阀的政治口号，通过《八小时工作》、《罢工援助》、《全国总工会组织原则》等决议案。大会决定，在全国总工会成立以前，中国劳动组织和书记部为全国工人组织的总通讯机关。这次大会的召开，标志着中国工人阶级开始走向团结统一的道路，为中国工运和工会组织的统一奠定了基础，推动了第一次全国工运高潮的深入发展。
         * lunar : 壬戌年四月初五
         * month : 5
         * pic :
         * title : 第一次全国劳动大会召开
         * year : 1922
         */

        private int id;
        private String day;
        private String des;
        private String lunar;
        private String month;
        private String pic;
        private String title;
        private String year;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getLunar() {
            return lunar;
        }

        public void setLunar(String lunar) {
            this.lunar = lunar;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }
    }
}
