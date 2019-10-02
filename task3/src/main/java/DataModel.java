public class DataModel {
    private String cod;
    private String organizationName;
    private String documentKind;
    private String templateName;
    private String hiddenDelete;

    public DataModel(String cod, String organizationName, String documentKind, String templateName, String hiddenDelete) {
        this.cod = cod;
        this.organizationName = organizationName;
        this.documentKind = documentKind;
        this.templateName = templateName;
        this.hiddenDelete = hiddenDelete;
    }

    public DataModel(){}

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getDocumentKind() {
        return documentKind;
    }

    public void setDocumentKind(String documentKind) {
        this.documentKind = documentKind;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getHiddenDelete() {
        return hiddenDelete;
    }

    public void setHiddenDelete(String hiddenDelete) {
        this.hiddenDelete = hiddenDelete;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "cod='" + cod + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", documentKind='" + documentKind + '\'' +
                ", templateName='" + templateName + '\'' +
                ", hiddenDelete='" + hiddenDelete + '\'' +
                '}';
    }
}
