package utils;


public class Constants {
    private static final PropertiesFileReader propReader    = new PropertiesFileReader();
    public static final String     PROJECT_PATH            = System.getProperty("user.dir");
//    private static final String           TESTDATA_FILE           = propReader.getTestdataFilePath();
//    public static final String             EXCEL_FILE              = TESTDATA_FILE;
    public static final String      EXCEL_GENERIC_TAB       = "generic";
    static final String            URL                     = propReader.getUrl();
    static final boolean                  BROWSER_MINIMIZE        = propReader.getBrowserMinimizeValue();
    static final boolean                  BROWSER_DISABLE_IMGAES  = propReader.getBrowserDisableImagesValue();
    static final long                      PAGE_LOAD_TIMEOUT       = propReader.getPageLoadTimeOut();
    public static final long                      DEFAULT_TIMEOUT         = propReader.getdefaultTimeOut();
    static final long                      MAX_TIMEOUT             = propReader.getMaxTimeOut();
//    public static final String MAIL_SENDER=propReader.mailSender();
//    public static final String MAIL_RECIEVER=propReader.mailReceiver();
    static final boolean RUN_ON_SEL_GRID=false;
   
    static String home = System.getProperty("user.home");
    public static final String DOWNLOAD_PATH=home+"\\Downloads";
    
//    public static final String TEST_FILES_PATH =PROJECT_PATH+ propReader.getTestFilePath();
    
//    public static final String ENVNAME=propReader.getEnvName();
//    private Constants() {}
    
    /*static final String            DBURL                     = propReader.getDBUrl();
    static final String            DBUSERNAME                     = propReader.getDBUsername();
    static final String            DBPASSWORD                     = propReader.getDBpassword();
    */

}
