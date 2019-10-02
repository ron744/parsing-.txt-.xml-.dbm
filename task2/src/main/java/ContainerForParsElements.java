public class ContainerForParsElements {

    String servletName;
    String servletClass;
    String servletURL;

    public String getServletName() {
        return servletName;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public String getServletClass() {
        return servletClass;
    }

    public void setServletClass(String servletClass) {
        this.servletClass = servletClass;
    }

    public String getServletURL() {
        return servletURL;
    }

    public void setServletURL(String servletURL) {
        this.servletURL = servletURL;
    }

    public ContainerForParsElements(String servletName, String servletClass, String servletURL) {
        this.servletName = servletName;
        this.servletClass = servletClass;
        this.servletURL = servletURL;
    }

    public ContainerForParsElements(){}
}
