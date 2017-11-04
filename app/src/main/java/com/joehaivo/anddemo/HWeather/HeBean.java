package com.joehaivo.anddemo.HWeather;

import java.util.List;

/**
 * Created by haivo on 2017-09-28.
 */

public class HeBean {
    private List<HeWeather5Bean> HeWeather5;

    public List<HeWeather5Bean> getHeWeather5() {
        return HeWeather5;
    }

    public void setHeWeather5(List<HeWeather5Bean> HeWeather5) {
        this.HeWeather5 = HeWeather5;
    }

    public static class HeWeather5Bean {
        /**
         * basic : {"city":"南昌","cnty":"中国","id":"CN101240101","lat":"28.67649269","lon":"115.89215088","update":{"loc":"2017-09-28 20:47","utc":"2017-09-28 12:47"}}
         * daily_forecast : [{"astro":{"mr":"13:00","ms":"23:50","sr":"06:09","ss":"18:07"},"cond":{"code_d":"104","code_n":"104","txt_d":"阴","txt_n":"阴"},"date":"2017-09-28","hum":"86","pcpn":"16.6","pop":"74","pres":"1013","tmp":{"max":"24","min":"20"},"uv":"1","vis":"14","wind":{"deg":"0","dir":"无持续风向","sc":"微风","spd":"3"}},{"astro":{"mr":"13:47","ms":"12:45","sr":"06:09","ss":"18:06"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-09-29","hum":"73","pcpn":"1.2","pop":"17","pres":"1015","tmp":{"max":"28","min":"21"},"uv":"7","vis":"19","wind":{"deg":"0","dir":"无持续风向","sc":"微风","spd":"6"}},{"astro":{"mr":"14:32","ms":"00:40","sr":"06:10","ss":"18:05"},"cond":{"code_d":"101","code_n":"100","txt_d":"多云","txt_n":"晴"},"date":"2017-09-30","hum":"70","pcpn":"0.0","pop":"59","pres":"1013","tmp":{"max":"33","min":"24"},"uv":"8","vis":"19","wind":{"deg":"0","dir":"无持续风向","sc":"微风","spd":"4"}},{"astro":{"mr":"15:16","ms":"01:33","sr":"06:10","ss":"18:04"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2017-10-01","hum":"63","pcpn":"0.0","pop":"10","pres":"1010","tmp":{"max":"35","min":"26"},"uv":"8","vis":"19","wind":{"deg":"0","dir":"无持续风向","sc":"微风","spd":"5"}},{"astro":{"mr":"15:57","ms":"02:27","sr":"06:11","ss":"18:02"},"cond":{"code_d":"302","code_n":"104","txt_d":"雷阵雨","txt_n":"阴"},"date":"2017-10-02","hum":"73","pcpn":"17.5","pop":"48","pres":"1011","tmp":{"max":"33","min":"22"},"uv":"6","vis":"15","wind":{"deg":"1","dir":"北风","sc":"微风","spd":"14"}},{"astro":{"mr":"16:36","ms":"03:24","sr":"06:11","ss":"18:01"},"cond":{"code_d":"104","code_n":"104","txt_d":"阴","txt_n":"阴"},"date":"2017-10-03","hum":"81","pcpn":"0.0","pop":"58","pres":"1016","tmp":{"max":"26","min":"20"},"uv":"5","vis":"15","wind":{"deg":"0","dir":"无持续风向","sc":"微风","spd":"6"}},{"astro":{"mr":"17:16","ms":"04:22","sr":"06:12","ss":"18:00"},"cond":{"code_d":"305","code_n":"101","txt_d":"小雨","txt_n":"多云"},"date":"2017-10-04","hum":"83","pcpn":"0.0","pop":"2","pres":"1016","tmp":{"max":"24","min":"20"},"uv":"5","vis":"17","wind":{"deg":"0","dir":"无持续风向","sc":"微风","spd":"7"}}]
         * status : ok
         */

