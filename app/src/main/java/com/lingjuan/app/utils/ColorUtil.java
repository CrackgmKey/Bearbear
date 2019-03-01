package com.lingjuan.app.utils;

import android.graphics.Color;


import java.util.Random;

/**
 * Created by hua on 2018/6/13.
 */

public class ColorUtil {

    public static String statisticsColors[] =
            {"#9B30FF", "#ef924b", "#7ecdf4",
                    "#feef01", "#e96a77", "#b86eff",

                    "#88c056", "#42629E", "#762C23",

                    "#EEB422", "#8B658B", "#CE5139",

                    "#D2691E", "#B22222", "#876868",

                    "#B03060", "#957A24", "#0D696C",

                    "#FF0220", "#4712F4", "#CDB626",

                    "#E034AC", "#00CD00", "#43CD80"};

    public static String cargoColors[] =
            {"#015581", "#ef924b", "#7ecdf4",
                    "#feef01", "#e96a77", "#b86eff",

                    "#88c056", "#42629E", "#762C23",

                    "#EEB422", "#8B658B", "#CE5139",

                    "#D2691E", "#B22222", "#876868",

                    "#B03060", "#957A24", "#0D696C",

                    "#FF0220", "#4712F4", "#CDB626",

                    "#E034AC", "#3E3737", "#303564"};


    public static int getColor(String[] colors, int position) {
        if (position >= colors.length) {
            Random random = new Random();
            return Color.parseColor(colors[(random.nextInt(colors.length))]);
        } else {
            return Color.parseColor(colors[position]);
        }
    }

}
