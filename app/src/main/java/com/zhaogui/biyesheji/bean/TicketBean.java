package com.zhaogui.biyesheji.bean;

import java.util.List;

/**
 * 汽车站信息查询
 */

public class TicketBean {


    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"ret_code":0,"busList":[{"segList":[{"line_name":"6路(北戴河火车站-秦皇岛火车站)","stats":"白塔岭;建材学院;中冶东方工程公司(秦皇岛现代妇科);秦皇岛海关;汤河公园;桥东里;旭日家居广场(红星美凯龙阳光商场);雅绅鸿居小区(渤海明珠城);四道桥汽车站;仁济医院;人民公园[广场西路];广场西路;广电中心;海港区财政局;房产大厦;市报社;范家店;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"白塔岭"}]},{"segList":[{"line_name":"34路(海滨汽车站-秦皇岛火车站)","stats":"河北科技师范学院;白塔岭;建材学院;桥西;秦皇岛海关;汤河公园;智得体检;旭日家具广场;雅居超市;四道桥汽车站;市政府;第一医院;秦皇岛国际旅行社;人民路;广电中心;海港区财政局;房产大厦;市报社;范家店;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"河北科技师范学院"}]},{"segList":[{"line_name":"12路(秦皇半岛-金色未来商厦)","stats":"白塔岭;白塔岭市场;东北大学;聚贤人才市场(珠江道);湘江道;经棉里;停车站(淮河道);外环路;汤河苗圃;海阳果菜批发市场;海阳大桥;海阳路口;邹吕庄小学;土台子;区交通局;妇幼保健院","end_stat":"妇幼保健院","start_stat":"白塔岭"}]},{"segList":[{"line_name":"19路夜班暑期线(金梦海湾一号-金色未来商厦)","stats":"旭海金梦海湾8号;秦皇岛国际大酒店;河滨路;体育基地;文体路;桥西;秦皇岛海关;汤河公园;智得体检;耀振里;秦港教育培训中心;耀华老村[光明路];第四医院南区;海港里;地道南口;鑫龙大市场;天桥市场;秦皇岛商城金原店;第二中学;仁济医院;人民公园[海阳路];工人文化宫;市中医医院;长城村;邵岭小区;中西医骨科医院;燕山大街;市骨科医院;金色未来商厦","end_stat":"金色未来商厦","start_stat":"旭海金梦海湾8号"}]},{"segList":[{"line_name":"31路(LG电子-秦皇小区)","stats":"建材学院;中冶东方工程公司(秦皇岛现代妇科);秦皇岛海关(主路);汤河公园;桥东里;旭日家具广场(红星美凯龙);雅绅鸿居小区(渤海明珠城);秦皇岛协和医院(四道桥汽车站)","end_stat":"秦皇岛协和医院(四道桥汽车站)","start_stat":"建材学院"},{"line_name":"33路支线(四道桥汽车站-正大有限公司)","stats":"四道桥汽车站;茂业百货(华联商厦);市政府;第一医院;第七中学;远东礼品城;东方皮肤病医院(公交工贸公司);军转培训中心;市报社;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"四道桥汽车站"}]},{"segList":[{"line_name":"19路(金梦海湾一号-秦皇岛火车站)","stats":"旭海金梦海湾8号;秦皇岛国际大酒店;河滨路;体育基地;文体路;桥西(秦皇岛现代妇科);秦皇岛海关(主路);汤河公园(智得体检);桥东里;耀振里;秦港教育培训中心;耀华老村[光明路];第四医院南区;海港里;地道南口;鑫龙大市场;天桥市场;仁济医院;人民公园[海阳路];工人文化宫;红旗路路口;长城村;邵岭小区(巧致美容医院);中西医骨科医院;燕山大街;市骨科医院(铁新里);妇幼保健院;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"旭海金梦海湾8号"}]},{"segList":[{"line_name":"31路(LG电子-秦皇小区)","stats":"建材学院;中冶东方工程公司(秦皇岛现代妇科);秦皇岛海关(主路);汤河公园;桥东里;旭日家具广场(红星美凯龙);雅绅鸿居小区(渤海明珠城);秦皇岛协和医院(四道桥汽车站);第二中学","end_stat":"第二中学","start_stat":"建材学院"},{"line_name":"27路(玉柴特约服务站-秦皇岛火车站)","stats":"第二中学;市政府;第一医院;第七中学;远东礼品城;东方皮肤病医院(公交工贸公司);军转培训中心;市报社;范家店;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"第二中学"}]},{"segList":[{"line_name":"6路(秦皇岛火车站-北戴河火车站)","stats":"白塔岭;河北科技师范学院(奥体中心);三五四零工厂;燕山大学;铁三处;东北石油大学;归提寨;市民中心","end_stat":"市民中心","start_stat":"白塔岭"},{"line_name":"27路(玉柴特约服务站-秦皇岛火车站)","stats":"市政府;第一医院;第七中学;远东礼品城;东方皮肤病医院(公交工贸公司);军转培训中心;市报社;范家店;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"市政府"}]},{"segList":[{"line_name":"31路(LG电子-秦皇小区)","stats":"建材学院;中冶东方工程公司(秦皇岛现代妇科);秦皇岛海关(主路);汤河公园;桥东里;旭日家具广场(红星美凯龙);雅绅鸿居小区(渤海明珠城);秦皇岛协和医院(四道桥汽车站)","end_stat":"秦皇岛协和医院(四道桥汽车站)","start_stat":"建材学院"},{"line_name":"33路(四道桥汽车站-山海关汽车站)","stats":"四道桥汽车站;茂业百货(华联商厦);市政府;第一医院;第七中学;远东礼品城;东方皮肤病医院(公交工贸公司);军转培训中心;市报社;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"四道桥汽车站"}]},{"segList":[{"line_name":"6路(秦皇岛火车站-北戴河火车站)","stats":"白塔岭;河北科技师范学院(奥体中心);三五四零工厂;燕山大学;铁三处;东北石油大学;归提寨;市民中心","end_stat":"市民中心","start_stat":"白塔岭"},{"line_name":"33路支线(四道桥汽车站-正大有限公司)","stats":"市政府;第一医院;第七中学;远东礼品城;东方皮肤病医院(公交工贸公司);军转培训中心;市报社;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"市政府"}]}]}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * ret_code : 0
         * busList : [{"segList":[{"line_name":"6路(北戴河火车站-秦皇岛火车站)","stats":"白塔岭;建材学院;中冶东方工程公司(秦皇岛现代妇科);秦皇岛海关;汤河公园;桥东里;旭日家居广场(红星美凯龙阳光商场);雅绅鸿居小区(渤海明珠城);四道桥汽车站;仁济医院;人民公园[广场西路];广场西路;广电中心;海港区财政局;房产大厦;市报社;范家店;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"白塔岭"}]},{"segList":[{"line_name":"34路(海滨汽车站-秦皇岛火车站)","stats":"河北科技师范学院;白塔岭;建材学院;桥西;秦皇岛海关;汤河公园;智得体检;旭日家具广场;雅居超市;四道桥汽车站;市政府;第一医院;秦皇岛国际旅行社;人民路;广电中心;海港区财政局;房产大厦;市报社;范家店;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"河北科技师范学院"}]},{"segList":[{"line_name":"12路(秦皇半岛-金色未来商厦)","stats":"白塔岭;白塔岭市场;东北大学;聚贤人才市场(珠江道);湘江道;经棉里;停车站(淮河道);外环路;汤河苗圃;海阳果菜批发市场;海阳大桥;海阳路口;邹吕庄小学;土台子;区交通局;妇幼保健院","end_stat":"妇幼保健院","start_stat":"白塔岭"}]},{"segList":[{"line_name":"19路夜班暑期线(金梦海湾一号-金色未来商厦)","stats":"旭海金梦海湾8号;秦皇岛国际大酒店;河滨路;体育基地;文体路;桥西;秦皇岛海关;汤河公园;智得体检;耀振里;秦港教育培训中心;耀华老村[光明路];第四医院南区;海港里;地道南口;鑫龙大市场;天桥市场;秦皇岛商城金原店;第二中学;仁济医院;人民公园[海阳路];工人文化宫;市中医医院;长城村;邵岭小区;中西医骨科医院;燕山大街;市骨科医院;金色未来商厦","end_stat":"金色未来商厦","start_stat":"旭海金梦海湾8号"}]},{"segList":[{"line_name":"31路(LG电子-秦皇小区)","stats":"建材学院;中冶东方工程公司(秦皇岛现代妇科);秦皇岛海关(主路);汤河公园;桥东里;旭日家具广场(红星美凯龙);雅绅鸿居小区(渤海明珠城);秦皇岛协和医院(四道桥汽车站)","end_stat":"秦皇岛协和医院(四道桥汽车站)","start_stat":"建材学院"},{"line_name":"33路支线(四道桥汽车站-正大有限公司)","stats":"四道桥汽车站;茂业百货(华联商厦);市政府;第一医院;第七中学;远东礼品城;东方皮肤病医院(公交工贸公司);军转培训中心;市报社;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"四道桥汽车站"}]},{"segList":[{"line_name":"19路(金梦海湾一号-秦皇岛火车站)","stats":"旭海金梦海湾8号;秦皇岛国际大酒店;河滨路;体育基地;文体路;桥西(秦皇岛现代妇科);秦皇岛海关(主路);汤河公园(智得体检);桥东里;耀振里;秦港教育培训中心;耀华老村[光明路];第四医院南区;海港里;地道南口;鑫龙大市场;天桥市场;仁济医院;人民公园[海阳路];工人文化宫;红旗路路口;长城村;邵岭小区(巧致美容医院);中西医骨科医院;燕山大街;市骨科医院(铁新里);妇幼保健院;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"旭海金梦海湾8号"}]},{"segList":[{"line_name":"31路(LG电子-秦皇小区)","stats":"建材学院;中冶东方工程公司(秦皇岛现代妇科);秦皇岛海关(主路);汤河公园;桥东里;旭日家具广场(红星美凯龙);雅绅鸿居小区(渤海明珠城);秦皇岛协和医院(四道桥汽车站);第二中学","end_stat":"第二中学","start_stat":"建材学院"},{"line_name":"27路(玉柴特约服务站-秦皇岛火车站)","stats":"第二中学;市政府;第一医院;第七中学;远东礼品城;东方皮肤病医院(公交工贸公司);军转培训中心;市报社;范家店;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"第二中学"}]},{"segList":[{"line_name":"6路(秦皇岛火车站-北戴河火车站)","stats":"白塔岭;河北科技师范学院(奥体中心);三五四零工厂;燕山大学;铁三处;东北石油大学;归提寨;市民中心","end_stat":"市民中心","start_stat":"白塔岭"},{"line_name":"27路(玉柴特约服务站-秦皇岛火车站)","stats":"市政府;第一医院;第七中学;远东礼品城;东方皮肤病医院(公交工贸公司);军转培训中心;市报社;范家店;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"市政府"}]},{"segList":[{"line_name":"31路(LG电子-秦皇小区)","stats":"建材学院;中冶东方工程公司(秦皇岛现代妇科);秦皇岛海关(主路);汤河公园;桥东里;旭日家具广场(红星美凯龙);雅绅鸿居小区(渤海明珠城);秦皇岛协和医院(四道桥汽车站)","end_stat":"秦皇岛协和医院(四道桥汽车站)","start_stat":"建材学院"},{"line_name":"33路(四道桥汽车站-山海关汽车站)","stats":"四道桥汽车站;茂业百货(华联商厦);市政府;第一医院;第七中学;远东礼品城;东方皮肤病医院(公交工贸公司);军转培训中心;市报社;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"四道桥汽车站"}]},{"segList":[{"line_name":"6路(秦皇岛火车站-北戴河火车站)","stats":"白塔岭;河北科技师范学院(奥体中心);三五四零工厂;燕山大学;铁三处;东北石油大学;归提寨;市民中心","end_stat":"市民中心","start_stat":"白塔岭"},{"line_name":"33路支线(四道桥汽车站-正大有限公司)","stats":"市政府;第一医院;第七中学;远东礼品城;东方皮肤病医院(公交工贸公司);军转培训中心;市报社;秦皇岛火车站","end_stat":"秦皇岛火车站","start_stat":"市政府"}]}]
         */

        private int ret_code;
        private List<BusListBean> busList;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public List<BusListBean> getBusList() {
            return busList;
        }

        public void setBusList(List<BusListBean> busList) {
            this.busList = busList;
        }

        public static class BusListBean {
            private List<SegListBean> segList;

            public List<SegListBean> getSegList() {
                return segList;
            }

            public void setSegList(List<SegListBean> segList) {
                this.segList = segList;
            }

            public static class SegListBean {
                /**
                 * line_name : 6路(北戴河火车站-秦皇岛火车站)
                 * stats : 白塔岭;建材学院;中冶东方工程公司(秦皇岛现代妇科);秦皇岛海关;汤河公园;桥东里;旭日家居广场(红星美凯龙阳光商场);雅绅鸿居小区(渤海明珠城);四道桥汽车站;仁济医院;人民公园[广场西路];广场西路;广电中心;海港区财政局;房产大厦;市报社;范家店;秦皇岛火车站
                 * end_stat : 秦皇岛火车站
                 * start_stat : 白塔岭
                 */

                private String line_name;
                private String stats;
                private String end_stat;
                private String start_stat;

                public String getLine_name() {
                    return line_name;
                }

                public void setLine_name(String line_name) {
                    this.line_name = line_name;
                }

                public String getStats() {
                    return stats;
                }

                public void setStats(String stats) {
                    this.stats = stats;
                }

                public String getEnd_stat() {
                    return end_stat;
                }

                public void setEnd_stat(String end_stat) {
                    this.end_stat = end_stat;
                }

                public String getStart_stat() {
                    return start_stat;
                }

                public void setStart_stat(String start_stat) {
                    this.start_stat = start_stat;
                }
            }
        }
    }
}