        private BasicBean basic;
        private String status;
        private List<DailyForecastBean> daily_forecast;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public static class BasicBean {
            /**
             * city : 南昌
             * cnty : 中国
             * id : CN101240101
             * lat : 28.67649269
             * lon : 115.89215088
             * update : {"loc":"2017-09-28 20:47","utc":"2017-09-28 12:47"}
             */

            private String city;
            private String cnty;
            private String id;
            private String lat;
            private String lon;
            private UpdateBean update;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public UpdateBean getUpdate() {
                return update;
            }

            public void setUpdate(UpdateBean update) {
                this.update = update;
            }

            public static class UpdateBean {
                /**
                 * loc : 2017-09-28 20:47
                 * utc : 2017-09-28 12:47
                 */

                private String loc;
                private String utc;

                public String getLoc() {
                    return loc;
                }

                public void setLoc(String loc) {
                    this.loc = loc;
                }

                public String getUtc() {
                    return utc;
                }

                public void setUtc(String utc) {
                    this.utc = utc;
                }
            }
        }

        public static class DailyForecastBean {
            /**
             * astro : {"mr":"13:00","ms":"23:50","sr":"06:09","ss":"18:07"}
             * cond : {"code_d":"104","code_n":"104","txt_d":"阴","txt_n":"阴"}
             * date : 2017-09-28
             * hum : 86
             * pcpn : 16.6
             * pop : 74
             * pres : 1013
             * tmp : {"max":"24","min":"20"}
             * uv : 1
             * vis : 14
             * wind : {"deg":"0","dir":"无持续风向","sc":"微风","spd":"3"}
             */

            private AstroBean astro;
            private CondBean cond;
            private String date;
            private String hum;
            private String pcpn;
            private String pop;
            private String pres;
            private TmpBean tmp;
            private String uv;
            private String vis;
            private WindBean wind;

            public AstroBean getAstro() {
                return astro;
            }

            public void setAstro(AstroBean astro) {
                this.astro = astro;
            }

            public CondBean getCond() {
                return cond;
            }

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public TmpBean getTmp() {
                return tmp;
            }

            public void setTmp(TmpBean tmp) {
                this.tmp = tmp;
            }

            public String getUv() {
                return uv;
            }

            public void setUv(String uv) {
                this.uv = uv;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class AstroBean {
                /**
                 * mr : 13:00
                 * ms : 23:50
                 * sr : 06:09
                 * ss : 18:07
                 */

                private String mr;
                private String ms;
                private String sr;
                private String ss;

                public String getMr() {
                    return mr;
                }

                public void setMr(String mr) {
                    this.mr = mr;
                }

                public String getMs() {
                    return ms;
                }

                public void setMs(String ms) {
                    this.ms = ms;
                }

                public String getSr() {
                    return sr;
                }

                public void setSr(String sr) {
                    this.sr = sr;
                }

                public String getSs() {
                    return ss;
                }

                public void setSs(String ss) {
                    this.ss = ss;
                }
            }

            public static class CondBean {
                /**
                 * code_d : 104
                 * code_n : 104
                 * txt_d : 阴
                 * txt_n : 阴
                 */

                private String code_d;
                private String code_n;
                private String txt_d;
                private String txt_n;

                public String getCode_d() {
                    return code_d;
                }

                public void setCode_d(String code_d) {
                    this.code_d = code_d;
                }

                public String getCode_n() {
                    return code_n;
                }

                public void setCode_n(String code_n) {
                    this.code_n = code_n;
                }

                public String getTxt_d() {
                    return txt_d;
                }

                public void setTxt_d(String txt_d) {
                    this.txt_d = txt_d;
                }

                public String getTxt_n() {
                    return txt_n;
                }

                public void setTxt_n(String txt_n) {
                    this.txt_n = txt_n;
                }
            }

            public static class TmpBean {
                /**
                 * max : 24
                 * min : 20
                 */

                private String max;
                private String min;

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }
            }

            public static class WindBean {
                /**
                 * deg : 0
                 * dir : 无持续风向
                 * sc : 微风
                 * spd : 3
                 */

                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }
    }
}
