package com.towatt;

import com.alibaba.datax.common.spi.Hook;
import com.alibaba.datax.common.util.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 *
 *
 *
 *
 *
 * @author guojie
 * @description
 * @createDate 2022/12/8
 */
public class DataxReportMyJ implements Hook {
    public String getName() {
        return "report hook";
    }

    private static final Logger LOG = LoggerFactory.getLogger(DataxReportMyJ.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void invoke(Configuration jobConf, Map<String, Number> msg) {

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
