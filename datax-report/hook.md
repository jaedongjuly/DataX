#  使用 spi +hook 获取datax内部信息
* 1 在 datax 目录下建立 一个hook目录 之后 再建立一个 子目录(名称任意)
* 2 新建一个项目 里面要依赖  
~~~xml
                       <dependency>
                            <groupId>com.alibaba.datax</groupId>
                            <artifactId>datax-common</artifactId>
                            <version>0.0.1-SNAPSHOT</version>
                           <!-- <scope>provided</scope>-->
                        </dependency>
~~~
* 3  在项目里面建立一个 META-INF/services/com.alibaba.datax.common.spi.Hook 文件，内容是对应的 
~~~text
com.towatt.DataxReportMyJ
~~~
 
* 4 实现  Hook 的接口
~~~java
package com.towatt;

import com.alibaba.datax.common.spi.Hook;
import com.alibaba.datax.common.util.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Map;

public class DataxReportMyJ implements Hook {
    public String getName() {
        return "report hook";
    }

    private static final Logger LOG = LoggerFactory.getLogger(DataxReportMyJ.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void invoke(Configuration jobConf, Map<String, Number> msg) {
     // 业务处理 根据返回结果 msg 包含处理结果
        String readrName = jobConf.getString("job.content[0].reader.name");
        if ("mysqlreader".equals(readrName)) {
            String table = jobConf.getString("job.content[0].reader.parameter.table");
            LOG.info(String.format("tb [%s]  ，result:[%s] ", table,msg));
        }
    }

    public static void main(String[] args) {
        // DataxReportMyJ dataxReportMyJ = new DataxReportMyJ();
        String s = "C:\\Users\\towatt\\Desktop\\my2tream.json";
        File file = new File(s);
        Configuration from = Configuration.from(file);
        Configuration from2 = Configuration.from(file);

        from.merge(from2, false);


        System.err.println(from.get("table"));
        System.out.println(from.get("[0].internal.job.content[0].reader.parameter.table"));
    }
}

~~~

* 5 打jar 放到 hook下的子目录下的