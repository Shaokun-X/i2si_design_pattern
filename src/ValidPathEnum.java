public enum ValidPathEnum {
    DASHBOARD("/dashboard"),
    HOME("/home");

    private final String text;

    ValidPathEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }    
}
