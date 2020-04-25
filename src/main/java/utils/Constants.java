package utils;


public class Constants {
    private static final PropertiesFileReader propReader    = new PropertiesFileReader();
    public static final String     PROJECT_PATH            = System.getProperty("user.dir");
    static final String            URL                     = propReader.getUrl();
    static final boolean                  BROWSER_MINIMIZE        = propReader.getBrowserMinimizeValue();
    static final boolean                  BROWSER_DISABLE_IMGAES  = propReader.getBrowserDisableImagesValue();
    static final long                      PAGE_LOAD_TIMEOUT       = propReader.getPageLoadTimeOut();
    public static final long                      DEFAULT_TIMEOUT         = propReader.getdefaultTimeOut();
    static final long                      MAX_TIMEOUT             = propReader.getMaxTimeOut();
    static final boolean RUN_ON_SEL_GRID=false;
   
    static String home = System.getProperty("user.home");
    public static final String DOWNLOAD_PATH=home+"\\Downloads";
    

}
