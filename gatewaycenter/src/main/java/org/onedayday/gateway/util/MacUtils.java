package org.onedayday.gateway.util;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @description:
 * @author: ncc
 * @createDate: 2021/8/22
 * @version: 1.0
 */
public class MacUtils {


    public static String hexByte(byte b) {
        String s = "000000" + Integer.toHexString(b);
        return s.substring(s.length() - 2);
    }

    public static String getMAC() {
        Enumeration<NetworkInterface> el;
        String mac_s = "";
        try {
            el = NetworkInterface.getNetworkInterfaces();
            while (el.hasMoreElements()) {
                byte[] mac = el.nextElement().getHardwareAddress();
                if (mac == null)
                    continue;
                mac_s = hexByte(mac[0]) + "-" + hexByte(mac[1]) + "-"
                        + hexByte(mac[2]) + "-" + hexByte(mac[3]) + "-"
                        + hexByte(mac[4]) + "-" + hexByte(mac[5]);
//                System.out.println("MAC地址 = " + mac_s);
               // System.out.println(" -" + mac_s);

            }
        } catch (SocketException e1) {
            e1.printStackTrace();
        }
        return mac_s;
    }

    //返回所有的MAC集合
    private static List getMacList(){
        Enumeration<NetworkInterface> el;
        List macList=new ArrayList();
        try {
            String mac_s = "";
            el = NetworkInterface.getNetworkInterfaces();
            while (el.hasMoreElements()) {
                byte[] mac = el.nextElement().getHardwareAddress();
                if (mac == null)
                    continue;
                mac_s = hexByte(mac[0]) + "-" + hexByte(mac[1]) + "-"
                        + hexByte(mac[2]) + "-" + hexByte(mac[3]) + "-"
                        + hexByte(mac[4]) + "-" + hexByte(mac[5]);
//                System.out.println("MAC地址 = " + mac_s);
                // System.out.println(" -" + mac_s);
                macList.add(mac_s);

            }
        } catch (SocketException e1) {
            e1.printStackTrace();
        }

        return macList;
    }

    public static void main(String[] args) {

        String mac = getMAC();
        System.out.println("mac = " + mac);

        List macList=getMacList();
        System.out.println("macList = " + macList.toString());

    }
}
