/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversões;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Usuario
 */
public class Data_p_Mysql {
    
    public String Data_p_Mysql(String data) {
        String dia = data.substring(0,2);
        String mes = data.substring(3,5);
        String ano = data.substring(6);
        String datap_mysql = ano+"-"+mes+"-"+dia;
        return datap_mysql;
    }
    
    public String DataVindaDoMysql(String data){
        String ano = data.substring(0,4);
        String mes = data.substring(5,7);
        String dia = data.substring(8);
        String datav_mysql = dia+"/"+mes+"/"+ano;
        return datav_mysql;
    }
    
    public Calendar StringMysqlParaCalendar(String data) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(DataVindaDoMysql(data)));
        return cal;
    }
    
    public Calendar StringCalendarioParaCalendar(String data) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(data));
        return cal;
    }
    
    
}
