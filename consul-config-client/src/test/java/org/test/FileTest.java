package org.test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application.xml"})*/
public class FileTest {
 /*   @Autowired
    ComponentService componentService;*/


    /**
     * 去掉文本中的前三字
     */
    @Test
    public void delete3() throws  Exception {
        File f = new File("/Users/sunkaixiang/pro/test");
        BufferedReader br = new BufferedReader(new FileReader(f));//构造一个BufferedReader类来读取文件
        String s = null;
        //int x =1;
        while((s = br.readLine())!=null ){//使用readLine方法，一次读一行

            String se = s.replaceAll("\\d+","");
            se = se.replace(".","");
            System.out.println(se.trim());

        }
        br.close();
    }


    /**
     * 去掉文本中的空格行
     */
    @Test
    public void deleteNULLLine() throws  Exception {
        File f = new File("D:\\usr\\test.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));//构造一个BufferedReader类来读取文件
        String s = null;
        StringBuilder sb =new StringBuilder();
        //int x =1;
        while((s = br.readLine())!=null ){//使用readLine方法，一次读一行
            if(!s.trim().equals("")){
                s = s.replace((char) 12288, ' ');
                sb.append(s.trim()).append("\r\n");
               // x ++ ;
            }

        }
        br.close();
        String word= sb.toString();
        System.out.println(word);
    }

    /**
     * 去掉文本中的空格行
     */
    @Test
    public void notReadFirstWord() throws  Exception {
        File f = new File("D:\\usr\\test.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));//构造一个BufferedReader类来读取文件
        String s = null;
        StringBuilder sb =new StringBuilder();
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            String  words= s.trim() ;
            if(words.contains(" ")){
                System.out.println(words.substring(words.indexOf(" ")));
            }
        }
        br.close();
    }


    /**
     * 去掉文本中的空格行
     */
    @Test
    public void check() throws  Exception {
        File f = new File("D:\\ll-doc\\20171020\\1027\\1data.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));//构造一个BufferedReader类来读取文件
        // BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
        String s = null;
        StringBuilder sb =new StringBuilder();
        Date now = new Date();
        Map<String ,String> map = new HashMap<>();
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            try{
                String name  = s.substring(s.indexOf("文件名")+4  , s.indexOf("sftp用户名")-1 );
                String time = s.substring(0,20);
                String sss = map.get(name);
                if(sss != null){
                    System.out.println(name + "   "+sss);
                    System.out.println(name + "   "+time);
                }
                map.put(name,time);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(s);
            }

        }
        br.close();
    }

    /**
     * 比较两行内容
     */
    @Test
    public void compare() throws  Exception {
        File f = new File("D:\\ll-doc\\20171020\\1027\\3data.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));//构造一个BufferedReader类来读取文件
        String s = null;
        Map<String ,String> map = new HashMap<>();
        int index= 1;
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            map.put("line"+index ,s);
            index ++;
        }
        br.close();
        String[] lin1 = map.get("line1").split(",");
        String[] lin2 = map.get("line2").split(",");

       for(int i= 0;i<lin1.length;i++){
           boolean ff =false;
           if(lin1[i].equals(lin2[i]))ff = true;
           System.out.println(lin1[i] + "  " +lin2[i] + "  " + ff );
       }




    }


    /**
     * 去掉文本中的空格行
     */
    @Test
    public void makeInvoke() throws  Exception {
        File f = new File("D:\\ll-doc\\20171020\\1027\\1data.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));//构造一个BufferedReader类来读取文件
       // BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
        String s = null;
        StringBuilder sb =new StringBuilder();
        Date now = new Date();
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            String  words= s.trim() ;
            if(words.contains(",")){
                String[] info = words.split(",");
                String  acct = info[0].trim();
                String  name = convert( info[1].trim());
                String  mert = info[2].trim();
                /*byte[] ss = mert.getBytes("GB2312");
                mert = new String(ss,"UTF-8");*/
               // String  va = info[3].trim();
                String  amount = info[3].trim();
                String  id = info[4].trim();
                String  exid = info[5].trim();
                Long time = now.getTime();
                String msg = "invoke com.lianlianpay.lli.services.paycore.client.service.FreezeOrderService.freeze(" +
                        "{\"acctDate\":20171022,\"amount\":"+amount+",\"bizChannelCode\":\"CitiUS\"," +
                        "\"bizCode\":\"GJSK\",\"currencyCode\":\"USD\",\"exlReOrderId\":\""+exid+"\"," +
                        "\"merchantAcct\":\""+acct+"\",\"merchantAcctType\":\"INTERNAL_GENERAL_ACCT\"," +
                        "\"merchantId\":\""+mert+"\",\"merchantName\":\""+name+"\",\"merchantType\":\"CUSTOMER\"," +
                        "\"reOrderId\":\""+id+"\",\"reOrderTime\":"+time+",\"reOrderTypeCode\":\"ENTRY\"})" ;
                sb.append(msg+"\r\n");

            }
        }

        System.out.println(sb.toString());
        br.close();
    }



    /**
     * 去掉文本中的空格行
     */
    @Test
    public void makeUnfrezz() throws  Exception {
        File f = new File("D:\\ll-doc\\20171020\\dd.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));//构造一个BufferedReader类来读取文件
        // BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
        String s = null;
        StringBuilder sb =new StringBuilder();
        Date now = new Date();
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            String  words= s.trim() ;
            if(words.contains(",")){
                String[] info = words.split(",");
               // String  id = "FZ"+info[1].trim();
                String  id =  info[1].trim();
                Long time = now.getTime();
               // String msg =id
                sb.append("\""+id+"\",");

            }
        }

        System.out.println(sb.toString());
        br.close();
    }

    /**
     * 去掉文本中的空格行
     */
    @Test
    public void makeUnfrezzDebit() throws  Exception {
        File f = new File("D:\\ll-doc\\20171020\\1027\\2data.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));//构造一个BufferedReader类来读取文件
        // BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
        String s = null;
        StringBuilder sb =new StringBuilder();
        Date now = new Date();
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            String  words= s.trim() ;
            if(words.contains(",")){
                String[] info = words.split(",");
                String  acct = info[0].trim();
                String  name = info[1].trim();
                String  mert = info[2].trim();
                /*byte[] ss = mert.getBytes("GB2312");
                mert = new String(ss,"UTF-8");*/
                //String  va = info[3].trim();
                String  amount = info[3].trim();
                String  id = info[4].trim();
                String  exid = info[6].trim();
                Long time = now.getTime();
                String msg = "invoke com.lianlianpay.lli.services.paycore.client.service.FreezeOrderService.unfreezeDebit(" +
                        "{\"acctDate\":20171022,\"unfreezeDebitAmount\":"+amount+"," +
                        "\"reOrderId\":\""+id+"\",\"reOrderTypeCode\":\"ENTRY\"})" ;
                sb.append(msg+"\r\n");

            }
        }

        System.out.println(sb.toString());
        br.close();
    }


    /**
     * 去掉文本中的空格行
     */
    @Test
    public void makejson() throws  Exception {
        File f = new File("D:\\ll-doc\\20171020\\2014\\preJson.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));//构造一个BufferedReader类来读取文件
        // BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
        String s = null;
        StringBuilder sb =new StringBuilder();
        Date now = new Date();
        int countLine = 0;
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            String  word= s.trim() ;
            countLine ++;
            if(countLine %3 ==1){
                if(sb.length() == 0){
                    sb.append("{\""+word+"\"");
                }else {
                    sb.append(",\""+word+"\"");
                }
            }else {
                sb.append(""+word+"");
            }
        }
        sb.append("}");
        System.out.println(sb.toString());
        br.close();
    }



    /**
     * 去掉文本中的空格行
     */
    @Test
    public void makecheck() throws  Exception {
        File f = new File("D:\\ll-doc\\20171020\\create_frz1.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));//构造一个BufferedReader类来读取文件
        // BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
        String s = null;
        StringBuilder sb =new StringBuilder();
        Date now = new Date();
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            String  words= s.trim() ;
            if(words.contains(",")){
                String[] info = words.split(",");
                String  acct = info[0].trim();
                String  name = info[1].trim();
                String  mert = info[2].trim();
                /*byte[] ss = mert.getBytes("GB2312");
                mert = new String(ss,"UTF-8");*/
                String  va = info[3].trim();
                String  amount = info[4].trim();
                String  id = info[5].trim();
                String  exid = info[6].trim();
                Long time = now.getTime();
                String msg = "select * from li_entry_bill where " ;
                sb.append(msg+"\r\n");

            }
        }

        System.out.println(sb.toString());
        br.close();
    }


    public String convert(String str)
    {
        str = (str == null ? "" : str);
        String tmp;
        StringBuffer sb = new StringBuffer(1000);
        char c;
        int i, j;
        sb.setLength(0);
        for (i = 0; i < str.length(); i++)
        {
            c = str.charAt(i);
            sb.append("\\u");
            j = (c >>>8); //取出高8位
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
                sb.append("0");
            sb.append(tmp);
            j = (c & 0xFF); //取出低8位
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
                sb.append("0");
            sb.append(tmp);

        }
        return (new String(sb));
    }


    @Test
    public void ss(){
        System.out.println("宝鸡有一群怀揣这梦想的少年相信在牛大叔的带领下会创造生命的奇迹的奇迹网络科技有限公司宝鸡有一群怀揣这梦想的少年相信在牛大叔的带领下会创造生命的奇迹的奇迹网络科技有限公司奇迹网络科技有限公司的奇迹网络科技有限公司奇迹网络科技有限公司".length());
    }
}
