package hibernate.mapping;

import hibernate.query.DeviceInfo;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.servlet.http.HttpServletRequest;

public class Devicedetails implements java.io.Serializable {

    private String autoId;
    private String deviceType;
    private String deviceOs;
    private String deviceResolution;
    private String browserName;
    private String browserVersion;
    private String clientIp;
    private String location;

    public Devicedetails() {
    }

    public Devicedetails(String autoId, String deviceType, String deviceOs, String deviceResolution, String browserName, String browserVersion, String clientIp, String location) {
        this.autoId = autoId;
        this.deviceType = deviceType;
        this.deviceOs = deviceOs;
        this.deviceResolution = deviceResolution;
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.clientIp = clientIp;
        this.location = location;
    }

    public String getAutoId() {
        return this.autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceOs() {
        return this.deviceOs;
    }

    public void setDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs;
    }

    public String getDeviceResolution() {
        return this.deviceResolution;
    }

    public void setDeviceResolution(String deviceResolution) {
        this.deviceResolution = deviceResolution;
    }

    public String getBrowserName() {
        return this.browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserVersion() {
        return this.browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void getDeviceInfo(HttpServletRequest request, String deviceId) {
        String browserDetails = request.getHeader("User-Agent").toLowerCase();
        String setDeviceIP = request.getRemoteAddr();
        String setDeviceOs = "Unknown";
        String setBrowserName = "Unknown";
        String setBrowserVersion = "Unknown";
        String setDeviceType = "Unknown";
        String setScreenResolution;
        //========================================= setDeviceOs ===================================================
        String android = ".*(android )([0-9.])*(;).*";
        if ((browserDetails.contains("windows")) && !(browserDetails.contains("windows phone"))) {
            setDeviceOs = "Windows";
        } else if (browserDetails.contains("windows phone")) {
            setDeviceOs = "Windows Phone";
        } else if (browserDetails.contains("iphone")) {
            setDeviceOs = "iOS";
        } else if (browserDetails.contains("ipad")) {
            setDeviceOs = "iOS";
        } else if (browserDetails.contains("ipod")) {
            setDeviceOs = "iOS";
        } else if (browserDetails.contains("mac")) {
            setDeviceOs = "Mac";
        } else if ((browserDetails.contains("x11")) && (browserDetails.contains("ubuntu"))) {
            setDeviceOs = "Ubuntu";
        } else if ((browserDetails.contains("x11")) && (browserDetails.contains("solaris"))) {
            setDeviceOs = "Solaris";
        } else if ((browserDetails.contains("x11")) && (browserDetails.contains("sunos"))) {
            setDeviceOs = "Solaris";
        } else if ((browserDetails.contains("x11")) && (browserDetails.contains("freebsd"))) {
            setDeviceOs = "FreeBSD";
        } else if ((browserDetails.contains("x11")) && (browserDetails.contains("linux"))) {
            setDeviceOs = "Linux";
        } else if ((browserDetails.contains("x11")) && (browserDetails.contains("unix"))) {
            setDeviceOs = "Unix";
        } else if (browserDetails.contains("android")) {
            setDeviceOs = "Android";
            if (browserDetails.matches(android)) {
                setDeviceOs = (browserDetails.substring(browserDetails.indexOf("android")).split(";")[0]).replace("android", "Android");
            }
        } else if (browserDetails.contains("blackberry")) {
            setDeviceOs = "Blackberry";
        } else if (browserDetails.contains("ios")) {
            setDeviceOs = "iOS";
        } else if (browserDetails.contains("symbian")) {
            setDeviceOs = "Symbian";
        } else if ((browserDetails.contains("j2me")) || (browserDetails.contains("midp"))) {
            setDeviceOs = "Java ME";
        }
        String match_os = "^(?:[.a-zA-Z0-9 ]) {1,}$";
        if (!setDeviceOs.matches(match_os)) {
            setDeviceOs = "Unknown";
        }
        //===================================== setBrowserName And setBrowserVersion ==============================================
        String IE = ".*(msie )([0-9.+])*(;).*";
        String IE11 = ".*(rv:)([0-9.+])*(\\)).*";
        String ucbrowser = ".*(ucbrowser/)([0-9.+]).*";
        String version = ".*(version/)([0-9.+]).*";
        String opera = ".*(opera/)([0-9.+]).*";
        String opr = ".*(opr/)([0-9.+]).*";
        String chrome = ".*(chrome/)([0-9.+]).*";
        String crios = ".*(crios/)([0-9.+]).*";
        String firefox = ".*(firefox/)([0-9.+]).*";
        String safari = ".*(safari/)([0-9.+]).*";
        if (browserDetails.contains("msie") && browserDetails.contains("net")) {
            setBrowserName = "MSIE(Compatibility View)";
            if (browserDetails.matches(IE)) {
                setBrowserVersion = (browserDetails.substring(browserDetails.indexOf("msie")).split(";")[0]).replace("msie ", "");
            }
        } else if (browserDetails.contains("msie") && !browserDetails.contains("net")) {
            setBrowserName = "MSIE(Non-Compatibility View)";
            if (browserDetails.matches(IE)) {
                setBrowserVersion = (browserDetails.substring(browserDetails.indexOf("msie")).split(";")[0]).replace("msie ", "");
            }
        } else if (browserDetails.contains("rv") && !(browserDetails.contains("firefox"))) {
            setBrowserName = "MSIE(Compatibility View)";
            if (browserDetails.matches(IE11)) {
                setBrowserVersion = ((browserDetails.substring(browserDetails.indexOf("rv")).split("\\)")[0]).split(":")[1]);
            }
        } else if (browserDetails.contains("ucbrowser")) {
            setBrowserName = "UC Browser";
            if (browserDetails.matches(ucbrowser)) {
                setBrowserVersion = (browserDetails.substring(browserDetails.indexOf("ucbrowser")).split(" ")[0]).split("/")[1];
            }
        } else if (browserDetails.contains("ubrowser")) {
            setBrowserName = "UC Browser";
            if (browserDetails.matches(ucbrowser)) {
                setBrowserVersion = (browserDetails.substring(browserDetails.indexOf("ubrowser")).split(" ")[0]).split("/")[1];
            }
        } else if (browserDetails.contains("safari") && (browserDetails.contains("version"))) {
            setBrowserName = "Safari";
            if (browserDetails.matches(version)) {
                setBrowserVersion = (browserDetails.substring(browserDetails.indexOf("version")).split(" ")[0]).split("/")[1];
            }
        } else if (browserDetails.contains("opr") || browserDetails.contains("opera")) {
            if (browserDetails.contains("opera")) {
                setBrowserName = "Opera";
                if (browserDetails.matches(version)) {
                    setBrowserVersion = (browserDetails.substring(browserDetails.indexOf("version")).split(" ")[0]).split("/")[1];
                } else if (browserDetails.matches(opera)) {
                    setBrowserVersion = (browserDetails.substring(browserDetails.indexOf("opera")).split(" ")[0]).split("/")[1];
                }
            } else if (browserDetails.contains("opr")) {
                setBrowserName = "Opera";
                if (browserDetails.matches(opr)) {
                    setBrowserVersion = (browserDetails.substring(browserDetails.indexOf("opr")).split(" ")[0]).split("/")[1];
                }
            }
        } else if (browserDetails.contains("edge")) {
            setBrowserName = "Microsoft Edge";
            if (browserDetails.matches(chrome)) {
                setBrowserVersion = (browserDetails.substring(browserDetails.indexOf("edge")).split(" ")[0]).split("/")[1];
            }
        } else if (browserDetails.contains("chrome")) {
            setBrowserName = "Chrome";
            if (browserDetails.matches(chrome)) {
                setBrowserVersion = (browserDetails.substring(browserDetails.indexOf("chrome")).split(" ")[0]).split("/")[1];
            }
        } else if (browserDetails.contains("crios")) {
            setBrowserName = "Chrome";
            if (browserDetails.matches(crios)) {
                setBrowserVersion = (browserDetails.substring(browserDetails.indexOf("crios")).split(" ")[0]).split("/")[1];
            }
        } else if (browserDetails.contains("firefox")) {
            setBrowserName = "Firefox";
            if (browserDetails.matches(firefox)) {
                setBrowserVersion = (browserDetails.substring(browserDetails.indexOf("firefox")).split(" ")[0]).split("/")[1];
            }
        } else if (browserDetails.contains("safari")) {
            setBrowserName = "Safari";
            if (browserDetails.matches(safari)) {
                setBrowserVersion = (browserDetails.substring(browserDetails.indexOf("safari")).split(" ")[0]).split("/")[1];
            }
        }
        String match_version = "^(?:[.0-9+]) {1,20}$";
        if (!setBrowserVersion.matches(match_version)) {
            setBrowserVersion = "Unknown";
        }
        //=============================================== setDeviceType =======================================================
        if (browserDetails.contains("iphone")) {
            setDeviceType = "iPhone";
        } else if (browserDetails.contains("ipad")) {
            setDeviceType = "iPad";
        } else if (browserDetails.contains("ipod")) {
            setDeviceType = "iPod";
        } else if ((browserDetails.contains("windows") && !browserDetails.contains("windows phone") && !browserDetails.contains("tablet")) || (browserDetails.contains("mac")) || (browserDetails.contains("x11"))) {
            setDeviceType = "PC";
        } else if ((browserDetails.contains("android") && browserDetails.contains("mobile")) || (browserDetails.contains("j2me")) || (browserDetails.contains("midp")) || (browserDetails.contains("mobile")) || (browserDetails.contains("symbian")) || (browserDetails.contains("ios"))) {
            setDeviceType = "Mobile";
        } else if ((browserDetails.contains("android") && !browserDetails.contains("mobile")) || (browserDetails.contains("tablet"))) {
            setDeviceType = "Tablet";
        } else if (browserDetails.contains("blackberry")) {
            setDeviceType = "Blackberry";
        }
        //=============================================== setScreenResolution ==================================================
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        setScreenResolution = width + "*" + height;
        //=================================================== Setter Values ====================================================
        setDeviceType(setDeviceType);
        setDeviceOs(setDeviceOs);
        setDeviceResolution(setScreenResolution);
        setBrowserName(setBrowserName);
        setBrowserVersion(setBrowserVersion);
        setClientIp(setDeviceIP);
        setLocation("Bhiwani");
        if (deviceId != null) {
            DeviceInfo saveDevice = new DeviceInfo();
            Devicedetails device_data = new Devicedetails(deviceId, setDeviceType, setDeviceOs, setScreenResolution, setBrowserName, setBrowserVersion, setDeviceIP, "Bhiwani");
            saveDevice.InsertDeviceInfo(device_data);
        }
    }

}
