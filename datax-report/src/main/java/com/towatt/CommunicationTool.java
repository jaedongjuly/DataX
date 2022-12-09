package com.towatt;

//import org.apache.commons.lang.Validate;

/**
 * 这里主要是业务层面的处理
 */
public final class CommunicationTool {
    public static final String STAGE = "stage";
    public static final String BYTE_SPEED = "byteSpeed";
    public static final String RECORD_SPEED = "recordSpeed";
    public static final String PERCENTAGE = "percentage";

    public static final String READ_SUCCEED_RECORDS = "readSucceedRecords";
    public static final String READ_SUCCEED_BYTES = "readSucceedBytes";

    public static final String READ_FAILED_RECORDS = "readFailedRecords";
    public static final String READ_FAILED_BYTES = "readFailedBytes";

    public static final String WRITE_RECEIVED_RECORDS = "writeReceivedRecords";
    public static final String WRITE_RECEIVED_BYTES = "writeReceivedBytes";

    public static final String WRITE_FAILED_RECORDS = "writeFailedRecords";
    public static final String WRITE_FAILED_BYTES = "writeFailedBytes";

    public static final String TOTAL_READ_RECORDS = "totalReadRecords";
    private static final String TOTAL_READ_BYTES = "totalReadBytes";

    private static final String TOTAL_ERROR_RECORDS = "totalErrorRecords";
    private static final String TOTAL_ERROR_BYTES = "totalErrorBytes";

    private static final String WRITE_SUCCEED_RECORDS = "writeSucceedRecords";
    private static final String WRITE_SUCCEED_BYTES = "writeSucceedBytes";

    public static final String WAIT_WRITER_TIME = "waitWriterTime";

    public static final String WAIT_READER_TIME = "waitReaderTime";

    public static final String TRANSFORMER_USED_TIME = "totalTransformerUsedTime";
    public static final String TRANSFORMER_SUCCEED_RECORDS = "totalTransformerSuccessRecords";
    public static final String TRANSFORMER_FAILED_RECORDS = "totalTransformerFailedRecords";
    public static final String TRANSFORMER_FILTER_RECORDS = "totalTransformerFilterRecords";
    public static final String TRANSFORMER_NAME_PREFIX = "usedTimeByTransformer_";


    public static void main(String[] args) {
        String s = new String();
    }

}
